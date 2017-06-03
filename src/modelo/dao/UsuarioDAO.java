package modelo.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.dominio.Usuario;
import controle.util.JpaDAO;

public class UsuarioDAO extends JpaDAO<Usuario> {

	public UsuarioDAO() {
		super();
	}

	public UsuarioDAO(EntityManager manager) {
		super(manager);
	}

	/*
	  public Usuario lerPorLogin(String login, String senha){ Usuario
	  resultado;
	  
	  Query consulta = this.getEntityManager().
	  createQuery("from tblUsuario u where u.login = :login and u.senha = :senha");
	  
	 */

	public Usuario lerPorLogin(String login) {
		Usuario resultado;

		//("from tblUsuario u where u.login = :login")
		Query consulta = this.getEntityManager().createQuery("from tblusuario u where u.login = :login");
		consulta.setParameter("login", login);

		try {
			resultado = (Usuario) consulta.getSingleResult();
		} catch (NoResultException e) {
			resultado = null;
		}
		System.out.println(resultado.toString());
		return resultado;
	}

}
