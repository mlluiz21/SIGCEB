package controle;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.context.RequestContext;

import modelo.dao.AdicionarEquipeDAO;
import modelo.dominio.AdicionarEquipe;

@SuppressWarnings("serial")
@ManagedBean (name = "AdicionarEquipeMBController")
@RequestScoped
public class AdicionarEquipeMB_Controller implements Serializable{
	
	private AdicionarEquipe addEquipe = new AdicionarEquipe();
	private AdicionarEquipeDAO addEquipeDAO = new AdicionarEquipeDAO();
	private List<AdicionarEquipe> equipesAdd = null;
	
	public AdicionarEquipe getAddEquipe() {
		return addEquipe;
	}
	
	public AdicionarEquipeDAO getAddEquipeDAO() {
		return addEquipeDAO;
	}
	
	public List<AdicionarEquipe> getEquipesAdd() {
		return equipesAdd;
	}
	
	public void abrirDialogAddSelectEquipes(){
		
		//Criando mapa de parametros string
		Map<String, Object> opcoesEquipes = new HashMap<>();
		
		opcoesEquipes.put("modal", true);
		opcoesEquipes.put("resizable", false);
		opcoesEquipes.put("contentHeight", 500);
		opcoesEquipes.put("contentWidth", 1000);
		/*opcoesEquipes.put("centralizar na Tela", arg1)*/
				
		//É uma API do Primefaces para cahamar um arquivo como janela de diálogo
		RequestContext.getCurrentInstance().openDialog("addEquipes", opcoesEquipes, null);
				
	}

}
