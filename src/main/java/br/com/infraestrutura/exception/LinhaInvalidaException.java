package br.com.infraestrutura.exception;


public class LinhaInvalidaException extends Exception {

	private static final long serialVersionUID = 1569331160493705539L;
	
	private String tipoRegistro;
	private String descricao;
	
	public LinhaInvalidaException(String tipoRegistro, String descricao) {
		this.tipoRegistro = tipoRegistro;
		this.descricao = descricao;
	}
	
	public String getTipoRegistro() {
		return tipoRegistro;
	}

	public String getDescricao() {
		return descricao;
	}

}
