package br.com.servico.carga.extrato.dao;

import br.com.servico.carga.extrato.dto.ExtratoDetailLoteDTO;
import br.com.servico.carga.extrato.dto.ExtratoHeaderArquivoDTO;
import br.com.servico.carga.extrato.dto.ExtratoHeaderLoteDTO;
import br.com.servico.carga.extrato.dto.ExtratoTrailerArquivoDTO;
import br.com.servico.carga.extrato.dto.ExtratoTrailerLoteDTO;

public interface IExtratoDAO {
	
	public void incluirExtratoHeaderArquivo(ExtratoHeaderArquivoDTO extratoHeaderArquivoDTO) throws Exception;
	
	public void incluirExtratoHeaderLote(ExtratoHeaderLoteDTO extratoHeaderLoteDTO) throws Exception;
	
	public void incluirExtratoDetailLote(ExtratoDetailLoteDTO extratoDetailLoteDTO) throws Exception;
	
	public void incluirExtratoTrailerLote(ExtratoTrailerLoteDTO extratoTrailerLoteDTO) throws Exception;
	
	public void incluirExtratoTrailerArquivo(ExtratoTrailerArquivoDTO extratoTrailerArquivoDTO) throws Exception;
}
