package controle;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import enuns.EstadoCivil;
import enuns.GrauDeEscolaridade;
import enuns.Sexo;
import enuns.TipoSanguineo;
import enuns.Uf;
import modelo.dao.AtletaDAO;
import modelo.dao.PessoaDAO;
import modelo.dominio.Atleta;
import modelo.dominio.Pessoa;

@SuppressWarnings("serial")
@ManagedBean(name = "AtletaMBController")
@RequestScoped
public class AtletaMB_Controller implements Serializable{

	private Pessoa pessoa = new Pessoa();
	private PessoaDAO pesDAO = new PessoaDAO();
	private List<Pessoa> pessoas = null;

	private Atleta atleta = new Atleta();
	private AtletaDAO atleDAO = new AtletaDAO();
	private List<Atleta> atletas = null;

	public Pessoa getPessoa() {
		return pessoa;
	}

	public List<Pessoa> getPessoas() {
		if (this.pessoas == null) {
			this.pessoas = this.pesDAO.lerTodos();
		}
		return pessoas;
	}

	public Atleta getAtleta() {
		return atleta;
	}

	public List<Atleta> getAtletas() {
		if (this.atletas == null) {
			this.atletas = this.atleDAO.lerTodos();
		}
		return atletas;
	}

	public Sexo[] getSexo() {
		return Sexo.values();
	}

	public Uf[] getUf() {
		return Uf.values();
	}

	public EstadoCivil[] getEstadoCivil() {
		return EstadoCivil.values();
	}

	public GrauDeEscolaridade[] getGrauDeEscolaridade() {
		return GrauDeEscolaridade.values();
	}

	public TipoSanguineo[] getTipoSanguineo() {
		return TipoSanguineo.values();
	}

	//public String novoCadastroAtleta(){}
	
	//public String cancelarCadastroAtleta(){}
			
	//public String salvarAtleta(){}
	
	//public String excluirAtleta(){}
	
	//public String listarAtletas(){}
		
}
