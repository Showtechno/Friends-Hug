package gui;

import javax.swing.JLabel;

public class MenuLabel
		extends JLabel {
	
	private static final long	serialVersionUID	= 4824375292608193984L;
	private int					number;
	
	public MenuLabel(int number) {
		this.number = number;
	}
	
	public int getNumber() {
		return number;
	}
	
}
