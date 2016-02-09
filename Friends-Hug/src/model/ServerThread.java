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
				System.out.println(input);
				flagdetectionObject.returnFlagText(input);
				if (true || flagdetectionObject.getFlag().equals("FLAG_CHAT")) {
					setClientSentence(flagdetectionObject.getFlag() + ';'
							+ ": " + flagdetectionObject.getText());
					for (ServerThread s : server.clientlist.values()) {
						System.out.println("forEach Durchlauf");
						s.setClientSentence(getClientSentence());
						s.sendServerThread(s.getClientSentence());
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
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
