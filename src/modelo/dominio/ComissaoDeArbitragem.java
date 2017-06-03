package modelo.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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

import org.hibernate.validator.constraints.NotEmpty;

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
	private OrganizadorInstituicao organizadorInstituicao;

	@OneToOne(cascade = CascadeType.ALL, optional = true, orphanRemoval = true)
	@JoinColumn(name = "idPessoa", referencedColumnName = "idPessoa")
	private Pessoa pessoa;

	@Column(length = 40, nullable = false)
	@NotEmpty(message = "")
	private String funcao;
	
	@Temporal (TemporalType.DATE)
	private Date dataDeCadastro;

	public ComissaoDeArbitragem() {

		super();
	}

	public ComissaoDeArbitragem(Long id, String funcao, Date dataDeCadastro) {

		super();
		this.setId(id);
		this.setFuncao(funcao);
	}

	public ComissaoDeArbitragem(String funcao) {

		super();
		this.setFuncao(funcao);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OrganizadorInstituicao getOrganizadorInstituicao() {
		return organizadorInstituicao;
	}

	public void setOrganizadorInstituicao(OrganizadorInstituicao organizadorInstituicao) {
		this.organizadorInstituicao = organizadorInstituicao;
	}
		
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
	public Date getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(Date dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}

	@Override
	public String toString() {
		return "ComissaoDeArbitragem [id=" + id + ", organizadorInstituicao=" + organizadorInstituicao + ", pessoa="
				+ pessoa + ", funcao=" + funcao + ", dataDeCadastro=" + dataDeCadastro + "]";
	}



}
