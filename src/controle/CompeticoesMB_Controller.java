package controle;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import enuns.Duracao;
import enuns.TipoDeCompeticao;
import modelo.dao.CompeticaoDAO;
import modelo.dominio.Competicao;

@ManagedBean(name = "CompeticoesMB_Controller")
@RequestScoped
public class CompeticoesMB_Controller implements Serializable {

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

		if (this.listCompeticoes == null) {
			this.listCompeticoes = this.competicaoDAO.lerTodos();
		}
		return listCompeticoes;
	}

	public void setListCompeticoes(List<Competicao> listCompeticoes) {
		this.listCompeticoes = listCompeticoes;
	}

	public TipoDeCompeticao[] getTipoDeCompeticao() {
		return TipoDeCompeticao.values();
	}

	public Duracao[] getDuracao() {
		return Duracao.values();
	}

	public String salvarCompeticao() {

		try {

			if ((this.getCompeticao().getId() != null) && (this.getCompeticao().getId().longValue() == 0))
				this.getCompeticao().setId(null);

			this.competicaoDAO.salvar(this.getCompeticao());
			this.listCompeticoes = null;
			this.setCompeticao(new Competicao());

		} catch (Exception e) {

			System.out.println(e);
		}

		return "";
	}

	public String cancelarComepticao() {

		this.setCompeticao(new Competicao());

		return "/pages/indexSistema.jsf";
	}

	public String novaCompeticao() {

		this.setCompeticao(new Competicao());
		return "editarCompeticao";
	}

}
