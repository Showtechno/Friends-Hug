package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import client.Client;

public class Delet extends MenuPanel {
	private static final long	serialVersionUID	= 4127857239432552031L;

	public Delet(JPanel Start) {
		setSize(700, 450);
		setLayout(null);
		this.setName("User Delet");
		
		JButton btnDelet = new MenuButton(7);
		btnDelet.setText("Account Löschen");
		btnDelet.setBounds(0, 150, 150, 50);
		btnDelet.addActionListener(MenuListener.getInstance());
		add(btnDelet);
		btnDelet.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Client.getInstance().send("FLAG_DELET;" + Client.getInstance().getUserName());
				System.exit(0);
			}
		});
		JButton btnBack = new MenuButton(8);
		btnBack.setText("Zurück");
		btnBack.setBounds(150, 150, 150, 50);
		btnBack.addActionListener(MenuListener.getInstance());
		add(btnBack);
		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Frame.getInstance().switchPanel(Frame.CHATMENU);
			}
		});
		
	}
		
	}
