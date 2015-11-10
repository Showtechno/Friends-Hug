package model;

import java.io.File;
import java.io.FileWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class LogfileWriter {
	
	
	File logDatei;
	FileWriter writer;
	static SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss.SSS");
	static Timestamp time = new Timestamp(System.currentTimeMillis());
	static String dateTime = format.format(time);

	public void writeLogfile(String input){
		
		logDatei = new File("Log.text");
		try{
			writer = new FileWriter(logDatei, true);
			writer.write(dateTime + ": " + input + "\n");
		}
		catch(Exception e){
			System.out.println("ACHTUNG: Logfile konnte nicht beschrieben werden!");
		}
	}
}
