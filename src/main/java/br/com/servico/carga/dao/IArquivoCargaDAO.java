package br.com.servico.carga.dao;


import br.com.servico.carga.dto.ArquivoCarga;



public interface IArquivoCargaDAO {
	
	public Long incluirArquivoCarga(ArquivoCarga arquivoCarga) throws Exception;

	public ArquivoCarga obterArquivoCargaPorId(Long idArquivoCarga) throws Exception;


} 
