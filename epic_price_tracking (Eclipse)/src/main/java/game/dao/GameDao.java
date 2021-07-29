package game.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import java.util.ArrayList;
import java.util.List;

import game.domain.Game;
import tracking.MyGame;
import tracking.UserGame;
import user.domain.User;




/**
 * DDL functions performed in database
 * @author changxin bai
 *
 */
public class GameDao {
	
	/**
	 * insert User
	 * @param user
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void add(Game game) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/epic_tracking?"
				              + "user=root&password=");
			
			
			String sql = "insert into game(name,thumbnail,price) values(?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,game.getName());
		    preparestatement.setString(2,game.getThumbnail());
		    preparestatement.setString(3,game.getPrice());
		    preparestatement.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/epic_tracking?"
				              + "user=root&password=");
			
			
			String sql = "SELECT game.id,game.name,game.thumbnail,game.price,publisher.publisher_name from game \r\n"
					+ "LEFT JOIN game_publisher AS GP ON game.id = GP.game_id \r\n"
					+ "LEFT JOIN publisher ON GP.publisher_id = publisher.id ";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			
			while(resultSet.next()){
				MyGame game = new MyGame();
				game.setId(resultSet.getString("id"));
				game.setName(resultSet.getString("name"));
	    		game.setThumbnail(resultSet.getString("thumbnail"));
	    		game.setPrice(resultSet.getString("price"));
	    		game.setPublisher(resultSet.getString("publisher_name"));
	    		list.add(game);
			 }
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	public Game findById(String id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Game game = new Game();
		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		    String sql = "select * from game where id=?";
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/epic_tracking?"
				              + "user=root&password=");
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,id);
		    ResultSet resultSet = preparestatement.executeQuery();
		    //ResultSet resultSet  = preparestatement.executeUpdate();
		    while(resultSet.next()){
		    	String user_name = resultSet.getString("id");
		    	if(user_name.equals(id)){
		    		game.setId(resultSet.getString("id"));
		    		game.setName(resultSet.getString("name"));
		    		game.setThumbnail(resultSet.getString("thumbnail"));
		    		game.setPrice(resultSet.getString("price"));
		    		
		    	}
		    }
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return game;
	}
	
	public Game updateGame(Game game) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		try {		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
	    String sql = "UPDATE game SET name=?,thumbnail=?,price=? WHERE id = ?";
		Connection connect = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/epic_tracking?"
			              + "user=root&password=");
	    PreparedStatement preparestatement = connect.prepareStatement(sql); 
	    preparestatement.setString(1,game.getName());
	    preparestatement.setString(2,game.getThumbnail());
	    preparestatement.setString(3,game.getPrice());
	    preparestatement.setString(4,game.getId());
	    System.out.println(preparestatement.toString());
	    preparestatement.executeUpdate();

	} catch(SQLException e) {
		throw new RuntimeException(e);
	}
	return game;
		
		
	}
	
	/**
	 * Function to query the list of games based on genre, publisher or both
	 * @param genre
	 * @param publisher
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	public List<Object> queryGames(String genre, String publisher) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		ArrayList<Object> list = new ArrayList<Object>();
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		try {
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/epic_tracking?"
				              + "user=root&password=");
			
			if(genre.isEmpty() && publisher.isEmpty()) {
				return findall();
			}
			
			PreparedStatement preparestatement = null;
			if(!genre.isEmpty() && !publisher.isEmpty()) { //return list of games belonging to genre and publisher
				String sql = "SELECT G.id,G.name,G.thumbnail,G.price,publisher.publisher_name FROM game G "
						+ "LEFT JOIN game_publisher AS GP ON G.id = GP.game_id "
						+ "LEFT JOIN publisher ON GP.publisher_id = publisher.id WHERE GP.publisher_id= ? "
						+ "AND EXISTS (SELECT * FROM game_genre WHERE game_genre.game_id = G.id AND game_genre.genre_id = ?)";
				preparestatement = connect.prepareStatement(sql);
				preparestatement.setString(1,publisher);
			    preparestatement.setString(2,genre);
			}else if(!genre.isEmpty()) { // return a list of games belonging to the genre
				String sql = "SELECT G.id,G.name,G.thumbnail,G.price,publisher.publisher_name FROM game G "
						+ "LEFT JOIN game_publisher AS GP ON G.id = GP.game_id "
						+ "LEFT JOIN publisher ON GP.publisher_id = publisher.id "
						+ "WHERE EXISTS (SELECT * FROM game_genre WHERE game_genre.game_id = G.id AND game_genre.genre_id = ?)";
				preparestatement = connect.prepareStatement(sql);
				preparestatement.setString(1,genre);
			}else if(!publisher.isEmpty()) { //return a list of games belonging to publisher
				String sql = "SELECT G.id,G.name,G.thumbnail,G.price,publisher.publisher_name FROM game G "
						+ "LEFT JOIN game_publisher AS GP ON G.id = GP.game_id "
						+ "LEFT JOIN publisher ON GP.publisher_id = publisher.id WHERE GP.publisher_id=?";
				preparestatement = connect.prepareStatement(sql);
				preparestatement.setString(1,publisher);
			}
			
			ResultSet resultSet = preparestatement.executeQuery();
			
			while(resultSet.next()){
				MyGame game = new MyGame();
				game.setId(resultSet.getString("id"));
				game.setName(resultSet.getString("name"));
	    		game.setThumbnail(resultSet.getString("thumbnail"));
	    		game.setPrice(resultSet.getString("price"));
	    		game.setPublisher(resultSet.getString("publisher_name"));
	    		list.add(game);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public Game deleteGame(Game game) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		try {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
	    String sql = "DELETE FROM game WHERE id = ? ";
		Connection connect = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/epic_tracking?"
			              + "user=root&password=");
	    PreparedStatement preparestatement = connect.prepareStatement(sql); 
	    preparestatement.setString(1,game.getId());
	    System.out.println(preparestatement.toString());
	    preparestatement.executeUpdate();

	} catch(SQLException e) {
		throw new RuntimeException(e);
	}
	return game;
		
		
	}
	
	
		
}
