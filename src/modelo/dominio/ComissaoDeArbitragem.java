package modelo.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import enuns.TipoDeJuiz;

@SuppressWarnings("serial")
@Entity
@Table(name = "tblComissaoDeArbitragem")
public class ComissaoDeArbitragem extends Pessoa implements Serializable{
	
	@ManyToOne
	@JoinColumn(name = "idOrganizador")
	private OrganizadorOuInstituicao organizadorOuInstituicao;

	@OneToOne(cascade = CascadeType.ALL, optional = true, orphanRemoval = true)
	@JoinColumn(name = "idPessoa", referencedColumnName = "idPessoa")
	private Pessoa pessoa;

	@Enumerated(EnumType.STRING)
	@Column(length = 25, nullable = false)
	/*@NotEmpty(message = "")*/
	private TipoDeJuiz tipoDeJuiz;
	
	@Temporal (TemporalType.DATE)
	private Date dataDeCadastro;

	public ComissaoDeArbitragem() {

		super();
	}

	public ComissaoDeArbitragem(TipoDeJuiz tipoDeJuiz, Date dataDeCadastro) {

		super();
		this.setDataDeCadastro(dataDeCadastro);
		this.setTipoDeJuiz(tipoDeJuiz);
		
	}

	public OrganizadorOuInstituicao getOrganizadorInstituicao() {
		return organizadorOuInstituicao;
	}

	public void setOrganizadorInstituicao(OrganizadorOuInstituicao organizadorOuInstituicao) {
		this.organizadorOuInstituicao = organizadorOuInstituicao;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public TipoDeJuiz getTipoDeJuiz() {
		return tipoDeJuiz;
	}

	public void setTipoDeJuiz(TipoDeJuiz tipoDeJuiz) {
		this.tipoDeJuiz = tipoDeJuiz;
	}

	public Date getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(Date dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}

	@Override
	public String toString() {
		return "ComissaoDeArbitragem [organizadorOuInstituicao=" + organizadorOuInstituicao + ", pessoa="
				+ pessoa + ", tipoDeJuiz=" + tipoDeJuiz + ", dataDeCadastro=" + dataDeCadastro + "]";
	}
	
}
