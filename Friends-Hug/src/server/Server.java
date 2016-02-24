package server;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Server {

	protected HashMap<Integer,ServerThread> clientlist = new HashMap<Integer, ServerThread>();
	private List<String> list = new ArrayList<>();
	
	private InetAddress ip;
	
	public InetAddress getIp() {
		return ip;
	}
	//FEHLT INTERNET CONNECTION
	public void setIp() {
		
//			InetSocketAddress i =new InetSocketAddress("127.0.0.1", 7778);
//			this.ip =i.getAddress();
		
	}		
		
	public List<String> getList() {
		return list;
	}
	public void start(){
//		if(ip == null){
//			setIp();
//		}
		int listnumber= 0;
		try{
			ServerSocket serverSocket = new ServerSocket(1337);
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
			System.out.println("Server funktioniert nicht.");
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
			new Server().start();
	}
}
