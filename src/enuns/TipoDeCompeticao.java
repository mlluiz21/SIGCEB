package enuns;

public enum TipoDeCompeticao {

	AMISTOSO("Amistoso"),
	LIGA("Liga"),
	TORNEIO("Torneio");
	
	private String descricao;
	
	private TipoDeCompeticao(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
