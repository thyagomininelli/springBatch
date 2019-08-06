package br.com.service.carga.agendamento;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import br.com.infraestrutura.batch.interfaces.IAgendadorCarga;
import br.com.servico.carga.orquestracao.OrquestradorCargaExtrato;

@Service
public class AgendadorCargaExtrato implements IAgendadorCarga{
	
	private static final Logger LOGGER = Logger.getLogger(AgendadorCargaExtrato.class.getName());

	@Autowired
	OrquestradorCargaExtrato orquestradorCargaExtrato;
	
	// Carga sera realizada diariamente as 10:00 e 22:00.
	// @Scheduled(cron = "0 * 10,22 * * *")
	@Override
	@Scheduled(cron = "*/10 * * * * *")
	public void executarCarga() {
		
		LOGGER.info("Inicio - AgendadorCargaExtrato.executarCarga");
		orquestradorCargaExtrato.executarCarga();
		LOGGER.info("Fim - AgendadorCargaExtrato.executarCarga");
	}
}
