package client;

public class Flagdetection {

	private String flag;
	private String text;

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

	// Slittet den input String in Flag und folgenen Text auf
	public void returnFlagText(String input) {
		String[] flagTextSplitted = input.split(";");
		setFlag(flagTextSplitted[0]);
		setText(flagTextSplitted[1]);
		if (1 < flagTextSplitted.length) {
			for (int i = 2; i < flagTextSplitted.length; i++) {
				setText(getText() + flagTextSplitted[i]);
			}
		}
	}
}
