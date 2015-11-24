package gui;

import javax.swing.JButton;


public class MenuButton
		extends JButton {
	
	private static final long	serialVersionUID	= 4824375292608193984L;
	private int					number;
	
	public MenuButton(int number) {
		this.number = number;
	}
	
	public int getNumber() {
		return number;
	}
}
