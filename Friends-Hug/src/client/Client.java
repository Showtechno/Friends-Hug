package client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;
import client.Flagdetection;
import gui.Chatfenster;
import gui.Frame;
import gui.Registration;

public class Client {

	// Text vom Server
	private String textVomServer;
	
	private String UserName;

	private Boolean isConnected = false;

	private String connectionText;

	private static Client instance;

	private String outToServerText;

	private static PrintWriter writer;

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
	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public static Client getInstance() {
		if (instance == null) {
			instance = new Client();
			try {
				instance.clientSocket = new Socket("localhost", 1337);
				writer = new PrintWriter(
						instance.clientSocket.getOutputStream());
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

	public void start() {

		// Client öffnet ein Verbindung mit dem Port:1337
		// FEHLT INTERNET CONNECTION
		try {
			while (true) {
				BufferedReader in = new BufferedReader(new InputStreamReader(
						clientSocket.getInputStream()));
				String serverResponse = in.readLine();
				System.out.println("vom Server empfangen: " + serverResponse);
				setTextVomServer(serverResponse);
				Flagdetection flagdetectionObject = new Flagdetection();
				flagdetectionObject.returnFlagText(getTextVomServer());
				if (flagdetectionObject.getFlag().equals("FLAG_CHAT")) {
					Chatfenster.nachrichtenFensterChange(flagdetectionObject
							.getText());
					setTextVomServer(null);
				} else {
					setTextVomServer(null);
				}
				if (flagdetectionObject.getFlag().equals("FLAG_REGI")) {
					if (flagdetectionObject.getText().contains("Benutzername")
							|| flagdetectionObject.getText().contains("Email")) {
						if (Frame.getInstance().getContentPane() instanceof Registration) {
							JOptionPane.showMessageDialog(null,
									flagdetectionObject.getText());
						} else {
							Frame.getInstance().switchPanel(Frame.REGISTATION);
							JOptionPane.showMessageDialog(null,
									flagdetectionObject.getText());
						}
					}
					if (flagdetectionObject.getText().equals("SUCCESS")) {
						Frame.getInstance().switchPanel(Frame.LOGIN);
						JOptionPane.showMessageDialog(null,
								"Registration erfolgreich!");
					}
				}
				if(flagdetectionObject.getFlag().equals("FLAG_ADD")){
					Chatfenster.addUser(flagdetectionObject.getText());
				}
				if(flagdetectionObject.getFlag().equals("FLAG_LOGIN")){
					
					String parts [] = flagdetectionObject.getText().split(",");
					String success= parts[0];
					String name = parts[1];
					
					if(success.equals("1")){
						setUserName(name);
						Frame.getInstance().switchPanel(Frame.CHATMENU);
						
					}
					if(flagdetectionObject.getFlag().equals("0")){
						JOptionPane.showMessageDialog(null,
								"Logindaten nicht korrekt!");
					}
				}
			}

		}
		// gui anschluss fehlt
		catch (Exception e) { 
			JOptionPane.showMessageDialog(null,"Verbindung zum Server unterbrochen!");
			System.exit(0);
		}
	}

	public void send(String outToServerString) {
		writer.println(outToServerString);
		writer.flush();

	}
	
}
