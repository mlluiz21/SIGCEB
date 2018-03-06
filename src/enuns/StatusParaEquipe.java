package enuns;

public enum StatusParaEquipe {

	DISPONIVEL("Disponível"),
	INDISPONIVEL("Indisponível");
	
	private String descricao;

	private StatusParaEquipe(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
		
}
