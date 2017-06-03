package modelo.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name = "tblAdicionarEquipe")
public class AdicionarEquipe implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (generator = "id_AdicionarEquipe", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator (name = "id_AdicionarEquipe", sequenceName = "seq_Adicionar_Equipe", allocationSize = 1)
	@Column (name = "idAdicionarEquipe")
	private Long id;
	
	
	@ManyToOne
	@JoinColumn (name = "idEquipe", referencedColumnName = "idEquipe")
	private Equipe equipe;
	
	@ManyToOne
	@JoinColumn (name = "idCompeticao", referencedColumnName = "idCompeticao")
	private Competicao competicao;
	
	
	@Temporal(TemporalType.DATE)
	@Column (nullable = false)
	private Date dataDeCadastro;
	
	public AdicionarEquipe(){
		
		super();
	}
	
	public AdicionarEquipe(Long id, Date dataDeCadastro, Equipe equipe, Competicao competicao){
		
		this.setId(id);
		this.setDataDeCadastro(dataDeCadastro);
		this.setEquipe(equipe);
		this.setCompeticao(competicao);
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public Competicao getCompeticao() {
		return competicao;
	}

	public void setCompeticao(Competicao competicao) {
		this.competicao = competicao;
	}

	public Date getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(Date dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}

	@Override
	public String toString() {
		return "AdicionarEquipe [id=" + id + ", equipe=" + equipe + ", competicao=" + competicao + ", dataDeCadastro="
				+ dataDeCadastro + "]";
	}
		
}
