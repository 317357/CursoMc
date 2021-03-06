package com.ronaldo.CursoMc.domain.enums;

public enum TipoCliente {
	
	PESSOAFISICA (1,"Pessoa Física"),
	PESSOAJURIDICA (2,"Pessoa Jurídica");
	
	private int cod;
	private String descricao;
	
	private TipoCliente(int cod, String descricao) {
		this.cod=cod;
		this.descricao=descricao;
		
		}
	
	public int getcod() {
		return cod;
	}
	
	public String getdescricao() {
		return descricao;
		
	}
	
	public static TipoCliente Toenum(Integer cod) {
		
		if(cod==null) {
			return null;
		}
		for(TipoCliente x: TipoCliente.values()) {
			
			if(cod.equals(x.getcod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido:"+ cod);
			
	}
		
	
	

}
