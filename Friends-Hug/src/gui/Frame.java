package gui;

import javax.swing.JFrame;



public class Frame
		extends JFrame {
	
	
	private static final long	serialVersionUID	= -4421585010809222177L;
	public static final int		START				= 0;
	public static final int		REGISTATION			= 1;
	public static final int		LOGIN				= 2;
	public static final int		CHATMENU			= 3;
	public static final int		CHATFENSTER			= 4;
	public static final int 	USEROPTION			= 5;
	private Chatfenster 		chatfenster;
	private UserOption			userOption;
	private Start				start;
	private Chatmenu			chatMenu;
	private LogIn				logIn;
	private Registration		registration;
	private static Frame		instance;
	
	
	
	public static Frame getInstance() {
		if (instance == null) {
			instance = new Frame();
		}
		return instance;
	}
	
	private Frame() {
		start = new Start();
		chatMenu = new Chatmenu(start);
		logIn = new LogIn(start);
		registration = new Registration(start);
		chatfenster = new Chatfenster(start);
		userOption = new UserOption(start);
		setContentPane(start);
		setBounds(700, 450, 250 + 6, 300 + 29);
		setTitle("PONG");
		setLayout(null);
		setSize(700,450);
		setResizable(false);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	
	public void switchPanel(int panelNumber) {
		switch (panelNumber) {
		case (-1): {
			this.dispose();
			System.exit(0);
			break;
		}
		case (START): {
			
			setSize(getContentPane().getWidth(), getContentPane().getHeight());
			break;
		}
		case (CHATMENU): {
			setSize(chatMenu.getWidth(), chatMenu.getHeight());
			setContentPane(chatMenu);
			break;
		}
		case (LOGIN): {
			setSize(logIn.getWidth(), logIn.getHeight());
			setContentPane(logIn);
			break;
		}
		
		case (REGISTATION): {
			setSize(registration.getWidth(), registration.getHeight());
			setContentPane(registration);
			break;
		}
		case (CHATFENSTER): {
			setSize(chatfenster.getWidth(), chatfenster.getHeight());
			setContentPane(chatfenster);
			break;
		}
		case (USEROPTION): {
			setSize(userOption.getWidth(), userOption.getHeight());
			setContentPane(userOption);
			break;
		}
		
		}
	}
}
