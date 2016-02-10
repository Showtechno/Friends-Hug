package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
			FileWriter fWriter = new FileWriter("log.txt");
			BufferedWriter bWriter = new BufferedWriter(fWriter);
			bWriter.append(dateTime + ": " + input+ "\n");
			System.out.println("Ereignis wurde in die Log.txt geschrieben.");
			bWriter.close();
		}
		catch(Exception e){
			System.out.println("ACHTUNG: Logfile konnte nicht beschrieben werden!");
		}
	}
}
