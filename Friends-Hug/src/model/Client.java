package model;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import gui.Chatfenster;


public class Client{

	//Text vom Server
	private String textVomServer;
	
	private Boolean isConnected = false;
	
	private String connectionText;
	
	private static Client instance;
	
	private String outToServerText;
	
	Socket clientSocket;
	DataOutputStream outToServer;
		
	
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
			try {
				instance.clientSocket = new Socket("localhost",1337);
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return instance;
	}
	public void start(){
		
		//Client öffnet ein Verbindung mit dem Port:1337
		//FEHLT INTERNET CONNECTION
		try{
			setIsConnected(true);
			//als Thread ersetzen
			if(isConnected == true){
				System.out.println("connected");
				while(true){
					System.out.println("while true");
					InputStream inFromServer = clientSocket.getInputStream();
					Scanner scan = new Scanner(inFromServer);
					System.out.println("Client horcht...");
					System.out.println(scan.nextLine());
					System.out.println("Client hat was");
					if(scan.hasNext()){
						System.out.println(scan.nextLine());
						setTextVomServer(scan.nextLine());
						Flagdetection flagdetectionObject = new Flagdetection();
						flagdetectionObject.returnFlagText(getTextVomServer());
						if(flagdetectionObject.getFlag().equals("FLAG_CHAT")){
							System.out.println("if abfrage flag_chat");
							Chatfenster.nachrichtenFensterChange(flagdetectionObject.getText());
							setTextVomServer(null);
						}
						else{
							setTextVomServer(null);
						}
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
		public void send(String OutToServerString){
			
			try {
//
				outToServer= new DataOutputStream(clientSocket.getOutputStream());
				outToServer.writeBytes(OutToServerString);
			}
			 catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
