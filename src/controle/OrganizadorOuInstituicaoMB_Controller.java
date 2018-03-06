package controle;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import modelo.dao.OrganizadorOuInstituicaoDAO;
import modelo.dominio.OrganizadorOuInstituicao;

@ManagedBean(name = "OrganizadorInstituicaoMBController")
@SessionScoped
public class OrganizadorOuInstituicaoMB_Controller implements Serializable {

	private static final long serialVersionUID = 1L;
	private OrganizadorOuInstituicao organizadorOuInstituicao = new OrganizadorOuInstituicao();
	private OrganizadorOuInstituicaoDAO organizaDAO = new OrganizadorOuInstituicaoDAO();

	public OrganizadorOuInstituicao getOrganizadorOuInstituicao() {
		return organizadorOuInstituicao;
	}

	public void setOrganizadorOuInstituicao(OrganizadorOuInstituicao organizadorOuInstituicao) {
		this.organizadorOuInstituicao = organizadorOuInstituicao;
	}

	public OrganizadorOuInstituicaoDAO getOrganizaDAO() {
		return organizaDAO;
	}

	public void setOrganizaDAO(OrganizadorOuInstituicaoDAO organizaDAO) {
		this.organizaDAO = organizaDAO;
	}

	public void abrirDialogOrganizadorInstituicao() {

		Map<String, Object> organizadorOuInstituicao = new HashMap<>();

		organizadorOuInstituicao.put("modal", true);
		organizadorOuInstituicao.put("resizable", false);
		organizadorOuInstituicao.put("contentHeight", 220);
		organizadorOuInstituicao.put("contentWidth", 550);
		organizadorOuInstituicao.put("closable", false);
		/* organizadorOuInstituicao.put("centralizar na Tela", arg1) */

		// É uma API do Primefaces para chamar um arquivo como janela de
		// diálogo

		RequestContext.getCurrentInstance().openDialog("editarOrganizadorOuInstituicaoDialog", organizadorOuInstituicao,
				null);

	}

	public String salvarOrganizadorOuInstituicao() {

		try {

			if ((this.getOrganizadorOuInstituicao().getId() != null)
					&& (this.getOrganizadorOuInstituicao().getId().longValue() == 0))
				this.getOrganizadorOuInstituicao().setId(null);

			this.organizaDAO.salvar(this.getOrganizadorOuInstituicao());
			this.setOrganizadorOuInstituicao(new OrganizadorOuInstituicao());

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Cadastro Organizador ou Instituição realizado com sucesso!", null);
			FacesContext.getCurrentInstance().addMessage(null, msg);

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

		return "/pages/indexSistema.jsf?faces-redirect=true";
		// return abrirSistema();
	}

	public String abrirSistema() {

		return "/pages/indexSistema.jsf?faces-redirect=true";
	}
}
