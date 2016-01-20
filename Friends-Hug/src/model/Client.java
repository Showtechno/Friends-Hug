package model;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import gui.Chatfenster;


public class Client {

	//Daten die vom Server kommen
	private BufferedReader inputFromServer;
	
	//Daten die der Client sendet
	private OutputStream outToServer;
	
	//Text vom Server
	private String textVomServer;
	
	private Boolean isConnected = false;
	
	private String connectionText;
	
	private static Client instance;
	
	
	public BufferedReader getInputFromServer() {
		return inputFromServer;
	}
	
	public void setInputFromServer(InputStream inputFromServer) {
		this.inputFromServer = new BufferedReader(new InputStreamReader(inputFromServer));
	}
	
	public OutputStream getOutToServer() {
		return outToServer;
	}
	
	public void setOutToServer(OutputStream outToServer) {
		this.outToServer = outToServer;
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
	

	public static Client getInstance() {
		if (instance == null) {
			instance = new Client();
		}
		return instance;
	}
	public void connection(){
		
		//Client öffnet ein Verbindung mit dem Port:7777
		//FEHLT INTERNET CONNECTION
		try{
			Socket clientSocket = new Socket("localhost", 7777);
			setIsConnected(true);
			System.out.println("test open port");
			//als Thread ersetzen
			while(true){
				System.out.println("while true schleife");
				setInputFromServer(clientSocket.getInputStream());
				setOutToServer(clientSocket.getOutputStream());
				setTextVomServer(getInputFromServer().readLine());
				System.out.println("bau");
				if(getTextVomServer()!= null){
					Flagdetection flagdetectionObject = new Flagdetection();
					flagdetectionObject.returnFlagText(getTextVomServer());
						if(flagdetectionObject.getFlag()=="FLAG_CHAT"){
							Chatfenster.nachrichtenFensterChange(flagdetectionObject.getText());
						}
						setTextVomServer(null);
				}
			}
		}
//		//gui anschluss fehlt
		catch(Exception e){
			e.printStackTrace();
//			setIsConnected(false);
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
	public void send(String sentenceToSent){
		System.out.println(outToServer);
//		try {
//			outToServer.write(sentenceToSent.getBytes());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		new Client().connection();
	}
}
