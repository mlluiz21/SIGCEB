package enuns;

public enum TipoDeUsuario {

	ATLETA("Atleta"), 
	ARBITRO("Árbitro"),
	ORGANIZADOR("Organizador ou Instituição"), 
	RESPONSAVEL_EQUIPE("Responsável por Equipe");
	
	private String descricao;

	TipoDeUsuario(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
