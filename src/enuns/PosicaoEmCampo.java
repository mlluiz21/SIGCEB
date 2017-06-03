package enuns;

public enum PosicaoEmCampo {

	GOLEIRO("Goleiro"), 
	MEIO_DE_CAMPO("Meio de campo"), 
	LATERAL_ESQUERDO("Lateral esquerdo"), 
	LATERAL_DIREITO("Lateral direito"),
	ZAGUEIRO("Zagueiro"),
	LIBERO("Líbero"),
	VOLANTE_OU_CABECA_DE_AREA("Volante ou Cabeça-de-área"),
	ARMADOR("Armador"),
	ALA_DIREITO("Ala direito"),
	ALA_ESQUERDO("Ala esquerdo"),
	MEIA_DE_LIGACAO_OU_APOIADOR("Meia de ligação ou Apoiador"),
	MEIA_ATACANTE("Meia atacante"),
	MEIA_OFENSIVO("Meia ofensivo"),
	MEIA_DEFENSIVO("Meia defensivo"),
	MEDIO_OFENSIVO("Médio ofensivo"),
	MEDIO_DEFENSIVO("Médio defensivo"),
	PONTA_ESQUERDA("Ponta esquerda"),
	PONTA_DIREITA("Ponta direita"),
	ATACANTE("Atacante"),
	SEGUNDO_ATACANTE("Segundo atacante"),
	CENTROAVANTE_OU_AVANCADO_CENTRO("Centroavante ou Avançado-centro");
	
	private String descricao;
	
	PosicaoEmCampo(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	
}
