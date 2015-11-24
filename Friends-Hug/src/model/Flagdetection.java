package model;

public class Flagdetection {

	private String flag;
	private String text;
	private static Flagdetection instance = new Flagdetection();
		
	public String getFlag() {
		return flag;
	}
	private void setFlag(String flag) {
		this.flag = flag;
	}
	public String getText() {
		return text;
	}
	private void setText(String text) {
		this.text = text;
	}
	public static Flagdetection getInstance(){
		return instance;
	}

	
	//slit a input stream to read the flag
	public void returnFlagText(String input){
		String [] flagTextSplitted = input.split(";");
		setFlag(flagTextSplitted[0]);
		setText(flagTextSplitted[1]);
		for(int i = 2;i<flagTextSplitted.length;i++){
			setText(getText() + flagTextSplitted[i]);
		}
	}
}