package controle;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import enuns.TipoDeCompeticao;
import modelo.dao.CriarEventoDAO;
import modelo.dominio.CriarEvento;

@ManagedBean(name = "CriarEventoMBController")
@RequestScoped
public class CriarEventoMB_Controller implements Serializable {

	private static final long serialVersionUID = 1L;
	private CriarEvento novoEvento = new CriarEvento();
	private List<CriarEvento> eventos = null;
	private CriarEventoDAO evenDAO = new CriarEventoDAO();

	public CriarEvento getNovoEvento() {
		return novoEvento;
	}

	public void setNovoEvento(CriarEvento novoEvento) {
		this.novoEvento = novoEvento;
	}

	public List<CriarEvento> getEventos() {
		if (this.eventos == null) {
			this.eventos = this.evenDAO.lerTodos();
		}
		return eventos;
	}

	public void setEventos(List<CriarEvento> eventos) {
		this.eventos = eventos;
	}

	public CriarEventoDAO getEvenDAO() {
		return evenDAO;
	}

	public void setEvenDAO(CriarEventoDAO evenDAO) {
		this.evenDAO = evenDAO;
	}

	public TipoDeCompeticao[] getTipoDeCompeticao() {
		return TipoDeCompeticao.values();
	}

	public String criarEvento() {

		try {

			if ((this.getNovoEvento().getId() != null) && (this.getNovoEvento().getId().longValue() == 0))
				this.getNovoEvento().setId(null);

			this.evenDAO.salvar(this.getNovoEvento());
			this.eventos = null;
			this.setNovoEvento(new CriarEvento());

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

		return "/pages/pagina.jsf?faces-redirect=true";
		// return abrirNovoCampeonatos();
	}

	public String abrirNovoEvento() {

		return "/pages/pagina.jsf?faces-redirect=true";
	}

	public String cancelarEvento(){
	
		this.setNovoEvento(getNovoEvento());
		
		return "/pages/indexSistema.jsf";	
	}
}
