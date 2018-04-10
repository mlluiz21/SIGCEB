package controle.util;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

public class EmailJava {
	
	public EmailJava(){
		
	}
	
	public void enviarEmail(){
	
		try {
			
	Email email = new SimpleEmail();
	email.setHostName("smtp.googlemail.com");
	email.setSmtpPort(465);
	email.setAuthenticator(new DefaultAuthenticator("username", "password"));
	email.setSSLOnConnect(true);
	email.setFrom("user@gmail.com");
	email.setSubject("TestMail");
	email.setMsg("This is a test mail ... :-)");
	email.addTo("foo@bar.com");
	email.send();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
