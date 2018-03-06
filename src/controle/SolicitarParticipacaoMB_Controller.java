package controle;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

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
		
		//LER USUÃ�RIO CADASTRADO NO POSTGRES
		Usuario loginBanco = usuDAO.lerPorLogin(this.getSolicitante().getLoginDoOrganizador());	
		FacesContext contexto = FacesContext.getCurrentInstance();
		
		if (loginBanco == null) {			
			contexto.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "O usuario nao existe.", null));		
		}
		else {
			
			if((this.getSolicitante().getId() != null) && (this.getSolicitante().getId().longValue() == 0))
				this.getSolicitante().setId(null);
			
			this.solicitDAO.salvar(this.getSolicitante());
			this.solicitante = null;
			this.setSolicitante(new Solicitante());
			
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Solicitação enviada com sucesso!", null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}		
		
		return "/pages/home.jsf?faces-redirect=true";
		
	}

	public String cancelarSolicitacao() {

		this.setSolicitante(new Solicitante());
		return "/pages/home.jsf?faces-redirect=true";
	}
}
