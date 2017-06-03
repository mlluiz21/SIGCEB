package modelo.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name = "tblCriarEvento")
public class CriarEvento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (generator = "id_Criar_Evento", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator (name = "id_Criar_Evento", sequenceName = "seq_Criar_Evento", allocationSize = 1)
	@Column (name = "idCriar_Evento")
	private Long id;

	
	@ManyToOne
	@JoinColumn (name = "idOrganizador", referencedColumnName = "idOrganizador")
	private OrganizadorInstituicao organizadorInstituicao;
	
	@ManyToOne
	@JoinColumn (name = "idCompeticao", referencedColumnName = "idCompeticao")
	private Competicao competicao;
	
	
	
	@Temporal(TemporalType.DATE)
	@Column
	private Date dataDeCadastro;
		
	public CriarEvento(){
		
		super();
	}
	
	public CriarEvento(Long id, Date dataDeCadastro){
		
		super();
		this.setId(id);
		this.setDataDeCadastro(dataDeCadastro);
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(Date dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}

	@Override
	public String toString() {
		return "CriarEvento [id=" + id + ", organizadorInstituicao=" + organizadorInstituicao + ", competicao="
				+ competicao + ", dataDeCadastro=" + dataDeCadastro + "]";
	}

		
}
