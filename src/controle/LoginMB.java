package controle;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import controle.util.JSFUtil;
import modelo.dao.UsuarioDAO2;
import modelo.dominio.Pessoa;
import modelo.dominio.Usuario;

@ManagedBean (name = "loginMBController")
@SessionScoped
public class LoginMB implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private boolean autenticado = false;
	private Usuario usu = new Usuario();	
	private String login;
	private String senha;
	private Pessoa pessoa = new Pessoa();
	
	public Usuario getUsu() {
		return usu;
	}

	public void setUsu(Usuario usu) {
		this.usu = usu;
	}

	public boolean isAutenticado() {
		return autenticado;
	}
	
	public void setAutenticado(boolean autenticado) {
		this.autenticado = autenticado;
	}		
		
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String autenticarUsuario() {

		UsuarioDAO2 usuDAO = new UsuarioDAO2();		
		Usuario loginBanco = usuDAO.lerPorId(this.getLogin());
		
		if (loginBanco == null){
			
			JSFUtil.retornarMensagemErro("Usuário não existe.", null, null);
			return "login";
		
		}
		else 
			if (loginBanco.senhaCorreta(this.getSenha())){
			
				this.setUsu(loginBanco);
				this.autenticado = true;
				
				return "index";
			}
		else {
			
			JSFUtil.retornarMensagemErro("Senha inv�lida.", null, null);
			return "login";
		}
		
	}
	
	public String abrirLoginUsuario()
	{
		return "login";
	}
	
	public String logOut() {

		this.usu = new Usuario();
		this.autenticado = false;
		this.setLogin(null);
		this.setSenha(null);

		// encerrar a sess�o atual
		JSFUtil.getHttpSession().invalidate();

		return "login";
	}
	
	/*public String salvarNovoUsuario(){
	 
	  UsuarioDAO usuDAO = new UsuarioDAO();
		// Deve limpar o ID com valor zero, pois o JSF sempre converte o campo vazio para um LONG = 0.
		 
		if ((this.getUsu().getId() != null) && (this.getUsu().getId().longValue() == 0))
			this.getUsu().setId(null);

		// Se o usuÃ¡rio nÃ£o tiver ID, deve testar se existe o mesmo no banco
		 
		if (this.getUsu().getId() == null)
		{
			Usuario usuDoBanco = this.usuDAO.lerPorLogin(this.getUsu().getLogin());

			if (usuDoBanco != null)
			{
				JSFUtil.retornarMensagemErro("Outro usuÃ¡rio com o mesmo login jÃ¡ existe no sistema.", null, null);
				return null; // volta p/mesma pÃ¡gina
			}
		}

		this.usuDAO.salvar(this.getUsu());
		// limpa a lista
		this.usu = null;

		// limpar o objeto da pÃ¡gina
		this.setUsu(new Usuario());

		return "indexSistema.jsf";
	}*/
	
	public String teste(){
		
		return "index";
	}
	
}
