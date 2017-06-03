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
import modelo.dao.ComissaoDeArbitragemDAO;
import modelo.dao.PessoaDAO;
import modelo.dominio.ComissaoDeArbitragem;
import modelo.dominio.Pessoa;

@SuppressWarnings("serial")
@ManagedBean (name = "ComissaoArbitragemMBController")
@RequestScoped
public class ComissaoArbitragemMB_Controller implements Serializable{

	private Pessoa pessoa = new Pessoa();
	private PessoaDAO pesDAO = new PessoaDAO();
	private List<Pessoa> pessoas = null;
	
	private ComissaoDeArbitragem arbitro = new ComissaoDeArbitragem();
	private ComissaoDeArbitragemDAO ArbDAO = new ComissaoDeArbitragemDAO();
	private List<ComissaoDeArbitragem> arbitros = null;
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public List<Pessoa> getPessoas() {
		if (this.pessoas == null) {
			this.pessoas = this.pesDAO.lerTodos();
		}
		return pessoas;
	}
	
	public ComissaoDeArbitragem getArbitro() {
		return arbitro;
	}
	
	public List<ComissaoDeArbitragem> getArbitros() {
		if(this.arbitros == null){
			this.arbitros = this.ArbDAO.lerTodos();
		}
		return arbitros;
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

	//public String novoCadastroArbitro(){}
	
	//public String cancelarCadastroArbitro(){}
			
	//public String salvarArbitro(){}
	
	//public String excluirArbitro(){}
	
	//public String listarArbitros(){}
		
}
