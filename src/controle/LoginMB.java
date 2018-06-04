package controle;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;

import controle.util.EmailJava;
import enuns.TipoDeUsuario;
import modelo.dao.PessoaDAO;
import modelo.dao.UsuarioDAO;
import modelo.dominio.Pessoa;
import modelo.dominio.Usuario;

@ManagedBean(name = "loginMBController")
@SessionScoped
public class LoginMB implements Serializable {

	private static final long serialVersionUID = 1L;
	private boolean autenticado = false;
	private PessoaDAO pesDAO = new PessoaDAO();
	private UsuarioDAO usuDAO = new UsuarioDAO();
	private String login;
	private String senha;
	private Usuario usu = new Usuario();
	private String tipoUsu;
	private String link = "";
	private Pessoa pessoa;
	private List<Pessoa> pessoas = null;
	public static String recuperarSenha;

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

	public List<Pessoa> getPessoas() {
		if (this.pessoas == null) {
			this.pessoas = this.pesDAO.lerTodos();
		}
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
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
		/* criarLogin.put("centralizar na Tela", arg1) */

		// Ã‰ uma API do Primefaces para chamar um arquivo como janela de
		// diÃ¡logo
		RequestContext.getCurrentInstance().openDialog("criarLoginDialog", criarLogin, null);
	}

	/*
	 * public String salvarPessoa() {
	 * 
	 * tipoUsu = usu.getTipoDeUsuario().toString();
	 * 
	 * try {
	 * 
	 * // DEVE LIMPAR O ID COM VALOR ZERO, POIS O JSF SEMPRE CONVERTE O CAMPO //
	 * VAZIO PARA UM LONG = 0. if ((this.getPessoa().getId() != null) &&
	 * (this.getPessoa().getId().longValue() == 0))
	 * this.getPessoa().setId(null);
	 * 
	 * this.usu.setPessoa(this.pessoa); this.pessoa =
	 * this.pesDAO.salvar(this.pessoa);
	 * 
	 * if ((this.getUsu().getId() != null) && (this.getUsu().getId().longValue()
	 * == 0)) this.getUsu().setId(null);
	 * 
	 * this.usu = this.usuDAO.salvar(this.usu);
	 * 
	 * this.pessoas = null; // LIMPA A LISTA this.setPessoa(new Pessoa()); //
	 * LIMPAR O OBJETO DA P�GINA this.setUsu(new Usuario());
	 * 
	 * } catch (Exception e) { // SE GERAR ALGUM TIPO DE ERRO, MOSTRAR ABAIXO
	 * 
	 * System.out.println(e.getMessage());
	 * 
	 * } // EXECUTA A A��O LISTAR E RETORNA A SUA P�GINA return
	 * verificarTipoUsu(); }
	 */

	// VERIFICAR NOVO PERFIL DE USUÁRIO NO SISTEMA
	// ********************************************************************* //
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

	// CRIAR NOVO PERFIL DE USUÁRIO NO SISTEMA
	// *************************************************************************
	// //
	public String salvarCriarLogin() {

		tipoUsu = usu.getTipoDeUsuario().toString();

		try {

			// DEVE LIMPAR O ID COM VALOR ZERO, POIS O JSF SEMPRE CONVERTE O
			// CAMPO
			// VAZIO PARA UM LONG = 0.
			if ((this.getPessoa().getId() != null) && (this.getPessoa().getId().longValue() == 0))
				this.getPessoa().setId(null);

			// this.pessoa = this.pesDAO.salvar(this.pessoa);

			if ((this.getUsu().getId() != null) && (this.getUsu().getId().longValue() == 0))
				this.getUsu().setId(null);
			this.usu.setPessoa(this.pessoa);

			this.usu = this.usuDAO.salvar(this.usu);

			this.pessoas = null; // LIMPA A LISTA
			this.setPessoa(new Pessoa()); // LIMPAR O OBJETO DA P�GINA
			this.setUsu(new Usuario());

			FacesMessage msg2 = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro do Login realizado com sucesso!",
					null);
			FacesContext.getCurrentInstance().addMessage(null, msg2);

		} catch (Exception e) {

			System.out.println(e);
		}

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
	

	// ################# MÉTODO PRA DISPARAR EMAIL DE RECUPERAÇÃO DE SENHA #################
	public void enviarEmail() {

		try {

			String dispararEmail = "";					

			Usuario loginBanco = usuDAO.lerPorLogin(this.login);
			FacesContext contexto = FacesContext.getCurrentInstance();

			if (loginBanco == null) {
				contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "O usuario nao existe.", null));
			} else {
				dispararEmail = this.pessoa.getEmail();
				EmailJava.emailDestinatario = dispararEmail;
				recuperarSenha = this.usu.getSenha();
				
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	// #############################################################

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
