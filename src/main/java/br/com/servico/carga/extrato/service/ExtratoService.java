package br.com.servico.carga.extrato.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.servico.carga.extrato.dao.IExtratoDAO;
import br.com.servico.carga.extrato.dto.ExtratoDetailLoteDTO;
import br.com.servico.carga.extrato.dto.ExtratoHeaderArquivoDTO;
import br.com.servico.carga.extrato.dto.ExtratoHeaderLoteDTO;
import br.com.servico.carga.extrato.dto.ExtratoTrailerArquivoDTO;
import br.com.servico.carga.extrato.dto.ExtratoTrailerLoteDTO;
import br.com.servico.carga.extrato.repository.IExtratoDetailLoteRepository;
import br.com.servico.carga.extrato.repository.IExtratoHeaderArquivoRepository;
import br.com.servico.carga.extrato.repository.IExtratoHeaderLoteDTORepository;
import br.com.servico.carga.extrato.repository.IExtratoTrailerArquivoDTORepository;
import br.com.servico.carga.extrato.repository.IExtratoTrailerLoteDTORepository;
import br.com.servico.carga.orquestracao.OrquestradorCargaExtrato;

@Service
public class ExtratoService implements IExtratoDAO{
	
	@Autowired
	private IExtratoHeaderArquivoRepository extratoHeaderArquivoRepository;
	
	@Autowired
	private IExtratoHeaderLoteDTORepository extratoHeaderLoteDTORepositor;
	
	@Autowired
	private IExtratoDetailLoteRepository extratoDetailLoteRepository;
	
	@Autowired
	private IExtratoTrailerLoteDTORepository extratoTrailerLoteDTORepository;
	
	@Autowired
	private IExtratoTrailerArquivoDTORepository extratoTrailerArquivoDTORepository;
	
	@Autowired
	private OrquestradorCargaExtrato orquestradorCargaExtrato;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public void incluirExtratoHeaderArquivo(ExtratoHeaderArquivoDTO extratoHeaderArquivoDTO) throws Exception {
		
		extratoHeaderArquivoDTO.setIdArquivoCarga(orquestradorCargaExtrato.getIdArquivoCarga());
		extratoHeaderArquivoRepository.save(extratoHeaderArquivoDTO);
		
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public void incluirExtratoHeaderLote(ExtratoHeaderLoteDTO extratoHeaderLoteDTO) throws Exception {
		
		extratoHeaderLoteDTO.setIdArquivoCarga(orquestradorCargaExtrato.getIdArquivoCarga());
		extratoHeaderLoteDTORepositor.save(extratoHeaderLoteDTO);
		
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void incluirExtratoDetailLote(ExtratoDetailLoteDTO extratoDetailLoteDTO) throws Exception {
		
		extratoDetailLoteDTO.setIdArquivoCarga(orquestradorCargaExtrato.getIdArquivoCarga());
		extratoDetailLoteRepository.save(extratoDetailLoteDTO);
		
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void incluirExtratoTrailerLote(ExtratoTrailerLoteDTO extratoTrailerLoteDTO) throws Exception {
		
		extratoTrailerLoteDTO.setIdArquivoCarga(orquestradorCargaExtrato.getIdArquivoCarga());
		extratoTrailerLoteDTORepository.save(extratoTrailerLoteDTO);
		
	}	

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void incluirExtratoTrailerArquivo(ExtratoTrailerArquivoDTO extratoTrailerArquivoDTO) throws Exception {
		
		extratoTrailerArquivoDTO.setIdArquivoCarga(orquestradorCargaExtrato.getIdArquivoCarga());
		extratoTrailerArquivoDTORepository.save(extratoTrailerArquivoDTO);
		
	}
}
