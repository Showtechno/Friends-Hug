package jUnittest;

import static org.junit.Assert.*;
import gui.Frame;
import gui.GuiMain;
import gui.Registration;
import gui.Start;

import org.junit.Test;

import server.Server;
import client.Client;

public class Anmelden {

	@Test
	public void anmeldenShouldWork() {
		Server s = new Server();
		s.start();
		Frame frame = Frame.getInstance();
		frame.switchPanel(Frame.REGISTATION);
		Client c  = Client.getInstance();
		c.start();
		
		assertEquals(expected, actual);
	}

}
