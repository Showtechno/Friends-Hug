package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Chatfenster{

	private JFrame frame;
	private JTextField textField;
	private static Chatfenster instance = new Chatfenster();
	private JLabel jlabelChatfenster;
	private JLabel teilnehmerliste;
	private JLabel lblStatusServer;
	private String eingabe;
	
	
	public JLabel getJlabelChatfenster() {
		return jlabelChatfenster;
	}

	public void setJlabelChatfenster(JLabel jlabelChatfenster) {
		this.jlabelChatfenster = jlabelChatfenster;
	}

	public JLabel getTeilnehmerliste() {
		return teilnehmerliste;
	}

	public void setTeilnehmerliste(JLabel teilnehmerliste) {
		this.teilnehmerliste = teilnehmerliste;
	}

	public JLabel getLblStatusServer() {
		return lblStatusServer;
	}

	public void setLblStatusServer(JLabel lblStatusServer) {
		this.lblStatusServer = lblStatusServer;
	}

	public String getEingabe() {
		return eingabe;
	}

	public void setEingabe(String eingabe) {
		this.eingabe = eingabe;
	}

	public static Chatfenster getInstance(){
		return instance;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chatfenster window = new Chatfenster();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Chatfenster() {
		frame = new JFrame();
		frame.setTitle("Chat");
		frame.setBounds(100, 100, 700, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel jlabelChatfenster = new JLabel("");
		JScrollPane scrollerForChatfenster = new JScrollPane(jlabelChatfenster, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jlabelChatfenster.setBounds(10, 11, 493, 416);
		frame.getContentPane().add(scrollerForChatfenster);
		
		JButton zurueckButton = new JButton("zurück");
		zurueckButton.setBounds(556, 456, 89, 23);
		frame.getContentPane().add(zurueckButton);
		
		JLabel teilnehmerliste = new JLabel("");
		JScrollPane scrollerForTeilnehmerliste = new JScrollPane(teilnehmerliste, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		teilnehmerliste.setBounds(528, 17, 133, 410);
		frame.getContentPane().add(scrollerForTeilnehmerliste);
		
		JLabel lblStatusServer = new JLabel("");
		lblStatusServer.setBounds(10, 447, 630, 44);
		frame.getContentPane().add(lblStatusServer);
	}


	public void nachrichtenFensterChange(String transmitterAndMassage) {
		getJlabelChatfenster().setText(getJlabelChatfenster() + transmitterAndMassage);
	}


	public Boolean serverStatusChange() {
		
		return null;
	}

	public String teilnehmerChange() {
		// TODO Auto-generated method stub
		return null;
	}
}
