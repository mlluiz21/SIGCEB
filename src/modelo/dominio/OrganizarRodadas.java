package modelo.dominio;

import java.io.Serializable;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name = "tblOrganizarRodadas")
public class OrganizarRodadas implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (generator = "id_Rodada", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator (name = "id_Rodada", sequenceName = "seq_Rodada", allocationSize = 1)
	@Column (name = "idRodada")
	private Long id;

	@ManyToOne
	@JoinColumn (name = "idCompeticao", referencedColumnName = "idCompeticao")
	private Competicao competicao;
	
	
	@OneToMany (mappedBy = "organizarRodadas", targetEntity = Jogos.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Jogos> listJogos;
	

	@Column (length = 2, nullable = false)
	private int numeroDaRodada;
	
	@Column (length = 2, nullable = false)
	private int turno;
	
	public OrganizarRodadas(){
		
		super();
		
	}
	
	public OrganizarRodadas(Long id, int numeroDaRodadas, int turno){
		
		super();
		this.setId(id);
		this.setNumeroDaRodada(numeroDaRodada);
		this.setTurno(turno);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public List<Jogos> getListJogos() {
		return listJogos;
	}

	public void setListJogos(List<Jogos> listJogos) {
		this.listJogos = listJogos;
	}
	
	public Competicao getCompeticao() {
		return competicao;
	}

	public void setCompeticao(Competicao competicao) {
		this.competicao = competicao;
	}

	public int getNumeroDaRodada() {
		return numeroDaRodada;
	}

	public void setNumeroDaRodada(int numeroDaRodada) {
		this.numeroDaRodada = numeroDaRodada;
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	@Override
	public String toString() {
		return "OrganizarRodadas [id=" + id + ", competicao=" + competicao + ", listJogos=" + listJogos
				+ ", numeroDaRodada=" + numeroDaRodada + ", turno=" + turno + "]";
	}	
	
}
