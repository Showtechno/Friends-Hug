package model;

import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.Socket;

public class ServerThread extends Thread {

	private boolean logInBoolean = false;
	private String username;
	Socket socket;
	int listnumber;
	Server server;
	String clientSentence;
	private Flagdetection flagdetectionObject = new Flagdetection();

	public boolean isLogInBoolean() {
		return logInBoolean;
	}

	public void setLogInBoolean(boolean logInBoolean) {
		this.logInBoolean = logInBoolean;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getClientSentence() {
		return clientSentence;
	}

	public void setClientSentence(String clientSentence) {
		this.clientSentence = clientSentence;
	}

	public ServerThread(Socket socket, int listnumber, Server server) {
		this.socket = socket; this.listnumber= listnumber; this.server = server;
		// TODO Auto-generated constructor stub
	}
	public void receive(){
		try{
			DataInputStream in=new DataInputStream(socket.getInputStream());
			setClientSentence(in.readLine());
			flagdetectionObject.returnFlagText(getClientSentence());
			if(flagdetectionObject.getFlag()=="FLAG_CHAT"){
				setClientSentence(flagdetectionObject.getFlag() + getUsername()+ ": " + flagdetectionObject.getText());
			}
		}
		catch(Exception e){
			//idle 5 min log out benötigt
			try{
				socket.close();
			}
			catch(Exception f){
				
			}
		}
	}
	public void transmit(){
		try{
			PrintStream	out=new PrintStream(socket.getOutputStream());
				for(ServerThread s: server.clientlist.values()) {
					s.setClientSentence(getClientSentence());
				}
			}
		catch(Exception e){
			//idle 5 min log out benötigt
			try{
				socket.close();
			}
			catch(Exception f){
				
			}
		}
	}
}
