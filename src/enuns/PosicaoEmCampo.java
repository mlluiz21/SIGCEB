package enuns;

public enum PosicaoEmCampo {

	ARMADOR("Armador"),
	ALA("Ala"),
	ALA_ARMADOR("Ala Armador"),
	ALA_PIVO("Ala Pivô"),
	ALA_DIREITO("Ala direito"),
	ALA_ESQUERDO("Ala esquerdo"),
	ATACANTE("Atacante"),
	CENTRAL_ARMADOR("Central Armador"),
	CENTROAVANTE_OU_AVANCADO_CENTRO("Centroavante ou Avançado-centro"),
	FIXO("Fixo"),
	GOLEIRO("Goleiro"),
	GUARDA_REDES("Guarda Redes"),
	LATERAL_ESQUERDO("Lateral esquerdo"), 
	LATERAL_DIREITO("Lateral direito"),
	LEVANTADOR("Levantador"),
	LIBERO("Líbero"),
	MEIO("Meio"),
	MEIO_DE_CAMPO("Meio de campo"), 
	MEIA_DE_LIGACAO_OU_APOIADOR("Meia de ligação ou Apoiador"),
	MEIA_ATACANTE("Meia atacante"),
	MEIA_OFENSIVO("Meia ofensivo"),
	MEIA_DEFENSIVO("Meia defensivo"),
	MEDIO_OFENSIVO("Médio ofensivo"),
	MEDIO_DEFENSIVO("Médio defensivo"),
	OPOSTO("Oposto"),
	PASSADOR("Passador"),
	PIVO("Pivô"),
	PONTA("Ponta"),
	PONTA_ESQUERDA("Ponta esquerda"),
	PONTA_DIREITA("Ponta direita"),
	SEGUNDO_ATACANTE("Segundo atacante"),
	VOLANTE_OU_CABECA_DE_AREA("Volante ou Cabeça-de-Área"),
	ZAGUEIRO("Zagueiro");
	
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
