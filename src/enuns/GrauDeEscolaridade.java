package enuns;

public enum GrauDeEscolaridade {

	EFI("Ens. Fundamental - Incompleto"), 
	EFC("Ens. Fundamental - Completo"), 
	EMI("Ens. Médio - Incompleto"),
	EMC("Ens. Médio - Completo"),
	ESI("Graduação - Incompleto"),
	ESC("Graduação - Completo");

	private String descricao;
	
	GrauDeEscolaridade(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
}
