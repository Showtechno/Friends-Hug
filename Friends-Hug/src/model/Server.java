package model;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;

public class Server {

	private HashMap<Integer,ServerThread> clientlist;
	
	private InetAddress ip;

	public InetAddress getIp() {
		return ip;
	}

	public void setIp() {
		try {
			this.ip = InetAddress.getLocalHost();
		}
		catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.out.println("keine IP-Adresse gefunden!");
		}
	}
		
	public void start() throws java.net.SocketException, java.io.IOException{
		int i= 0;
		try{
			ServerSocket serverSocket = new ServerSocket(7777,0,getIp());
			while(true){
				Socket cs = serverSocket.accept();
				clientlist.put(i, new ServerThread());
			}
		}
		catch(Exception e){
			
		}
	}
}
