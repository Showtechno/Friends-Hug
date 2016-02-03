package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import model.Client;

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
		lblStatusServer.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblStatusServer.setBounds(10, 391, 630, 44);
		add(lblStatusServer);
		lblStatusServer.setText("Serverstatus getrennt!");
		
		chatfenster = new JTextArea();
		chatfenster.setOpaque(true);
		chatfenster.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		chatfenster.setLineWrap(true);
		chatfenster.setBounds(10, 11, 493, 356);
		chatfenster.setEditable(true);
		chatfenster.setEditable(false);
		add(chatfenster);
		JScrollPane scrollPaneChatfenster= new JScrollPane();
		scrollPaneChatfenster.setBounds(10, 11, 493, 356);
		add(scrollPaneChatfenster);
		scrollPaneChatfenster.setViewportView(chatfenster);
		
		teilnehmerliste = new JTextArea();
		teilnehmerliste.setOpaque(true);
		teilnehmerliste.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		teilnehmerliste.setLineWrap(false);
		teilnehmerliste.setBounds(520, 11, 133, 356);
		teilnehmerliste.setEditable(true);
		teilnehmerliste.setEditable(false);
		add(teilnehmerliste);
		JScrollPane scrollPaneChatteilnehmerliste= new JScrollPane();
		scrollPaneChatteilnehmerliste.setBounds(520, 11, 133, 356);
		add(scrollPaneChatteilnehmerliste);
		scrollPaneChatteilnehmerliste.setViewportView(teilnehmerliste);
		
		JButton zurueckButton = new MenuButton(3);
		zurueckButton.setText("Back");
		zurueckButton.setBounds(546, 386, 89, 23);
		zurueckButton.addActionListener(MenuListener.getInstance());
		add(zurueckButton);
		zurueckButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Frame.getInstance().switchPanel(Frame.CHATMENU);
			}
		});
		
		JTextArea eingabe = new JTextArea();
		eingabe.setOpaque(true);
		eingabe.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		eingabe.setLineWrap(false);
		eingabe.setBounds(11, 368, 493, 37);
		eingabe.setEditable(true);
		add(eingabe);
		JScrollPane scrollPaneEingabe= new JScrollPane();
		scrollPaneEingabe.setBounds(11, 368, 493, 37);
		add(scrollPaneEingabe);
		scrollPaneEingabe.setViewportView(eingabe);
		eingabe.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode()== 10){
					 Client.getInstance().setOutToServerText("CHAT_FLAG;" + eingabe.getText());
					eingabe.setText(null);
				}
			}
		});
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
