package gui;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

public class Chatfenster
		extends MenuPanel {
	
	
	private static final long	serialVersionUID	= 6292949248291295930L;
	
	public JLabel lblStatusServer;
	public static JTextArea chatfenster;
	public JTextArea teilnehmerliste;
	
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
		chatfenster.setBounds(10, 11, 493, 356);
		chatfenster.setEditable(true);
		add(chatfenster);
		JScrollPane scrollPaneChatfenster= new JScrollPane();
		scrollPaneChatfenster.setBounds(10, 11, 493, 356);
		add(scrollPaneChatfenster);
		scrollPaneChatfenster.setViewportView(chatfenster);
		
		teilnehmerliste = new JTextArea();
		teilnehmerliste.setOpaque(true);
		teilnehmerliste.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		teilnehmerliste.setLineWrap(true);
		teilnehmerliste.setBounds(528, 17, 133, 356);
		teilnehmerliste.setEditable(true);
		teilnehmerliste.
		add(teilnehmerliste);
//		JScrollPane scrollPaneChatteilnehmerliste= new JScrollPane();
//		scrollPaneChatteilnehmerliste.setBounds(528, 17, 133, 356);
//		add(scrollPaneChatteilnehmerliste);
//		scrollPaneChatteilnehmerliste.setViewportView(teilnehmerliste);
		
		JButton zurueckButton = new MenuButton(3);
		zurueckButton.setText("Back");
		zurueckButton.setBounds(556, 456, 89, 23);
		zurueckButton.addActionListener(MenuListener.getInstance());
		add(zurueckButton);
		
		
		
		
//		chatfenster.append("test1");
//		int i = 0;
//		while(i <100){
//			nachrichtenFensterChange("test2dfjjjjjjjjjjjdfbjjjjjjjjjjjjjjjjjjjjjjjjj\n");		
//			i++;
//		}
		
		
	}		


		public static void nachrichtenFensterChange(String massagefromServer){
			if(chatfenster.getText() != null){
				chatfenster.append("\n" + massagefromServer);
			}
			else{
				chatfenster.append(massagefromServer);
			}
		}
	
}
