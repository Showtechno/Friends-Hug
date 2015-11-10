package model;

import java.sql.Connection;
import java.sql.DriverManager;  
import java.sql.ResultSet;  
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
	public void Connection(){
		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement =null;
		
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:db/FriendsHug.db3");
			statement = connection.createStatement();
			resultSet = statement.executeQuery("Select * from Data");
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
