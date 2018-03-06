package modelo.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.dominio.Pessoa;
import controle.util.JpaDAO;

public class PessoaDAO extends JpaDAO<Pessoa>{
	
	public PessoaDAO()
	{
		super();
	}

	public PessoaDAO(EntityManager manager)
	{
		super(manager);
	}
	
	public Pessoa lerPorId(Long id){
		
		Pessoa resultadoBusca;
		
		Query consulta = this.getEntityManager().createQuery("from tblpessoa p where p.id = :id");
		consulta.setParameter("id", id);
		
		try
		{
			resultadoBusca = (Pessoa) consulta.getSingleResult();
		}
		
		catch (NoResultException e)
		{
//			POR UMA MENSAGEM AQUI, NENHUM CLIENTE ENCONTRADO COM ESSE CÓDIGO.
			resultadoBusca = null;
		}
		
		return resultadoBusca;
	}
	
	public Pessoa lerPorCpf(int cpf){
		
		Pessoa resultadoBusca;
		
		Query consulta = this.getEntityManager().createQuery("from tblPessoa p where p.cpf = :cpf");
		consulta.setParameter("cpf", cpf);
		
		try
		{
			resultadoBusca = (Pessoa) consulta.getSingleResult();
		}
		
		catch (NoResultException e)
		{
//			POR UMA MENSAGEM AQUI, NENHUM CLIENTE ENCONTRADO COM ESSE CÓDIGO.
			resultadoBusca = null;
		}
		
		return resultadoBusca;
	}
	
	public Pessoa lerPorNomeCompleto(String nomeCompleto){
		
		Pessoa resultadoBusca;
		
		Query consulta = this.getEntityManager().createQuery("from tblPessoa p where p.nomecompleto = :nomeCompleto");
		consulta.setParameter("nomeCompleto", nomeCompleto);
		
		try
		{
			resultadoBusca = (Pessoa) consulta.getSingleResult();
		}
		
		catch (NoResultException e)
		{
//			POR UMA MENSAGEM AQUI, NENHUM CLIENTE ENCONTRADO COM ESSE CÓDIGO.
			resultadoBusca = null;
		}
		
		return resultadoBusca;
	}

}