package gui;

import javax.swing.JPanel;


abstract class MenuPanel
		extends JPanel {
	
	private static final long	serialVersionUID	= 7193657142067965189L;
	static JPanel						parent;
	
	public JPanel getParentPanel() {
		return parent;
	}
	
}
