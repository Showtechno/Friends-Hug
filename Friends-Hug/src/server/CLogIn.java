package server;


public class CLogIn{

	private CLogIn instance;

	public CLogIn getInstance() {
		if (instance == null) {
			instance = new CLogIn();
		}
		return instance;
	}
	//Ueberprueft die LogIn Daten
	public void logIn(String data, ServerThread s){
		RegiSplitter.getInstance().returnRegiInfos(data);
		DatabaseConnection connectionDB = new DatabaseConnection();
		//Ueberprueft ob eine Mail-Addresse eingegeben wurde
		if(RegiSplitter.getInstance().getRegiInfos()[0].contains("@")){
			connectionDB.ConnectionLogIn("SELECT Passwort FROM Data WHERE MailAdress = '"+RegiSplitter.getInstance()
					.getRegiInfos()[0]+"'", s, RegiSplitter
					.getInstance().getRegiInfos());
		}
		//Sonst wird der UserName verwendet
		else{
			connectionDB.ConnectionLogIn("SELECT Passwort FROM Data WHERE USERName = '"+RegiSplitter.getInstance()
					.getRegiInfos()[0]+"'", s, RegiSplitter
					.getInstance().getRegiInfos());
		}

	}
}
