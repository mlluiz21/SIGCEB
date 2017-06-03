package controle;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import modelo.dao.CompeticaoDAO;
import modelo.dominio.Competicao;


@ManagedBean(name = "CompeticoesMB_Controller")
@RequestScoped
public class CompeticoesMB_Controller implements Serializable{
		
	private static final long serialVersionUID = 1L;
	
	private Competicao competicao = new Competicao();
	private List<Competicao> listCompeticoes;
	private CompeticaoDAO competicaoDAO = new CompeticaoDAO(); 

	
	public Competicao getCompeticao() {
		return competicao;
	}

	public void setCompeticao(Competicao competicao) {
		this.competicao = competicao;
	}

	public List<Competicao> getListCompeticoes() {
		
		if(this.competicao == null){
			this.competicao = (Competicao) this.competicaoDAO.lerTodos();
		}
		return listCompeticoes;
	}

	public void setListCompeticoes(List<Competicao> listCompeticoes) {
		this.listCompeticoes = listCompeticoes;
	}
	
	
	public void salvarCompeticao(Competicao competicao){
		
		//Falta
	}
	
	public String novaCompeticao(){
		
		return "editarCompeticao";
	}
	
}
