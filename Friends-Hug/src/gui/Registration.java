package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import client.Client;

public class Registration extends MenuPanel {

	private static final long serialVersionUID = 5873155239462552831L;
	private JLabel lblStatusRegistration;

	public JLabel getLblStatusRegistration() {
		return lblStatusRegistration;
	}

	public void setLblStatusRegistration(JLabel lblStatusRegistration) {
		this.lblStatusRegistration = lblStatusRegistration;
	}

	public Registration(JPanel Start) {
		setSize(700, 450);
		setLayout(null);
		this.setName("Registrierung");

		parent = Start;

		JLabel lblVorname = new JLabel();
		lblVorname.setText("Vorname: ");
		lblVorname.setHorizontalAlignment(SwingConstants.LEFT);
		lblVorname.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblVorname.setBounds(10, 20, 198, 14);
		add(lblVorname);

		JLabel lblNachname = new JLabel();
		lblNachname.setText("Nachname: ");
		lblNachname.setHorizontalAlignment(SwingConstants.LEFT);
		lblNachname.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNachname.setBounds(10, 60, 198, 14);
		add(lblNachname);

		JLabel lblBenutzername = new JLabel();
		lblBenutzername.setText("Benutzername: ");
		lblBenutzername.setHorizontalAlignment(SwingConstants.LEFT);
		lblBenutzername.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblBenutzername.setBounds(10, 100, 198, 14);
		add(lblBenutzername);

		JLabel lblPasswort = new JLabel();
		lblPasswort.setText("Passwort: ");
		lblPasswort.setHorizontalAlignment(SwingConstants.LEFT);
		lblPasswort.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblPasswort.setBounds(10, 140, 198, 14);
		add(lblPasswort);

		JLabel lblPasswordWiederholen = new JLabel();
		lblPasswordWiederholen.setText("Password wiederholen: ");
		lblPasswordWiederholen.setHorizontalAlignment(SwingConstants.LEFT);
		lblPasswordWiederholen.setFont(new Font("Times New Roman", Font.PLAIN,
				12));
		lblPasswordWiederholen.setBounds(10, 180, 198, 14);
		add(lblPasswordWiederholen);

		JLabel lblEmailAdresse = new JLabel();
		lblEmailAdresse.setText("E-Mail Adresse: ");
		lblEmailAdresse.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmailAdresse.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblEmailAdresse.setBounds(10, 220, 198, 14);
		add(lblEmailAdresse);

		JLabel lblEmailAdresseWiederholen = new JLabel();
		lblEmailAdresseWiederholen.setText("E-Mail Adresse wiederholen: ");
		lblEmailAdresseWiederholen.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmailAdresseWiederholen.setFont(new Font("Times New Roman",
				Font.PLAIN, 12));
		lblEmailAdresseWiederholen.setBounds(10, 260, 198, 14);
		add(lblEmailAdresseWiederholen);

		lblStatusRegistration = new JLabel();
		lblStatusRegistration.setText("");
		lblStatusRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatusRegistration.setFont(new Font("Times New Roman", Font.PLAIN,
				14));
		lblStatusRegistration.setBounds(10, 378, 647, 23);
		add(lblStatusRegistration);

		JTextField txtVorname = new JTextField();
		txtVorname.setBounds(150, 20, 198, 23);
		add(txtVorname);

		JTextField txtNachname = new JTextField();
		txtNachname.setBounds(150, 60, 198, 23);
		add(txtNachname);

		JTextField txtBenutzername = new JTextField();
		txtBenutzername.setBounds(150, 100, 198, 23);
		add(txtBenutzername);

		JTextField txtPasswort = new JPasswordField();
		txtPasswort.setBounds(150, 140, 198, 23);
		add(txtPasswort);

		JTextField txtPasswordWiederholen = new JPasswordField();
		txtPasswordWiederholen.setBounds(150, 180, 198, 23);
		add(txtPasswordWiederholen);

		JTextField txtEMailAddresse = new JTextField();
		txtEMailAddresse.setBounds(150, 220, 198, 23);
		add(txtEMailAddresse);

		JTextField txtEMailAddressenWiederholen = new JTextField();
		txtEMailAddressenWiederholen.setBounds(150, 260, 198, 23);
		add(txtEMailAddressenWiederholen);

		JButton btnRegistrieren = new MenuButton(3);
		btnRegistrieren.setText("Registrieren");
		btnRegistrieren.setBounds(0, 280, 250, 50);
		btnRegistrieren.addActionListener(MenuListener.getInstance());
		add(btnRegistrieren);
		btnRegistrieren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Ueberpruefen ob beide passwoerter gleich sind
				if (txtPasswort.getText().equals(
						txtPasswordWiederholen.getText())) {
					//Ueberpruefen ob beide Mails gleich sind
					if (txtEMailAddresse.getText().equals(
							txtEMailAddressenWiederholen.getText())) {
						//Ueberpruefen ob die Mail ein @ enthaelt
						if (txtEMailAddresse.getText().contains("@")) {
							//Daten an senden
							Client.getInstance().send(
									"FLAG_REGI;" + txtVorname.getText() + ','
											+ txtNachname.getText() + ','
											+ txtBenutzername.getText() + ','
											+ txtPasswort.getText() + ','
											+ txtEMailAddresse.getText());
						} else {
							JOptionPane.showMessageDialog(null,
									"Bitte korrekte E-Mail eingeben");
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"Email bitte korrekt wiederholen!");
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"Passwort bitte korrekt wiederholen!");
				}
			}
		});

		JButton btnZurck = new MenuButton(0);
		btnZurck.setText("Back");
		btnZurck.setBounds(0, 330, 250, 50);
		btnZurck.addActionListener(MenuListener.getInstance());
		add(btnZurck);
		btnZurck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame.getInstance().switchPanel(Frame.START);
			}
		});
	}
}