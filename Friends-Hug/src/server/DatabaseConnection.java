package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

	private boolean isUsernameAvailable;
	private boolean isEmailAvailable;

	public boolean isUsernameAvailable() {
		return isUsernameAvailable;
	}

	public void setUsernameAvailable(boolean isUsernameAvailable) {
		this.isUsernameAvailable = isUsernameAvailable;
	}

	public boolean isEmailAvailable() {
		return isEmailAvailable;
	}

	public void setEmailAvailable(boolean isEmailAvailable) {
		this.isEmailAvailable = isEmailAvailable;
	}

	// holt sich die aktuelle hoechtste userID und returned die naechst hoehere
	public String IDNumberSearchLast() {
		String searchUserID = "SELECT USERID from Data";
		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;
		int lastID = 0;
		try {
			connection = DriverManager
					.getConnection("jdbc:sqlite:db/FriendsHug.db3");
			statement = connection.createStatement();
			resultSet = statement.executeQuery(searchUserID);
			while (resultSet.next()) {
				lastID = (Integer.valueOf(resultSet.getString(1)));
			}
			lastID++;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return Integer.toString(lastID);
	}

	public void ConnectionLogIn(String sqlStatement, ServerThread s,
			String[] data) {
		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;
		String logInName = "SELECT Passwort FROM Data WHERE USERName = '"
				+ RegiSplitter.getInstance().getRegiInfos()[0] + "'";
		String logInMail = "SELECT Passwort FROM Data WHERE MailAdress = '"
				+ RegiSplitter.getInstance().getRegiInfos()[0] + "'";
		try {
			connection = DriverManager
					.getConnection("jdbc:sqlite:db/FriendsHug.db3");
			statement = connection.createStatement();
			LogfileWriter.getInstance().writeLogfile("connect to Database");
			if (sqlStatement.equals(logInName)) {
				resultSet = statement.executeQuery(logInName);
				while (resultSet.next()) {
					if (resultSet.getString(1).equals(data[1])) {
						s.sendServerThread("FLAG_LOGIN;1," + data[0]);
						s.setUsername(data[0]);
					} else {
						s.sendServerThread("FLAG_LOGIN;0");
					}
				}
				resultSet.close();
			} else if (sqlStatement.equals(logInMail)) {
				resultSet = statement.executeQuery(logInMail);
				while (resultSet.next()) {
					if (resultSet.getString(1).equals(data[1])) {

						s.sendServerThread("FLAG_LOGIN;1," + data[0]);
						s.setUsername(data[0]);
					} else {
						s.sendServerThread("FLAG_LOGIN;0");
					}
				}
				resultSet.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
/*baut die verbindung zur Datenbank auf und verarbeitet die empfangenen Daten
 * ueberprueft ob username oder Email schon einmal vergeben sind und schreibt bei erfolgreichen ueberpfuefung
 * die Registrationsdaten in die Datenbank
 */
	public void ConnectionRegi(String sqlStatement, ServerThread s,
			String[] data, CRegistration regi) {
		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;
		String searchUserName = "SELECT UserName FROM Data";
		String searchEmail = "SELECT MailAdress FROM Data";
		String writeUserDB = "INSERT INTO Data VALUES('" + IDNumberSearchLast()
				+ "','" + data[2] + "','" + data[4] + "','" + data[3] + "','"
				+ data[1] + "','" + data[0] + "'," + "'0'" + "," + "'0'" + ","
				+ null + ')';
		try {
			connection = DriverManager
					.getConnection("jdbc:sqlite:db/FriendsHug.db3");
			statement = connection.createStatement();
			//UserName ueberpruefung
			if (sqlStatement.equals(searchUserName)) {
				resultSet = statement.executeQuery(searchUserName);
				while (resultSet.next()) {
					if (resultSet.getString(1).equals(
							RegiSplitter.getInstance().getRegiInfos()[2])) {
						s.sendServerThread("FLAG_REGI;Benutzername schon vergeben");
						setUsernameAvailable(false);
						LogfileWriter.getInstance().writeLogfile(
								"Registration failed. Username already in use");
					} else {
						setUsernameAvailable(true);
					}
				}
			}
			//Email ueberpruefung
			if (sqlStatement.equals(searchEmail)) {
				resultSet = statement.executeQuery(searchEmail);
				while (resultSet.next()) {
					if (resultSet.getString(1).equals(
							RegiSplitter.getInstance().getRegiInfos()[4])) {
						s.sendServerThread("FLAG_REGI;Email schon vergeben");
						setEmailAvailable(false);
						LogfileWriter.getInstance().writeLogfile(
								"Registration failed. Email already in use");
					} else {
						setEmailAvailable(true);
					}
				}
			}
			//schreiben in die Datenbank(Registrationsdaten)
			if (sqlStatement.equals(writeUserDB)) {
				statement.executeUpdate(writeUserDB);
				s.sendServerThread("FLAG_REGI;SUCCESS");
				LogfileWriter.getInstance().writeLogfile(
						"Registration complete");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
