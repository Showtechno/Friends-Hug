package controller;

import java.util.Observable;
import java.util.Observer;

import model.Client;
import gui.Chatfenster;

public class ClientController {

	private static ClientController instance = new ClientController();
	
	public static ClientController getInstance(){
		return instance;
	}	
}
