package client;

import java.io.*;

import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.print.attribute.standard.MediaSize.Other;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import client.Flagdetection;
import gui.Chatfenster;
import gui.Frame;
import gui.Registration;

public class Client {

	// Text vom Server
	private String textVomServer;

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
				System.out.println("while true");
				BufferedReader in = new BufferedReader(new InputStreamReader(
						clientSocket.getInputStream()));
				String serverResponse = in.readLine();
				System.out.println("vom Server empfangen: " + serverResponse);
				setTextVomServer(serverResponse);
				Flagdetection flagdetectionObject = new Flagdetection();
				flagdetectionObject.returnFlagText(getTextVomServer());
				System.out.println(flagdetectionObject.getFlag());
				System.out.println(flagdetectionObject.getText());
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
							JOptionPane.showInputDialog(null,
									flagdetectionObject.getText(),
									"Registration");
						} else {
							Frame.getInstance().switchPanel(Frame.REGISTATION);
							JOptionPane.showInputDialog(null,
									flagdetectionObject.getText(),
									"Registration");
						}
					}
					if (flagdetectionObject.getText().equals("SUCCESS")) {
						Frame.getInstance().switchPanel(Frame.LOGIN);
						JOptionPane.showInputDialog(null,
								"Registration erfolgreich!", "Registration");
					}
				
						
				}
				if(flagdetectionObject.getFlag().equals("FLAG_LOGIN")){
					System.out.println("anmelden");
					if(flagdetectionObject.getText().equals("1")){
						Frame.getInstance().switchPanel(Frame.CHATMENU);
						
					}
					if(flagdetectionObject.getFlag().equals("0")){
						JOptionPane.showInputDialog(null,
								"Logindaten nicht korrekt!", "Login");
					}
				}
			}

		}
		// gui anschluss fehlt
		catch (Exception e) {
			System.out.println("Verbinden fehlgeschlagen!");
			// if(connectionTryCount > 0 && isConnected == false){
			// connectionTryCount--;
			// connection();
			// }
			//
			// else{
			//
			// }
		}
	}

	public void send(String outToServerString) {
		writer.println(outToServerString);
		writer.flush();

	}
}
