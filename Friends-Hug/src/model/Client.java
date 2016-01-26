package model;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

import gui.Chatfenster;


public class Client{

	//Daten die vom Server kommen
	private BufferedReader inputFromServer;
		
	//Text vom Server
	private String textVomServer;
	
	private Boolean isConnected = false;
	
	private String connectionText;
	
	private static Client instance;
	
	private String outToServerText;
		
	
	public BufferedReader getInputFromServer() {
		return inputFromServer;
	}
	
	public void setInputFromServer(InputStream inputFromServer) {
		this.inputFromServer = new BufferedReader(new InputStreamReader(inputFromServer));
	}
	
	public String getTextVomServer() {
		return textVomServer;
	}
	
	public void setTextVomServer(String textVomServer) {
		this.textVomServer = textVomServer;
	}
	
	public Boolean getIsConnected() {
		return isConnected;
	}

	public void setIsConnected(Boolean isConnected) {
		this.isConnected = isConnected;
	}

	public String getConnectionText() {
		return connectionText;
	}

	public void setConnectionText(String connectionText) {
		this.connectionText = connectionText;
	}
	

	public String getOutToServerText() {
		return outToServerText;
	}

	public void setOutToServerText(String outToServerText) {
		this.outToServerText = outToServerText;
	}

	public static Client getInstance() {
		if (instance == null) {
			instance = new Client();
		}
		return instance;
	}
	public void start(){
		
		//Client öffnet ein Verbindung mit dem Port:7777
		//FEHLT INTERNET CONNECTION
		try{
			Socket clientSocket = new Socket("localhost", 7777);
			setIsConnected(true);
			System.out.println("test open port");
			//als Thread ersetzen
			if(isConnected == true){
				while(true){
					System.out.println("chatschleife");
					setInputFromServer(clientSocket.getInputStream());
					DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
					outToServer.writeBytes(getOutToServerText());
					System.out.println(getOutToServerText());
					System.out.println("outToServer initalisiert");
					setTextVomServer(getInputFromServer().readLine());
					if(getTextVomServer()!= null){
						System.out.println("if abfrage gettextvomserver != null");
						Flagdetection flagdetectionObject = new Flagdetection();
						flagdetectionObject.returnFlagText(getTextVomServer());
							if(flagdetectionObject.getFlag()=="FLAG_CHAT"){
								System.out.println("if abfrage flag_chat");
								Chatfenster.nachrichtenFensterChange(flagdetectionObject.getText());
							}
//							else{
//								setTextVomServer(null);
//							}
					}
				}
			}
		}
		//gui anschluss fehlt
		catch(Exception e){
			e.printStackTrace();
			setIsConnected(false);
//			if(connectionTryCount > 0 && isConnected == false){
//				connectionTryCount--;
//				connection();
//			}
//			
//			else{
//				
//			}
		}
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		new Client().start();
	}


}
