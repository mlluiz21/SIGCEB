package controle;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.context.RequestContext;

import modelo.dao.EquipeDAO;
import modelo.dominio.Equipe;

@ManagedBean(name = "EquipeMBController")
@RequestScoped
public class EquipeMB_Controller implements Serializable {

	private static final long serialVersionUID = 1L;

	private Equipe equipe = new Equipe();
	private EquipeDAO equiDAO = new EquipeDAO();
	private List<Equipe> equipes = null;

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public EquipeDAO getEquiDAO() {
		return equiDAO;
	}

	public void setEquiDAO(EquipeDAO equiDAO) {
		this.equiDAO = equiDAO;
	}

	public List<Equipe> getEquipes() {
		if(this.equipes == null){
			this.equipes = this.equiDAO.lerTodos();
		}
		return equipes;
	}

	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}

	public void abrirDialogEquipe(){
		
		//Criando mapa de parâmetros string
		Map<String, Object> equipe = new HashMap<>();
		
		equipe.put("modal", true);
		equipe.put("resizable", false);
		equipe.put("contentHeight", 230);
		equipe.put("contentWidth", 550);
		equipe.put("closable", false);
		/* atleta.put("centralizar a tela", args);*/
		
		//É uma API do Primefaces para chamar um arquivo xhtml como janela de diálogo
		RequestContext.getCurrentInstance().openDialog("editarEquipeDialog", equipe, null);
		
	}
	
	public String salvarEquipe() {

		if ((this.getEquipe().getId() != null) && (this.getEquipe().getId().longValue() == 0))
			this.getEquipe().setId(null);
		this.equiDAO.salvar(this.equipe);
		this.equipes = null;
		this.setEquipe(new Equipe());

		return "/pages/indexSistema.jsf?faces-redirect=true";
	}
	
	public String cancelarCadastroEquipe(){
		
		this.setEquipe(new Equipe());
		
		return "";
		
	}

}
