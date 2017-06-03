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
@Table (name= "tblPeriodoNaEquipe")
public class Periodo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (generator = "id_Periodo_Na_Equipe", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator (name = "id_Periodo_Na_Equipe", sequenceName = "seq_Periodo_Na_Equipe", allocationSize = 1)
	@Column (name = "idPeriodoNaEquipe")
	private Long id;
	
	
	@ManyToOne
	@JoinColumn (name = "idAtleta", referencedColumnName = "idAtleta")
	private Atleta atleta;
	
	@ManyToOne
	@JoinColumn (name = "idEquipe", referencedColumnName = "idEquipe")
	private Equipe equipeAtletas;	
		
	
	@Temporal(TemporalType.DATE)
	@Column (nullable = false)
	private Date dataDeEntrada;
	
	@Temporal(TemporalType.DATE)
	@Column
	private Date dataDeDaSida;

	public Periodo(){
		
		super();
	}
	
	public Periodo (Long id, Date dataDeEntrada, Date dataDeSaida){
		
		super();
		this.setId(id);
		this.setDataDeEntrada(dataDeEntrada);
		this.setDataDeDaSida(dataDeSaida);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Atleta getAtleta() {
		return atleta;
	}

	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}
	
	public Equipe getEquipeAtletas() {
		return equipeAtletas;
	}

	public void setEquipeAtletas(Equipe equipeAtletas) {
		this.equipeAtletas = equipeAtletas;
	}

	public Date getDataDeEntrada() {
		return dataDeEntrada;
	}

	public void setDataDeEntrada(Date dataDeEntrada) {
		this.dataDeEntrada = dataDeEntrada;
	}

	public Date getDataDeDaSida() {
		return dataDeDaSida;
	}

	public void setDataDeDaSida(Date dataDeDaSida) {
		this.dataDeDaSida = dataDeDaSida;
	}

	@Override
	public String toString() {
		return "Periodo [id=" + id + ", atleta=" + atleta + ", equipeAtletas=" + equipeAtletas + ", dataDeEntrada="
				+ dataDeEntrada + ", dataDeDaSida=" + dataDeDaSida + "]";
	}
		
}
