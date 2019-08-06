package br.com.servico.carga.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.servico.carga.dao.IErroCargaDAO;
import br.com.servico.carga.dto.ErroCarga;
import br.com.servico.carga.repository.IErroCargaRepository;

@Service
public class ErroCargaService implements IErroCargaDAO{
	
	@Autowired
	IErroCargaRepository erroCargaRepository;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public Integer incluirErroCarga(ErroCarga erroCarga) throws Exception {
		return erroCargaRepository.save(erroCarga).getIdErroCarga();
	}

}
