package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

public class User_Option {

	private JFrame frmBenutzeroptionen;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_Option window = new User_Option();
					window.frmBenutzeroptionen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public User_Option() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBenutzeroptionen = new JFrame();
		frmBenutzeroptionen.setTitle("Benutzeroptionen");
		frmBenutzeroptionen.setBounds(100, 100, 700, 540);
		frmBenutzeroptionen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBenutzeroptionen.getContentPane().setLayout(null);
		
		JLabel lblNamendern = new JLabel("Name \u00E4ndern:");
		lblNamendern.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNamendern.setBounds(10, 31, 90, 26);
		frmBenutzeroptionen.getContentPane().add(lblNamendern);
		
		JLabel lblPasswordndern = new JLabel("Password \u00E4ndern:");
		lblPasswordndern.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPasswordndern.setBounds(10, 271, 110, 26);
		frmBenutzeroptionen.getContentPane().add(lblPasswordndern);
		
		textField = new JTextField();
		textField.setBounds(206, 71, 86, 20);
		frmBenutzeroptionen.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblAlterName = new JLabel("Alter Name:");
		lblAlterName.setBounds(10, 68, 172, 26);
		frmBenutzeroptionen.getContentPane().add(lblAlterName);
		
		JLabel lblNeuerName = new JLabel("Neuer Name:");
		lblNeuerName.setBounds(10, 109, 172, 14);
		frmBenutzeroptionen.getContentPane().add(lblNeuerName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(206, 106, 86, 20);
		frmBenutzeroptionen.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNeuerNameWiederholen = new JLabel("Neuer Name wiederholen:");
		lblNeuerNameWiederholen.setBounds(10, 140, 172, 14);
		frmBenutzeroptionen.getContentPane().add(lblNeuerNameWiederholen);
		
		textField_2 = new JTextField();
		textField_2.setBounds(206, 140, 86, 20);
		frmBenutzeroptionen.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblAltesPassword = new JLabel("Altes Password:");
		lblAltesPassword.setBounds(10, 308, 157, 14);
		frmBenutzeroptionen.getContentPane().add(lblAltesPassword);
		
		textField_3 = new JPasswordField();
		textField_3.setBounds(206, 305, 86, 20);
		frmBenutzeroptionen.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNeuesPassword = new JLabel("Neues Password:");
		lblNeuesPassword.setBounds(10, 339, 157, 14);
		frmBenutzeroptionen.getContentPane().add(lblNeuesPassword);
		
		textField_4 = new JPasswordField();
		textField_4.setBounds(206, 336, 86, 20);
		frmBenutzeroptionen.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNeuesPasswordWiederholen = new JLabel("Neues Password wiederholen:");
		lblNeuesPasswordWiederholen.setBounds(10, 370, 186, 14);
		frmBenutzeroptionen.getContentPane().add(lblNeuesPasswordWiederholen);
		
		textField_5 = new JPasswordField();
		textField_5.setBounds(206, 367, 86, 20);
		frmBenutzeroptionen.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnBenutzernamendern = new JButton("Benutzername \u00E4ndern");
		btnBenutzernamendern.setBounds(10, 188, 172, 26);
		frmBenutzeroptionen.getContentPane().add(btnBenutzernamendern);
		
		JButton btnPasswordndern = new JButton("Password \u00E4ndern");
		btnPasswordndern.setBounds(11, 399, 171, 26);
		frmBenutzeroptionen.getContentPane().add(btnPasswordndern);
		
		JButton btnZurck = new JButton("Zur\u00FCck");
		btnZurck.setBounds(447, 401, 89, 23);
		frmBenutzeroptionen.getContentPane().add(btnZurck);
		
		JLabel lblStatusServer = new JLabel("");
		lblStatusServer.setBounds(10, 451, 640, 40);
		frmBenutzeroptionen.getContentPane().add(lblStatusServer);
		

	}
}
