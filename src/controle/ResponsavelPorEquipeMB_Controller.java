package controle;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import modelo.dominio.Equipe;
import modelo.dominio.Pessoa;
import modelo.dominio.ResponsavelPorEquipeTecnico;

@SuppressWarnings("serial")
@ManagedBean(name = "ResponsavelPorEquipeMBController")
@RequestScoped
public class ResponsavelPorEquipeMB_Controller implements Serializable {

	private Pessoa pessoa = new Pessoa();
	private ResponsavelPorEquipeTecnico responsavelPorEquipe = new ResponsavelPorEquipeTecnico();
	private Equipe equipe = new Equipe();

	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public ResponsavelPorEquipeTecnico getResponsavelPorEquipe() {
		return responsavelPorEquipe;
	}

	public void setResponsavelPorEquipe(ResponsavelPorEquipeTecnico responsavelPorEquipe) {
		this.responsavelPorEquipe = responsavelPorEquipe;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

}
