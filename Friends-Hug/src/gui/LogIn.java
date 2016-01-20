package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

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
		lblName.setText("Benutzername: ");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblName.setBounds(10, 11, 130, 40);
		add(lblName);
		
		JLabel lblPassword = new JLabel();
		lblPassword.setText("Passwort: ");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblPassword.setBounds(10, 11, 130, 40);
		add(lblPassword);
		
		JLabel lblEmailAdresse = new JLabel();
		lblEmailAdresse.setText("E-Mail Addresse: ");
		lblEmailAdresse.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmailAdresse.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblEmailAdresse.setBounds(10, 11, 130, 40);
		add(lblEmailAdresse);
		
		JTextField txtName = new JTextField();
		txtName.setBounds(162, 21, 200, 20);
		
		JTextField txtPasswort = new JPasswordField();
		txtPasswort.setBounds(162, 72, 200, 20);
		
		JTextField txtEMailAdresse = new JTextField();
		txtEMailAdresse.setBounds(162, 123, 200, 20);

		JButton btnEinloggen = new MenuButton(3);
		btnEinloggen.setText("Einloggen");
		btnEinloggen.setBounds(10, 216, 89, 23);
		btnEinloggen.addActionListener(MenuListener.getInstance());
		add(btnEinloggen);
		btnEinloggen.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("einloggen fehlt!");
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