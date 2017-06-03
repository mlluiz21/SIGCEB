package controle;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import modelo.dao.EquipeDAO;
import modelo.dao.JogosDAO;
import modelo.dominio.Equipe;
import modelo.dominio.Jogos;

@SuppressWarnings("serial")
@ManagedBean (name = "JogosMBController")
@RequestScoped
public class JogosMB_Controller implements Serializable{

	private Jogos jogo = new Jogos();
	private JogosDAO jogDAO = new JogosDAO();
	private List<Jogos> jogos = null;
	
	private Equipe equipe = new Equipe();
	private EquipeDAO equiDAO = new EquipeDAO();
	private List<Equipe> equipes = null;
}
