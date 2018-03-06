package enuns;

public enum TipoSanguineo {

	A("A+"),
	A_MENOS("A-"),
	B("B+"),
	B_MENOS("B-"),
	AB("AB+"),
	AB_MENOS("AB-"),
	O("O+"),
	O_MENOS("O-");
	
	private String descricao;
	
	TipoSanguineo (String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
