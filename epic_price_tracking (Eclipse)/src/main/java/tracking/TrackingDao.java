package tracking;

import java.sql.Connection;
import config.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import game.domain.Game;
import genre.domain.Genre;

public class TrackingDao {
	
	
	public List<Object> getMyList(String userId) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/" + DBConfig.db_name + "?"
				              + "user="+DBConfig.db_user+"&password="+DBConfig.db_password);
			
			
			String sql = "SELECT G.id,G.name,G.thumbnail,G.price,publisher.publisher_name from game G "
					+ "LEFT JOIN game_publisher AS GP ON G.id = GP.game_id "
					+ "LEFT JOIN publisher ON GP.publisher_id = publisher.id "
					+ "WHERE EXISTS "
					+ "(SELECT * FROM user_interested_game WHERE user_interested_game.game_id = G.id AND user_interested_game.user_id = ?) ";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,userId);
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
	
	public void add(UserGame userGame) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/" + DBConfig.db_name + "?"
				              + "user="+DBConfig.db_user+"&password="+DBConfig.db_password);
			
			
			String sql = "INSERT INTO `user_interested_game` (`game_id`, `user_id`) VALUES (?, ?); ";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,userGame.getGame_id());
		    preparestatement.setString(2,userGame.getUser_id());
		    preparestatement.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void remove(UserGame userGame) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/" + DBConfig.db_name + "?"
				              + "user="+DBConfig.db_user+"&password="+DBConfig.db_password);
			
			
			String sql = "DELETE FROM `user_interested_game` WHERE game_id=? AND user_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,userGame.getGame_id());
		    preparestatement.setString(2,userGame.getUser_id());
		    preparestatement.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
