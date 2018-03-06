package controle;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.context.RequestContext;

import modelo.dao.ResponsavelPorEquipeTecnicoDAO;
import modelo.dominio.Equipe;
import modelo.dominio.Pessoa;
import modelo.dominio.ResponsavelPorEquipeTecnico;

@ManagedBean(name = "ResponsavelPorEquipeMBController")
@SessionScoped
public class ResponsavelPorEquipeMB_Controller implements Serializable {

	private static final long serialVersionUID = 1L;		
	private ResponsavelPorEquipeTecnico responsavelPorEquipe = new ResponsavelPorEquipeTecnico();
	private ResponsavelPorEquipeTecnicoDAO responsavelPorEquipeDAO = new ResponsavelPorEquipeTecnicoDAO();	
	private List<ResponsavelPorEquipeTecnico> responsaveisPorEquipes = null;
	private Pessoa pessoa = new Pessoa();
	private Equipe equipe = new Equipe();
		
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	
	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public ResponsavelPorEquipeTecnico getResponsavelPorEquipe() {
		return responsavelPorEquipe;
	}

	public void setResponsavelPorEquipe(ResponsavelPorEquipeTecnico responsavelPorEquipe) {
		this.responsavelPorEquipe = responsavelPorEquipe;
	}
	
	public List<ResponsavelPorEquipeTecnico> getResponsaveisPorEquipes() {
		if(this.responsaveisPorEquipes == null){
			this.responsaveisPorEquipes = this.responsavelPorEquipeDAO.lerTodos();
		}
		return responsaveisPorEquipes;
	}

	public void setResponsaveisPorEquipes(List<ResponsavelPorEquipeTecnico> responsaveisPorEquipes) {
		this.responsaveisPorEquipes = responsaveisPorEquipes;
	}
	
	public void abrirDialogResponsavelPorEquipe(){
		
		Map<String, Object> responsavelPorEquipe = new HashMap<>();
		
		responsavelPorEquipe.put("modal", true);
		responsavelPorEquipe.put("resizable", false);
		responsavelPorEquipe.put("contentHeight", 200);
		responsavelPorEquipe.put("contentWidth", 550);
		responsavelPorEquipe.put("closable", false);
		/* criarLogin.put("centralizar na Tela", arg1) */

		// É uma API do Primefaces para chamar um arquivo como janela de
		// diálogo
		RequestContext.getCurrentInstance().openDialog("editarResponsavelPorEquipeDialog", responsavelPorEquipe, null);

	}
		
	public String salvarResponsavelPorEquipe(){
		
		if((this.getResponsavelPorEquipe().getId() != null) && (this.getResponsavelPorEquipe().getId().longValue() == 0))
			this.getResponsavelPorEquipe().setId(null);
		
		this.responsavelPorEquipeDAO.salvar(this.getResponsavelPorEquipe());
		this.responsaveisPorEquipes = null;
		this.setResponsavelPorEquipe(new ResponsavelPorEquipeTecnico());
		
		return "/pages/editarEquipeDialog.jsf?faces-redirect=true";
		//return abrirSistema();
	}
	
	public String abrirSistema(){
		
		return "/pages/indexSistema.jsf?faces-redirect=true";
	}

}
