from numpy import insert
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.keys import Keys
import mysql.connector
from mysql.connector.utils import validate_normalized_unicode_string
import time
import os

DB = mysql.connector.connect(
        host="localhost",
        user="root",
        password="password",
        database="epic_tracking",
        auth_plugin='mysql_native_password'
    )

CURSOR1 = DB.cursor(prepared=True)


def getAllGenreGames(driver):
    games_list = []


    while(True):
        element = WebDriverWait(driver, 10).until(
            EC.presence_of_element_located((By.CLASS_NAME, "css-zgal9t-DiscoverCardLayout__component"))
        )

        body = driver.find_element_by_tag_name('body') 
        for i in range(7):
            body.send_keys(Keys.PAGE_DOWN)
            time.sleep(0.5) 

        games = driver.find_elements_by_class_name('css-zgal9t-DiscoverCardLayout__component')
        next_paginate = None
        
        for game in games:
            title = game.find_element_by_xpath('.//*[@data-testid="offer-title-info-title"]').text
            subtitle = game.find_element_by_xpath('.//*[@data-testid="offer-title-info-subtitle"]').text
            pricing1 = game.find_element_by_xpath('.//*[@class="css-nxq7ez-PriceLayout__rowItem" or @class="css-1mc6sjq"]').text
            pricing2 = game.find_element_by_xpath('.//*[@class="css-1mc6sjq"]').text

            if pricing1 and '%' not in pricing1: #% is usually in sale texts and not in actual price
                pricing = pricing1
            else:
                pricing = pricing2
            if pricing == "Free":
                pricing = "$00.00" 
            if pricing == "Coming Soon":
                pricing = None

            thumbnail = game.find_element_by_xpath('.//*[@data-testid="offer-card-image-portrait"]')
            thumbnail = WebDriverWait(thumbnail, 10).until(EC.presence_of_element_located((By.TAG_NAME, "img"))) #waits until the thumbnail is loaded in the browser
            thumbnail = thumbnail.get_attribute('src')

            game_obj = {
                'title': title,
                'publisher': subtitle,
                'pricing': float("00.00" if pricing == None else pricing.strip()[1:]),
                'thumbnail': thumbnail
            }

            games_list.append(game_obj)

        next_paginate = driver.find_elements_by_class_name('css-1j31wz6-Icon__wrapper-PaginationItem__next')
        print(next_paginate)

        try:
            if next_paginate:
                next_paginate[0].click()
                time.sleep(5)
            else:
                #print(games_list)
                break
        except:
            #print(games_list)
            break
    return games_list


def insertGamesWithGenre(genre, games):
    print('enter the generes here')
    genreID = insertGenreIfNotExists(genre)
    
    for game in games:
        print(game)
        publisherID = insertPublisherIfNotExists(game['publisher'])
        gameId = insertGameifNotExists(game)
        insertGenreGame(genreID,gameId)
        insertPublisherGame(publisherID,gameId)
        insertPriceRecordForGame(game,gameId)
        

def insertGameifNotExists(game):
    stmt = "SELECT id, name FROM game WHERE name = ?"
    CURSOR1.execute(stmt, tuple([game['title']]))
    output = CURSOR1.fetchone()
    if output is None:
        print("inserting new Game")
        stmt= "INSERT INTO game (name, thumbnail, price) VALUES (?,?,?)"
        CURSOR1.execute(stmt, tuple([game['title'], game['thumbnail'], game['pricing']]))
        gameId = CURSOR1.lastrowid
    else:
        gameId = output[0]    
    print(gameId)
    DB.commit()
    return gameId  

def insertPublisherIfNotExists(publisherName):
    stmt = "SELECT id, publisher_name FROM publisher WHERE publisher_name = ?"
    CURSOR1.execute(stmt, tuple([publisherName]))
    output = CURSOR1.fetchone()
    
    if output is None:
        print("inserting new publisher")
        stmt= "INSERT INTO publisher (publisher_name) VALUES (?)"
        CURSOR1.execute(stmt, tuple([publisherName]))
        publisherid = CURSOR1.lastrowid
    else:
        publisherid = output[0]

    print(publisherid)
    DB.commit()
    return publisherid    

