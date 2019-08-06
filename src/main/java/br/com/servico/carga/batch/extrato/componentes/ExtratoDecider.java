package br.com.servico.carga.batch.extrato.componentes;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;
import org.springframework.stereotype.Component;


@Component
public class ExtratoDecider implements JobExecutionDecider {

	
	public FlowExecutionStatus decide(JobExecution jobExecution, StepExecution stepExecution) {
		return FlowExecutionStatus.COMPLETED;
		/*if(orquestradorCargaExtrato.isArquivoValido()){
			return FlowExecutionStatus.COMPLETED;
		} else {
			return FlowExecutionStatus.FAILED;
		}*/
	}
}
