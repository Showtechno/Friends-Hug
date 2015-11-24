package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MenuListener implements KeyListener,ActionListener{
	
	private static MenuListener instance;
	
	/*
	 * Singelton Pattern für den MenuListener
	 */
	public static MenuListener getInstance() {
		if (instance == null) {
			instance = new MenuListener();
		}
		return instance;
	}
	
	/*
	 * Konstruktor des MenuListeners
	 */
	private MenuListener() {
	}
	
	/*
	 * Eine Taste wurde gedrückt
	 */
	@Override
	public void keyPressed(KeyEvent arg0) {
		System.out.println(arg0.getKeyCode());
		//Switch-Case
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
}
