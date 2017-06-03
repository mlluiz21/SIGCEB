package modelo.dao;


import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import controle.util.JpaDAO;
import modelo.dominio.Usuario;

public class UsuarioDAO2 extends JpaDAO<Usuario>{
	
		public UsuarioDAO2()
		{
			super();
		}

		public UsuarioDAO2(EntityManager manager)
		{
			super(manager);
		}
		
		public Usuario lerPorLogin(String login){
			
			Usuario resultado;
			Query consulta = this.getEntityManager().createQuery("select login,senha from tblusuario where login=?");
			consulta.setParameter("login", login);

			try
			{
				resultado = (Usuario) consulta.getSingleResult();
			}
			
			catch (NoResultException e)
			{
				resultado = null;
			}
			
			System.out.println(resultado.toString());
			return resultado;
		}
		
	
		/*public boolean lerPorLogin(String login, String senha) throws SQLException{
			
			EntityManager conex = this.getEntityManager();
			Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost/ProjetoBancoSIGCEB","postgres","123456");
			boolean aut = false;
			String verificar = "select login,senha from tblUsuario where login=? and senha=?";
			
			try{
				PreparedStatement stm = conexao.prepareStatement(verificar);
				stm.setString(1, login);
				stm.setString(2, senha);
				ResultSet rs;
				rs = stm.executeQuery();
				if(rs.next()){
					String loginbanco = rs.getString("login");
					String senhabanco = rs.getString("senha");
					aut = true;
					return aut;
				}
		
				rs.close();
				
			}
			catch(SQLException erro ){
				System.out.println("Erro ao recuperar login e senha" + erro.getMessage());
				
			}
			return aut;					
		}

		
		public Usuario lerPorLogin(String login){

			Usuario resultado;
			Query consulta = this.getEntityManager().createQuery("from tblUsuario u where u.login = :login");
			consulta.setParameter("login", login);

			try
			{
				resultado = (Usuario) consulta.getSingleResult();
			}
			catch (NoResultException e)
			{
				resultado = null;
			}
			System.out.println(resultado.toString());
			return resultado;
		}
		*/

}
