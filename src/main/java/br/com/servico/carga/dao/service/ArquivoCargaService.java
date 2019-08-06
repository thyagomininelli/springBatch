package br.com.servico.carga.dao.service;


import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.servico.carga.dao.IArquivoCargaDAO;
import br.com.servico.carga.dto.ArquivoCarga;
import br.com.servico.carga.repository.IArquivoCargaRepository;

@Service
public class ArquivoCargaService implements IArquivoCargaDAO{
	
	@Autowired
	private IArquivoCargaRepository arquivoCargaRepository;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Long incluirArquivoCarga(ArquivoCarga arquivoCarga) throws Exception {
		ArquivoCarga arq = null;
		
		try {
			
			arquivoCarga.setDataCarga(new Date());
			
			arq = arquivoCargaRepository.save(arquivoCarga);
			return arq.getIdArquivoCarga();
		}catch(Exception e) {
			throw e;
		}
		
	}

	@Override
	public ArquivoCarga obterArquivoCargaPorId(Long idArquivoCarga) throws Exception {
		Optional<ArquivoCarga> result = arquivoCargaRepository.findById(idArquivoCarga);
		return result.get();
	}


}
