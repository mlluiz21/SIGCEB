package testes;

import modelo.dao.PessoaDAO;
import modelo.dominio.Pessoa;

public class TesteUnitPessoa {

	
	public static void main(String[] args) {

	
		Pessoa p = new Pessoa();
		
		p.setNomeCompleto("Marcelo Luiz");
		p.setCpf(1111522226);
		p.setRg(222256111);
		
		p.setNomeDaMae("Elze");
		p.setNomeDoPai("Jo");
			
		p.setEmail("mlluiz21@gmail.com");
		p.setTelefone(2133332222);
		
		PessoaDAO pdao = new PessoaDAO();
		pdao.salvar(p);
				
		System.out.println("Pessoa " + p.getNomeCompleto() + " cadastrado(a) com sucesso!");
		
			
		
	}
}