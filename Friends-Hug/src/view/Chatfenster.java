package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Chatfenster {

	private JFrame frame;
	private JTextField textField;
	private static Chatfenster instance = new Chatfenster();
	
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
		initialize();
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Chat");
		frame.setBounds(100, 100, 700, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel chatfenster = new JLabel("");
		JScrollPane scrollerForChatfenster = new JScrollPane(chatfenster, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		chatfenster.setBounds(10, 11, 493, 416);
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
}
