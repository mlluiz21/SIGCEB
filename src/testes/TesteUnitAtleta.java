package testes;

import java.util.Date;

import modelo.dao.AtletaDAO;
import modelo.dominio.Atleta;


public class TesteUnitAtleta {

	public static void main(String[] args) {
		
		Atleta atleta = new Atleta();
		
		/*SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");*/
		Date dataAtual = new Date(System.currentTimeMillis());
		
		
		atleta.setId(null);
		atleta.setDataDeCadastro(dataAtual);
		atleta.setPosicaoEmCampo(null);
		atleta.setStatusParaEquipe(null);
		atleta.setStatusParaJogo(null);
		
		AtletaDAO atleDAO = new AtletaDAO();
		
		atleDAO.salvar(atleta);

	}

}
