package modelo.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import enuns.Duracao;


@Entity
@Table (name = "tblCompeticao")
public class Competicao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "id_Competicao", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "id_Competicao", sequenceName = "seq_Competicao", allocationSize = 1)
	@Column (name = "idCompeticao")
	private Long id;
	
	
	@OneToMany (mappedBy = "competicao", targetEntity = OrganizarRodadas.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<OrganizarRodadas> listOrganizarRodadas;
	
	@OneToMany (mappedBy = "competicao", targetEntity = AdicionarEquipe.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<AdicionarEquipe> listAdicionarEquipe;
		

	@Column (length = 60, nullable = false)
	@NotEmpty(message = "")
	private String nomeDaCompeticao;
	
	@Enumerated(EnumType.STRING)
	@Column (length = 8, nullable = false)
	@NotEmpty(message = "")
	private Duracao duracao;
	
	@Column (length = 2, nullable = false)
	@NotEmpty(message = "")
	private int quantidadeDeEquipes;
	
	@Column (length = 2, nullable = false)
	@NotEmpty(message = "")
	private int quantidadeDeGrupos;
	
	@Column (nullable = false)
	private Date dataDeInicio;
	
	@Column (length = 1024)
	private String regrasDaCompeticao;
	
	public Competicao(){
		
		super();
	}
	
	public Competicao(Long id, String nomeDaCompeticao, Duracao duracao,
	int quantidadeDeEquipes, int quantidadeDeGrupos, Date dataDeInicio, String regrasDaCompeticao){
		
		super();
		this.setId(id);
		this.setNomeDaCompeticao(nomeDaCompeticao);
		this.setDuracao(duracao);
		this.setQuantidadeDeEquipes(quantidadeDeEquipes);
		this.setQuantidadeDeGrupos(quantidadeDeGrupos);
		this.setDataDeInicio(dataDeInicio);
		this.setRegrasDaCompeticao(regrasDaCompeticao);				
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public List<OrganizarRodadas> getListOrganizarRodadas() {
		return listOrganizarRodadas;
	}

	public void setListOrganizarRodadas(List<OrganizarRodadas> listOrganizarRodadas) {
		this.listOrganizarRodadas = listOrganizarRodadas;
	}

	public List<AdicionarEquipe> getListAdicionarEquipe() {
		return listAdicionarEquipe;
	}

	public void setListAdicionarEquipe(List<AdicionarEquipe> listAdicionarEquipe) {
		this.listAdicionarEquipe = listAdicionarEquipe;
	}

	public String getNomeDaCompeticao() {
		return nomeDaCompeticao;
	}

	public void setNomeDaCompeticao(String nomeDaCompeticao) {
		this.nomeDaCompeticao = nomeDaCompeticao;
	}

	public Duracao getDuracao() {
		return duracao;
	}

	public void setDuracao(Duracao duracao) {
		this.duracao = duracao;
	}

	public int getQuantidadeDeEquipes() {
		return quantidadeDeEquipes;
	}

	public void setQuantidadeDeEquipes(int quantidadeDeEquipes) {
		this.quantidadeDeEquipes = quantidadeDeEquipes;
	}

	public int getQuantidadeDeGrupos() {
		return quantidadeDeGrupos;
	}

	public void setQuantidadeDeGrupos(int quantidadeDeGrupos) {
		this.quantidadeDeGrupos = quantidadeDeGrupos;
	}

	public Date getDataDeInicio() {
		return dataDeInicio;
	}

	public void setDataDeInicio(Date dataDeInicio) {
		this.dataDeInicio = dataDeInicio;
	}

	public String getRegrasDaCompeticao() {
		return regrasDaCompeticao;
	}

	public void setRegrasDaCompeticao(String regrasDaCompeticao) {
		this.regrasDaCompeticao = regrasDaCompeticao;
	}

	@Override
	public String toString() {
		return "Competicao [id=" + id + ", listOrganizarRodadas=" + listOrganizarRodadas + ", listAdicionarEquipe="
				+ listAdicionarEquipe + ", nomeDaCompeticao=" + nomeDaCompeticao + ", duracao=" + duracao
				+ ", quantidadeDeEquipes=" + quantidadeDeEquipes + ", quantidadeDeGrupos=" + quantidadeDeGrupos
				+ ", dataDeInicio=" + dataDeInicio + ", regrasDaCompeticao=" + regrasDaCompeticao + "]";
	}
	


}