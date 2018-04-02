package modelo.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import enuns.PosicaoEmCampo;
import enuns.StatusParaEquipe;
import enuns.StatusParaJogo;

@SuppressWarnings("serial")
@Entity
@Table(name = "tblAtleta")
public class Atleta extends Pessoa implements Serializable {

	@OneToOne(cascade = CascadeType.ALL, optional = true, orphanRemoval = true)
	@JoinColumn(name = "idPessoa", referencedColumnName = "idPessoa")
	private Pessoa pessoa;

	@ManyToOne
	@JoinColumn(name = "idResp_Equipe", referencedColumnName = "idResp_Equipe")
	private ResponsavelPorEquipeTecnico responsavelPorEquipeTecnico;

	@OneToMany(mappedBy = "atleta", targetEntity = Periodo.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Periodo> listCompeticao;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dataDeCadastro;

	@Enumerated(EnumType.STRING)
	@Column(length = 40, nullable = false)
	/*@NotEmpty(message = "")*/
	private PosicaoEmCampo posicaoEmCampo;

	@Enumerated(EnumType.STRING)
	@Column(length = 40, nullable = false)
	private StatusParaJogo statusParaJogo;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 40, nullable = false)	
	private StatusParaEquipe statusParaEquipe;

	public Atleta(Pessoa pessoa, ResponsavelPorEquipeTecnico responsavelPorEquipeTecnico,
			List<Periodo> listCompeticao, PosicaoEmCampo posicaoEmCampo, Date dataDeCadastro, StatusParaJogo statusParaJogo, StatusParaEquipe statusParaEquipe) {
		super();
		this.pessoa = pessoa;
		this.responsavelPorEquipeTecnico = responsavelPorEquipeTecnico;
		this.listCompeticao = listCompeticao;
		this.posicaoEmCampo = posicaoEmCampo;
		this.dataDeCadastro = dataDeCadastro;
		this.statusParaJogo = statusParaJogo;
		this.statusParaEquipe = statusParaEquipe;
	}

	public Atleta() {
		super();
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public ResponsavelPorEquipeTecnico getResponsavelPorEquipeTecnico() {
		return responsavelPorEquipeTecnico;
	}

	public void setResponsavelPorEquipeTecnico(ResponsavelPorEquipeTecnico responsavelPorEquipeTecnico) {
		this.responsavelPorEquipeTecnico = responsavelPorEquipeTecnico;
	}

	public List<Periodo> getListCompeticao() {
		return listCompeticao;
	}

	public void setListCompeticao(List<Periodo> listCompeticao) {
		this.listCompeticao = listCompeticao;
	}

	public PosicaoEmCampo getPosicaoEmCampo() {
		return posicaoEmCampo;
	}

	public void setPosicaoEmCampo(PosicaoEmCampo posicaoEmCampo) {
		this.posicaoEmCampo = posicaoEmCampo;
	}

	public Date getDataDeCadastro() {
		return dataDeCadastro;
	}
	
/*	public Date setDataDeCadastro(String format) {
		return dataDeCadastro;
		// TODO Auto-generated method stub
		
	}*/
	
	public void setDataDeCadastro(Date dataDeCadastro) {
		
		this.dataDeCadastro = dataDeCadastro;
	}
	
	/*public void setDataDeCadastro(Date dataDeCadastro) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dataAtual = new Date(System.currentTimeMillis());
		
		this.dataDeCadastro = setDataDeCadastro(sdf.format(dataAtual));
	}
*/
	public StatusParaJogo getStatusParaJogo() {
		return statusParaJogo;
	}

	public void setStatusParaJogo(StatusParaJogo statusParaJogo) {
		this.statusParaJogo = statusParaJogo;
	}

	public StatusParaEquipe getStatusParaEquipe() {
		return statusParaEquipe;
	}

	public void setStatusParaEquipe(StatusParaEquipe statusParaEquipe) {
		this.statusParaEquipe = statusParaEquipe;
	}

	@Override
	public String toString() {
		return "Atleta [pessoa=" + pessoa + ", responsavelPorEquipeTecnico="
				+ responsavelPorEquipeTecnico + ", listCompeticao=" + listCompeticao + ", posicaoEmCampo="
				+ posicaoEmCampo + ", dataDeCadastro=" + dataDeCadastro + ", statusParaJogo=" + statusParaJogo
				+ ", statusParaEquipe=" + statusParaEquipe + "]";
	}

	
}
