package controle.util;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

public class EmailJava2 {
	
	Email email;	
	
	public EmailJava2(){
		
		email = new SimpleEmail();
		configure();
		
	}
	
	//Configuração do email
	public void configure(){

		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setDebug(true);
		email.setAuthentication("sigcebs@gmail.com", "mp3m2134$");
		email.setSSLOnConnect(true);

	}
	
	public void enviarEmail(String de, String titulo, String msg, String para ){
	
		try {
			
	email.setFrom(de);
	email.setSubject(titulo);
	email.setMsg(msg);
	email.addTo(para);
	email.send();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
