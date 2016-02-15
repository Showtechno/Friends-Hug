package model;

public class CRegistration {

	private CRegistration instance;
	
	public CRegistration getInstance(){
		if(instance==null){
			instance = new CRegistration();
		}
		return instance;
		
	}
	/*
	 * 0 = Vorname
	 * 1 = Nachname
	 * 2 = Benutzername
	 * 3 = Passwort
	 * 4 = Email-Adresse
	 */
	
	public void writeRegiIntoDB(String data, ServerThread s){
		RegiSplitter.getInstance().returnRegiInfos(data);
		DatabaseConnection connectionDB = new DatabaseConnection();
		connectionDB.Connection("SELECT UserName FROM Data", s);
//		Codegenerator generator = new Codegenerator();
//		generator.generate();
//		Mail.getInstance().sendMail(RegiSplitter.getInstance().getRegiInfos()[4], generator.getCode());
		// daten in db speichern
	}
}
