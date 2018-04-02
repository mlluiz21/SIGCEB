package controle.util;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

public class EmailJava {
	
	public EmailJava(){
		
	}
	
	public void enviarEmail(){
	
		try {
			
	Email email = new SimpleEmail();
	email.setHostName("smtp.googlemail.com");
	email.setSSL(true);
	email.setSmtpPort(587);
	email.setDebug(true);
	//email.setAuthenticator(new DefaultAuthenticator("username", "password"));
	email.setAuthentication("sigcebs@gmail.com", "mp3m2134$");
	email.setSSLOnConnect(true);
	email.setFrom("sigcebs@gmail.com");
	email.setSubject("Senha da SIGCEBs recuperada com sucesso");
	email.setMsg("Recuperar senha do sistema :-)");
	email.addTo("mlluiz21@gmail.com");
	email.send();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
