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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table (name = "tblJogos")
public class Jogos implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (generator = "id_Jogo", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator (name ="id_Jogo",sequenceName = "seq_Jogo", allocationSize = 1)
	@Column (name = "idJogos")
	private Long id;
	
	@ManyToOne
	@JoinColumn (name = "idRodada", referencedColumnName = "idRodada")
	private OrganizarRodadas organizarRodadas; 
	
	@OneToMany (mappedBy = "jogo", targetEntity = Escalacao.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Escalacao> listEscalacao; 
	
	
	@Column
	private int numJogo;
	
	@Column (length = 50, nullable = false)
	@NotEmpty(message = "")
	private String local;

	@Temporal(TemporalType.DATE)
	@Column (nullable = false)
	private Date dataDoJogo;
	
	@Column (nullable = false)
	private Date horaDoJogo;
	
	@Column (length = 80, nullable = false)
	@NotEmpty(message = "")
	private String equipe1;

	@Column (length = 2)	
	private int placarEquipe1;

	@Column (length = 80, nullable = false)
	@NotEmpty(message = "")
	private String equipe2;
	
	@Column (length = 2)
	private int placarEquipe2;
	
	//JUIZ DO JOGO
	
	@Column (length = 250)
	private String resumoDoJogo;
	
	public Jogos(){
		
		super();
	}
	
	public Jogos(Long id, int numJogo, String local, Date dataDoJogo, Date horaDoJogo, 
	String equipe1, String equipe2, String resumoDoJogo){
		
		super();
		this.setId(id);
		this.setLocal(local);
		this.setDataDoJogo(dataDoJogo);
		this.setHoraDoJogo(horaDoJogo);
		this.setEquipe1(equipe1);
		this.setEquipe2(equipe2);
		this.setResumoDoJogo(resumoDoJogo);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public OrganizarRodadas getOrganizarRodadas() {
		return organizarRodadas;
	}

	public void setOrganizarRodadas(OrganizarRodadas organizarRodadas) {
		this.organizarRodadas = organizarRodadas;
	}
	
	public List<Escalacao> getListEscalacao() {
		return listEscalacao;
	}

	public void setListEscalacao(List<Escalacao> listEscalacao) {
		this.listEscalacao = listEscalacao;
	}

	public int getNumJogo() {
		return numJogo;
	}

	public void setNumJogo(int numJogo) {
		this.numJogo = numJogo;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Date getDataDoJogo() {
		return dataDoJogo;
	}

	public void setDataDoJogo(Date dataDoJogo) {
		this.dataDoJogo = dataDoJogo;
	}

	public Date getHoraDoJogo() {
		return horaDoJogo;
	}

	public void setHoraDoJogo(Date horaDoJogo) {
		this.horaDoJogo = horaDoJogo;
	}

	public String getEquipe1() {
		return equipe1;
	}

	public void setEquipe1(String equipe1) {
		this.equipe1 = equipe1;
	}

	public String getEquipe2() {
		return equipe2;
	}

	public void setEquipe2(String equipe2) {
		this.equipe2 = equipe2;
	}

	public String getResumoDoJogo() {
		return resumoDoJogo;
	}

	public void setResumoDoJogo(String resumoDoJogo) {
		this.resumoDoJogo = resumoDoJogo;
	}

	@Override
	public String toString() {
		return "Jogos [id=" + id + ", organizarRodadas=" + organizarRodadas + ", listEscalacao=" + listEscalacao
				+ ", numJogo=" + numJogo + ", local=" + local + ", dataDoJogo=" + dataDoJogo + ", horaDoJogo="
				+ horaDoJogo + ", equipe1=" + equipe1 + ", placarEquipe1=" + placarEquipe1 + ", equipe2=" + equipe2
				+ ", placarEquipe2=" + placarEquipe2 + ", resumoDoJogo=" + resumoDoJogo + "]";
	}
	
}
