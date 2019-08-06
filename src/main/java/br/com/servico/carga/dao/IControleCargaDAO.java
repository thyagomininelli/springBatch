package br.com.servico.carga.dao;

import br.com.servico.carga.dto.ControleCarga;

public interface IControleCargaDAO {

	public Long incluirControleCarga(ControleCarga controleCarga) throws Exception;

	public Long atualizarControleCarga(ControleCarga controleCarga) throws Exception;

	public ControleCarga obterControleCargaPorId(Long idControleCarga) throws Exception;
	
}
