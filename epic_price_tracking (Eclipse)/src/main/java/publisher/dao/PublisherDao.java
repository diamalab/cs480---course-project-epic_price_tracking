package publisher.dao;

import java.sql.Connection;
import config.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import publisher.domain.Publisher;
import user.domain.User;

public class PublisherDao {
	
	
	public void add(Publisher publisher) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/" + DBConfig.db_name + "?"
				              + "user="+DBConfig.db_user+"&password="+DBConfig.db_password);
			
			
			String sql = "insert into publisher(publisher_name) values(?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,publisher.getPublisherName());
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
					.getConnection("jdbc:mysql://localhost:3306/" + DBConfig.db_name + "?"
				              + "user="+DBConfig.db_user+"&password="+DBConfig.db_password);
			
			
			String sql = "select * from publisher";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			
			while(resultSet.next()){
				Publisher publisher = new Publisher();
				publisher.setId(resultSet.getString("id"));
				publisher.setPublisherName(resultSet.getString("publisher_name"));
				list.add(publisher);
			}
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	
	public Publisher findById(String id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Publisher publisher = new Publisher();
		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		    String sql = "select * from publisher where id=?";
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
		    		publisher.setId(resultSet.getString("id"));
		    		publisher.setPublisherName(resultSet.getString("publisher_name"));
		    	}
		    }
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return publisher;
	}
	
	public Publisher updatePublisher(Publisher publisher) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		try {		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
	    String sql = "UPDATE publisher SET publisher_name=? WHERE id = ?";
		Connection connect = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/" + DBConfig.db_name + "?"
			              + "user="+DBConfig.db_user+"&password="+DBConfig.db_password);
	    PreparedStatement preparestatement = connect.prepareStatement(sql); 
	    preparestatement.setString(1,publisher.getPublisherName());
	    preparestatement.setString(2,publisher.getId());
	    preparestatement.executeUpdate();

	} catch(SQLException e) {
		throw new RuntimeException(e);
	}
	return publisher;
				
	}
	
	public Publisher deletePublisher(Publisher publisher) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		try {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
	    String sql = "DELETE FROM publisher WHERE id = ? ";
		Connection connect = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/" + DBConfig.db_name + "?"
			              + "user="+DBConfig.db_user+"&password="+DBConfig.db_password);
	    PreparedStatement preparestatement = connect.prepareStatement(sql); 
	    preparestatement.setString(1,publisher.getId());
	    System.out.println(preparestatement.toString());
	    preparestatement.executeUpdate();

	} catch(SQLException e) {
		throw new RuntimeException(e);
	}
	return publisher;		
	}
	
	
}
