package controle;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import controle.util.JSFUtil;
import modelo.dao.SolicitarParticipacaoDAO;
import modelo.dao.UsuarioDAO;
import modelo.dominio.Solicitante;
import modelo.dominio.Usuario;

@ManagedBean(name = "SolicitarParticipacaoMBController")
@RequestScoped
public class SolicitarParticipacaoMB_Controller implements Serializable {

	private static final long serialVersionUID = 1L;
	private UsuarioDAO usuDAO = new UsuarioDAO();
	private SolicitarParticipacaoDAO solicitDAO = new SolicitarParticipacaoDAO();

	private Solicitante solicitante = new Solicitante();
	private List<Solicitante> listSolicitacoes;

	public Solicitante getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Solicitante solicitante) {
		this.solicitante = solicitante;
	}

	public List<Solicitante> getListSolicitacoes() {
		if(this.listSolicitacoes == null){
			this.listSolicitacoes = this.solicitDAO.lerTodos();
		}
		return listSolicitacoes;
	}

	public void setListSolicitacoes(List<Solicitante> listSolicitacoes) {
		this.listSolicitacoes = listSolicitacoes;
	}

	public String enviarSolicitacao() {
		
		try {
			
		//LER USUÃ�RIO CADASTRADO NO POSTGRES
		Usuario loginBanco = usuDAO.lerPorLogin(this.getSolicitante().getLoginDoOrganizador());	
		FacesContext contexto = FacesContext.getCurrentInstance();
		
		if (loginBanco == null) {			
			contexto.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "O usuário nao existe.", null));		
		}
		else {
			
			if((this.getSolicitante().getId() != null) && (this.getSolicitante().getId().longValue() == 0))
				this.getSolicitante().setId(null);
			
			this.solicitDAO.salvar(this.getSolicitante());
			
			FacesMessage msg = new FacesMessage("Solicitação enviada com sucesso!");			
			FacesContext contexto1 = FacesContext.getCurrentInstance();		
			contexto1.addMessage(null, msg);
			
			this.solicitante = null;
			this.setSolicitante(new Solicitante());
			
			/*FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Solicitação enviada com sucesso!", null);
			FacesContext.getCurrentInstance().addMessage(null, msg);*/
		}
		
		} catch (Exception e) {
			
			System.out.println(e);
			
		}
				
		return "/pages/home.jsf?faces-redirect=true";
		
	}

	public String excluirSolicitacao(){
	
		try {
			
			Long id = JSFUtil.getParametroLong("idSolicitante");
			Solicitante solicitaBanco = this.solicitDAO.lerPorId(id);
			this.solicitDAO.excluir(solicitaBanco);
			
			//this.setListSolicitacoes(new Solicitante());
			
			this.solicitante = null;
			
			FacesContext contexto = FacesContext.getCurrentInstance();
			contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"O Solicitante foi excluído com sucesso.", null));
			
		} catch (Exception e) {

			System.out.println(e);
		}

		// executa a ação listar e retorna a sua página
		return "listSolicitacao.jsf";
		
		//this.listSolicitacoes();
		
	}
	
	public String cancelarSolicitacao() {

		this.setSolicitante(new Solicitante());
		return "/pages/home.jsf?faces-redirect=true";
	}
}
