package gui;




import javax.swing.JButton;
import javax.swing.JLabel;




public class Start
		extends MenuPanel {
	
	private static final long	serialVersionUID	= -7976732089602227034L;
		
	public Start() {
		setSize(700, 450);
		setLayout(null);
		this.setName("Friends Hug");
		
		JLabel lblStatusServer = new JLabel();
		lblStatusServer.setBounds(10, 363, 647, 38);
		add(lblStatusServer);
		
		JButton btnAnmelden = new MenuButton(2);
		btnAnmelden.setText("Anmelden");
		btnAnmelden.setBounds(55, 107, 155, 55);
		btnAnmelden.addActionListener(MenuListener.getInstance());
		add(btnAnmelden);
		
		JButton btnRegistrieren = new MenuButton(1);
		btnRegistrieren.setText("Registrieren");
		btnRegistrieren.setBounds(455, 107, 155, 55);
		btnRegistrieren.addActionListener(MenuListener.getInstance());
		add(btnRegistrieren);
		
		JButton btnBeenden = new MenuButton(-1);
		btnBeenden.setText("Beenden");
		btnBeenden.setBounds(455, 297, 155, 55);
		btnBeenden.addActionListener(MenuListener.getInstance());
		add(btnBeenden);
	}
}