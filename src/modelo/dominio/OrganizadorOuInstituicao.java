package modelo.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name = "tblOrganizadorOuInstituicao")
public class OrganizadorOuInstituicao implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (generator = "id_Organizador", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator (name = "id_Organizador", sequenceName = "seq_Organizador", allocationSize = 1)
	@Column (name = "idOrganizador")
	private Long id;
	

	@OneToOne (cascade = CascadeType.ALL, optional = true, orphanRemoval = true)
	@JoinColumn (name = "idPessoa", referencedColumnName = "idPessoa")
	private Pessoa pessoa;
	
	
	@OneToMany (mappedBy = "organizadorOuInstituicao", targetEntity = ComissaoDeArbitragem.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List <ComissaoDeArbitragem> comissaoDeArbitragem;
		
	@OneToMany (mappedBy = "organizadorOuInstituicao", targetEntity = CriarEvento.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<CriarEvento> listCriarEventos;
	
	@OneToMany (mappedBy = "organizadorOuInstituicao", targetEntity = Solicitante.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Solicitante> solicitantes;
	
	//OBS TABELA CRIAR EVENTOS - RELACIONAMENTO **
	
	@Temporal(TemporalType.DATE)
	@Column
	private Date dataDeCadastro;
	
	@Column (length = 40)
	/*@NotEmpty(message = "")*/
	private String localEvento;
		
	@Column (length = 40)
	/*@NotEmpty(message = "")*/
	private String nomeDoCampoOuQuadra;
	

	public OrganizadorOuInstituicao(){
		
		super();
	}
	
	public OrganizadorOuInstituicao(Long id, String nomeDoCampoOuQuadra, String localDoEvento, Date dataDeCadastro, Pessoa pessoa){
		
		super();
		this.setId(id);
		this.setDataDeCadastro(dataDeCadastro);
		this.setLocalEvento(localDoEvento);
		this.setNomeDoCampoOuQuadra(nomeDoCampoOuQuadra);
		this.setPessoa(pessoa);
	}
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public List<ComissaoDeArbitragem> getComissaoDeArbitragem() {
		return comissaoDeArbitragem;
	}

	public void setComissaoDeArbitragem(List<ComissaoDeArbitragem> comissaoDeArbitragem) {
		this.comissaoDeArbitragem = comissaoDeArbitragem;
	}
				
	public List<CriarEvento> getListCriarEventos() {
		return listCriarEventos;
	}

	public void setListCriarEventos(List<CriarEvento> listCriarEventos) {
		this.listCriarEventos = listCriarEventos;
	}
	
	public List<Solicitante> getSolicitantes() {
		return solicitantes;
	}

	public void setSolicitantes(List<Solicitante> solicitantes) {
		this.solicitantes = solicitantes;
	}

	public String getNomeDoCampoOuQuadra() {
		return nomeDoCampoOuQuadra;
	}

	public void setNomeDoCampoOuQuadra(String nomeDoCampoOuQuadra) {
		this.nomeDoCampoOuQuadra = nomeDoCampoOuQuadra;
	}

	public String getLocalEvento() {
		return localEvento;
	}

	public void setLocalEvento(String localEvento) {
		this.localEvento = localEvento;
	}

	public Date getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(Date dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}

	@Override
	public String toString() {
		return "OrganizadorOuInstituicao [id=" + id + ", pessoa=" + pessoa + ", comissaoDeArbitragem="
				+ comissaoDeArbitragem + ", listCriarEventos=" + listCriarEventos + ", solicitantes=" + solicitantes
				+ ", dataDeCadastro=" + dataDeCadastro + ", localEvento=" + localEvento + ", nomeDoCampoOuQuadra="
				+ nomeDoCampoOuQuadra + "]";
	}

		
}
