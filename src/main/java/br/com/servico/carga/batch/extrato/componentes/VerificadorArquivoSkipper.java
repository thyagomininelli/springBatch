package br.com.servico.carga.batch.extrato.componentes;

import org.springframework.batch.core.step.skip.SkipLimitExceededException;
import org.springframework.batch.core.step.skip.SkipPolicy;
import org.springframework.batch.item.file.FlatFileParseException;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.servico.carga.dto.ErroCarga;
import br.com.servico.carga.orquestracao.OrquestradorCargaExtrato;
import br.com.servico.carga.repository.IErroCargaRepository;

/**
 * Caso ocorra qualquer erro no parser do arquivo, será disparado o método shouldSkip abaixo.
 * Esse método será responsável em:
 * 
 *    1)LOGAR NA TABELA DE ERRO O PROBLEMA
 *    2)RETORNAR O ERRO(FALHA) PARA O FLUXO PRINCIPAL
 */
public class VerificadorArquivoSkipper implements SkipPolicy {

	@Autowired
	OrquestradorCargaExtrato orquestradorCargaExtrato;
	
	@Autowired
	IErroCargaRepository erroCargaRepository;
	
	@Override
    public boolean shouldSkip(Throwable exception, int skipCount) throws SkipLimitExceededException {

		try {
			orquestradorCargaExtrato.setArquivoValido(false);
			
			FlatFileParseException flatFileParseException = (FlatFileParseException) exception;
			
			String tipoRegistro = "LINHA " + String.valueOf(flatFileParseException.getLineNumber()); 
			
			ErroCarga erroCarga = new ErroCarga(orquestradorCargaExtrato.getIdControleCarga(), tipoRegistro , flatFileParseException.getMessage());
			erroCargaRepository.save(erroCarga);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return false;
    }
}