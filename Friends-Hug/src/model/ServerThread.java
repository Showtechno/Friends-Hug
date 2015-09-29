package model;

import java.net.Socket;

public class ServerThread extends Thread {

	private boolean logInBoolean = false;
	private String username;
	Socket socket;
	int listnumber;
	Server server;

	public ServerThread(Socket socket, int listnumber, Server server) {
		this.socket = socket; this.listnumber= listnumber; this.server = server;
		// TODO Auto-generated constructor stub
	}

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
}
