package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

public class Chatfenster
		extends MenuPanel {
	
	
	private static final long	serialVersionUID	= 6292949248291295930L;
	
	public JLabel lblStatusServer;
	public JTextArea chatfenster;
	public JLabel teilnehmerliste;
	
	public Chatfenster(JPanel Start) {
		this.setName("Chat");
		setSize(700, 450);
		setLayout(null);
		
		parent = Start;
		
		
		lblStatusServer = new JLabel();
		lblStatusServer.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatusServer.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblStatusServer.setBounds(10, 447, 630, 44);
		add(lblStatusServer);
		
		chatfenster = new JTextArea();
		chatfenster.setOpaque(true);
		chatfenster.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		chatfenster.setLineWrap(true);
		chatfenster.setBounds(10, 11, 493, 416);
		JScrollPane areaScrollPane = new JScrollPane(chatfenster);
		areaScrollPane.setVerticalScrollBarPolicy(
		                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		areaScrollPane.setPreferredSize(new Dimension(493, 416));
		areaScrollPane.setViewportView(chatfenster);
		chatfenster.setEditable(false);
		add(chatfenster);
		
		teilnehmerliste = new JLabel();
		JScrollPane scrollerForTeilnehmerliste = new JScrollPane(teilnehmerliste, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		teilnehmerliste.setHorizontalAlignment(SwingConstants.CENTER);
		teilnehmerliste.setFont(new Font("Times New Roman", Font.BOLD, 30));
		teilnehmerliste.setBounds(528, 17, 133, 410);
		add(scrollerForTeilnehmerliste);
		add(teilnehmerliste);
		
		JButton zurueckButton = new MenuButton(3);
		zurueckButton.setText("Back");
		zurueckButton.setBounds(556, 456, 89, 23);
		zurueckButton.addActionListener(MenuListener.getInstance());
		add(zurueckButton);
		
		chatfenster.setText("test1");
		int i = 0;
		while(i <100){
			nachrichtenFensterChange("test2dfjjjjjjjjjjjdfbjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjxcbadfbadfbjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjasjjjjjjjjjjjjjjsdfbadfgbjjjjjjjjjjjjjjjjjjjj");		
			i++;
		}

		nachrichtenFensterChange("test");	
				
		if(chatfenster.getText() != null)
			chatfenster.setText(chatfenster.getText() +  "\n" + massagefromServer);
		else{
			chatfenster.setText(massagefromServer);
		}

		chatfenster.setText(chatfenster.getText() + "\n" + massagefromServer);
	}
}
