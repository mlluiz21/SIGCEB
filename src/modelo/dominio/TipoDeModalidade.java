package modelo.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import enuns.TipoModalidade;

@Entity
@Table (name = "tblTipoDeModalidade")
public class TipoDeModalidade implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (generator = "id_Modalidade", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator (name = "id_Modalidade", sequenceName = "seq_Modalidade", allocationSize = 1)
	@Column (name = "idModalidade")
	private Long id;
	
	@ManyToOne
	@JoinColumn (name = "idEquipe", referencedColumnName = "idEquipe")
	private Equipe equipe;

	@Enumerated(EnumType.STRING)
	@Column (length = 15)
	private TipoModalidade modalidade;
	
	

	public TipoDeModalidade(Long id, Equipe equipe, TipoModalidade modalidade) {
		super();
		this.setId(id);
		this.setEquipe(equipe);
		this.setModalidade(modalidade);
	}

	public TipoDeModalidade() {
		// TODO Auto-generated constructor stub
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

	public TipoModalidade getModalidade() {
		return modalidade;
	}

	public void setModalidade(TipoModalidade modalidade) {
		this.modalidade = modalidade;
	}

	@Override
	public String toString() {
		return "TipoDeModalidade [id=" + id + ", equipe=" + equipe + ", modalidade=" + modalidade + "]";
	}
		
}
