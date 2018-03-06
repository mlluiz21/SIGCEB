package testes;

import modelo.dao.UsuarioDAO;
import modelo.dominio.Usuario;

public class TesteUnitUsuario {

		
	public static void main(String[] args) {

		Usuario usuario = new Usuario();
				
		usuario.setLogin("mlluiz21");
		usuario.setSenha("112233");
		usuario.setTipoDeUsuario(null);
	
		UsuarioDAO usuDAO = new UsuarioDAO();
		
		usuDAO.salvar(usuario);
	
				
		System.out.println("Usu�rio com login " + usuario.getLogin() + " cadastrado(a) com sucesso!");	
			
		
	}
}