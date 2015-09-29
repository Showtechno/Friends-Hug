package model;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {

	public void connection() throws UnknownHostException, IOException{
		Socket clientSocket = new Socket("localhost", 7777);
	}
	public static void main(String[] args) throws UnknownHostException, IOException {
		new Client().connection();
	}
}
