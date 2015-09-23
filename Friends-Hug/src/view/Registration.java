package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Registration {

	private JFrame frame;
	private JTextField textField_Email_Bestaetigen;
	private JTextField textField_Email;
	private JTextField textField_Passwort_Bestaetigen;
	private JTextField textField_Passwort;
	private JTextField textField_Benutzername;
	private JTextField textField_Nachname;
	private JTextField textField_Vorname;
	private JButton btnRegistrieren;
	private JButton btnZurueck;

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
		frame.setBounds(100, 100, 450, 380);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblVorname = new JLabel("Vorname:");
		lblVorname.setHorizontalAlignment(SwingConstants.CENTER);
		lblVorname.setBounds(10, 10, 139, 30);
		frame.getContentPane().add(lblVorname);
		
		JLabel lblNachname = new JLabel("Nachname:");
		lblNachname.setHorizontalAlignment(SwingConstants.CENTER);
		lblNachname.setBounds(10, 51, 139, 30);
		frame.getContentPane().add(lblNachname);
		
		JLabel lblBenutzername = new JLabel("Benutzername:");
		lblBenutzername.setHorizontalAlignment(SwingConstants.CENTER);
		lblBenutzername.setBounds(10, 92, 139, 30);
		frame.getContentPane().add(lblBenutzername);
		
		JLabel lblPasswort = new JLabel("Passwort:");
		lblPasswort.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasswort.setBounds(10, 133, 139, 30);
		frame.getContentPane().add(lblPasswort);
		
		JLabel lblPasswortBestaetigen = new JLabel("Passwort best\u00E4tigen:");
		lblPasswortBestaetigen.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasswortBestaetigen.setBounds(10, 174, 139, 30);
		frame.getContentPane().add(lblPasswortBestaetigen);
		
		JLabel lblEmailadresse = new JLabel("E-mail-Adresse:");
		lblEmailadresse.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmailadresse.setBounds(10, 215, 139, 30);
		frame.getContentPane().add(lblEmailadresse);
		
		JLabel lblEmailadresseBestaetigen = new JLabel("E-mail-Adresse best\u00E4tigen:");
		lblEmailadresseBestaetigen.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmailadresseBestaetigen.setBounds(10, 256, 139, 30);
		frame.getContentPane().add(lblEmailadresseBestaetigen);
		
		textField_Email_Bestaetigen = new JTextField();
		textField_Email_Bestaetigen.setBounds(150, 256, 200, 30);
		frame.getContentPane().add(textField_Email_Bestaetigen);
		textField_Email_Bestaetigen.setColumns(10);
		
		textField_Email = new JTextField();
		textField_Email.setColumns(10);
		textField_Email.setBounds(150, 215, 200, 30);
		frame.getContentPane().add(textField_Email);
		
		textField_Passwort_Bestaetigen = new JTextField();
		textField_Passwort_Bestaetigen.setColumns(10);
		textField_Passwort_Bestaetigen.setBounds(150, 174, 200, 30);
		frame.getContentPane().add(textField_Passwort_Bestaetigen);
		
		textField_Passwort = new JTextField();
		textField_Passwort.setColumns(10);
		textField_Passwort.setBounds(150, 133, 200, 30);
		frame.getContentPane().add(textField_Passwort);
		
		textField_Benutzername = new JTextField();
		textField_Benutzername.setColumns(10);
		textField_Benutzername.setBounds(150, 92, 200, 30);
		frame.getContentPane().add(textField_Benutzername);
		
		textField_Nachname = new JTextField();
		textField_Nachname.setColumns(10);
		textField_Nachname.setBounds(150, 51, 200, 30);
		frame.getContentPane().add(textField_Nachname);
		
		textField_Vorname = new JTextField();
		textField_Vorname.setColumns(10);
		textField_Vorname.setBounds(150, 10, 200, 30);
		frame.getContentPane().add(textField_Vorname);
		
		btnRegistrieren = new JButton("Registrieren");
		btnRegistrieren.setBounds(20, 307, 107, 23);
		frame.getContentPane().add(btnRegistrieren);
		
		btnZurueck = new JButton("Zur\u00FCck");
		btnZurueck.setBounds(323, 307, 89, 23);
		frame.getContentPane().add(btnZurueck);
	}
}
