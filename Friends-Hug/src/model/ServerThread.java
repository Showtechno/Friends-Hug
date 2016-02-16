package model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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

	public ServerThread(Socket socket, int listnumber, Server server) {
		this.socket = socket;
		this.listnumber = listnumber;
		this.server = server;
	}

	public void run() {
		try {
			while (true) {
				DataInputStream in = new DataInputStream(
						socket.getInputStream());
				Scanner scan = new Scanner(in);
				String input = scan.nextLine();
				flagdetectionObject.returnFlagText(input);
				if (flagdetectionObject.getFlag().equals("FLAG_CHAT")) {
					setClientSentence(flagdetectionObject.getFlag() + ';'
							+ ": " + flagdetectionObject.getText());
					for (ServerThread s : server.clientlist.values()) {
						s.setClientSentence(getClientSentence());
						s.sendServerThread(s.getClientSentence());
					}
				}
				else if(flagdetectionObject.getFlag().equals("FLAG_LOGOUT")){
					server.clientlist.remove(listnumber);
					stop();
				}
				else if(flagdetectionObject.getFlag().equals("FLAG_LOGIN")){
					System.out.println(flagdetectionObject.getText());
				}
				else if(flagdetectionObject.getFlag().equals("FLAG_REGI")){
					cRegistrationObject.getInstance().writeRegiIntoDB(flagdetectionObject.getText(), this);
				}



			}
		} catch (Exception e) {
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
			//
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			out.println(OutToServerString);
			System.out.println(OutToServerString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("client disconnect?");
		}
	}

}
