package modelo.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table (name = "tblResponsavelPorEquipe")
public class ResponsavelPorEquipeTecnico extends Pessoa implements Serializable{
	
	@OneToOne (cascade = CascadeType.ALL, optional = true, orphanRemoval = true)
	@JoinColumn (name = "idPessoa", referencedColumnName = "idPessoa")
	private Pessoa pessoa;
		
	@OneToMany (mappedBy = "responsavelPorEquipeTecnico", targetEntity = Atleta.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Atleta> atleta;
	
	
	@Column (length = 80, nullable = false, unique = true)
	/*@NotEmpty(message = "")*/
	private String nomeDaEquipe;
	
	@Temporal (TemporalType.DATE)
	private Date dataDeCadastro;
		
	public ResponsavelPorEquipeTecnico(){
		
		super();
	}
	
	public ResponsavelPorEquipeTecnico(String nomeDaEquipe, Date dataDeCadastro, Pessoa pessoa){
	
		super();
		this.setNomeDaEquipe(nomeDaEquipe);
		this.setDataDeCadastro(dataDeCadastro);
		this.setPessoa(pessoa);
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
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
		return "ResponsavelPorEquipeTecnico [pessoa=" + pessoa + ", atleta=" + atleta + ", nomeDaEquipe="
				+ nomeDaEquipe + ", dataDeCadastro=" + dataDeCadastro + "]";
	}

	

}
