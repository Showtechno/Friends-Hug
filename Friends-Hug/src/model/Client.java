package model;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

import gui.Chatfenster;


public class Client {

	//Daten die vom Server kommen
	private BufferedReader inputFromServer;
	
	//Daten die der Client sendet
	private DataOutputStream outToServer;
	
	//Text vom Server
	private String textVomServer;
	
	private Boolean isConnected = false;
	
	private String connectionText;
	
	private int connectionTryCount = 10;
	
	
	public BufferedReader getInputFromServer() {
		return inputFromServer;
	}
	
	public void setInputFromServer(InputStream inputFromServer) {
		this.inputFromServer = new BufferedReader(new InputStreamReader(inputFromServer));
	}
	
	public DataOutputStream getOutToServer() {
		return outToServer;
	}
	
	public void setOutToServer(DataOutputStream outToServer) {
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

	public void connection(){
		
		//Client öffnet ein Verbindung mit dem Port:7777
		//FEHLT INTERNET CONNECTION
		try{
			Socket clientSocket = new Socket("localhost", 7777);
			setIsConnected(true);
			//als Thread ersetzen
			while(true){
				setInputFromServer(clientSocket.getInputStream());
				setOutToServer((DataOutputStream) clientSocket.getOutputStream());
				setTextVomServer(getInputFromServer().readLine());
				Flagdetection flagdetectionObject = new Flagdetection();
				flagdetectionObject.returnFlagText(getTextVomServer());
				if(flagdetectionObject.getFlag()=="FLAG_CHAT"){
//				 	gui.Chatfenster.ChatfensternachrichtenFensterChange(getTextVomServer());
				}
			}
		}
		//gui anschluss fehlt
		catch(Exception e){
			setIsConnected(false);
			if(connectionTryCount > 0){
				connection();
				connectionTryCount--;
			}
			
			else{
				
			}
		}
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		new Client().connection();
	}
}
