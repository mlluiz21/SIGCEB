package controle;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import modelo.dao.EscalacaoDAO;
import modelo.dominio.Atleta;
import modelo.dominio.Escalacao;

@SuppressWarnings("serial")
@ManagedBean(name = "EscalacaoMBController")
@RequestScoped
public class EscalacaoMB_Controller implements Serializable {

	private Escalacao escalarAtleta = new Escalacao();
	private EscalacaoDAO escalarDAO = new EscalacaoDAO();
	private List<Escalacao> listEscalacao = null;
	
	private List<Atleta> atletas = null;
	
	
	// public String novaEscalacao(){}

	// public String cancelarCadastroEscalacao(){}

	// public String salvarEscalacao(){}

	// public String excluirEscalacao(){}

	// public String listarEscalacao(){}

}
