package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import client.Client;

public class LogIn
		extends MenuPanel {
	
	
	private static final long	serialVersionUID	= 6292949248291295930L;
	public JLabel lblStatusServer;
	public LogIn(JPanel Start) {
		this.setName("Log In");
		setSize(700, 450);
		setLayout(null);
		
		parent = Start;

		lblStatusServer = new JLabel();
		lblStatusServer.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatusServer.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblStatusServer.setBounds(10, 361, 639, 40);
		add(lblStatusServer);
		
		JLabel lblName = new JLabel();
		lblName.setText("Name/Mail: ");
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblName.setBounds(10, 11, 130, 40);
		add(lblName);
		
		JLabel lblPassword = new JLabel();
		lblPassword.setText("Passwort: ");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblPassword.setBounds(10, 51, 130, 40);
		add(lblPassword);
	
		
		JLabel lblCode = new JLabel();
		lblCode.setText("Sicherheitscode: ");
		lblCode.setHorizontalAlignment(SwingConstants.LEFT);
		lblCode.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblCode.setBounds(10, 131, 130, 40);
		add(lblCode);
		
		JTextField txtName = new JTextField();
		txtName.setBounds(162, 11, 200, 20);
		add(txtName);
		
		JTextField txtPasswort = new JPasswordField();
		txtPasswort.setBounds(162, 51, 200, 20);
		add(txtPasswort);
		
		JTextField txtCode = new JTextField();
		txtCode.setBounds(162, 131, 200, 20);
		add(txtCode);
		
		JButton btnEinloggen = new MenuButton(3);
		btnEinloggen.setText("Einloggen");
		btnEinloggen.setBounds(10, 216, 89, 23);
		btnEinloggen.addActionListener(MenuListener.getInstance());
		add(btnEinloggen);
		btnEinloggen.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String name = txtName.getText();
				String passwort = txtPasswort.getText();
				//sendet die Eingegebenden Daten
				Client.getInstance().send("FLAG_LOGIN;"+ name +','+ passwort);
			}
		});
		
		
		JButton btnZurck = new MenuButton(0);
		btnZurck.setText("Back");
		btnZurck.setBounds(417, 216, 89, 23);
		btnZurck.addActionListener(MenuListener.getInstance());
		add(btnZurck);
		btnZurck.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Frame.getInstance().switchPanel(Frame.START);
			}
		});
			
		
	}
}