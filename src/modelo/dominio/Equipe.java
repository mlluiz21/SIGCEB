package modelo.dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name = "tblEquipe")
public class Equipe implements Serializable{
	
	private static final long serialVersionUID = 1L;
		
	@Id
	@GeneratedValue(generator = "id_Equipe", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "id_Equipe", sequenceName = "seq_Equipe", allocationSize = 1)
	@Column (name = "idEquipe")
	private Long id;
	
	@OneToOne (cascade = CascadeType.ALL, optional = true, orphanRemoval = true)
	@JoinColumn (name = "idResp_Equipe", referencedColumnName = "idResp_Equipe")
	private ResponsavelPorEquipeTecnico responsavelPorEquipeTecnico;
	
	@OneToMany (mappedBy = "equipeAtletas", targetEntity = Periodo.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Periodo> listAtletas; 
	
	/*@OneToMany (mappedBy = "equipe", targetEntity = TipoDeModalidade.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<TipoDeModalidade> listTipoDeModalidade;*/
	
	@OneToMany (mappedBy = "equipe", targetEntity = AdicionarEquipe.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<AdicionarEquipe> listAdicionarEquipe;
	
	@Column (length = 35, nullable = false)
	/*@NotEmpty(message = "")*/
	private String nomeFantasia;
	
	@Column (length = 40, nullable = false)
	private String bairro;
	
	@Column (length = 40, nullable = false)
	/*@NotEmpty(message = "")*/
	private String tecnico;

	//DEFINIR O TIPO DE RELACIONAMENTO AS MODALIDADES
	
	public Equipe(){
		
		super();
	}
		
	public Equipe(Long id, String nomeFantasia, String bairro, String tecnico) {
		super();
		this.setNomeFantasia(nomeFantasia);	
		this.setId(id);
		this.setBairro(bairro);
		this.setTecnico(tecnico);		
	}
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
		
	public ResponsavelPorEquipeTecnico getResponsavelPorEquipeTecnico() {
		return responsavelPorEquipeTecnico;
	}

	public void setResponsavelPorEquipeTecnico(ResponsavelPorEquipeTecnico responsavelPorEquipeTecnico) {
		this.responsavelPorEquipeTecnico = responsavelPorEquipeTecnico;
	}
	/*
	public List<TipoDeModalidade> getListTipoDeModalidade() {
		return listTipoDeModalidade;
	}

	public void setListTipoDeModalidade(List<TipoDeModalidade> listTipoDeModalidade) {
		this.listTipoDeModalidade = listTipoDeModalidade;
	}
*/
	public List<AdicionarEquipe> getListAdicionarEquipe() {
		return listAdicionarEquipe;
	}

	public void setListAdicionarEquipe(List<AdicionarEquipe> listAdicionarEquipe) {
		this.listAdicionarEquipe = listAdicionarEquipe;
	}
		
	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getTecnico() {
		return tecnico;
	}

	public void setTecnico(String tecnico) {
		this.tecnico = tecnico;
	}



	@Override
	public String toString() {
		return "Equipe [id=" + id + ", responsavelPorEquipeTecnico=" + responsavelPorEquipeTecnico + ", listAtletas="
				+ listAtletas + ", listAdicionarEquipe="
				+ listAdicionarEquipe + ", nomeFantasia=" + nomeFantasia + ", bairro=" + bairro + ", tecnico=" + tecnico
				+ "]";
	}

	

}
