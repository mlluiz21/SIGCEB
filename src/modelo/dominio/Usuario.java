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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import enuns.TipoDeUsuario;

@Entity
@Table (name = "tblUsuario")
public class Usuario implements Serializable{
		
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (generator = "id_Usuario", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator (name = "id_Usuario", sequenceName = "seq_Usuario", allocationSize = 1)
	@Column (name = "idUsuario")
	private Long id;
	
	@OneToOne
	@JoinColumn(name="idPessoa", referencedColumnName = "idPessoa", nullable=true)
	private Pessoa pessoa;	
				
	@Column (length = 35, unique = true)
	private String login;
	
	@Column (length = 25)
	private String senha;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 30)
	private TipoDeUsuario tipoDeUsuario;
	
	
	public Usuario(){
		
		super();
	}
	
	public Usuario(Long id, Pessoa pessoa, String login, String senha, TipoDeUsuario tipoDeUsuario) {
		
		super();
		this.setId(id);
		this.setPessoa(pessoa);
		this.setLogin(login);
		this.setSenha(senha);
		this.setTipoDeUsuario(tipoDeUsuario);
		
	}
			
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
		
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean senhaCorreta(String senhaDigitada){
		
		if(this.senha.equals(senhaDigitada))
			return true;
		else
			return false;
	}
	
	public TipoDeUsuario getTipoDeUsuario() {
		return tipoDeUsuario;
	}

	public void setTipoDeUsuario(TipoDeUsuario tipoDeUsuario) {
		this.tipoDeUsuario = tipoDeUsuario;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", pessoa=" + pessoa + ", login=" + login + ", senha=" + senha + ", tipoDeUsuario="
				+ tipoDeUsuario + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
}
