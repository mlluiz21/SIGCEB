package modelo.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
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

import enuns.PosicaoEmCampo;

@Entity
@Table(name = "tblAtleta")
public class Atleta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "id_Atleta", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "id_Atleta", sequenceName = "seq_Atleta", allocationSize = 1)
	@Column(name = "idAtleta")
	private Long id;

	@OneToOne(cascade = CascadeType.ALL, optional = true, orphanRemoval = true)
	@JoinColumn(name = "idPessoa", referencedColumnName = "idPessoa")
	private Pessoa pessoa;

	@ManyToOne
	@JoinColumn(name = "idResp_Equipe", referencedColumnName = "idResp_Equipe")
	private ResponsavelPorEquipeTecnico responsavelPorEquipeTecnico;

	@OneToMany(mappedBy = "atleta", targetEntity = Periodo.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Periodo> listCompeticao;

	@Enumerated
	@Column(length = 40, nullable = false)
	@NotEmpty(message = "")
	private PosicaoEmCampo posicaoEmCampo;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dataDeCadastro;

	@Column(nullable = false)
	@NotEmpty(message = "")
	private boolean statusDoAtleta;

	public Atleta(Long id, Pessoa pessoa,
			ResponsavelPorEquipeTecnico responsavelPorEquipeTecnico,
			List<Periodo> listCompeticao, PosicaoEmCampo posicaoEmCampo,
			Date dataDeCadastro, boolean statusDoAtleta) {
		super();
		this.id = id;
		this.pessoa = pessoa;
		this.responsavelPorEquipeTecnico = responsavelPorEquipeTecnico;
		this.listCompeticao = listCompeticao;
		this.posicaoEmCampo = posicaoEmCampo;
		this.dataDeCadastro = dataDeCadastro;
		this.statusDoAtleta = statusDoAtleta;
	}

	public Atleta() {
		super();
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

	public ResponsavelPorEquipeTecnico getResponsavelPorEquipeTecnico() {
		return responsavelPorEquipeTecnico;
	}

	public void setResponsavelPorEquipeTecnico(
			ResponsavelPorEquipeTecnico responsavelPorEquipeTecnico) {
		this.responsavelPorEquipeTecnico = responsavelPorEquipeTecnico;
	}

	public List<Periodo> getListCompeticao() {
		return listCompeticao;
	}

	public void setListCompeticao(List<Periodo> listCompeticao) {
		this.listCompeticao = listCompeticao;
	}

	public PosicaoEmCampo getPosicaoEmCampo() {
		return posicaoEmCampo;
	}

	public void setPosicaoEmCampo(PosicaoEmCampo posicaoEmCampo) {
		this.posicaoEmCampo = posicaoEmCampo;
	}

	public Date getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(Date dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}

	public boolean isStatusDoAtleta() {
		return statusDoAtleta;
	}

	public void setStatusDoAtleta(boolean statusDoAtleta) {
		this.statusDoAtleta = statusDoAtleta;
	}

	@Override
	public String toString() {
		return "Atleta [id=" + id + ", pessoa=" + pessoa
				+ ", responsavelPorEquipeTecnico="
				+ responsavelPorEquipeTecnico + ", listCompeticao="
				+ listCompeticao + ", posicaoEmCampo=" + posicaoEmCampo
				+ ", statusDoAtleta=" + statusDoAtleta + "]";
	}

}
