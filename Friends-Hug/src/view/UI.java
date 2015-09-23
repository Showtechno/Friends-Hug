package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

public class UI {

	private JFrame frmJavaChatprogramm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI window = new UI();
					window.frmJavaChatprogramm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmJavaChatprogramm = new JFrame();
		frmJavaChatprogramm.setTitle("Java Chatprogramm");
		frmJavaChatprogramm.setBounds(100, 100, 249, 238);
		frmJavaChatprogramm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJavaChatprogramm.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnAnmelden = new JButton("Anmelden");
		btnAnmelden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frmJavaChatprogramm.getContentPane().add(btnAnmelden);
		
		JButton btnBeenden = new JButton("Beenden");
		btnBeenden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnRegistrieren = new JButton("Registrieren");
		frmJavaChatprogramm.getContentPane().add(btnRegistrieren);
		frmJavaChatprogramm.getContentPane().add(btnBeenden);
	}

}
