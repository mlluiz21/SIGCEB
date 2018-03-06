package controle;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.context.RequestContext;

import enuns.TipoDeJuiz;
import modelo.dao.ComissaoDeArbitragemDAO;
import modelo.dominio.ComissaoDeArbitragem;

@ManagedBean (name = "ComissaoArbitragemMBController")
@SessionScoped
public class ComissaoArbitragemMB_Controller implements Serializable{

	private static final long serialVersionUID = 1L;		
	private ComissaoDeArbitragem arbitro = new ComissaoDeArbitragem();
	private ComissaoDeArbitragemDAO ArbDAO = new ComissaoDeArbitragemDAO();
	private List<ComissaoDeArbitragem> arbitros = null;
	
	
	
	public void setArbitro(ComissaoDeArbitragem arbitro) {
		this.arbitro = arbitro;
	}
	
	public ComissaoDeArbitragem getArbitro() {
		return arbitro;
	}
	
	public List<ComissaoDeArbitragem> getArbitros() {
		if(this.arbitros == null){
			this.arbitros = this.ArbDAO.lerTodos();
		}
		return arbitros;
	}
			
	public void setArbitros(List<ComissaoDeArbitragem> arbitros) {
		this.arbitros = arbitros;
	}

	public TipoDeJuiz[] getTipoDeJuiz() {
		return TipoDeJuiz.values();
	}
	
	public void abrirDialogArbitro() {

		// Criando mapa de parametros string
		Map<String, Object> arbitro = new HashMap<>();

		arbitro.put("modal", true);
		arbitro.put("resizable", false);
		arbitro.put("contentHeight", 200);
		arbitro.put("contentWidth", 500);
		arbitro.put("closable", false);
		/* arbitro.put("centralizar na Tela", arg1) */

		// É uma API do Primefaces para chamar um arquivo como janela de
		// diálogo
		RequestContext.getCurrentInstance().openDialog("editarArbitroDialog", arbitro, null);

	}
	
	//public String novoCadastroArbitro(){}
			
	public String salvarArbitro(){
		
		if((this.getArbitro().getId() != null) && (this.getArbitro().getId().longValue() == 0))
			this.getArbitro().setId(null);
		
		this.ArbDAO.salvar(this.getArbitro());
		this.arbitros = null;
		this.setArbitro(new ComissaoDeArbitragem());
		
		return "/pages/indexSistema.jsf?faces-redirect=true";
		/*return abrirSistema();*/
	}
	
	public String abrirSistema(){
		
		return "/pages/indexSistema.jsf?faces-redirect=true";
	}
		
	//public String excluirArbitro(){}
	
	//public String listarArbitros(){}
		
}