def insertGenreIfNotExists(genreName):
    stmt = "SELECT id, genre_name FROM genre WHERE genre_name = ?"
    CURSOR1.execute(stmt, tuple([genreName]))
    output = CURSOR1.fetchone()
    
    if output is None:
        print("inserting new genre")
        stmt= "INSERT INTO genre (genre_name) VALUES (?)"
        CURSOR1.execute(stmt, tuple([genreName]))
        genreId = CURSOR1.lastrowid
    else:
        genreId = output[0]
        
    print(genreId)
    DB.commit()
    return genreId    

def insertGenreGame(genreId, gameId):
    stmt = "SELECT game_id, genre_id FROM game_genre WHERE game_id = ? AND genre_id = ?"
    CURSOR1.execute(stmt, tuple([gameId, genreId]))
    output = CURSOR1.fetchone()
    
    if output is None:
        print("inserting new game_genre")
        stmt= "INSERT INTO game_genre (game_id, genre_id) VALUES (?,?)"
        CURSOR1.execute(stmt, tuple([gameId, genreId]))
       
    DB.commit()

def insertPublisherGame(publisherId, gameId):
    stmt = "SELECT game_id, publisher_id FROM game_publisher WHERE game_id = ? AND publisher_id = ?"
    CURSOR1.execute(stmt, tuple([gameId, publisherId]))
    output = CURSOR1.fetchone()
    
    if output is None:
        print("inserting new publisher_game")
        stmt= "INSERT INTO game_publisher (game_id, publisher_id) VALUES (?,?)"
        CURSOR1.execute(stmt, tuple([gameId, publisherId]))
       
    DB.commit()   

def insertPriceRecordForGame(game, gameId):
    stmt = "INSERT INTO price_record (game_id, timestamp, current_price) VALUES (?,?,?)"
    CURSOR1.execute(stmt, tuple([gameId, time.strftime('%Y-%m-%d %H:%M:%S'), game['pricing']]))
    DB.commit() 



def main():
    url = 'https://www.epicgames.com/store/en-US/browse?sortBy=title&sortDir=ASC&count=40&start=0'
#   driver = webdriver.Firefox(executable_path='D:/EpicGames Price Tracker/Drivers/geckodriver.exe')
#   driver = webdriver.Firefox(executable_path=':/')

    PROJECT_ROOT = os.path.abspath(os.path.dirname(__file__))
    DRIVER_BIN = os.path.join(PROJECT_ROOT, "chromedriver.exe")
    driver = webdriver.Chrome(executable_path = DRIVER_BIN)
    driver.get(url)

    
    element = WebDriverWait(driver, 10).until(
        EC.presence_of_element_located((By.CLASS_NAME, "css-zgal9t-DiscoverCardLayout__component"))
    )

    body = driver.find_element_by_tag_name('body') 

    genreLink = driver.find_element_by_xpath("//div[@data-component='FilterSectionTitleText' and text()='Genre']")
    genreTab = genreLink.find_element_by_xpath("./../../..")
    genres = genreTab.find_elements_by_class_name('css-29uz1d-CheckableFilter__CheckableFilter')


    previousGenre = None

    for genre in genres:
        print(genre.text)
        if previousGenre != None:
            previousGenre.click()
            time.sleep(2)
        
        genre.click() 
        time.sleep(3)
        driver.find_element_by_tag_name('body').send_keys(Keys.CONTROL + Keys.HOME)
        previousGenre = genre
        genreGames = getAllGenreGames(driver)  
        insertGamesWithGenre(genre.text,genreGames)
        print(genreGames)
        print("\n\n")


main()


      





    


    


