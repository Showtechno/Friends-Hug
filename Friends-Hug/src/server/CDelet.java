package server;

public class CDelet {
	private CDelet instance;

	public CDelet getInstance() {
		if (instance == null) {
			instance = new CDelet();
		}
		return instance;
	}

	// schreibt das neue Passwort in die DB
	public void userDelet(String data, ServerThread s) {
		RegiSplitter.getInstance().returnRegiInfos(data);
		DatabaseConnection connectionDB = new DatabaseConnection();
		connectionDB.ConnectionUserDelet(
				"DELETE FROM Data WHERE UserName = '"
						+ RegiSplitter.getInstance().getRegiInfos()[0] + "'",
				s, RegiSplitter.getInstance().getRegiInfos());
	}
}
