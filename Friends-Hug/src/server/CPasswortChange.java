package server;

public class CPasswortChange {
	private CPasswortChange instance;

	public CPasswortChange getInstance() {
		if (instance == null) {
			instance = new CPasswortChange();
		}
		return instance;
	}
	//schreibt das neue Passwort in die DB
	public void passwortChange(String data, ServerThread s) {
		RegiSplitter.getInstance().returnRegiInfos(data);
		DatabaseConnection connectionDB = new DatabaseConnection();
		connectionDB.ConnectionPasswortChange("UPDATE Data SET Passwort = '"
				+ RegiSplitter.getInstance().getRegiInfos()[1]
				+ "' WHERE UserName = '"
				+ RegiSplitter.getInstance().getRegiInfos()[0] + "'", s,
				RegiSplitter.getInstance().getRegiInfos());
	}
}
