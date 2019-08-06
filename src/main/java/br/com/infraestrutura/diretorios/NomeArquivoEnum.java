package br.com.infraestrutura.diretorios;

public enum NomeArquivoEnum {
	
	ITAU_CARGA_EXTRATO("6628377@9627813@ITAEXTRATO");
	
	private String nomeArquivo;

	private NomeArquivoEnum(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

}
