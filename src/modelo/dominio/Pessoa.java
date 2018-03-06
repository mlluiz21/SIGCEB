package modelo.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import enuns.EstadoCivil;
import enuns.GrauDeEscolaridade;
import enuns.Sexo;
import enuns.TipoSanguineo;

@Entity
@Table(name = "tblPessoa")
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "id_Pessoa", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "id_Pessoa", sequenceName = "seq_Pessoa", allocationSize = 1)
	@Column(name = "idPessoa")
	private Long id;

	@Size(min = 8, max = 70)
	@Column(length = 70, nullable = false)
	private String nomeCompleto;

	@Column(length = 11, nullable = false, unique = true)
	private String cpf;

	@Column(length = 10, unique = true)
	private String rg;

	@Temporal(TemporalType.DATE)
	@Past
	private Date dataDeNascimento;

	@Enumerated(EnumType.STRING)
	@Column(length = 1)
	private Sexo sexo;

	@Column(length = 60)
	private String nomeDaMae;

	@Column(length = 60)
	private String nomeDoPai;

	@Enumerated(EnumType.STRING)
	@Column(length = 13)
	private EstadoCivil estadoCivil;

	@Enumerated(EnumType.STRING)
	@Column(length = 3)
	private TipoSanguineo tipoSanguineo;

	@Enumerated(EnumType.STRING)
	@Column(length = 31)
	private GrauDeEscolaridade grauDeEscolaridade;

	@Column(length = 55)
	private String email;

	@Column(length = 11)
	private String celular;

	@Column(length = 10)
	private String telefone;

	private Endereco endereco;

	public Pessoa() {
		super();
	}

	public Pessoa(Long id, String nomeCompleto, String cpf, String rg, Date dataDeNascimento, Sexo sexo,
			String nomeDaMae, String nomeDoPai, EstadoCivil estadoCivil, TipoSanguineo tipoSanguineo,
			GrauDeEscolaridade grauDeEscolaridade, String email, String celular, String telefone, Endereco endereco) {

		super();
		this.setId(id);
		this.setNomeCompleto(nomeCompleto);
		this.setCpf(cpf);
		this.setRg(rg);
		this.setDataDeNascimento(dataDeNascimento);
		this.setSexo(sexo);
		this.setNomeDaMae(nomeDaMae);
		this.setNomeDoPai(nomeDoPai);
		this.setEstadoCivil(estadoCivil);
		this.setTipoSanguineo(tipoSanguineo);
		this.setGrauDeEscolaridade(grauDeEscolaridade);
		this.setEmail(email);
		this.setCelular(celular);
		this.setTelefone(telefone);
		this.setEndereco(endereco);

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getNomeDaMae() {
		return nomeDaMae;
	}

	public void setNomeDaMae(String nomeDaMae) {
		this.nomeDaMae = nomeDaMae;
	}

	public String getNomeDoPai() {
		return nomeDoPai;
	}

	public void setNomeDoPai(String nomeDoPai) {
		this.nomeDoPai = nomeDoPai;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public TipoSanguineo getTipoSanguineo() {
		return tipoSanguineo;
	}

	public void setTipoSanguineo(TipoSanguineo tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}

	public GrauDeEscolaridade getGrauDeEscolaridade() {
		return grauDeEscolaridade;
	}

	public void setGrauDeEscolaridade(GrauDeEscolaridade grauDeEscolaridade) {
		this.grauDeEscolaridade = grauDeEscolaridade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {

		if (endereco == null)
			endereco = new Endereco();
		return endereco;
	}

	public void setEndereco(Endereco endereco) {

		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nomeCompleto=" + nomeCompleto + ", cpf=" + cpf + ", rg=" + rg
				+ ", dataDeNascimento=" + dataDeNascimento + ", sexo=" + sexo + ", nomeDaMae=" + nomeDaMae
				+ ", nomeDoPai=" + nomeDoPai + ", estadoCivil=" + estadoCivil + ", tipoSanguineo=" + tipoSanguineo
				+ ", grauDeEscolaridade=" + grauDeEscolaridade + ", email=" + email + ", celular=" + celular
				+ ", telefone=" + telefone + ", endereco=" + endereco + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		return true;
	}

	public Pessoa getPessoa() {
		// TODO Auto-generated method stub
		return null;
	}
}
