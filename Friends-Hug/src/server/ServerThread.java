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

import javax.swing.DefaultListModel;
import javax.swing.JList;

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
	String userList="";
	
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
			//uebergibt des isreader den inputsteam vom socket
			isReader = new InputStreamReader(socket.getInputStream());
			//uebergibt den bufferedreader den inputsteam
			reader = new BufferedReader(isReader);
		} catch (IOException e) {
			LogfileWriter.getInstance().writeLogfile("A Client disconnected.");
			//iterriert ueber die clientenlist und loescht alle heraus die nicht mehr verbunden sind
			for (ServerThread s : server.clientlist.values()) {
				if(s.isAlive()== false){
					server.clientlist.remove(s);
					
				}
			}
		}
		
	}
//reagiert auf die von Client gesendeten Flags
	public void run() {
		try {
			while (true) {
				String input = reader.readLine();
				flagdetectionObject.returnFlagText(input);
				//regiert auf die Flag Chat
				if (flagdetectionObject.getFlag().equals("FLAG_CHAT")) {
					setClientSentence(flagdetectionObject.getFlag() + ';'
							+ getUsername() +": " + flagdetectionObject.getText());
					//iteriert ueber die clientlist und sendet an alle die Nachricht
					for (ServerThread s : server.clientlist.values()) {
						s.setClientSentence(getClientSentence());
						s.sendServerThread(s.getClientSentence());
					}
				}
				//regiert auf die Flag quit und loescht sich aus der clientlist
				if(flagdetectionObject.getFlag().equals("FLAG_QUIT")){
					server.clientlist.remove(listnumber);
				}
				//regiert auf die Flag login
				if(flagdetectionObject.getFlag().equals("FLAG_LOGIN")){
					cLoginObject.getInstance().logIn(flagdetectionObject.getText(),this);
					LogfileWriter.getInstance().writeLogfile("Login request");
					if(getUsername()!= null){
						server.getList().add(getUsername());
						for(int i = 0; i < server.getList().size(); i++){
							if(userList==""){
								userList = server.getList().get(i);
							}
							else{
								userList = userList +',' + server.getList().get(i);
							}
						}
						System.out.println(userList);
						for (ServerThread s : server.clientlist.values()) {
								s.sendServerThread("FLAG_ADD;" + userList );
						}
					}
				}
				//regiert auf Registrations Flag
				if(flagdetectionObject.getFlag().equals("FLAG_REGI")){
					//uebergibt den registrationsauftrag an die entsprechende klasse weiter
					cRegistrationObject.getInstance().writeRegiIntoDB(flagdetectionObject.getText(), this);
					LogfileWriter.getInstance().writeLogfile("Registration request");
				}
			}
		}
		//faengt ab das die Clientverbindung abgebrochen ist und loescht ihn aus der Server clientlist
		catch (Exception e) {
			System.out.println("A Client disconnected.");
			LogfileWriter.getInstance().writeLogfile("A Client disconnected.");
			for (ServerThread s : server.clientlist.values()) {
				if(s.isAlive()== false){
					server.clientlist.remove(s);
					
				}
			}
		}
	}
//methode zum senden zum Client auf dem outputstream
	public void sendServerThread(String OutToServerString) {
		try {
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			out.println(OutToServerString);
		} catch (IOException e) {
			LogfileWriter.getInstance().writeLogfile("A Client disconnected.");
		}
	}

}
