package server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread extends Thread {

	private boolean logInBoolean = false;
	Socket socket;
	int listnumber;
	Server server;
	String clientSentence;
	DataOutputStream outToClient;
	private Flagdetection flagdetectionObject = new Flagdetection();
	private CRegistration cRegistrationObject = new CRegistration();
	private CLogIn cLoginObject = new CLogIn();
	private String Username;
	
	private BufferedReader reader;

	public boolean isLogInBoolean() {
		return logInBoolean;
	}

	public void setLogInBoolean(boolean logInBoolean) {
		this.logInBoolean = logInBoolean;
	}

	public String getClientSentence() {
		return clientSentence;
	}

	public void setClientSentence(String clientSentence) {
		this.clientSentence = clientSentence;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	
	public ServerThread(Socket socket, int listnumber, Server server) {
		this.socket = socket;
		this.listnumber = listnumber;
		this.server = server;
		
		InputStreamReader isReader;
		try {
			isReader = new InputStreamReader(socket.getInputStream());
			reader = new BufferedReader(isReader);
		} catch (IOException e) {
			e.printStackTrace();
			LogfileWriter.getInstance().writeLogfile("A Client disconnected.");
			for (ServerThread s : server.clientlist.values()) {
				if(s.isAlive()== false){
					server.clientlist.remove(s);
					
				}
			}
		}
		
	}

	public void run() {
		try {
			while (true) {
				String input = reader.readLine();
				LogfileWriter.getInstance().writeLogfile("Message arrived from a Client");
				flagdetectionObject.returnFlagText(input);
				if (flagdetectionObject.getFlag().equals("FLAG_CHAT")) {
					setClientSentence(flagdetectionObject.getFlag() + ';'
							+ ": " + flagdetectionObject.getText());
					for (ServerThread s : server.clientlist.values()) {
						s.setClientSentence(getClientSentence());
						s.sendServerThread(s.getClientSentence());
					}
				}
				if(flagdetectionObject.getFlag().equals("FLAG_LOGOUT")){
					server.clientlist.remove(listnumber);
					stop();
				}
				if(flagdetectionObject.getFlag().equals("FLAG_LOGIN")){
					cLoginObject.getInstance().logIn(flagdetectionObject.getText(),this);
					LogfileWriter.getInstance().writeLogfile("Login request");
				}
				if(flagdetectionObject.getFlag().equals("FLAG_REGI")){
					cRegistrationObject.getInstance().writeRegiIntoDB(flagdetectionObject.getText(), this);
					LogfileWriter.getInstance().writeLogfile("Registration request");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("A Client disconnected.");
			LogfileWriter.getInstance().writeLogfile("A Client disconnected.");
			for (ServerThread s : server.clientlist.values()) {
				if(s.isAlive()== false){
					server.clientlist.remove(s);
					
				}
			}
		}
	}

	public void sendServerThread(String OutToServerString) {
		try {
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			out.println(OutToServerString);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("client disconnect?");
		}
	}

}
