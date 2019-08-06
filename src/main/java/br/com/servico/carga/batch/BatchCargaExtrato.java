package br.com.servico.carga.batch;

import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.skip.SkipPolicy;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionAttribute;

import br.com.infraestrutura.batch.JobCompletionNotificationListener;
import br.com.infraestrutura.batch.MoverArquivoTasklet;
import br.com.infraestrutura.diretorios.CaminhoArquivoEnum;
import br.com.servico.carga.batch.extrato.componentes.ExtratoDecider;
import br.com.servico.carga.batch.extrato.componentes.ExtratoProcessor;
import br.com.servico.carga.batch.extrato.componentes.ExtratoReader;
import br.com.servico.carga.batch.extrato.componentes.ExtratoValidaEstruturaArquivoProcessor;
import br.com.servico.carga.batch.extrato.componentes.ExtratoWriter;
import br.com.servico.carga.batch.extrato.componentes.VerificadorArquivoSkipper;
import br.com.servico.carga.extrato.dto.ExtratoDTO;

@Configuration
public class BatchCargaExtrato {
	
	private static final Logger LOGGER = Logger.getLogger(BatchCargaExtrato.class.getName());
	
	@Autowired
	private JobBuilderFactory job;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job carregarExtratoJob(
			@Qualifier("step1_ValidaEstruturaArquivoExtrato") Step step1_ValidaEstruturaArquivoExtrato,
			@Qualifier("step2_LerProcessarEscreverArquivoExtrato") Step step2_LerProcessarEscreverArquivoExtrato,
			@Qualifier("step3_MoverArquivoExtratoParaSucesso") Step step3_MoverArquivoExtratoParaSucesso,
			@Qualifier("step4_MoverArquivoExtratoParaErro") Step step4_MoverArquivoExtratoParaErro,
			ExtratoDecider extratoDecider) throws Exception {

		FlowBuilder<Flow> flowBuilder = new FlowBuilder<Flow>("flowCarregarExtratoJob");
		
		Flow flow = flowBuilder
				.start(step1_ValidaEstruturaArquivoExtrato)
				.on(FlowExecutionStatus.FAILED.getName())
				.to(step4_MoverArquivoExtratoParaErro)
				.from(step1_ValidaEstruturaArquivoExtrato)
				.next(extratoDecider)
				.on(FlowExecutionStatus.COMPLETED.getName())
				.to(step2_LerProcessarEscreverArquivoExtrato)
				.on(FlowExecutionStatus.FAILED.getName())
				.to(step4_MoverArquivoExtratoParaErro)
				.from(step2_LerProcessarEscreverArquivoExtrato)				
				.on(FlowExecutionStatus.COMPLETED.getName())
				.to(step3_MoverArquivoExtratoParaSucesso)
				.from(extratoDecider)
				.on(FlowExecutionStatus.FAILED.getName()).to(step4_MoverArquivoExtratoParaErro).build();

		return job.get("jobCarregarExtratoJob").incrementer(new RunIdIncrementer()).start(flow).end().build();
	}
	
	@Bean
	public Step step1_ValidaEstruturaArquivoExtrato() throws Exception {
		LOGGER.info("Step1 - ValidaEstruturaArquivoExtrato");
		return stepBuilderFactory.get("step1_ValidaEstruturaArquivoExtrato").<FieldSet, ExtratoDTO> chunk(500)
				.faultTolerant().noRollback(Exception.class).reader(readExtrato()).faultTolerant()
				.skipPolicy(verificadorArquivoSkipperExtrato())
				.processor(processorValidaEstruturaArquivoExtrato()).build();
	}
	
	@Bean
	public Step step2_LerProcessarEscreverArquivoExtrato() throws Exception {
		LOGGER.info("Step2 - LerProcessarEscreverArquivoExtrato");
		DefaultTransactionAttribute defaultTransactionAttribute = new DefaultTransactionAttribute(
				TransactionAttribute.PROPAGATION_REQUIRED);

		// Cada chunk(pedaço do arquivo) é  processado em uma transação.
		return stepBuilderFactory.get("step2_LerProcessarEscreverArquivoExtrato").<FieldSet, ExtratoDTO> chunk(500)
				.faultTolerant().noRollback(Exception.class)
				.reader(readExtrato()).processor(processorExtrato()).writer(writerExtrato())
				.transactionAttribute(defaultTransactionAttribute).build();
	}

	@Bean
	protected Step step3_MoverArquivoExtratoParaSucesso() {
		LOGGER.info("Step3 - MoverArquivoExtratoParaSucesso");
		return stepBuilderFactory.get("step3_MoverArquivoExtratoParaSucesso")
				.tasklet(new MoverArquivoTasklet(
						CaminhoArquivoEnum.BANCO_ITAU_EXTRATO_CAMINHO_DIRETORIO_EXECUCAO.getCaminho(),
						CaminhoArquivoEnum.BANCO_ITAU_EXTRATO_CAMINHO_DIRETORIO_SUCESSO.getCaminho()))
				.build();
	}

	@Bean
	protected Step step4_MoverArquivoExtratoParaErro() {
		LOGGER.info("Step4 - MoverArquivoExtratoParaErro");
		return stepBuilderFactory.get("step4_MoverArquivoExtratoParaErro")
				.tasklet(new MoverArquivoTasklet(
						CaminhoArquivoEnum.BANCO_ITAU_EXTRATO_CAMINHO_DIRETORIO_EXECUCAO.getCaminho(),
						CaminhoArquivoEnum.BANCO_ITAU_EXTRATO_CAMINHO_DIRETORIO_ERRO.getCaminho()))
				.build();
	}
	
	
	/**Caso ocorra qualquer problema no parser do arquivo, será invocado o
	 * método shouldSkip da classe VerificadorArquivoSkipper.*/
	@Bean
	public SkipPolicy verificadorArquivoSkipperExtrato() {
		return new VerificadorArquivoSkipper();
	}
	
	
	@Bean
	@StepScope
	public MultiResourceItemReader<FieldSet> readExtrato() throws Exception {
		LOGGER.info("Leitura do Arquivo de Extrato");
		return new ExtratoReader().read();
	}

	@Bean
	public ExtratoValidaEstruturaArquivoProcessor processorValidaEstruturaArquivoExtrato() {
		LOGGER.info("Validação de Estrutura do Arquivo");
		return new ExtratoValidaEstruturaArquivoProcessor();
	}

	@Bean
	@StepScope
	public ExtratoProcessor processorExtrato() {
		LOGGER.info("Processamento do Arquivo de Extrato");
		return new ExtratoProcessor();
	}

	@Bean
	public ExtratoWriter writerExtrato() throws Exception {
		LOGGER.info("Armazenamento do Arquivo de Extrato no Banco de Dados");
		return new ExtratoWriter();
	}

	@Bean
	public JobExecutionListener listenerGarantiaEstendida() {
		return new JobCompletionNotificationListener();
	}
}
