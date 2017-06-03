package controle;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import modelo.dominio.Solicitante;
import modelo.dominio.Usuario;

@ManagedBean(name = "SolicitarParticipacaoMBController")
@RequestScoped
public class SolicitarParticipacaoMB_Controller implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	private Solicitante solicitante;
	private List<Solicitante> listSolicitacoes;
		
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Solicitante getSolicitante() {
		return solicitante;
	}
	public void setSolicitante(Solicitante solicitante) {
		this.solicitante = solicitante;
	}
	public List<Solicitante> getListSolicitacoes() {
		return listSolicitacoes;
	}
	public void setListSolicitacoes(List<Solicitante> listSolicitacoes) {
		this.listSolicitacoes = listSolicitacoes;
	}
	
	public String enviarSolicitacao(){
		
		return "";		
	}
}
