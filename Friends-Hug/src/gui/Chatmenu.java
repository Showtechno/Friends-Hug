package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import client.Client;


public class Chatmenu
		extends MenuPanel {
	
	private static final long	serialVersionUID	= 4123157239432552031L;
	public JLabel lblStatusServer;
	public Chatmenu(JPanel Start) {
		setSize(700, 450);
		setLayout(null);
		this.setName("Chatmenu");
		
		parent = Start;
				
		lblStatusServer = new JLabel();
		lblStatusServer.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatusServer.setVerticalAlignment(SwingConstants.BOTTOM);
		lblStatusServer.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblStatusServer.setBounds(10, 454, 640, 37);
		add(lblStatusServer);
		
		JButton btnChat = new MenuButton(4);
		btnChat.setText("Chat");
		btnChat.setBounds(0, 150, 150, 50);
		btnChat.addActionListener(MenuListener.getInstance());
		add(btnChat);
		btnChat.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Frame.getInstance().switchPanel(Frame.CHATFENSTER);
			}
		});
		
		JButton btnOptionen = new MenuButton(5);
		btnOptionen.setText("Optionen");
		btnOptionen.setBounds(150, 150, 150, 50);
		btnOptionen.addActionListener(MenuListener.getInstance());
		add(btnOptionen);
		btnOptionen.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Frame.getInstance().switchPanel(Frame.USEROPTION);
			}
		});
		
		JButton btnDelet  = new MenuButton(6);
		btnDelet.setText("Account löschen");
		btnDelet.setBounds(450, 150, 150, 50);
		add(btnDelet);
		btnDelet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame.getInstance().switchPanel(Frame.DELET);
			}
		});
		
		JButton btnAbmelden = new MenuButton(0);
		btnAbmelden.setText("Abmelden");
		btnAbmelden.setBounds(300, 150, 150, 50);
		btnAbmelden.addActionListener(MenuListener.getInstance());
		add(btnAbmelden);
		btnAbmelden.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Client.getInstance().send("FLAG_LOGOUT;" + Client.getInstance().getUserName());
				Client.getInstance().setUserName(null);
				System.exit(0);
			}
		});
		
	}
	
}
