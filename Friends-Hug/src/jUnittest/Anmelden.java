//package jUnittest;
//
//import static org.junit.Assert.*;
//import gui.Frame;
//import gui.GuiMain;
//import gui.LogIn;
//import gui.Registration;
//import gui.Start;
//
//import org.junit.Test;
//
//import server.Server;
//import client.Client;
//import client.Flagdetection;
//
//public class Anmelden {
//
//	@Test
//	public void anmeldenShouldWork() {
//		Server s = new Server();
//		s.start();
//		Client c  = Client.getInstance();
//		c.start();
//		c.doLogin("asda", "");
//		Flagdetection flag = new Flagdetection();
//		
//		assert("asd", flag.getText() == c.send("FLAG_LOGIN"+"test,test,test"));
//	}
//
//}
