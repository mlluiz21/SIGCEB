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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import enuns.TipoDeCompeticao;

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
	private OrganizadorOuInstituicao organizadorOuInstituicao;
	
	@ManyToOne
	@JoinColumn (name = "idCompeticao", referencedColumnName = "idCompeticao")
	private Competicao competicao;
	
		
	@Temporal(TemporalType.DATE)
	@Column
	private Date dataDeCadastro = Date();
	
	@Enumerated(EnumType.STRING)
	@Column(length = 40)
	/*@NotEmpty(message = "")*/
	private TipoDeCompeticao tipoDeCompeticao;
	
	
	public CriarEvento(){
		
		super();
	}
	
	private Date Date() {
		// TODO Auto-generated method stub
		return null;
	}

	public CriarEvento(Long id, Date dataDeCadastro, TipoDeCompeticao tipoDeCompeticao){
		
		super();
		this.setId(id);
		this.setDataDeCadastro(dataDeCadastro);
		this.setTipoDeCompeticao(tipoDeCompeticao);
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
	

	public TipoDeCompeticao getTipoDeCompeticao() {
		return tipoDeCompeticao;
	}

	public void setTipoDeCompeticao(TipoDeCompeticao tipoDeCompeticao) {
		this.tipoDeCompeticao = tipoDeCompeticao;
	}

	@Override
	public String toString() {
		return "CriarEvento [id=" + id + ", organizadorOuInstituicao=" + organizadorOuInstituicao + ", competicao="
				+ competicao + ", dataDeCadastro=" + dataDeCadastro + ", tipoDeCompeticao=" + tipoDeCompeticao + "]";
	}
		
}
