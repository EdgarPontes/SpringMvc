package br.com.tecnonoticias.ecommerce.model;

public enum NomeEstados {
	
	ACRE("Acre"),
	ALAGOAS("Alagoas"),
	AMAZONAS("Amazonas"),
	AMAPA("Amapa"),
	BAHIA("Bahia"),
	CEARA("Ceara"),
	DISTRITO_FEDERAL("Distrito Federal"),
	ESPIRITO_SANTO("Espirito Santo"),
	GOIAS("Goias"),
	MARANHAO("Maranhão"),
	MATO_GROSSO("Mato Grosso"),
	MATO_GROSSO_DO_SUL("Mato Grosso do Sul"),
	MINAS_GERAIS("Minas Gerais"),
	PARA("Pará"),
	PARAIBA("Paraiba"),
	PARANA("Paraná"),
	PERNAMBUCO("Pernambuco"),
	PIAUI("Piaui"),
	RIO_DE_JANEIRO("Rio de Janeiro"),
	RIO_GRANDE_DO_NORTE("Rio Grande do Norte"),
	RIO_GRANDE_DO_SUL("Rio Grande do Sul"),
	RONDONIA("Rondonia"),
	RORAIMA("Roraima"),
	SANTA_CATARINA("Santa Catarina"),
	SERGIPE("Sergipe"),
	SAO_PAULO("São Paulo"),
	TOCANTINS("Tocantins");
	
	private String descricao;
	
	NomeEstados(String descricao){
		
		this.descricao = descricao;
		 
	}
	
	public String getDescricao(){
		
		return descricao;
		
	}

}
