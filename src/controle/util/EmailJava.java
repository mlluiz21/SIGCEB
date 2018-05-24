package controle.util;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

public class EmailJava {
	
	public static String emailDestinatario;
	
	public EmailJava(){
		
	}
	
	public void enviarEmail(){
	
		try {
			
	Email email = new SimpleEmail();
	email.setHostName("smtp.gmail.com");
	email.setSmtpPort(465);
	email.setAuthenticator(new DefaultAuthenticator("username", "password"));
	email.setSSLOnConnect(true);
	email.setFrom("user@gmail.com");
	email.setSubject("Título do Email");
	email.setMsg("This is a test mail ... :-)");
	email.addTo(EmailJava.emailDestinatario);
	email.send();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
