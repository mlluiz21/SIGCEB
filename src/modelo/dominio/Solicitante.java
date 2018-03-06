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
@Table (name = "tblSolicitante")
public class Solicitante implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (generator = "id_Solicitante", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator (name = "id_Solicitante", sequenceName = "seq_Solicitante", allocationSize = 1)
	@Column (name = "idSolicitante")
	private Long id;
	
/*	//FALTA DETERMINAR O TIPO DE RELACIONAMENTO
	@OneToMany (mappedBy = "solicita", targetEntity = FALTA_CLASSE.class, fetch = FetchType.LAZY)
	private OrganizadorInstituicao organizadorOuInstituicao; 

*/	
	@ManyToOne
	@JoinColumn(name = "idOrganizador")
	private OrganizadorOuInstituicao organizadorOuInstituicao;

	
	@Column (length = 35, nullable = false)
	@NotEmpty(message = "")
	private String loginDoOrganizador;
	
	@Column (length = 60, nullable = false)
	@NotEmpty(message = "")
	private String nomeCompleto;
	
	@Column (length = 50, nullable = false)
	@NotEmpty(message = "")
	private String email;
	
	@Column (length = 11, nullable = false)
	@NotEmpty(message = "")
	private String telefoneCelular;
	
	@Column (length = 11)
	@NotEmpty(message = "")
	private String telefoneResidencial;
	
	@Column (length = 80, nullable = false)
	@NotEmpty(message = "")
	private String nomeDaEquipe;
	
	@Column (length = 50, nullable = false)
	private String bairro;
	
	@Column (length = 50, nullable = false)
	private String cidade;
	
	public Solicitante(){
		
		super();
	}
	
	public Solicitante(Long id, String loginDoOrganizador, String nomeCompleto, String email, 
			String telefoneCelular, String telefoneResidencial, String nomeDaEquipe, String bairro, String cidade){
		
		super();
		this.setId(id);
		this.setLoginDoOrganizador(loginDoOrganizador);
		this.setNomeCompleto(nomeCompleto);
		this.setEmail(email);
		this.setTelefoneCelular(telefoneCelular);
		this.setTelefoneResidencial(telefoneResidencial);
		this.setNomeDaEquipe(nomeDaEquipe);
		this.setBairro(bairro);
		this.setCidade(cidade);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoginDoOrganizador() {
		return loginDoOrganizador;
	}

	public void setLoginDoOrganizador(String loginDoOrganizador) {
		this.loginDoOrganizador = loginDoOrganizador;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public String getTelefoneResidencial() {
		return telefoneResidencial;
	}

	public void setTelefoneResidencial(String telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}

	public String getNomeDaEquipe() {
		return nomeDaEquipe;
	}

	public void setNomeDaEquipe(String nomeDaEquipe) {
		this.nomeDaEquipe = nomeDaEquipe;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public OrganizadorOuInstituicao getOrganizadorInstituicao() {
		return organizadorOuInstituicao;
	}

	public void setOrganizadorInstituicao(OrganizadorOuInstituicao organizadorOuInstituicao) {
		this.organizadorOuInstituicao = organizadorOuInstituicao;
	}

	@Override
	public String toString() {
		return "Solicitante [id=" + id + ", organizadorOuInstituicao=" + organizadorOuInstituicao + ", loginDoOrganizador="
				+ loginDoOrganizador + ", nomeCompleto=" + nomeCompleto + ", email=" + email + ", telefoneCelular="
				+ telefoneCelular + ", telefoneResidencial=" + telefoneResidencial + ", nomeDaEquipe=" + nomeDaEquipe
				+ ", bairro=" + bairro + ", cidade=" + cidade + "]";
	}

}
