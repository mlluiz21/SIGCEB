package enuns;

public enum TipoDeJuiz {

	ARBITRO_PRINCIPAL("햞bitro Principal"), 
	ARBITRO_ASSISTENTE1("햞bitro Bandeirinha 1"), 
	ARBITRO_ASSISTENTE2("햞bitro Bandeirinha 2"),
	ARBITRO_RESERVA("햞bitro Reserva");
	
	private String descricao;

	TipoDeJuiz(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
