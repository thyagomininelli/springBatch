package br.com.servico.carga.dto;
public enum Parceiro {

	BANCO_ITAU("BANCO_ITAU");
	
	private String codigo;

	Parceiro(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}
	
}
