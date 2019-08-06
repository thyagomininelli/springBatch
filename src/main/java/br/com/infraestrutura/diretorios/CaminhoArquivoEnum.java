package br.com.infraestrutura.diretorios;

/** 
 * 
 */ 
public enum CaminhoArquivoEnum {
	
	BANCO_ITAU_EXTRATO_CAMINHO_DIRETORIO_ENTRADA("/data/brinks/bancoitau/entrada/extrato/"),
	BANCO_ITAU_EXTRATO_CAMINHO_DIRETORIO_EXECUCAO("/data/brinks/bancoitau/execucao/extrato/"), 
	BANCO_ITAU_EXTRATO_CAMINHO_DIRETORIO_SUCESSO("/data/brinks/bancoitau/sucesso/extrato/"),
	BANCO_ITAU_EXTRATO_CAMINHO_DIRETORIO_ERRO("/data/brinks/bancoitau/erro/extrato/"),
	BANCO_ITAU_EXTRATO_CAMINHO_ARQUIVO_EXECUCAO("file:/data/brinks/bancoitau/execucao/extrato/*");
	
	private String caminho;

	private CaminhoArquivoEnum(String caminho) {
		this.caminho = caminho;
	}

	public String getCaminho() {
		return caminho;
	}

}
