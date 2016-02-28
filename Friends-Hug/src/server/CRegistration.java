package server;

public class CRegistration {

	DatabaseConnection connectionDB = new DatabaseConnection();
	private CRegistration instance;

	// singelton Pattern
	public CRegistration getInstance() {
		if (instance == null) {
			instance = new CRegistration();
		}
		return instance;
	}

	/*
	 * 0 = Vorname 1 = Nachname 2 = Benutzername 3 = Passwort 4 = Email-Adresse
	 */
	// schreibt die Regisaten in die db
	public void writeRegiIntoDB(String data, ServerThread s) {
		RegiSplitter.getInstance().returnRegiInfos(data);
		// uebergibt einer neuen Klasse die Daten, die ueberprueft ob Username
		// schon einmal vergeben ist
		connectionDB.ConnectionRegi("SELECT UserName FROM Data", s,
				RegiSplitter.getInstance().getRegiInfos(), instance);
		LogfileWriter.getInstance().writeLogfile(
				"connect to Database: search if Username already in use");
		if (connectionDB.isUsernameAvailable()) {
			// uebergibt einer neuen Klasse die Daten, die ueberprueft ob
			// Emailadresse schon einmal vergeben ist{
			connectionDB.ConnectionRegi("SELECT MailAdress FROM Data", s,
					RegiSplitter.getInstance().getRegiInfos(), instance);
			LogfileWriter
					.getInstance()
					.writeLogfile(
							"connect to Database: search if Emailadresse already in use");
			if (connectionDB.isEmailAvailable()) {
				// schreibt die Registrationsdaten in die Datenbank
				connectionDB.ConnectionRegi("INSERT INTO Data VALUES('" + connectionDB.IDNumberSearchLast()
						+ "','" + RegiSplitter.getInstance().getRegiInfos()[2] + "','"
						+ RegiSplitter.getInstance().getRegiInfos()[4] + "','"
						+ RegiSplitter.getInstance().getRegiInfos()[3] + "','"
						+ RegiSplitter.getInstance().getRegiInfos()[1] + "','"
						+ RegiSplitter.getInstance().getRegiInfos()[0] + "'," + "'0'"
						+ "," + "'0'" + "," + null + ")", s, RegiSplitter.getInstance().getRegiInfos(),
						instance);
				LogfileWriter.getInstance().writeLogfile(
						"connect to Database: write Registration in Database");

			}
		}
	}
}
