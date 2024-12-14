package initializeDB.dao;

import java.sql.Connection;
import config.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import user.domain.User;


public class InitializeDBDao {
	
	
	/**
	 * create the tables for the database
	 * @param username
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void createDB() {
		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/" + DBConfig.db_name + "?"
				              + "user="+DBConfig.db_user+"&password="+DBConfig.db_password);
		    
			Statement statement = connect.createStatement();
			
		
			statement.execute("SET FOREIGN_KEY_CHECKS=0");
			
			statement.executeUpdate("DROP TABLE IF EXISTS phone_number");
			statement.executeUpdate("DROP TABLE IF EXISTS game");
			statement.executeUpdate("DROP TABLE IF EXISTS price_record");
			statement.executeUpdate("DROP TABLE IF EXISTS genre");
			statement.executeUpdate("DROP TABLE IF EXISTS publisher");
			statement.executeUpdate("DROP TABLE IF EXISTS game_genre");
			statement.executeUpdate("DROP TABLE IF EXISTS user_interested_game");
			statement.executeUpdate("DROP TABLE IF EXISTS game_publisher");
			statement.executeUpdate("DROP TABLE IF EXISTS alert_log");
			
			statement.execute("SET FOREIGN_KEY_CHECKS=0");
			
			String sqlstmt = "Create TABLE phone_number("
					+ "    user_id INT,\r\n"
					+ "    phoneNo INT(12) UNIQUE NOT NULL,"
					+ "\r\n"
					+ "    PRIMARY KEY (user_id, phoneNo),\r\n"
					+ "    FOREIGN KEY (user_id) REFERENCES tb_user(id)"
					+ "    ON DELETE CASCADE"
					+ "    ON UPDATE CASCADE"
					+ ");";
			
			statement.executeUpdate(sqlstmt);
			
			sqlstmt = "Create Table game("
					+ "    id INT AUTO_INCREMENT,"
					+ "    name VARCHAR(215) NOT NULL,"
					+ "    thumbnail VARCHAR(512),"
					+ "    price DECIMAL(5,2),\r\n"
					+ ""
					+ "    PRIMARY KEY (id)\r\n"
					+ ");";

			statement.executeUpdate(sqlstmt);
			
			sqlstmt = "CREATE TABLE price_record("
					+ "    id INT AUTO_INCREMENT,"
					+ "    game_id INT NOT NULL,"
					+ "    timestamp DATETIME NOT NULL,"
					+ "    current_price DECIMAL(5,2) NOT NULL,"
					+ ""
					+ "    PRIMARY KEY (id),"
					+ "    FOREIGN KEY (game_id) REFERENCES game(id)"
					+ "    ON DELETE CASCADE"
					+ "    ON UPDATE CASCADE"
					+ ");";

					statement.executeUpdate(sqlstmt);
					
					sqlstmt = "CREATE TABLE genre("
					+ "    id INT AUTO_INCREMENT,"
					+ "    genre_name VARCHAR(215) NOT NULL,"
					+ "    parent_genre INT,"
					+ ""
					+ "    PRIMARY KEY (id),"
					+ "    UNIQUE (genre_name, parent_genre),"
					+ "    FOREIGN KEY (parent_genre) REFERENCES Genre (id)"
					+ "    ON DELETE CASCADE"
					+ "    ON UPDATE CASCADE"
					+ ");";

					statement.executeUpdate(sqlstmt);
					
					sqlstmt =  "CREATE TABLE publisher("
					+ "    id INT AUTO_INCREMENT,"
					+ "    publisher_name VARCHAR(215) UNIQUE NOT NULL,"
					+ ""
					+ "    PRIMARY KEY (id)"
					+ ");";

					statement.executeUpdate(sqlstmt);
					
					sqlstmt = "CREATE TABLE game_genre("
					+ "    game_id INT,"
					+ "    genre_id INT,"
					+ ""
					+ "    PRIMARY KEY (game_id, genre_id),"
					+ "    FOREIGN KEY (game_id) REFERENCES game(id)"
					+ "    ON DELETE CASCADE"
					+ "    ON UPDATE CASCADE,"
					+ "    FOREIGN KEY (genre_id) REFERENCES genre(id)"
					+ "    ON DELETE CASCADE"
					+ "    ON UPDATE CASCADE"
					+ ");";

					statement.executeUpdate(sqlstmt);
					
					sqlstmt =  "CREATE TABLE user_interested_game("
					+ "    game_id INT,"
					+ "    user_id INT,"
					+ ""
					+ "    PRIMARY KEY (game_id, user_id),"
					+ "    FOREIGN KEY (game_id) REFERENCES game(id)"
					+ "    ON DELETE CASCADE"
					+ "    ON UPDATE CASCADE,"
					+ "    FOREIGN KEY (user_id) REFERENCES tb_user(id)"
					+ "    ON DELETE CASCADE"
					+ "    ON UPDATE CASCADE"
					+ ");";

					statement.executeUpdate(sqlstmt);
					
					sqlstmt =  "CREATE TABLE game_publisher("
					+ "    game_id INT,"
					+ "    publisher_id INT,"
					+ ""
					+ "    PRIMARY KEY (game_id, publisher_id),"
					+ "    FOREIGN KEY (game_id) REFERENCES game(id)"
					+ "    ON DELETE CASCADE"
					+ "    ON UPDATE CASCADE,"
					+ "    FOREIGN KEY (publisher_id) REFERENCES publisher(id)"
					+ "    ON DELETE CASCADE"
					+ "    ON UPDATE CASCADE"
					+ ");";

					statement.executeUpdate(sqlstmt);
					
					sqlstmt =  "CREATE TABLE alert_log("
					+ "    id INT AUTO_INCREMENT,"
					+ "    user_id INT,\r\n"
					+ "    game_id INT,\r\n"
					+ "    timestamp DATETIME NOT NULL,"
					+ ""
					+ "    PRIMARY KEY (id),"
					+ "    FOREIGN KEY (user_id) REFERENCES tb_user(id),"
					+ "    FOREIGN KEY (game_id) REFERENCES game(id)"
					+ ");";
			
					statement.executeUpdate(sqlstmt);
					
					statement.close();
			
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void InsertEntries() {
		try {
					
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection connect = DriverManager
						.getConnection("jdbc:mysql://localhost:3306/" + DBConfig.db_name + "?"
					              + "user="+DBConfig.db_user+"&password="+DBConfig.db_password);
				    
				Statement statement = connect.createStatement();
				
				
				String sqlstmt = "INSERT INTO `game`(`name`, `thumbnail`, `price`) \r\n"
						+ "VALUES ('game1','https://testurl','45'),('gam2','https://testurl','45'),('game2','https://testurl','45')";
				
				statement.executeUpdate(sqlstmt);
				
				sqlstmt = "INSERT INTO genre( genre_name, parent_genre) \r\n"
						+ "VALUES ('Action',NULL),('Adventure',NULL),('Shooter',NULL);";
				
				statement.executeUpdate(sqlstmt);
				
				sqlstmt = "INSERT INTO `publisher`(`publisher_name`) VALUES ('Ubisoft'), ('EA'), ('Rockstar Games');";
				
				statement.executeUpdate(sqlstmt);
				statement.close();
				
		}catch(SQLException e) {
			throw new RuntimeException(e);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

		
}
