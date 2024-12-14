# cs480---course-project-epic_price_tracking
cs480---course-project-epic_price_tracking created by GitHub Classroom

Team Members:
- Sampath Gottikere Kumaraiah
- Ajay Sagar Nandimandalam
- Sanjay Kalidindi


Project Name: epic_price_tracking

Project Description:
The Epic Game Store has games which have a unique name, publisher, genre, and other details associated with the game. Each publisher had published multiple games over the years. Each game might have addons like the DLC but require the base game to function. Our web scraping tool will scrape the Epic Game Store for prices daily and record the prices for all the games and addons. Users can register for notifications from the web tool on price drops for specific games. For every time we run our web scraping tool, we compare the current price to the previous price, and notify all users who subscribed to be notified for that particular game.
Our GUI tool, a web application for users to select games by publisher, genre, and view price history of the game. It will also allow users to select add-ons associated with a game and view the price history. Users will have full freedom to choose any permutation of selections for notifications on price drop.


# Running this project:

This project populates the database using a python web scraping tool which fetches information about games along with relevant information from the EPIC GAMES store.

1. Create a Maven project in eclipse with the folder epic_price_tracking (Eclipse) as the root of the project.
2. Update the maven dependencies and deploy the project using Tomcat.
3. Create a table within in your database called tb_user(Sql query can be found in src/main/webapp/sql/user.sql)
4. Open the deployed website in a web browser and login by registering a user.
5. Click on initialize database to setup the database tables.
6. Next you will need to run the web scraping script which will populate the database tables with information from the epic games store.
    1. To run the pyton script you will need to install selenium and mysql python dependencies.
    2. Download geckodriver for firefox browser. (https://github.com/mozilla/geckodriver/releases)
    3. Modify the <b>getDetailsScraper.py</b> file and change the driver path to point to the geckodriver downloaded.
    4. Execute <b>"py getDetailsScraper.py"</b> (can take approximately 5 mins)
    
7. After the script is done executing. Navigate to the Home tab in the webpage to see the list of all games.


Once deployed, logged-in users are able to filter the games based on the Genre, Publisher or both. 
Users can also select games that they want to track and also view a separate list of games that they are tracking. Users will also have the ability to remove games they are no longer interested in from the tracking list.


UI for CRUD functionality Implemented for the following entities:-

1. User
2. Game
3. Publisher
4. Genre

# Preview

![alt text](https://raw.githubusercontent.com/diamalab/cs480---course-project-epic_price_tracking/main/documentation/Preview/HomePagePreview.PNG)



