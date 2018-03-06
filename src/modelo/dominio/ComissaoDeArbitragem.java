package modelo.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import enuns.TipoDeJuiz;

@Entity
@Table(name = "tblComissaoDeArbitragem")
public class ComissaoDeArbitragem implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "id_Arbitro", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "id_Arbitro", sequenceName = "seq_Arbitro", allocationSize = 1)
	@Column(name = "idArbitro")
	private Long id;

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

	public ComissaoDeArbitragem(Long id, TipoDeJuiz tipoDeJuiz, Date dataDeCadastro) {

		super();
		this.setId(id);
		this.setDataDeCadastro(dataDeCadastro);
		this.setTipoDeJuiz(tipoDeJuiz);
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return "ComissaoDeArbitragem [id=" + id + ", organizadorOuInstituicao=" + organizadorOuInstituicao + ", pessoa="
				+ pessoa + ", tipoDeJuiz=" + tipoDeJuiz + ", dataDeCadastro=" + dataDeCadastro + "]";
	}
	
}
