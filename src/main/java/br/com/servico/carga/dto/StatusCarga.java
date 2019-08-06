package br.com.servico.carga.dto;

public enum StatusCarga {

	EXECUCAO("EXECUCAO"),
	
	CARGA_SUCESSO("CARGA_SUCESSO"),
	
	CARGA_ERRO("CARGA_ERRO"),
	
	PROCESSANDO("PROCESSANDO"),
	
	PROCESSO_SUCESSO("PROCESSO_SUCESSO"),
	
	PROCESSO_ERRO("PROCESSO_ERRO");
	
	private String codigo;

	StatusCarga(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
}
