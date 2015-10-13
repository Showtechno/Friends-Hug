package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Chatfenster {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chatfenster window = new Chatfenster();
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
	public Chatfenster() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 699, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 444, 500, 47);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel chatfenster = new JLabel("");
		chatfenster.setBounds(10, 11, 493, 416);
		frame.getContentPane().add(chatfenster);
		
		JButton zurueckButton = new JButton("zurück");
		zurueckButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		zurueckButton.setBounds(556, 456, 89, 23);
		frame.getContentPane().add(zurueckButton);
		
		JLabel teilnehmerliste = new JLabel("");
		teilnehmerliste.setBounds(528, 17, 133, 410);
		frame.getContentPane().add(teilnehmerliste);
	}
}
