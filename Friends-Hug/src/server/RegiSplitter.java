package server;

public class RegiSplitter {

	private static RegiSplitter instance;
	private String regiInfos[] = new String[5];

	public String[] getRegiInfos() {
		return regiInfos;
	}

	public void setRegiInfos(String regiInfos[]) {
		this.regiInfos = regiInfos;
	}
	
	public static RegiSplitter getInstance() {
		if (instance == null) {
			instance = new RegiSplitter();
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
	public void returnRegiInfos(String nonSplittedInfos){
		
		setRegiInfos(nonSplittedInfos.split(","));
	}
}
