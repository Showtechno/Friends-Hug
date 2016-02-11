package model;

import java.util.concurrent.ThreadLocalRandom;

public class Codegenerator {
	
	private int code;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void generate(){
		String number1 = Integer.toString(ThreadLocalRandom.current().nextInt(0,10));
		String number2 = Integer.toString(ThreadLocalRandom.current().nextInt(0,10));
		String number3 = Integer.toString(ThreadLocalRandom.current().nextInt(0,10));
		String number4 = Integer.toString(ThreadLocalRandom.current().nextInt(0,10));
		setCode(Integer.valueOf(number1+number2+number3+number4));
	}
}
