package Model;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class sendMail {
	
	public void  sendValidateMail(String subject, String  body, String to)
	//public static void main(String args[])
	{
//		String subject="test";
//		String  body="test";
//		String from="advaita.iiit@gmail.com";
//		String to="kanha.prayas@gmail.com";
		final String senderEmail="advaita.iiit@gmail.com";
		final String senderPassword="dondictatorandbitch";
		String receiverEmail="";
		receiverEmail = to;
		Properties props=new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.stmp.port", "587");
		Session session = Session.getInstance(props,
				  new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(senderEmail, senderPassword);
					}
				  });
		try {
			 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(senderEmail));
			
				message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(receiverEmail));
			
			
			
			//message.setSubject("Thank you for doing registration in ADVAITA`14");
			message.setSubject(subject);
			message.setText(body);
			//message.setText("Click on the below link to validate your email Id with your Advaita Account http://advaita.iiit-bh.ac.in/validateEmail?aswert="+uuid);
 
			Transport.send(message);
 
			System.out.println("\nDone email");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
		
	}

