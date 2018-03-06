package enuns;

public enum TipoDeJuiz {

	ARBITRO_PRINCIPAL("Árbitro Principal"), 
	ARBITRO_ASSISTENTE1("Árbitro Bandeirinha 1"), 
	ARBITRO_ASSISTENTE2("Árbitro Bandeirinha 2"),
	ARBITRO_RESERVA("Árbitro Reserva");
	
	private String descricao;

	TipoDeJuiz(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
