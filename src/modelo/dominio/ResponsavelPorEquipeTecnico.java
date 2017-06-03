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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table (name = "tblResponsavelPorEquipe")
public class ResponsavelPorEquipeTecnico implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (generator = "id_Resp_Equipe", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator (name = "id_Resp_Equipe", sequenceName = "seq_Resp_Equipe", allocationSize = 1)
	@Column (name = "idResp_Equipe")
	private Long id;

	
	@OneToOne (cascade = CascadeType.ALL, optional = true, orphanRemoval = true)
	@JoinColumn (name = "idPessoa", referencedColumnName = "idPessoa")
	private Pessoa pessoa;
	
	@ManyToOne
	@JoinColumn(name = "idOrganizador")
	private OrganizadorInstituicao organizadorInstituicao;
	
	@OneToMany (mappedBy = "responsavelPorEquipeTecnico", targetEntity = Atleta.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Atleta> atleta;
	
	
	@Column (length = 80, nullable = false, unique = true)
	@NotEmpty(message = "")
	private String nomeDaEquipe;
	
	@Temporal (TemporalType.DATE)
	private Date dataDeCadastro;
		
	public ResponsavelPorEquipeTecnico(){
		
		super();
	}
	
	public ResponsavelPorEquipeTecnico(Long id, String nomeDaEquipe, Date dataDeCadastro, Pessoa pessoa){
	
		super();
		this.setId(id);
		this.setNomeDaEquipe(nomeDaEquipe);
		this.setDataDeCadastro(dataDeCadastro);
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

	public OrganizadorInstituicao getOrganizadorInstituicao() {
		return organizadorInstituicao;
	}

	public void setOrganizadorInstituicao(OrganizadorInstituicao organizadorInstituicao) {
		this.organizadorInstituicao = organizadorInstituicao;
	}

	public List<Atleta> getAtleta() {
		return atleta;
	}

	public void setAtleta(List<Atleta> atleta) {
		this.atleta = atleta;
	}

	public String getNomeDaEquipe() {
		return nomeDaEquipe;
	}

	public void setNomeDaEquipe(String nomeDaEquipe) {
		this.nomeDaEquipe = nomeDaEquipe;
	}
	
	public Date getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(Date dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}

	@Override
	public String toString() {
		return "ResponsavelPorEquipeTecnico [id=" + id + ", pessoa=" + pessoa + ", organizadorInstituicao="
				+ organizadorInstituicao + ", atleta=" + atleta + ", nomeDaEquipe=" + nomeDaEquipe + ", dataDeCadastro="
				+ dataDeCadastro + "]";
	}

	

}
