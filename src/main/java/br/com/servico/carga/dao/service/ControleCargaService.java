package br.com.servico.carga.dao.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.servico.carga.dao.IControleCargaDAO;
import br.com.servico.carga.dto.ControleCarga;
import br.com.servico.carga.repository.IControleCargaRepository;

@Service
public class ControleCargaService implements IControleCargaDAO{

	@Autowired
	private IControleCargaRepository controleCargaRepository;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Long incluirControleCarga(ControleCarga controleCarga) throws Exception {
		return controleCargaRepository.save(controleCarga).getIdControleCarga();
	}

	@Override
	public Long atualizarControleCarga(ControleCarga controleCarga) throws Exception {
		return controleCargaRepository.save(controleCarga).getIdControleCarga();
	}

	@Override
	public ControleCarga obterControleCargaPorId(Long idControleCarga) throws Exception {
		Optional<ControleCarga> result = controleCargaRepository.findById(idControleCarga);
		return result.get();
	}

}
