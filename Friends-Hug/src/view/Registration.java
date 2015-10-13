package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Registration {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JButton btnRegistrieren;
	private JButton btnZurck;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Registrierung");
		frame.setBounds(100, 100, 700, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblVorname = new JLabel("Vorname:");
		lblVorname.setBounds(10, 20, 198, 14);
		frame.getContentPane().add(lblVorname);
		
		JLabel lblNachname = new JLabel("Nachname:");
		lblNachname.setBounds(10, 60, 198, 14);
		frame.getContentPane().add(lblNachname);
		
		JLabel lblBenutzername = new JLabel("Benutzername:");
		lblBenutzername.setBounds(10, 100, 198, 14);
		frame.getContentPane().add(lblBenutzername);
		
		JLabel lblPasswort = new JLabel("Passwort:");
		lblPasswort.setBounds(10, 140, 198, 14);
		frame.getContentPane().add(lblPasswort);
		
		JLabel lblPasswordWiederholen = new JLabel("Password wiederholen:");
		lblPasswordWiederholen.setBounds(10, 180, 198, 14);
		frame.getContentPane().add(lblPasswordWiederholen);
		
		JLabel lblEmailAdresse = new JLabel("E-Mail Adresse:");
		lblEmailAdresse.setBounds(10, 220, 198, 14);
		frame.getContentPane().add(lblEmailAdresse);
		
		JLabel lblEmailAdresseWiederholen = new JLabel("E-Mail Adresse Wiederholen:");
		lblEmailAdresseWiederholen.setBounds(10, 260, 198, 14);
		frame.getContentPane().add(lblEmailAdresseWiederholen);
		
		textField = new JTextField();
		textField.setBounds(248, 20, 170, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(248, 60, 170, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(248, 100, 170, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new  JPasswordField();
		textField_3.setBounds(248, 140, 170, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new  JPasswordField();
		textField_4.setBounds(248, 180, 170, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(248, 220, 170, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(248, 260, 170, 20);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		btnRegistrieren = new JButton("Registrieren");
		btnRegistrieren.setBounds(10, 378, 120, 23);
		frame.getContentPane().add(btnRegistrieren);
		
		btnZurck = new JButton("Zur\u00FCck");
		btnZurck.setBounds(444, 378, 89, 23);
		frame.getContentPane().add(btnZurck);
	}

}
