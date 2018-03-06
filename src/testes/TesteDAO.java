package testes;

import enuns.GrauDeEscolaridade;
import enuns.Sexo;
import enuns.TipoSanguineo;
import modelo.dao.PessoaDAO;
import modelo.dominio.Pessoa;

public class TesteDAO {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		Pessoa p = new Pessoa();

		p.setNomeCompleto("Marcelo Luiz");
		p.setCpf("1111522226");
		p.setRg("222256111");
		Sexo M;
		p.setNomeDaMae("Elze");
		p.setNomeDoPai("Jo");
		TipoSanguineo sanguineo;
		GrauDeEscolaridade ESC;
		p.setEmail("mlluiz21@gmail.com");
		p.setTelefone("2133332222");

		PessoaDAO pdao = new PessoaDAO();
		pdao.salvar(p);

		System.out.println("Pessoa " + p.getNomeCompleto() + " cadastrado(a) com sucesso!");

		/*
		 * Pessoa p1 = new Pessoa();
		 * 
		 * p1.setNomeCompleto("Ana Paula"); p1.setCpf(717273737);
		 * p1.setTelefone(77773333);
		 * 
		 * PessoaDAO dao = new PessoaDAO(); dao.salvar(p1);
		 * 
		 * System.out.println("Pessoa " + p1.getNomeCompleto() +
		 * " Cadastrado com sucesso");
		 */

	}
}