package enuns;

public enum TipoModalidade {

	BASQUETEBOL("Basquete"),
	HANDEBOL("Handebol"),
	FUTEBOL("Futebol de Campo"),
	FUTSAL("Futsal"),
	VOLEI("Vôlei");
	
	private String descricao;
	
	private TipoModalidade(String descricao) {
		this.descricao = descricao;	
	}

	public String getDescricao() {
		return descricao;
	}

}
