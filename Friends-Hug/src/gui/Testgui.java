package gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import javax.swing.border.LineBorder;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JTextArea;
import java.awt.Cursor;

public class Testgui {

	private JFrame frame;

	public JLabel lblStatusServer;
	public JLabel teilnehmerliste;
	private JTextArea textArea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Testgui window = new Testgui();
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
	public Testgui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setName("Chat");
		frame.setSize(700, 450);
		frame.getContentPane().setLayout(null);

		
		
		lblStatusServer = new JLabel();
		lblStatusServer.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatusServer.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblStatusServer.setBounds(10, 447, 630, 44);
		frame.getContentPane().add(lblStatusServer);
		
		teilnehmerliste = new JLabel();
		teilnehmerliste.setHorizontalAlignment(SwingConstants.CENTER);
		teilnehmerliste.setFont(new Font("Times New Roman", Font.BOLD, 30));
		teilnehmerliste.setBounds(528, 17, 133, 410);
		frame.getContentPane().add(teilnehmerliste);
		
		JButton zurueckButton = new MenuButton(3);
		zurueckButton.setText("Back");
		zurueckButton.setBounds(556, 456, 89, 23);
		zurueckButton.addActionListener(MenuListener.getInstance());
		frame.getContentPane().add(zurueckButton);
		
		textArea = new JTextArea();
		textArea.setAutoscrolls(false);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textArea.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		textArea.setAlignmentX(Component.LEFT_ALIGNMENT);
		textArea.setBounds(10, 11, 417, 305);
		frame.getContentPane().add(textArea);

		int i = 0;
		while(i <100){
			nachrichtenFensterChange("test2dfjjjjjjjjjjjdfbjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjxcbadfbadfbjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjasjjjjjjjjjjjjjjsdfbadfgbjjjjjjjjjjjjjjjjjjjj");		
			i++;
		}
	}
	public void nachrichtenFensterChange(String massagefromServer){
		textArea.setText(textArea.getText() +  "\n" + massagefromServer);
	}
}
