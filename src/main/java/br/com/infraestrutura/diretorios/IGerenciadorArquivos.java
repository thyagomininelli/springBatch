package br.com.infraestrutura.diretorios;

import java.io.File;

/** 
 * 
 * @author lincoln.coelho
 * 
 */ 
public interface IGerenciadorArquivos {

	public void moverArquivosEntreDiretorios(String origem, String destino);
	
	public void moveArquivoParaDiretorio(File diretorioDestino, File arquivo);
	
}
