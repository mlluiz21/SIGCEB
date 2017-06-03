package controle;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

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
	
	

}
