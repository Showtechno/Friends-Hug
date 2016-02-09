package model;

import java.util.*;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.*;

public class Mail {

	public static void main(String[] args) {
		String to = "melina.wolle@gmail.com";
		String from = "melwo97@web.de";
		String host = "localhost";
		Properties propeties = System.getProperties();
		propeties.setProperty("mail.smtp.host", host);
		Session session = Session.getDefaultInstance(propeties);
		
		try{
			MimeMessage message = new MimeMessage(session);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Wilkommen bei Friends-Hug");
			message.setText("Bitte geben sie diesen Code beim ersten Anmelden an");
			Transport.send(message);
			System.out.println("Nachricht wurde gesendet");
		}catch(MessagingException mex){
			mex.printStackTrace();
		}

	}

}
