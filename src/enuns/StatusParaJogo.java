package enuns;

public enum StatusParaJogo {

	CONTUNDIDO("Contundido(a)"),
	LICENCA_MEDICA("Licença Médica"),
	SUSPENSO("Suspenso(a)"),
	JOGANDO("Jogando"),
	AUSENTE("Ausente");
	
	private String descricao;
	
	private StatusParaJogo(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
