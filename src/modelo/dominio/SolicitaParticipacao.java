/*package modelo.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tblSolicitaParticipacao")
public class SolicitaParticipacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "id_SolicitaParticipacao", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "id_SolicitaParticipacao", sequenceName = "seq_SolicitaParticipacao", allocationSize = 1)
	@Column(name = "idSolicitaParticipacao")
	private Long id;

	@Column
	private Date dataSolicitacao;

	@ManyToMany
	private List<SolicitaParticipacao> solicitantes;
	
	public Date getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(Date dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

}
*/