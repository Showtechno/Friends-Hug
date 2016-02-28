package server;

public class CNameChange {
	private CNameChange instance;

	public CNameChange getInstance() {
		if (instance == null) {
			instance = new CNameChange();
		}
		return instance;
	}

	public void nameChange(String data, ServerThread s) {
		RegiSplitter.getInstance().returnRegiInfos(data);
		DatabaseConnection connectionDB = new DatabaseConnection();
		connectionDB.ConnectionNameChange("SELECT UserName FROM Data", s,
				RegiSplitter.getInstance().getRegiInfos());

		if (connectionDB.isUsernameAvailable()) {
			connectionDB.ConnectionNameChange("UPDATE Data SET UserName = '"
					+ RegiSplitter.getInstance().getRegiInfos()[1]
					+ "' WHERE UserName = '"
					+ RegiSplitter.getInstance().getRegiInfos()[0] + "'", s,
					RegiSplitter.getInstance().getRegiInfos());
		}
	}
}
