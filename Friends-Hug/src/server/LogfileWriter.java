package server;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class LogfileWriter {
	
	static SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss.SSS");
	static Timestamp time = new Timestamp(System.currentTimeMillis());
	static String dateTime = format.format(time);
	private static LogfileWriter instance;
	
	public static LogfileWriter getInstance() {
		if (instance == null) {
			instance = new LogfileWriter();
		}
		return instance;
	}
		
	public void writeLogfile(String input){
		try{
			FileWriter fWriter = new FileWriter("log.txt", true);
			BufferedWriter bWriter = new BufferedWriter(fWriter);
			PrintWriter pWriter = new PrintWriter(bWriter);
			pWriter.println(dateTime + ": " + input);
			System.out.println("Ereignis wurde in die Log.txt geschrieben: " + input);
			bWriter.close();
		}
		catch(Exception e){
			System.out.println("ACHTUNG: Logfile konnte nicht beschrieben werden!");
		}
	}
	public static void main(String[] args) {
		LogfileWriter w = new LogfileWriter();
		w.writeLogfile("test");
		w.writeLogfile("test");
		w.writeLogfile("test");
		w.writeLogfile("test");
	}
}
