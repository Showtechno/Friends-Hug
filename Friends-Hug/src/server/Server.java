package server;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Server {

	//hashmap mit allen Teilnehmern
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
			//ein socket wird auf port 1337 geoeffnet
			ServerSocket serverSocket = new ServerSocket(1337);
			LogfileWriter.getInstance().writeLogfile("Server ist im Betrieb");
			while(true){
				/*server nimmt jede einkommende verbindung an und startet ein neuen Thread und uebergibt ihm
				 * den socket seine ,,Verbindungsnummer" und den Server selbst
				 * diesen Thread fuegt er der Hashmap hinzu und erhoeht die Verbindungsnummer
				 *der Key fuer die Hashmap ist die Verbindungsnummer
				 */
				Socket socket = serverSocket.accept();
				ServerThread serverThread = new ServerThread(socket,listnumber,this);
				serverThread.start();
				clientlist.put(listnumber, serverThread);
				listnumber++;
				LogfileWriter.getInstance().writeLogfile("Verbindungsnummer: "+ listnumber);
			}
		}
		catch(Exception e){
			LogfileWriter.getInstance().writeLogfile("Server crashed");
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
			new Server().start();
	}
}
