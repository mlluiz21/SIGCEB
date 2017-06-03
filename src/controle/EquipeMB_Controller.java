package controle;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import modelo.dominio.Equipe;
import modelo.dominio.TipoDeModalidade;

@SuppressWarnings("serial")
@ManagedBean(name = "EquipeMBController")
@RequestScoped
public class EquipeMB_Controller implements Serializable {

	private Equipe equipe = new Equipe();
	private TipoDeModalidade tipoModalidade = new TipoDeModalidade();

	
	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public TipoDeModalidade getTipoModalidade() {
		return tipoModalidade;
	}

	public void setTipoModalidade(TipoDeModalidade tipoModalidade) {
		this.tipoModalidade = tipoModalidade;
	}


}
