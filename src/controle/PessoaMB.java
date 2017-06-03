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
import modelo.dao.PessoaDAO;
import modelo.dominio.Pessoa;

@SuppressWarnings("serial")
@ManagedBean(name = "pessoaMBController")
@RequestScoped
public class PessoaMB implements Serializable{

	private Pessoa pessoa = new Pessoa();
	private PessoaDAO pesDAO = new PessoaDAO();
	private List<Pessoa> pessoas = null;

	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		if (this.pessoas == null) {
			this.pessoas = this.pesDAO.lerTodos();
		}
		return pessoas;
	}
		
	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
	public Sexo[] getSexo(){		
		return Sexo.values();
	}
	
	public Uf[] getUf(){		
		return Uf.values();
	}
	
	public EstadoCivil[] getEstadoCivil(){		
		return EstadoCivil.values();
	}
	
	public GrauDeEscolaridade[] getGrauDeEscolaridade(){		
		return GrauDeEscolaridade.values();
	}
	
	public TipoSanguineo[] getTipoSanguineo(){		
		return TipoSanguineo.values();
	}
	
	public String listarPessoas() {
		return "pessoaListar.jsf";
	}

	public String novoCadastroPessoa() {
		// LIMPAR O OBJETO DA P�GINA
		this.setPessoa(new Pessoa());
		return "editarPessoa.jsf";
	}

	/*
	 * public String abrirAlteracaoPessoa() { // pega o ID escolhido que veio no
	 * par�metro Long id = JSFUtil.getParametroLong("idPessoa"); Pessoa
	 * objetoDoBanco = this.dao.lerPorId(id); this.setPessoa(objetoDoBanco);
	 * 
	 * return "pessoaEditar.jsf"; }
	 */

	public String salvarPessoa() {

		// DEVE LIMPAR O ID COM VALOR ZERO, POIS O JSF SEMPRE CONVERTE O CAMPO
		// VAZIO PARA UM LONG = 0.
		if ((this.getPessoa().getId() != null) && (this.getPessoa().getId().longValue() == 0))
			this.getPessoa().setId(null);
		this.pesDAO.salvar(this.getPessoa());
		this.pessoas = null; // LIMPA A LISTA
		this.setPessoa(new Pessoa()); // LIMPAR O OBJETO DA P�GINA

		// EXECUTA A A��O LISTAR E RETORNA A SUA P�GINA
		return this.listarPessoas();
	}

	//TROCAR PARA cancelarCADASTROPessoa
	
	public String cancelarPessoa() {

		// LIMPAR O OBJETO DA P�GINA
		this.setPessoa(new Pessoa());

		// EXECUTA A A��O LISTAR E RETORNA A SUA P�GINA
		return this.listarPessoas();
	}

	/*
	 * public String excluirPessoa() { Long id =
	 * JSFUtil.getParametroLong("idPessoa"); Pessoa pessoaBanco =
	 * this.pesDAO.lerPorId(id); this.pesDAO.excluir(pessoaBanco);
	 * 
	 * // LIMPAR O OBJETO DA P�GINA this.setPessoa(new Pessoa());
	 * 
	 * // LIMPA A LISTA this.pessoas = null;
	 * 
	 * // EXECUTA A A��O LISTAR E RETORNA A SUA P�GINA return
	 * this.listarPessoas(); }
	 */

}