package genre.dao;

import java.sql.Connection;
import config.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import genre.domain.Genre;
import user.domain.User;




/**
 * DDL functions performed in database
 * @author changxin bai
 *
 */
public class GenreDao {
	
	/**
	 * insert User
	 * @param user
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void add(Genre genre) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/" + DBConfig.db_name + "?"
				              + "user="+DBConfig.db_user+"&password="+DBConfig.db_password);
			
			
			String sql = "INSERT INTO `genre` (`genre_name`, `parent_genre`) VALUES (?, ?); ";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,genre.getName());
		    preparestatement.setInt(2,(genre.getParentGenre().isEmpty()? Types.NULL: Integer.parseInt(genre.getParentGenre())));
		    preparestatement.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/" + DBConfig.db_name + "?"
				              + "user="+DBConfig.db_user+"&password="+DBConfig.db_password);
			
			
			String sql = "select * from genre";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			
			while(resultSet.next()){
				Genre genre = new Genre();
				genre.setId(resultSet.getString("id"));
				genre.setName(resultSet.getString("genre_name"));
	    		genre.setParentGenre(resultSet.getString("parent_genre"));
	    		list.add(genre);
			 }
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	public Genre findById(String id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Genre genre = new Genre();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		    String sql = "select * from genre where id=?";
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/" + DBConfig.db_name + "?"
				              + "user="+DBConfig.db_user+"&password="+DBConfig.db_password);
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,id);
		    ResultSet resultSet = preparestatement.executeQuery();
		    //ResultSet resultSet  = preparestatement.executeUpdate();
		    while(resultSet.next()){
		    	String user_name = resultSet.getString("id");
		    	if(user_name.equals(id)){
		    		genre.setId(resultSet.getString("id"));
		    		genre.setName(resultSet.getString("genre_name"));
		    		genre.setParentGenre(resultSet.getString("parent_genre"));
		    	}
		    }
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return genre;
	}
	
	public Genre updateGenre(Genre genre) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		try {		
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	    String sql = "UPDATE genre SET genre_name=?,parent_genre=? WHERE id = ?";
		Connection connect = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/" + DBConfig.db_name + "?"
			              + "user="+DBConfig.db_user+"&password="+DBConfig.db_password);
	    PreparedStatement preparestatement = connect.prepareStatement(sql); 
	    preparestatement.setString(1,genre.getName());
	    preparestatement.setInt(2,(genre.getParentGenre().isEmpty()?Types.NULL:Integer.parseInt(genre.getParentGenre())));
	    preparestatement.setString(3,genre.getId());
	    System.out.println(preparestatement.toString());
	    preparestatement.executeUpdate();

	} catch(SQLException e) {
		throw new RuntimeException(e);
	}
	return genre;
		
		
	}
	
	public Genre deleteGenre(Genre genre) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	    String sql = "DELETE FROM genre WHERE id = ? ";
		Connection connect = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/" + DBConfig.db_name + "?"
			              + "user="+DBConfig.db_user+"&password="+DBConfig.db_password);
	    PreparedStatement preparestatement = connect.prepareStatement(sql); 
	    preparestatement.setString(1,genre.getId());
	    System.out.println(preparestatement.toString());
	    preparestatement.executeUpdate();

	} catch(SQLException e) {
		throw new RuntimeException(e);
	}
	return genre;
		
		
	}
	
	
		
}
