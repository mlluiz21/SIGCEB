package controle;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;

import enuns.TipoDeUsuario;
import modelo.dao.UsuarioDAO;
import modelo.dominio.Pessoa;
import modelo.dominio.Usuario;

@ManagedBean(name = "loginMBController")
@SessionScoped
public class LoginMB implements Serializable {

	private static final long serialVersionUID = 1L;
	private boolean autenticado = false;
	private UsuarioDAO usuDAO = new UsuarioDAO();
	private String login;
	private String senha;
	private Usuario usu = new Usuario();
	private String tipoUsu;
	private String link = "";
	private Pessoa pessoa;

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

	/*
	 * public String getTipoUsuario() { return tipoUsuario; }
	 * 
	 * public void setTipoUsuario(String tipoUsuario) { this.tipoUsuario =
	 * tipoUsuario; }
	 */

	public TipoDeUsuario[] getTipoDeUsuario() {
		return TipoDeUsuario.values();
	}

	public void abrirDialogCriarLogin() {

		// Criando mapa de parametros string
		Map<String, Object> criarLogin = new HashMap<>();

		criarLogin.put("modal", true);
		criarLogin.put("resizable", false);
		criarLogin.put("contentHeight", 260);
		criarLogin.put("contentWidth", 550);
		criarLogin.put("closable", false);
		/* criarLogin.put("centralizar na Tela", arg1) */

		// É uma API do Primefaces para chamar um arquivo como janela de
		// diálogo
		RequestContext.getCurrentInstance().openDialog("criarLoginDialog", criarLogin, null);

	}

	public String verificarTipoUsu(String t) {

		t = this.usu.getTipoDeUsuario().getDescricao();

		switch (tipoUsu) {

		case "ATLETA":
			link = "/pages/editarAtletaDialog.jsf?faces-redirect=true";
			break;

		case "ARBITRO":
			link = "/pages/editarArbitroDialog.jsf?faces-redirect=true";
			break;

		case "ORGANIZADOR":
			link = "/pages/editarOrganizadorOuInstituicaoDialog.jsf?faces-redirect=true";
			break;

		case "RESPONSAVEL_EQUIPE":
			link = "/pages/editarResponsavelPorEquipeDialog.jsf?faces-redirect=true";
			break;
		}

		/* tipoUsu.equals(getUsu().getTipoDeUsuario().getDescricao()); */
	}

	public String salvarCriarLogin() {

		if ((this.getUsu().getId() != null) && (this.getUsu().getId().longValue() == 0))
			this.getUsu().setId(null);
		if ((this.getPessoa().getId() != null) && (this.getPessoa().getId().longValue() == 0))
			this.getPessoa().setId(null);
		usu.setPessoa(getPessoa());
		this.usuDAO.salvar(this.usu);

		this.setPessoa(new Pessoa());
		this.setUsu(new Usuario());
		// Usuario objetoDoBancoTipoUsuario =
		// this.usuDAO.lerPorId(getTipoDeUsuario());

		FacesMessage msg2 = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro do Login realizado com sucesso!",
				null);
		FacesContext.getCurrentInstance().addMessage(null, msg2);

		return verificarTipoUsu();

	}

	public String salvarCriarLogin2() {

		tipoUsu = this.usu.getTipoDeUsuario().getDescricao();

		if ((this.getUsu().getId() != null) && (this.getUsu().getId().longValue() == 0))
			this.getUsu().setId(null);
		usu.setPessoa(getPessoa());
		this.usuDAO.salvar(this.usu);
		// Usuario objetoDoBancoTipoUsuario =
		// this.usuDAO.lerPorId(getTipoDeUsuario());

		FacesMessage msg2 = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro do Login realizado com sucesso!",
				null);
		FacesContext.getCurrentInstance().addMessage(null, msg2);

		tipoUsu = (this.usu.getTipoDeUsuario().getDescricao());

		if (this.tipoUsu.equals("Atleta")) {
			return "/pages/editarAtletaDialog.jsf?faces-redirect=true";
		}

		else if (this.tipoUsu.equals("Árbitro")) {
			return "/pages/editarArbitroDialog.jsf?faces-redirect=true";
		}

		else if (this.tipoUsu.equals("Organizador ou Instituição")) {
			return "/pages/editarOrganizadorOuInstituicaoDialog.jsf?faces-redirect=true";
		}

		else if (this.tipoUsu.equals("Responsável por Equipe")) {
			return "/pages/editarResponsavelPorEquipeDialog.jsf?faces-redirect=true";
		}

		else {
			FacesMessage msg3 = new FacesMessage(FacesMessage.SEVERITY_INFO, "Deve-se escolher um Tipo de Usuário!",
					null);
			FacesContext.getCurrentInstance().addMessage(null, msg3);
		}

		this.setUsu(new Usuario());
		// return "/pages/indexSistema.jsf?faces-redirect=true";
		return "/pages/editarResponsavelPorEquipeDialog.jsf?faces-redirect=true";

	}

	public String telaRecuperarSenha() {

		return "/pages/recuperarSenha.jsf";
	}

	public String cancelarRecuperarSenha() {

		this.setLogin(null);
		this.setSenha(null);

		return "/pages/login.jsf";
	}

	public String fazerCadastro() {

		return "/pages/fazerCadastro.jsf";
	}
	/*
	 * public String acaoSalvar() { // Deve limpar o ID com valor zero, pois o
	 * JSF sempre converte o campo vazio para um LONG = 0.
	 * 
	 * if ((this.getUsu().getId() != null) && (this.getUsu().getId().longValue()
	 * == 0)) this.getUsu().setId(null);
	 * 
	 * // Se o usuÃ¡rio nÃ£o tiver ID, deve testar se existe o mesmo no banco
	 * 
	 * if (this.getUsu().getId() == null) { Usuario objetoDoBanco =
	 * this.usuDAO.lerPorLogin(this.getUsu().getLogin());
	 * 
	 * if (objetoDoBanco != null) { JSFUtil.
	 * retornarMensagemErro("Outro usuÃ¡rio com o mesmo login jÃ¡ existe no sistema."
	 * , null, null); return null; // volta p/mesma pÃ¡gina } }
	 * 
	 * this.usuDAO.salvar(this.getUsu()); // limpa a lista this.usu = null;
	 * 
	 * // limpar o objeto da pÃ¡gina this.setUsu(new Usuario());
	 * 
	 * return "usuarioListar"; }
	 */

	public String autenticarUsuario() {

		boolean autenticadoOk = false;

		// LER USUÃ�RIO CADASTRADO NO POSTGRES
		Usuario loginBanco = usuDAO.lerPorLogin(this.login);
		FacesContext contexto = FacesContext.getCurrentInstance();

		if (loginBanco == null) {
			contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "O usuario nao existe.", null));
		}

		else {
			if (loginBanco.senhaCorreta(this.senha)) {
				autenticado = autenticadoOk = true;
				this.usu = loginBanco;
			} else {
				contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "A senha é inválida.", null));
			}
		}
		if (autenticadoOk)
			return "/pages/indexSistema.jsf?faces-redirect=true";
		else
			return "/pages/login.jsf?faces-redirect=true";
	}

	public Boolean isAutenticado() {
		return this.autenticado;
	}

	public String logOut() {

		this.usu = new Usuario();
		this.setLogin(null);
		this.setSenha(null);

		// ENCERRAR A SESSÃO ATUAL
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		session.invalidate();

		return "/pages/home.jsf?faces-redirect=true";
	}

	public String getTipoUsu() {
		return tipoUsu;
	}

	public void setTipoUsu(String tipoUsu) {
		this.tipoUsu = tipoUsu;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
