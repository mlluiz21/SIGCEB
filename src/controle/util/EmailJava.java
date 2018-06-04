package controle.util;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

import controle.LoginMB;

public class EmailJava {

	public static String emailDestinatario;
	
	public EmailJava() {

	}

	public void enviarEmail() {

		try {

			Email email = new SimpleEmail();
			email.setHostName("smtp.gmail.com");
			email.setSmtpPort(587); //465
			email.setAuthenticator(new DefaultAuthenticator("sigceb@gmail.com", "sigceb21"));
			email.setSSLOnConnect(true);
			email.setFrom("sigceb@gmail.com");
			email.setSubject("SiGCEB - Recuperar senha");
			//email.setMsg("This is a test mail ... :-)");
			email.setMsg("Sua senha de acesso é: " + LoginMB.recuperarSenha);
			email.addTo(EmailJava.emailDestinatario);
			email.send();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
