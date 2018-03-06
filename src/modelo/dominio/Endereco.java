package modelo.dominio;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import enuns.Uf;

@Embeddable
public class Endereco {
	
	@Column (length = 40)
	private String logradouro;
	
	@Column (length = 6)
	private String numero;
	
	@Column (length = 40)
	private String complemento;
	
	@Column (length = 40)
	private String bairro;
	
	@Column (length = 40)
	private String cidade;
	
	@Enumerated (EnumType.STRING)
	@Column (length = 2)
	private Uf uf;
	
	@Column (length = 8)
	private String cep;
	
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
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
	public Uf getUf() {
		return uf;
	}
	public void setUf(Uf uf) {
		this.uf = uf;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	@Override
	public String toString() {
		return "Endereco [logradouro=" + logradouro + ", numero=" + numero + ", complemento=" + complemento
				+ ", bairro=" + bairro + ", cidade=" + cidade + ", uf=" + uf + ", cep=" + cep + "]";
	}
	
	

}
