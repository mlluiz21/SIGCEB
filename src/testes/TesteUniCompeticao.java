package testes;

import java.util.Date;

import modelo.dao.CompeticaoDAO;
import modelo.dominio.Competicao;

public class TesteUniCompeticao {

	public static void main(String[] args) {
		
		Competicao compet = new Competicao();
		
		compet.setDataDeCadastro(Date());
		compet.setDataDeInicio(Date());
		compet.setDuracao(null);
		compet.setNomeDaCompeticao("Teste Compeonato");
		compet.setQuantidadeDeEquipes(1);
		compet.setQuantidadeDeGrupos(6);
		compet.setRegrasDaCompeticao("Vai cadastrar o a competição");
		
		
		CompeticaoDAO compDao = new CompeticaoDAO();
		compDao.salvar(compet);
		
		System.out.println("Competição " + compet.getNomeDaCompeticao() + "com sucesso");
		
	}

	private static Date Date() {
		// TODO Auto-generated method stub
		return null;
	}
}
