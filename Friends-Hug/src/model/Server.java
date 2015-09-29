package model;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashMap;

import javax.xml.stream.events.StartDocument;

public class Server {

	private HashMap<Integer,ServerThread> clientlist;
	
	private InetAddress ip;
	
	public InetAddress getIp() {
		return ip;
	}
	public void setIp() {
		
			InetSocketAddress i =new InetSocketAddress("127.0.0.1", 1234);
			this.ip =i.getAddress();
		
	}		
		
	public void start(){
		if(ip == null){
			setIp();
		}
		int listnumber= 1;
		try{
			ServerSocket serverSocket = new ServerSocket(7777,0,ip);
			System.out.println("Server ist im Betrieb");
			while(true){
				Socket socket = serverSocket.accept();
				ServerThread serverThread = new ServerThread(socket,listnumber,this);
				serverThread.start();
				clientlist.put(listnumber, serverThread);
				listnumber++;
				System.out.println("Verbindungsnummer: "+ listnumber);
			}
		}
		catch(Exception e){
			System.out.println("Servers funktioniert nicht.");
		}
	}
	public void removeClient(int serverListID){
		clientlist.remove(serverListID);
	}
	public static void main(String[] args) {
			new Server().start();
	}
}
