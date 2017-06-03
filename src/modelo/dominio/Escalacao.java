package modelo.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table (name = "tblEscalacao")
public class Escalacao implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (generator = "id_Escalacao", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator (name = "id_Escalacao", sequenceName = "seq_Escalacao", allocationSize = 1)
	@Column (name = "idEscalacao")
	private Long id;
	
	@ManyToOne
	@JoinColumn (name = "idJogos", referencedColumnName = "idJogos")
	private Jogos jogo;
	
	
	@Column (length = 2, nullable = false)
	@NotEmpty(message = "")
	private int equipeNumero;
	
	@Column (length = 160)
	@NotEmpty(message = "")
	private String nomeDaEquipe;
	
	@Column (length = 60)
	@NotEmpty(message = "")
	private String nomeDoAtleta;
	
	public Escalacao(){
		
		super();
	}
	
	public Escalacao(Long id, int equipeNumero, String nomeDaEquipe,String nomeDoAtleta){
		
		super();
		this.setId(id);
		this.setEquipeNumero(equipeNumero);
		this.setNomeDaEquipe(nomeDaEquipe);
		this.setNomeDoAtleta(nomeDoAtleta);
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
		
	public int getEquipeNumero() {
		return equipeNumero;
	}

	public void setEquipeNumero(int equipeNumero) {
		this.equipeNumero = equipeNumero;
	}

	public Jogos getJogo() {
		return jogo;
	}

	public void setJogo(Jogos jogo) {
		this.jogo = jogo;
	}

	public String getNomeDaEquipe() {
		return nomeDaEquipe;
	}

	public void setNomeDaEquipe(String nomeDaEquipe) {
		this.nomeDaEquipe = nomeDaEquipe;
	}

	public String getNomeDoAtleta() {
		return nomeDoAtleta;
	}

	public void setNomeDoAtleta(String nomeDoAtleta) {
		this.nomeDoAtleta = nomeDoAtleta;
	}

	@Override
	public String toString() {
		return "Escalacao [id=" + id + ", jogo=" + jogo + ", equipeNumero=" + equipeNumero + ", nomeDaEquipe="
				+ nomeDaEquipe + ", nomeDoAtleta=" + nomeDoAtleta + "]";
	}
		
}
