package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Chatmenu {

	private JFrame frmChatmen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chatmenu window = new Chatmenu();
					window.frmChatmen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Chatmenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmChatmen = new JFrame();
		frmChatmen.setTitle("Chatmen\u00FC");
		frmChatmen.setBounds(100, 100, 700, 540);
		frmChatmen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmChatmen.getContentPane().setLayout(null);
		
		JButton btnChat = new JButton("Chat");
		btnChat.setBounds(254, 82, 149, 50);
		frmChatmen.getContentPane().add(btnChat);
		
		JButton btnOptionen = new JButton("Optionen");
		btnOptionen.setBounds(254, 157, 149, 50);
		frmChatmen.getContentPane().add(btnOptionen);
		
		JButton btnAbmelden = new JButton("Abmelden");
		btnAbmelden.setBounds(254, 231, 149, 50);
		frmChatmen.getContentPane().add(btnAbmelden);
		
		JLabel lblStatusServer = new JLabel("");
		lblStatusServer.setBounds(10, 454, 640, 37);
		frmChatmen.getContentPane().add(lblStatusServer);
	}

}
