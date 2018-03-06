package controle;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import enuns.EstadoCivil;
import enuns.GrauDeEscolaridade;
import enuns.Sexo;
import enuns.TipoSanguineo;
import enuns.Uf;
import modelo.dao.AtletaDAO;
import modelo.dao.ComissaoDeArbitragemDAO;
import modelo.dao.PessoaDAO;
import modelo.dominio.Atleta;
import modelo.dominio.ComissaoDeArbitragem;
import modelo.dominio.Pessoa;
import modelo.dominio.Usuario;

@ManagedBean(name = "pessoaMBController")
@SessionScoped
public class PessoaMB implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Pessoa pessoa = new Pessoa();
	private Usuario usuario = new Usuario();
	private Atleta atleta = new Atleta();
	private ComissaoDeArbitragem arbito = new ComissaoDeArbitragem();
	
	private ComissaoDeArbitragemDAO arbiDAO = new ComissaoDeArbitragemDAO();
	private PessoaDAO pesDAO = new PessoaDAO();
	private AtletaDAO atleDAO = new AtletaDAO();
	
	private List<ComissaoDeArbitragem> arbitros = null;
	private List<Atleta> atletas = null;
	private List<Pessoa> pessoas = null;
		
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
		
	public Atleta getAtleta() {
		return atleta;
	}

	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}

	public ComissaoDeArbitragem getArbito() {
		return arbito;
	}

	public void setArbito(ComissaoDeArbitragem arbito) {
		this.arbito = arbito;
	}

	public List<ComissaoDeArbitragem> getArbitros() {
		if (this.arbitros == null){
			this.arbitros = this.arbiDAO.lerTodos();
		}
		return arbitros;
	}

	public void setArbitros(List<ComissaoDeArbitragem> arbitros) {
		this.arbitros = arbitros;
	}

	public List<Atleta> getAtletas() {
		if (this.atletas == null){
			this.atletas = this.atleDAO.lerTodos();
		}
		return atletas;
	}

	public void setAtletas(List<Atleta> atletas) {
		this.atletas = atletas;
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

	try {
		
		
		// DEVE LIMPAR O ID COM VALOR ZERO, POIS O JSF SEMPRE CONVERTE O CAMPO
		// VAZIO PARA UM LONG = 0.
		if ((this.getPessoa().getId() != null) && (this.getPessoa().getId().longValue() == 0))
			this.getPessoa().setId(null);
		this.pessoas = null; // LIMPA A LISTA
		this.setPessoa(new Pessoa()); // LIMPAR O OBJETO DA P�GINA

	} catch (Exception e) { // SE GERAR ALGUM TIPO DE ERRO, MOSTRAR ABAIXO
		
		System.out.println(e.getMessage());
		
	}
		// EXECUTA A A��O LISTAR E RETORNA A SUA P�GINA
		return "/pages/criarLoginDialog.jsf";
	}

	public String salvarPessoaSistema() {
		
		try {
			
			// DEVE LIMPAR O ID COM VALOR ZERO, POIS O JSF SEMPRE CONVERTE O CAMPO
			// VAZIO PARA UM LONG = 0.
			if ((this.getPessoa().getId() != null) && (this.getPessoa().getId().longValue() == 0))
				this.getPessoa().setId(null);
			this.pesDAO.salvar(this.pessoa);
			this.pessoas = null; // LIMPA A LISTA
			this.setPessoa(new Pessoa()); // LIMPAR O OBJETO DA P�GINA
			
			System.out.println("Dados gravado com sucesso!");
			
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		
		// EXECUTA A A��O LISTAR E RETORNA A SUA P�GINA
		return "pages/indexSistema.jsf";
	}
	
	
	//TROCAR PARA cancelarCADASTROPessoa
	
	public String cancelarPessoa() {
		
		// LIMPAR O OBJETO DA P�GINA
		this.setPessoa(new Pessoa());
		
		// EXECUTA A A��O LISTAR E RETORNA A SUA P�GINA
		return "/pages/home.jsf";
	}
	
	public String cancelarPessoaSistema() {

		// LIMPAR O OBJETO DA P�GINA
		this.setPessoa(new Pessoa());

		// EXECUTA A A��O LISTAR E RETORNA A SUA P�GINA
		return "/pages/indexSistema.jsf";
	}

	public String cancelarEdicaoPerfil() {		
					
		// EXECUTA A A��O LISTAR E RETORNA A SUA P�GINA
		return "/pages/indexSistema.jsf";
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