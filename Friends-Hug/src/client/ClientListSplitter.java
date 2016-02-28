package client;

import java.util.ArrayList;
import java.util.List;

public class ClientListSplitter {
	private static ClientListSplitter instance;
	private List<String> list = new ArrayList<>();

	public List<String> getList() {
		return list;
	}
	//singelton pattern
	public static ClientListSplitter getInstance() {
		if (instance == null) {
			instance = new ClientListSplitter();
		}
		return instance;
	}
	//Methode zum splitten fuer clientens im empfangenen String
	public void returnListClient(String input){
		String[] templist = input.split(",");
		for(int i = 0;i<templist.length;i++){
			getList().add(templist[i]);		
		}
	}
}
