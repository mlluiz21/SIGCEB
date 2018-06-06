package testes;

import modelo.dao.UsuarioDAO;
import modelo.dominio.Pessoa;
import modelo.dominio.Usuario;

public class TesteUnitUsuario {

	public static void main(String[] args) {

		Pessoa p = new Pessoa();
		p.setNomeCompleto("Marcelo Luiz");
		p.setCpf("11122233345");
		p.setRg("111111112");
		p.setDataDeNascimento(null);
		// p.setUsuario(usuario);

		Usuario usuario = new Usuario();

		usuario.setLogin("mlluiz2");
		usuario.setSenha("112233");
		usuario.setTipoDeUsuario(null);
		usuario.setPessoa(p);

		UsuarioDAO usuDAO = new UsuarioDAO();

		usuDAO.salvar(usuario);

		System.out.println("Usuário com login " + usuario.getLogin() + " da pessoa " + p.getNomeCompleto()
				+ " cadastrado(a) com sucesso!");

	}
}