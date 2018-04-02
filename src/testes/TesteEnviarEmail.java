package testes;

import controle.util.EmailJava;

public class TesteEnviarEmail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			EmailJava email = new EmailJava();
			email.enviarEmail();
			System.out.println("Mensagem enviada com sucesso");
			
		} catch (Exception e) {
			
			System.out.println(e);
		}

	}

}
