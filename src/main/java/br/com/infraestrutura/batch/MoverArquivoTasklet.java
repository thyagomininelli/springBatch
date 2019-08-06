package br.com.infraestrutura.batch;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.log4j.Logger;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class MoverArquivoTasklet implements Tasklet {
	
	private static final Logger LOGGER = Logger.getLogger(MoverArquivoTasklet.class);
	
	private String origem;
	private String destino;
	
	public MoverArquivoTasklet(String origem, String destino) {
		this.origem = origem;
		this.destino = destino;
	}

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		
		JobParameters jobParameters = chunkContext.getStepContext().getStepExecution().getJobParameters();

		String nomeArquivo = jobParameters.getString("nomeArquivo");
		String renameArquivo = jobParameters.getString("renameArquivo");
		
		File arquivoOrigem = new File(origem + nomeArquivo);
		File arquivoDestino = new File(destino + renameArquivo + "_" + jobParameters.getLong("time"));
		
		if (!nomeArquivo.isEmpty()) {
			try {
				LOGGER.info(" Movendo o arquivo [" + arquivoOrigem.toPath() + "] para [" + arquivoDestino.toPath() + "].");
				Files.move(arquivoOrigem.toPath(), arquivoDestino.toPath(),java.nio.file.StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException ex) {
				LOGGER.error(ex);
				LOGGER.error("Não foi possível mover o arquivo [" + nomeArquivo + "] do diretório [" + origem + "] para o [" + destino + "].");
			}
		} else {
			LOGGER.info("Nao foram encontrados arquivos no diretorio: " + origem);
		}
		return RepeatStatus.FINISHED;
	}
}