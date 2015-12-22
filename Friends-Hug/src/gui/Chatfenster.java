package gui;

import java.awt.Font;

import javax.swing.*;

public class Chatfenster
		extends MenuPanel {
	
	
	private static final long	serialVersionUID	= 6292949248291295930L;
	
	public JLabel lblStatusServer;
	public JLabel chatfenster;
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
		
		chatfenster = new JLabel();
		JScrollPane scrollerForChatfenster = new JScrollPane(chatfenster, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		chatfenster.setHorizontalAlignment(SwingConstants.CENTER);
		chatfenster.setFont(new Font("Times New Roman", Font.BOLD, 30));
		chatfenster.setBounds(10, 11, 493, 416);
		add(scrollerForChatfenster);
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
		
		nachrichtenFensterChange("test");		
	}
	public void nachrichtenFensterChange(String massagefromServer){
		chatfenster.setText(chatfenster.getName() + "\n" + massagefromServer);
	}
}