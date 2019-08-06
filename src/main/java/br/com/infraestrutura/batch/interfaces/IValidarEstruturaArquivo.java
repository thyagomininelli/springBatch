package br.com.infraestrutura.batch.interfaces;

public interface IValidarEstruturaArquivo {
	
	public void validarObrigatoriedadeDoCampo(String nomeCampo, String valorCampo, String parteLayout) throws Exception;
	
	public void validarTipagemDoCampo(String nomeCampo, String valorCampo, String parteLayout) throws Exception;

}
