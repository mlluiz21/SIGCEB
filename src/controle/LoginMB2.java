package controle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import modelo.dao.UsuarioDAO;
import modelo.dominio.Pessoa;
import modelo.dominio.Usuario;

@ManagedBean(name = "loginMBController2")
@SessionScoped
public class LoginMB2 {

	private Usuario usu = new Usuario();
	private UsuarioDAO usuDAO = new UsuarioDAO();
	private String login;
	private String senha;
	private Pessoa pessoa = new Pessoa();

	
	public Usuario getUsu() {
		return usu;
	}

	public void setUsu(Usuario usu) {
		this.usu = usu;
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
	
	public String telaRecuperarSenha(){
		
		return "/pages/login/recuperarSenha.jsf";
	}
	
	public String cancelarRecuperarSenha(){
		
		this.setLogin(null);
		this.setSenha(null);
		
		return "/pages/indexSistema.jsf";
	}

	public String telaIndexSistema(){
		
		return "/pages/indexSistema.jsf";
	}
	/*public String acaoSalvar()
	{
		// Deve limpar o ID com valor zero, pois o JSF sempre converte o campo vazio para um LONG = 0.
		 
		if ((this.getUsu().getId() != null) && (this.getUsu().getId().longValue() == 0))
			this.getUsu().setId(null);

		// Se o usuÃ¡rio nÃ£o tiver ID, deve testar se existe o mesmo no banco
		 
		if (this.getUsu().getId() == null)
		{
			Usuario objetoDoBanco = this.usuDAO.lerPorLogin(this.getUsu().getLogin());

			if (objetoDoBanco != null)
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

		return "usuarioListar";
	}*/
	
	public String autenticarUsuario() {
	
		boolean autenticado = false;
				
		//LER USUÃ�RIO CADASTRADO NO POSTGRES
		Usuario loginBanco = usuDAO.lerPorLogin(this.getLogin());	
		FacesContext contexto = FacesContext.getCurrentInstance();
		
		if (loginBanco == null){			
			contexto.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "O usuÃ¡rio nÃ£o existe.", null));		
		}
		
		else{ 
				if (loginBanco.senhaCorreta(this.getSenha())) {
					autenticado = true;
					this.setUsu(loginBanco);
				}
			else {
					contexto.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "A senha Ã© invÃ¡lida.",
						null));
				}
			}
			if (autenticado)
					return "/pages/indexSistema.jsf?faces-redirect=true";
				else
					return "/pages/login2.jsf?faces-redirect=true";
		}


	public String logOut() {

		this.usu = new Usuario();
		this.setLogin(null);
		this.setSenha(null);

		// ENCERRAR A SESSÃƒO ATUAL
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		session.invalidate();

		return "login.jsf?faces-redirect=true";
	}

}
