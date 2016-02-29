package client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

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

	// singelton Pattern
	public static Client getInstance() {
		if (instance == null) {
			instance = new Client();
			/*
			 * Client oeffnet ein Socket mit dem Port:1337 oeffnet einen
			 * outputstream auf dem Socket
			 */
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

	/*
	 * ließt den Inputstream ein wertet die Empfangenen ,,FLAGs" aus
	 */
	public void start() {
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
				// Auswertung der Registrierung
				if (flagdetectionObject.getFlag().equals("FLAG_REGI")) {
					// Benuter oder Email schon vergeben
					if (flagdetectionObject.getText().contains("Benutzername")
							|| flagdetectionObject.getText().contains("Email")) {
						// ueberprüfung der Benutzerobeflaeche(Registration)
						if (Frame.getInstance().getContentPane() instanceof Registration) {
							JOptionPane.showMessageDialog(null,
									flagdetectionObject.getText());
						} else {
							Frame.getInstance().switchPanel(Frame.REGISTATION);
							JOptionPane.showMessageDialog(null,
									flagdetectionObject.getText());
						}
					}
					// Registration erfolgreich
					if (flagdetectionObject.getText().equals("SUCCESS")) {
						Frame.getInstance().switchPanel(Frame.LOGIN);
						JOptionPane.showMessageDialog(null,
								"Registration erfolgreich!");
					}
				}
				
				if(flagdetectionObject.getFlag().equals("FLAG_DELETE")){
					for(int i = 0; i < Chatfenster.getListModel().getSize(); i++){
						if(flagdetectionObject.getText().equals(Chatfenster.getListModel().getElementAt(i))){
							Chatfenster.getListModel().remove(i);
						}
					}
					}
				
				// Auswertung zum Anzeigen der Teilnehmenr
				if (flagdetectionObject.getFlag().equals("FLAG_ADD")) {
					ClientListSplitter.getInstance().returnListClient(
							flagdetectionObject.getText());
				 Chatfenster.getListModel().removeAllElements();
					// System.out.println(Chatfenster.getListModel().getSize());
					// for(int i=0;i<Chatfenster.getListModel().getSize();i++){
					// Chatfenster.getListModel().remove(i);
					// }
//					Chatfenster.deletUser();

					 
					for (int i = 0; i < ClientListSplitter.getInstance()
							.getList().size(); i++) {
						Chatfenster.addUser(ClientListSplitter.getInstance()
								.getList().get(i));
					}
				}
				// Auswertung des Logins
				if (flagdetectionObject.getFlag().equals("FLAG_LOGIN")) {

					String parts[] = flagdetectionObject.getText().split(",");
					String success = parts[0];
					String name = parts[1];
					// gesendete logindaten waren korrekt
					if (success.equals("1")) {
						setUserName(name);
						Frame.getInstance().switchPanel(Frame.CHATMENU);

					}
					// gesendete logindaten waren nicht korrekt
					if (flagdetectionObject.getFlag().equals("0")) {
						JOptionPane.showMessageDialog(null,
								"Logindaten nicht korrekt!");
					}
				}
				// Auswertung des Namen aenderns
				if (flagdetectionObject.getFlag().equals("FLAG_NAMECHANGE")) {
					// Name schon vergeben
					if (flagdetectionObject.getText().contains("vergeben")) {
						JOptionPane.showMessageDialog(null,
								"Nutzername ist schon vergeben");
					}
					// Name noch nicht vergeben
					if (flagdetectionObject.getText().equals("1")) {
						JOptionPane.showMessageDialog(null,
								"Name erfolgreich geändert");
					}
				}
				// Auswertung des Passwort aenderns
				if (flagdetectionObject.getFlag().equals("FLAG_PASSWORTCHANGE")) {
					// Passwort wurde geaendert
					if (flagdetectionObject.getText().equals("1")) {
						JOptionPane.showMessageDialog(null,
								"Passwort erfolgreich geändert");
					} else {
						JOptionPane.showMessageDialog(null,
								"Passowrt konnte nicht geändert werden");
					}
				}
			}

		}
		// verbindung wird zum Server Unterbrochen und informiert clientuser
		catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Verbindung zum Server unterbrochen!");
			System.exit(0);
		}
	}

	// Methode zum senden zum Server ueber den outputstrem am Socket
	public void send(String outToServerString) {
		writer.println(outToServerString);
		writer.flush();

	}

}
