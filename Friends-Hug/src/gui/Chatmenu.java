package gui;

import java.awt.Font;

import javax.swing.*;


public class Chatmenu
		extends MenuPanel {
	
	private static final long	serialVersionUID	= 4123157239432552031L;
	
	public Chatmenu(JPanel Start) {
		setSize(700, 450);
		setLayout(null);
		this.setName("Chatmenu");
		
		parent = Start;
				
		JLabel lblStatusServer = new JLabel();
		lblStatusServer.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatusServer.setVerticalAlignment(SwingConstants.BOTTOM);
		lblStatusServer.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblStatusServer.setBounds(10, 454, 640, 37);
		add(lblStatusServer);
		
		JButton btnChat = new MenuButton(4);
		btnChat.setText("Chat");
		btnChat.setBounds(0, 200, 250, 50);
		btnChat.addActionListener(MenuListener.getInstance());
		add(btnChat);
		
		JButton btnOptionen = new MenuButton(5);
		btnOptionen.setText("Optionen");
		btnOptionen.setBounds(0, 200, 250, 50);
		btnOptionen.addActionListener(MenuListener.getInstance());
		add(btnOptionen);
		
		JButton btnAbmelden = new MenuButton(0);
		btnAbmelden.setText("Abmelden");
		btnAbmelden.setBounds(254, 231, 149, 50);
		btnAbmelden.addActionListener(MenuListener.getInstance());
		add(btnAbmelden);
		
	}
	
}
