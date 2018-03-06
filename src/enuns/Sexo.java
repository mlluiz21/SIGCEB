package enuns;

public enum Sexo {

	F("Feminino"), M("Masculino");
	
	private String descricao;
	
	Sexo (String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
		
}