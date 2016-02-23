package server;

import org.hamcrest.core.IsEqual;

public class CRegistration {

	DatabaseConnection connectionDB = new DatabaseConnection();
	private CRegistration instance;

	public CRegistration getInstance() {
		if (instance == null) {
			instance = new CRegistration();
		}
		return instance;
	}

	/*
	 * 0 = Vorname 1 = Nachname 2 = Benutzername 3 = Passwort 4 = Email-Adresse
	 */

	public void writeRegiIntoDB(String data, ServerThread s) {
		RegiSplitter.getInstance().returnRegiInfos(data);	
		connectionDB.ConnectionRegi("SELECT UserName FROM Data", s, RegiSplitter
				.getInstance().getRegiInfos(), instance);
		LogfileWriter.getInstance().writeLogfile("connect to Database: search if Username already in use");
		if (connectionDB.isUsernameAvailable()) {
			connectionDB.ConnectionRegi("SELECT MailAdress FROM Data", s,RegiSplitter.getInstance().getRegiInfos(), instance);
			LogfileWriter.getInstance().writeLogfile("connect to Database: search if Emailadresse already in use");
			if (connectionDB.isEmailAvailable()) {
				connectionDB
						.ConnectionRegi(
								"INSERT INTO Data VALUES("
										+ "'" + connectionDB.IDNumberSearchLast()+"'" 
										+ ','
										+ "'"+RegiSplitter.getInstance()
												.getRegiInfos()[2]+"'"
										+ ','
										+ "'"+RegiSplitter.getInstance()
												.getRegiInfos()[4]+"'"
										+ ','
										+ "'"+RegiSplitter.getInstance()
												.getRegiInfos()[3]+"'"
										+ ','
										+ "'"+RegiSplitter.getInstance()
												.getRegiInfos()[1]+"'"
										+ ','
										+ "'"+RegiSplitter.getInstance()
												.getRegiInfos()[0]+"'" +",'"+0+"'"+ ','
												+"'"+0+"'"+"," + null+ ')', s,
								RegiSplitter.getInstance().getRegiInfos(), instance);
				LogfileWriter.getInstance().writeLogfile("connect to Database: write Registration in Database");

			}
		}


	}
}
