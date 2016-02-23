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
	
	private JTextField eingabe;
	
	public Chatfenster(JPanel Start) {
		this.setName("Chat");
		setSize(700, 450);
		setLayout(null);
		
		parent = Start;
		
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
		
		eingabe = new JTextField();
		eingabe.setOpaque(true);
		eingabe.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		eingabe.setEditable(true);
		JScrollPane scrollPaneEingabe= new JScrollPane(eingabe, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPaneEingabe.setBounds(11, 368, 493, 37);
		add(scrollPaneEingabe);
		eingabe.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode()== KeyEvent.VK_ENTER && !eingabe.getText().equals(null)){
					Client.getInstance().send("FLAG_CHAT;"+ eingabe.getText());
					eingabe.setText(null);
				}
			}
		});
	}		


		public static void nachrichtenFensterChange(String massagefromServer){
			if(!chatfenster.getText().equals(null)){
					chatfenster.append(massagefromServer + "\n");
			}
			else{
				chatfenster.append(massagefromServer);
			}
		}
}
