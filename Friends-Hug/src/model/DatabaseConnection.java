package model;

import java.sql.Connection;
import java.sql.DriverManager;  
import java.sql.ResultSet;  
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.xml.crypto.Data;

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
	public void Connection(String sqlStatement, ServerThread s, String[]data){
		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement =null;
		String searchUserID = "SELECT USERID from Data";
		String searchUserName = "SELECT UserName FROM Data";
		String writeUserDB = "INSERT INTO Data (UserID,UserName,MailAdress,Passwort,Name,Firstname,NewPasswort,UserLoggedIn) VALUES(" +
				ID + data[2] + ',' + data[4] + ',' + data[3] + ',' + data[1] + ',' + data[0] +')';
		
		
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:db/FriendsHug.db3");
			statement = connection.createStatement();
			if(sqlStatement.equals(searchUserName)){
				resultSet = statement.executeQuery(searchUserName);
				while(resultSet.next()){
					if(resultSet.getString(1).equals(RegiSplitter.getInstance().getRegiInfos()[2])){
						s.sendServerThread("FLAG_REGI;"+"Benutzername schon vergeben");
					}
				}
			}
//			resultSet = statement.executeQuery("Select * from Data");
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
