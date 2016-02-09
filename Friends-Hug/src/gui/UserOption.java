package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class UserOption
		extends MenuPanel {
	
	
	private static final long	serialVersionUID	= 6292949248291295930L;
	public JLabel lblStatusServer;
	public UserOption(JPanel Start) {
		this.setName("Benutzeroptionen");
		setSize(700, 450);
		setLayout(null);
		
		parent = Start;
		
		lblStatusServer = new JLabel();
		lblStatusServer.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatusServer.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblStatusServer.setBounds(10, 451, 640, 40);
		add(lblStatusServer);
		
		JLabel lblNamendern = new JLabel();
		lblNamendern.setText("Name ändern: ");
		lblNamendern.setHorizontalAlignment(SwingConstants.LEFT);
		lblNamendern.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNamendern.setBounds(10, 31, 200, 26);
		add(lblNamendern);
		
		JLabel lblPasswordndern = new JLabel();
		lblPasswordndern.setText("Passwort ändern: ");
		lblPasswordndern.setHorizontalAlignment(SwingConstants.LEFT);
		lblPasswordndern.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPasswordndern.setBounds(10, 271, 200, 26);
		add(lblPasswordndern);	
		
		JLabel lblAlterName = new JLabel();
		lblAlterName.setText("Alter Name: ");
		lblAlterName.setHorizontalAlignment(SwingConstants.LEFT);
		lblAlterName.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblAlterName.setBounds(10, 68, 172, 26);
		add(lblAlterName);	
		
		JLabel lblNeuerName = new JLabel();
		lblNeuerName.setText("Neuer Name: ");
		lblNeuerName.setHorizontalAlignment(SwingConstants.LEFT);
		lblNeuerName.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNeuerName.setBounds(10, 109, 172, 14);
		add(lblNeuerName);	
		
		JLabel lblNeuerNameWiederholen = new JLabel();
		lblNeuerNameWiederholen.setText("Neuen Name wiederholen: ");
		lblNeuerNameWiederholen.setHorizontalAlignment(SwingConstants.LEFT);
		lblNeuerNameWiederholen.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNeuerNameWiederholen.setBounds(10, 140, 172, 14);
		add(lblNeuerNameWiederholen);	
		
		JLabel lblAltesPassword = new JLabel();
		lblAltesPassword.setText("Altes Passwort: ");
		lblAltesPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblAltesPassword.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblAltesPassword.setBounds(10, 308, 157, 14);
		add(lblAltesPassword);
		
		JLabel lblNeuesPassword = new JLabel();
		lblNeuesPassword.setText("Neues Passwort: ");
		lblNeuesPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblNeuesPassword.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNeuesPassword.setBounds(10, 339, 157, 14);
		add(lblNeuesPassword);
		
		JLabel lblNeuesPasswordWiederholen = new JLabel();
		lblNeuesPasswordWiederholen.setText("Neues Passwort wiederholen: ");
		lblNeuesPasswordWiederholen.setHorizontalAlignment(SwingConstants.LEFT);
		lblNeuesPasswordWiederholen.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNeuesPasswordWiederholen.setBounds(10, 370, 186, 14);
		add(lblNeuesPasswordWiederholen);
		
		JTextField txtalterName = new JTextField();
		txtalterName.setBounds(206, 71, 86, 20);
		add(txtalterName);
		
		JTextField txtneuerName = new JTextField();
		txtneuerName.setBounds(206, 106, 86, 20);
		add(txtneuerName);
		
		JTextField txtneuerNameWiederholen = new JTextField();
		txtneuerNameWiederholen.setBounds(206, 140, 86, 20);
		add(txtneuerNameWiederholen);
		
		JTextField altesPasswort = new JPasswordField();
		altesPasswort.setBounds(206, 305, 86, 20);
		add(altesPasswort);
		
		JTextField neuesPasswort = new JPasswordField();
		neuesPasswort.setBounds(206, 336, 86, 20);
		add(neuesPasswort);
		
		JTextField neuesPasswortWiederholen = new JPasswordField();
		neuesPasswortWiederholen.setBounds(206, 367, 86, 20);
		add(neuesPasswortWiederholen);
		
		String name = txtneuerName.getText();
		String name2 = txtneuerNameWiederholen.getText();
		String passwort = neuesPasswort.getText();
		String passwort2 = neuesPasswortWiederholen.getText();
		
		
		JButton btnBenutzernamendern = new JButton();
		btnBenutzernamendern.setText("Benutzername ändern");
		btnBenutzernamendern.setBounds(10, 188, 172, 26);
		btnBenutzernamendern.addActionListener(MenuListener.getInstance());
		add(btnBenutzernamendern);
		btnBenutzernamendern.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(name.equals(name2)){
					System.out.println(txtneuerNameWiederholen.getText());
				}
				System.out.println("Benutzername ändern fehlt");
			}
		});
		
		JButton btnPasswordndern = new JButton();
		btnPasswordndern.setText("Passwort ändern");
		btnPasswordndern.setBounds(10, 216, 172, 26);
		btnPasswordndern.addActionListener(MenuListener.getInstance());
		add(btnPasswordndern);
		btnPasswordndern.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(passwort.equals(passwort2)){
					System.out.println(neuesPasswort.getText());
				}
				System.out.println("Password ändern fehlt");
			}
		});
		
		JButton btnZurck = new MenuButton(3);
		btnZurck.setText("Back");
		btnZurck.setBounds(447, 401, 89, 23);
		btnZurck.addActionListener(MenuListener.getInstance());
		add(btnZurck);
		btnZurck.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Frame.getInstance().switchPanel(Frame.CHATMENU);
			}
		});
		
		
	}
}