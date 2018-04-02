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

@ManagedBean(name = "loginMBController2")
@SessionScoped
public class LoginMB2 implements Serializable {

	private static final long serialVersionUID = 1L;
	private boolean autenticado = false;
	private UsuarioDAO usuDAO = new UsuarioDAO();
	private String login;
	private String senha;
	private Usuario usu = new Usuario();
	private String tipoUsu;
	private String link = "";
	private Pessoa pessoa;


	
	public UsuarioDAO getUsuDAO() {
		return usuDAO;
	}

	public void setUsuDAO(UsuarioDAO usuDAO) {
		this.usuDAO = usuDAO;
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

	public Usuario getUsu() {
		return usu;
	}

	public void setUsu(Usuario usu) {
		this.usu = usu;
	}

	public String getTipoUsu() {
		return tipoUsu;
	}

	public void setTipoUsu(String tipoUsu) {
		this.tipoUsu = tipoUsu;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public void setAutenticado(boolean autenticado) {
		this.autenticado = autenticado;
	}

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
		RequestContext.getCurrentInstance().openDialog("criarLoginDialog", criarLogin, null);

	}

	
	//VERIFICAR NOVO PERFIL DE USUÁRIO NO SISTEMA ********************************************************************* //	
	public String verificarTipoUsu() {
		
		String t = "";
		switch (tipoUsu) {

		case "ATLETA":
			t = "/pages/editarAtletaDialog.jsf?faces-redirect=true";
			break;

		case "ARBITRO":
			t = "/pages/editarArbitroDialog.jsf?faces-redirect=true";
			break;

		case "ORGANIZADOR":
			t = "/pages/editarOrganizadorOuInstituicaoDialog.jsf?faces-redirect=true";
			break;

		case "RESPONSAVEL_EQUIPE":
			t = "/pages/editarResponsavelPorEquipeDialog.jsf?faces-redirect=true";
			break;
		}
		return link = t; 
	}

	
	//CRIAR NOVO PERFIL DE USUÁRIO NO SISTEMA ************************************************************************* //	
	public String salvarCriarLogin() {

		tipoUsu = this.usu.getTipoDeUsuario().getDescricao();
		
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


	public String telaRecuperarSenha() {

		return "/pages/recuperarSenha.jsf";
	}

	
	public String cancelarRecuperarSenha() {

		this.setLogin(null);
		this.setSenha(null);
		return "/pages/login.jsf";
	}

	
	//RECUPARAR E ENVIAR SENHA POR EMAIL
	public void enviarSenhaPorEmail(String de, String titulo, String msg, String para){
		
	}
	
	public String fazerCadastro() {

		return "/pages/fazerCadastro.jsf";
	}

	
	public String autenticarUsuario() {

		boolean autenticadoOk = false;

		// LER USUÃƒï¿½RIO CADASTRADO NO POSTGRES
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

	
	public void enviarEmail(){
		
		@SuppressWarnings("unused")
		String dispararEmail = "";
		
		Usuario loginBanco = usuDAO.lerPorLogin(this.login);
		FacesContext contexto = FacesContext.getCurrentInstance();

		if (loginBanco == null) {
			contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "O usuario nao existe.", null));
		}
		else {
			dispararEmail = this.pessoa.getEmail();
		}
	}

	
	public Boolean isAutenticado() {
		return this.autenticado;
	}

	
	public String logOut() {

		this.usu = new Usuario();
		this.setLogin(null);
		this.setSenha(null);

		// ENCERRAR A SESSÃƒO ATUAL
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		session.invalidate();
		return "/pages/home.jsf?faces-redirect=true";
	}
}