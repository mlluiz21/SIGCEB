package controle;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.context.RequestContext;

import enuns.TipoModalidade;
import modelo.dao.TipoDeModalidadeDAO;
import modelo.dominio.TipoDeModalidade;

@ManagedBean(name = "TipoModalidadeMBController")
@SessionScoped
public class TipoModalidadeMB_Controller implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private TipoDeModalidade modalidade = new TipoDeModalidade();
	private TipoDeModalidadeDAO modalDAO = new TipoDeModalidadeDAO();
	private List<TipoDeModalidade> modalidades = null;

	public TipoDeModalidade getModalidade() {
		return modalidade;
	}

	public void setModalidade(TipoDeModalidade modalidade) {
		this.modalidade = modalidade;
	}

	public TipoDeModalidadeDAO getModalDAO() {
		return modalDAO;
	}

	public void setModalDAO(TipoDeModalidadeDAO modalDAO) {
		this.modalDAO = modalDAO;
	}

	public List<TipoDeModalidade> getModalidades() {
		if (this.modalidades == null) {
			this.modalidades = this.modalDAO.lerTodos();
		}
		return modalidades;
	}

	public void setModalidades(List<TipoDeModalidade> modalidades) {
		this.modalidades = modalidades;
	}
	
	public TipoModalidade[] getTipoModalidade(){
		return TipoModalidade.values();
	}
	
	public void abrirDialogModalidade(){
		
		Map<String, Object> novaModalidade = new HashMap<>();
		
		novaModalidade.put("Modal", true);
		novaModalidade.put("contentWidth", 450);
		novaModalidade.put("contentHeight", 300);
		novaModalidade.put("resizable", true);
		
		RequestContext.getCurrentInstance().openDialog("novaModalidadeDialog", novaModalidade, null);
	}

	public String salvarAdicionarModalidade() {

		try {
			
			if ((this.getModalidade().getId() != null) && (this.getModalidade().getId().longValue() == 0))
				this.getModalidade().setId(null);
			
			this.modalDAO.salvar(this.getModalidade());
			this.setModalidade(new TipoDeModalidade());
			this.modalidades = null;
			
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		
		return abrirListaDeModalidades();		
	}
	
	
	public String abrirListaDeModalidades(){
		
		return "Como chamar dentro de uma página Xhtml uma model";		
	}
	
	
	public void sairListaDeModalidades(){
		
		// AGUARDANDO CÓDIGO
	}
	
	

	public String cancelarAdicionarModalidade() {
		
		this.setModalidade(new TipoDeModalidade());

		return "";
	}

}
