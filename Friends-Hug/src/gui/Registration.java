package gui;

import java.awt.Font;

import javax.swing.*;


public class Registration
		extends MenuPanel {
	
	private static final long	serialVersionUID	= 5873155239462552831L;
	public JLabel lblStatusServer;
	public Registration(JPanel Start) {
		setSize(700, 450);
		setLayout(null);
		this.setName("Registrierung");
		
		parent = Start;
		
		JLabel lblVorname = new JLabel();
		lblVorname.setText("Vorname: ");
		lblVorname.setHorizontalAlignment(SwingConstants.CENTER);
		lblVorname.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblVorname.setBounds(10, 20, 198, 14);
		add(lblVorname);
		
		JLabel lblNachname = new JLabel();
		lblNachname.setText("Nachname: ");
		lblNachname.setHorizontalAlignment(SwingConstants.CENTER);
		lblNachname.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNachname.setBounds(10, 60, 198, 14);
		add(lblNachname);
		
		JLabel lblBenutzername = new JLabel();
		lblBenutzername.setText("Benutzername: ");
		lblBenutzername.setHorizontalAlignment(SwingConstants.CENTER);
		lblBenutzername.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblBenutzername.setBounds(10, 100, 198, 14);
		add(lblBenutzername);
		
		JLabel lblPasswort = new JLabel();
		lblPasswort.setText("Passwort: ");
		lblPasswort.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasswort.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPasswort.setBounds(10, 140, 198, 14);
		add(lblPasswort);
		
		JLabel lblPasswordWiederholen = new JLabel();
		lblPasswordWiederholen.setText("Password wiederholen: ");
		lblPasswordWiederholen.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasswordWiederholen.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPasswordWiederholen.setBounds(10, 180, 198, 14);
		add(lblPasswordWiederholen);
		
		JLabel lblEmailAdresse = new JLabel();
		lblEmailAdresse.setText("E-Mail Adresse: ");
		lblEmailAdresse.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmailAdresse.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblEmailAdresse.setBounds(10, 220, 198, 14);
		add(lblEmailAdresse);
		
		JLabel lblEmailAdresseWiederholen = new JLabel();
		lblEmailAdresseWiederholen.setText("E-Mail Adresse wiederholen: ");
		lblEmailAdresseWiederholen.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmailAdresseWiederholen.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblEmailAdresseWiederholen.setBounds(10, 260, 198, 14);
		add(lblEmailAdresseWiederholen);
		
		lblStatusServer = new JLabel();
		lblStatusServer.setText("");
		lblStatusServer.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatusServer.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblStatusServer.setBounds(10, 378, 647, 23);
		add(lblStatusServer);
		
		JTextField txtVorname = new JTextField();
		txtVorname.setBounds(10, 20, 198, 14);
		
		JTextField txtNachname = new JTextField();
		txtNachname.setBounds(10, 60, 198, 14);
		
		JTextField txtBenutzername = new JTextField();
		txtBenutzername.setBounds(10, 100, 198, 14);
		
		JTextField txtPasswort = new JPasswordField();
		txtPasswort.setBounds(10, 140, 198, 14);
		
		JTextField txtPasswordWiederholen = new JPasswordField();
		txtPasswordWiederholen.setBounds(10, 180, 198, 14);
		
		JTextField txtEMailAddresse = new JTextField();
		txtEMailAddresse.setBounds(10, 220, 198, 14);
		
		JTextField txtEMailAddressenWiederholen = new JTextField();
		txtEMailAddressenWiederholen.setBounds(10, 260, 198, 14);
		
		JButton btnRegistrieren = new MenuButton(3);
		btnRegistrieren.setText("Play");
		btnRegistrieren.setBounds(0, 200, 250, 50);
		btnRegistrieren.addActionListener(MenuListener.getInstance());
		add(btnRegistrieren);
		
		JButton btnZurck = new MenuButton(0);
		btnZurck.setText("Back");
		btnZurck.setBounds(0, 250, 250, 50);
		btnZurck.addActionListener(MenuListener.getInstance());
		add(btnZurck);
	}
}