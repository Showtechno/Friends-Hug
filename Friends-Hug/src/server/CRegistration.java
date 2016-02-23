package server;

public class CRegistration {

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
		DatabaseConnection connectionDB = new DatabaseConnection();
		connectionDB.ConnectionRegi("SELECT UserName FROM Data", s, RegiSplitter
				.getInstance().getRegiInfos());
		if (connectionDB.isEmailAvailable()) {
			connectionDB.ConnectionRegi("SELECT MailAdress FROM Data", s,
					RegiSplitter.getInstance().getRegiInfos());
			if (connectionDB.isEmailAvailable()) {
				connectionDB
						.ConnectionRegi(
								"INSERT INTO Data (UserID,UserName,MailAdress,Passwort,Name,Firstname,NewPasswort,UserLoggedIn) VALUES("
										+ connectionDB.IDNumberSearchLast()
										+ RegiSplitter.getInstance()
												.getRegiInfos()[2]
										+ ','
										+ RegiSplitter.getInstance()
												.getRegiInfos()[4]
										+ ','
										+ RegiSplitter.getInstance()
												.getRegiInfos()[3]
										+ ','
										+ RegiSplitter.getInstance()
												.getRegiInfos()[1]
										+ ','
										+ RegiSplitter.getInstance()
												.getRegiInfos()[0] + ')', s,
								RegiSplitter.getInstance().getRegiInfos());
			}
		}
		// Codegenerator generator = new Codegenerator();
		// generator.generate();
		// Mail.getInstance().sendMail(RegiSplitter.getInstance().getRegiInfos()[4],
		// generator.getCode());
		// daten in db speichern
	}
}
