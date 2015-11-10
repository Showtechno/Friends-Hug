package model;

import java.sql.Connection;
import java.sql.DriverManager;  
import java.sql.ResultSet;  
import java.sql.SQLException;
import java.sql.Statement;

//UserID = Einmalige ID der Users
//UserName = Name des Benutzers im Chatprogramm
//MailAdress = E-Mail Adresse des Users
//Passwort = Passwort des Users
//Name = Nachname des Users
//FirstName = Vorname des Users
//NewPasswort = Flag ob das Passwort neu gestzt werden muss
//UserLoggedIn = Flag ob der Userr eingeloggt ist oder nicht
//Code = Code welcher der User beim ersten anmelden eingeben muss

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
