package model;

import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;

public class Mail {

	private static Mail instance;
	public static Mail getInstance() {
		if (instance == null) {
			instance = new Mail();
		}
		return instance;
	}
	
	public void sendMail(String mailAdress, int code) {
		// Nicht in der Schule testen da Port 25 gebloggt ist!!!!
		
		String to = mailAdress;
		String from = "tvhamster4@hotmail.de";
		String host = "localhost";
		Properties propeties = System.getProperties();
		propeties.setProperty("mail.smtp.host", host);
		Session session = Session.getDefaultInstance(propeties);
		
		try{
			MimeMessage message = new MimeMessage(session);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Wilkommen bei Friends-Hug");
			message.setText("Bitte geben sie diesen Code beim ersten Anmelden an:");
			message.setText(Integer.toString(code));
			Transport.send(message);
			System.out.println("Nachricht wurde gesendet");
		}catch(MessagingException mex){
			mex.printStackTrace();
		}

	}
	public static void main(String[] args) {
		Mail.getInstance().sendMail("tvhamster4@hotmail.de", 1111);
	}

}
