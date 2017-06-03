package testes;

import modelo.dao.UsuarioDAO2;
import modelo.dominio.Usuario;

public class TesteUnitUsuario {

	
	public static void main(String[] args) {

		Usuario usuario = new Usuario();
				
		usuario.setLogin("mlluiz21");
		usuario.setSenha("112233");
	
		UsuarioDAO2 usuDAO = new UsuarioDAO2();
		
		usuDAO.salvar(usuario);
	
				
		System.out.println("Usuário com login " + usuario.getLogin() + " cadastrado(a) com sucesso!");
		
			
		
	}
}