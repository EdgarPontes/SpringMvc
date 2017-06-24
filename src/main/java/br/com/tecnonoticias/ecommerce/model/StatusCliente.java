package br.com.tecnonoticias.ecommerce.model;

public enum StatusCliente {
	
	ATIVO("Ativo"),
	INATIVO("Inativo");
	
	private String descricao;
	
	StatusCliente(String descricao){
		
		this.descricao = descricao;
		 
	}
	
	public String getDescricao(){
		
		return descricao;
		
	}

}
