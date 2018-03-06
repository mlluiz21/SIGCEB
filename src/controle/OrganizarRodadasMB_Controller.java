package controle;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import modelo.dao.OrganizarRodadasDAO;
import modelo.dominio.OrganizarRodadas;

@ManagedBean(name = "OrganizarRodadasMBController")
@RequestScoped
public class OrganizarRodadasMB_Controller implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private OrganizarRodadas rodada = new OrganizarRodadas();
	private OrganizarRodadasDAO rodadaDAO = new OrganizarRodadasDAO();
	private List<OrganizarRodadas> rodadas = null;

	public OrganizarRodadas getRodada() {
		return rodada;
	}

	public void setRodada(OrganizarRodadas rodada) {
		this.rodada = rodada;
	}

	public OrganizarRodadasDAO getRodadaDAO() {
		return rodadaDAO;
	}

	public void setRodadaDAO(OrganizarRodadasDAO rodadaDAO) {
		this.rodadaDAO = rodadaDAO;
	}

	public List<OrganizarRodadas> getRodadas() {
		if(this.rodadas == null){
			this.rodadas = this.rodadaDAO.lerTodos();
		}
		return rodadas;
	}

	public void setRodadas(List<OrganizarRodadas> rodadas) {
		this.rodadas = rodadas;
	}

	public String salvarRodada(){
		
		if((this.getRodada().getId() != null) && (this.getRodada().getId().longValue() == 0))
			this.getRodada().setId(null);
		
		this.rodadaDAO.salvar(rodada);
		this.rodada = null;
		this.setRodada(new OrganizarRodadas());
		
		return "";
	}
}
