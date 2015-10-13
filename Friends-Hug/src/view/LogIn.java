package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class LogIn {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnZurck;
	private JButton btnEinloggen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn window = new LogIn();
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
	public LogIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Log In");
		frame.setBounds(100, 100, 700, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 11, 130, 40);
		frame.getContentPane().add(lblName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(10, 113, 130, 40);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblEmailAdresse = new JLabel("E-Mail Adresse:");
		lblEmailAdresse.setBounds(10, 62, 130, 40);
		frame.getContentPane().add(lblEmailAdresse);
		
		textField = new JTextField();
		textField.setBounds(162, 21, 200, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(162, 72, 200, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(162, 123, 200, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		btnZurck = new JButton("Zur\u00FCck");
		btnZurck.setBounds(417, 216, 89, 23);
		frame.getContentPane().add(btnZurck);
		
		btnEinloggen = new JButton("Einloggen");
		btnEinloggen.setBounds(10, 216, 89, 23);
		frame.getContentPane().add(btnEinloggen);
	}

}
