package testes;

import modelo.dao.EquipeDAO;
import modelo.dominio.Equipe;


public class TesteUnitEquipe {

	public static void main(String[] args) {
		
		Equipe equipe = new Equipe();
		
		equipe.setId(null);
		equipe.setNomeFantasia("Fla");
		equipe.setBairro("SB");
		equipe.setTecnico("Mar");
		equipe.setResponsavelPorEquipeTecnico(null);
		
		EquipeDAO equiDAO = new EquipeDAO();
		
		equiDAO.salvar(equipe);

	}

}
