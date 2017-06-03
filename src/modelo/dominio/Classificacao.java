package modelo.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name = "tblClassificacao")
public class Classificacao implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (generator = "id_Classificacao", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator (name = "id_Classificacao", sequenceName = "seq_Classificacao", allocationSize = 1)
	@Column (name = "idClassificacao")
	private Long id;

	/*
	private Competicao competicao;
	
	private OrganizarRodadas rodadas;*/
	
	@Column (length = 80, nullable = false, unique = true)
	private String nomeDaEquipe;
	
	@Column (length = 3, nullable = false)
	private int pontos;
	
	@Column  (length = 2, nullable = false)
	private int numeroDeJogos;
	
	@Column (length = 3, nullable = false)
	private int golsPro;
	
	@Column (length = 3, nullable = false)
	private int golsContra;
	
	public Classificacao(){
		
		super();
	}
	
	public Classificacao(Long id, String nomeDaEquipe, int pontos, int numeroDeJogos, int golsPro, int golsContra){
				
		super();
		this.setId(id);
		this.setNomeDaEquipe(nomeDaEquipe);
		this.setPontos(pontos);
		this.setNumeroDeJogos(numeroDeJogos);
		this.setGolsPro(golsPro);
		this.setGolsContra(golsContra);
	}
		

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeDaEquipe() {
		return nomeDaEquipe;
	}

	public void setNomeDaEquipe(String nomeDaEquipe) {
		this.nomeDaEquipe = nomeDaEquipe;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public int getNumeroDeJogos() {
		return numeroDeJogos;
	}

	public void setNumeroDeJogos(int numeroDeJogos) {
		this.numeroDeJogos = numeroDeJogos;
	}

	public int getGolsPro() {
		return golsPro;
	}

	public void setGolsPro(int golsPro) {
		this.golsPro = golsPro;
	}

	public int getGolsContra() {
		return golsContra;
	}

	public void setGolsContra(int golsContra) {
		this.golsContra = golsContra;
	}

	@Override
	public String toString() {
		return "Classificacao [id=" + id + ", nomeDaEquipe=" + nomeDaEquipe + ", pontos=" + pontos + ", numeroDeJogos="
				+ numeroDeJogos + ", golsPro=" + golsPro + ", golsContra=" + golsContra + "]";
	}
	
}
