package server;

public class CNameChange {
	private CNameChange instance;

	public CNameChange getInstance() {
		if (instance == null) {
			instance = new CNameChange();
		}
		return instance;
	}
	//schreibt den NameChange in die DB
	public void nameChange(String data, ServerThread s) {
		RegiSplitter.getInstance().returnRegiInfos(data);
		DatabaseConnection connectionDB = new DatabaseConnection();
		//Ueberprueft ob der UserName schon vergeben ist
		connectionDB.ConnectionNameChange("SELECT UserName FROM Data", s,
				RegiSplitter.getInstance().getRegiInfos());
		//schreibt den neuen Namen in die DB
		if (connectionDB.isUsernameAvailable()) {
			connectionDB.ConnectionNameChange("UPDATE Data SET UserName = '"
					+ RegiSplitter.getInstance().getRegiInfos()[1]
					+ "' WHERE UserName = '"
					+ RegiSplitter.getInstance().getRegiInfos()[0] + "'", s,
					RegiSplitter.getInstance().getRegiInfos());
		}
	}
}
