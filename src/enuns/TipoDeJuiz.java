package enuns;

public enum TipoDeJuiz {

	ARBITRO_PRINCIPAL("�rbitro Principal"), 
	ARBITRO_ASSISTENTE1("�rbitro Bandeirinha 1"), 
	ARBITRO_ASSISTENTE2("�rbitro Bandeirinha 2"),
	ARBITRO_RESERVA("�rbitro Reserva");
	
	private String descricao;

	TipoDeJuiz(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
