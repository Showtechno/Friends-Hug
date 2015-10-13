package model;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;



public class Client {

	//Daten die vom Server kommen
	private BufferedReader inputFromServer;
	
	//Daten die der Client sendet
	private DataOutputStream outToServer;
	
	//Text vom Server
	private String textVomServer;
	
	
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
	public void connection() throws UnknownHostException, IOException{
		//Client öffnet ein Verbindung mit dem Port:7777
		Socket clientSocket = new Socket("localhost", 7777);
		//als Thread ersetzen
		while(true){
			setInputFromServer(clientSocket.getInputStream());
			setOutToServer((DataOutputStream) clientSocket.getOutputStream());
			setTextVomServer(getInputFromServer().readLine());
			if(getTextVomServer() =="chatFlag = true"){
				
			}
			
		}
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		new Client().connection();
	}
}
