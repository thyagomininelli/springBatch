package br.com.infraestrutura.diretorios;

import java.io.File;

import org.springframework.stereotype.Service;

/** 
 * 
 * @author lincoln.coelho
 * 
 */ 
@Service
public class GerenciadorArquivos implements IGerenciadorArquivos {

	@Override
	public void moverArquivosEntreDiretorios(String origem, String destino) {
		File arquivosDiretorioOrigem = new File(origem);
		File diretorioDestino = new File(destino);

		File arrayArquivos[] = arquivosDiretorioOrigem.listFiles();

		File arquivo;

		int i = 0;

		if (arrayArquivos.length > 0) {
			for (int j = arrayArquivos.length; i < j; i++) {
				arquivo = arrayArquivos[i];
				moveArquivoParaDiretorio(diretorioDestino, arquivo);
			}
		} else {
		}
	}

	@Override
	public void moveArquivoParaDiretorio(File diretorioDestino, File arquivo) {
		arquivo.renameTo(new File(diretorioDestino, arquivo.getName()));
	}

}
