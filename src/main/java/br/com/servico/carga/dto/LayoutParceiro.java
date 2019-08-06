package br.com.servico.carga.dto;


public enum LayoutParceiro {
	
	EXTRATO("EXTRATO");
	
	private String codigo;

	LayoutParceiro(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
}
