package controle;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.context.RequestContext;

import enuns.PosicaoEmCampo;
import enuns.StatusParaEquipe;
import enuns.StatusParaJogo;
import modelo.dao.AtletaDAO;
import modelo.dominio.Atleta;
import modelo.dominio.Pessoa;

@ManagedBean(name = "AtletaMBController")
@SessionScoped
public class AtletaMB_Controller implements Serializable{

	private static final long serialVersionUID = 1L;	
	private Pessoa pessoa = new Pessoa();
	private Atleta atleta = new Atleta();
	private AtletaDAO atleDAO = new AtletaDAO();
	private List<Atleta> atletas = null;
		

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Atleta getAtleta() {
		return atleta;
	}
	
	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}

	public List<Atleta> getAtletas() {
		if (this.atletas == null) {
			this.atletas = this.atleDAO.lerTodos();
		}
		return atletas;
	}
	
	public void setAtletas(List<Atleta> atletas) {
		this.atletas = atletas;
	}	

	public PosicaoEmCampo[] getPosicaoEmCampo(){
		return PosicaoEmCampo.values();
	}
	
	public StatusParaJogo[] getStatusParaJogo(){
		return StatusParaJogo.values();
	}
	public StatusParaEquipe[] getStatusParaEquipe(){
		return StatusParaEquipe.values();
	}

	public void abrirDialogAtleta(){
		
		//Criando mapa de parâmetros string
		Map<String, Object> atleta = new HashMap<>();
		
		atleta.put("modal", true);
		atleta.put("resizable", true);
		atleta.put("contentHeight", 260);
		atleta.put("contentWidth", 550);
		atleta.put("closable", false);
		/* atleta.put("centralizar a tela", args);*/
		
		//É uma API do Primefaces para chamar um arquivo xhtml como janela de diálogo
		RequestContext.getCurrentInstance().openDialog("editarAtletaDialog", atleta, null);
		
	}
	
	//public String novoCadastroAtleta(){}	
		
	public String salvarAtleta(){
		
		try {
			
			if ((this.getAtleta().getId() != null) && (this.getAtleta().getId().longValue() == 0))
				this.getAtleta().setId(null);
			this.atleDAO.salvar(this.getAtleta());
			this.atletas = null; // LIMPA A LISTA
			this.setAtleta(new Atleta()); // LIMPAR O OBJETO DA P�GINA
			
			RequestContext.getCurrentInstance().closeDialog(this.getAtleta());
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
		// ABRIR PAGINA DO SISTEMA AO SALVAR
		//return "/pages/indexSistema.jsf?faces-redirect=true";
		return abrirSistema();

		
	}
	
	public String abrirSistema(){
		return "/pages/indexSistema.jsf?faces-redirect=true";
	}
	
	//public String excluirAtleta(){}
	
	//public String listarAtletas(){}
		
}
