package gui;

import client.Client;
import gui.Frame;
public class GuiMain {

	public static void main(String[] args) {
		Frame frame = Frame.getInstance();
		frame.switchPanel(frame.START);
		Client c  = Client.getInstance();
		c.start();
	}

}
