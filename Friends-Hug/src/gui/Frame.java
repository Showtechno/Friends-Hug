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
	public static final int 	DELET				= 6;
	public static final int 	BEENDEN				= -1;
	private Delet				delet;
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
		delet = new Delet(start);
		setContentPane(start);
		setBounds(700, 450, 250 + 6, 300 + 29);
		setTitle("Friends Hug");
		setLayout(null);
		setSize(700,450);
		setResizable(false);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	
	public void switchPanel(int panelNumber) {
		switch (panelNumber) {
		case (BEENDEN): {
			//this.dispose();
			System.exit(0);
			break;
		}
		case (START): {
			setContentPane(start);
			break;
		}
		case (CHATMENU): {
			setContentPane(chatMenu);
			break;
		}
		case (LOGIN): {
			setContentPane(logIn);
			break;
		}
		
		case (REGISTATION): {
			setContentPane(registration);
			break;
		}
		case (CHATFENSTER): {
			setContentPane(chatfenster);
			break;
		}
		case (USEROPTION): {
			setContentPane(userOption);
			break;
		}
		case (DELET):{
			setContentPane(delet);
			break;
		}
		
		}
	}
}
