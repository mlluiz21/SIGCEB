package testes;

import modelo.dao.PessoaDAO;
import modelo.dao.UsuarioDAO;
import modelo.dominio.Pessoa;
import modelo.dominio.Usuario;

public class TesteUnitPessoa {

	
	public static void main(String[] args) {

	
		Pessoa p = new Pessoa();
		
		p.setNomeCompleto("Marcelo Luiz");
		p.setCpf("1111522226");
		p.setRg("222256111");
		
		p.setNomeDaMae("Elze");
		p.setNomeDoPai("Jo");
			
		p.setEmail("mlluiz3@gmail.com");
		p.setTelefone("2133332222");
		
		PessoaDAO pdao = new PessoaDAO();
		pdao.salvar(p);
				
		System.out.println("Pessoa " + p.getNomeCompleto() + " cadastrado(a) com sucesso!");
		
		
		
		Usuario usuario = new Usuario();
		
		usuario.setLogin("mlluiz3");
		usuario.setSenha("112233");
		usuario.setTipoDeUsuario(null);
	
		UsuarioDAO usuDAO = new UsuarioDAO();
		
		usuDAO.salvar(usuario);
	
				
		System.out.println("Usu�rio com login " + usuario.getLogin() + " cadastrado(a) com sucesso!");	
	
		
			
		
	}
}