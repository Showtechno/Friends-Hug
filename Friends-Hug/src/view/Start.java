package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

public class Start {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start window = new Start();
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
	public Start() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Friends Hug");
		frame.setBounds(100, 100, 700, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAnmelden = new JButton("Anmelden");
		btnAnmelden.setBounds(55, 107, 155, 55);
		frame.getContentPane().add(btnAnmelden);
		
		JButton btnRegistrieren = new JButton("Registrieren");
		btnRegistrieren.setBounds(455, 107, 155, 55);
		frame.getContentPane().add(btnRegistrieren);
		
		JButton btnBeenden = new JButton("Beenden");
		btnBeenden.setBounds(455, 346, 155, 55);
		frame.getContentPane().add(btnBeenden);
	}

}
