package enuns;

public enum Duracao {

	MES1("1 Mês"),
	MESES2("2 Meses"),
	MESES3("3 Meses"),
	MESES4("4 Meses"),
	MESES5("5 Meses"),
	MESES6("6 Meses"),
	MESES7("7 Meses"),
	MESES8("8 Meses"),
	MESES9("9 Meses"),
	MESES10("10 Meses"),
	MESES11("11 Meses"),
	ANO1("1 Ano");
			
	private String descricao;
	
	private Duracao(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
