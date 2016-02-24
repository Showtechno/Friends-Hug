package gui;

import client.Client;
import gui.Frame;
public class GuiMain {

	public static void main(String[] args) {
		Frame frame = Frame.getInstance();
		frame.switchPanel(Frame.START);
		Client c  = Client.getInstance();
		c.start();
	}

}
