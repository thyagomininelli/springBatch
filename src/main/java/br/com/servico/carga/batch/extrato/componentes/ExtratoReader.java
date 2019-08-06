package br.com.servico.carga.batch.extrato.componentes;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemStream;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.PassThroughFieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.batch.item.file.transform.PatternMatchingCompositeLineTokenizer;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourceArrayPropertyEditor;

import br.com.infraestrutura.diretorios.CaminhoArquivoEnum;
import br.com.servico.carga.batch.extrato.layout.ExtratoDetailLoteLayout;
import br.com.servico.carga.batch.extrato.layout.ExtratoHeaderArquivoLayout;
import br.com.servico.carga.batch.extrato.layout.ExtratoHeaderLoteLayout;
import br.com.servico.carga.batch.extrato.layout.ExtratoTrailerArquivoLayout;
import br.com.servico.carga.batch.extrato.layout.ExtratoTrailerLoteLayout;

/** 
 */ 
public class ExtratoReader implements ItemReader<MultiResourceItemReader<FieldSet>>, ItemStream {

	private static final String HEADER_EXTRATO_ARQUIVO = "???????0*";
	private static final String HEADER_EXTRATO_LOTE = "???????1*";
	private static final String BODY_EXTRATO_LOTE = "???????3*";
	private static final String TRAILER_EXTRATO_LOTE = "???????5*";
	private static final String TRAILER_EXTRATO_ARQUIVO = "???????9*";

	private FlatFileItemReader<FieldSet> flatFileItemReader;
	private MultiResourceItemReader<FieldSet> multiResourceItemReader;

	@BeforeStep
	public void beforeStep(StepExecution stepExecution) {
		flatFileItemReader = new FlatFileItemReader<>();
	}

	@AfterStep
	public void afterStep(StepExecution stepExecution) {
		flatFileItemReader.close();
		multiResourceItemReader.close();
	}

	@Override
	public MultiResourceItemReader<FieldSet> read()
			throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		flatFileItemReader = new FlatFileItemReader<>();
		multiResourceItemReader = new MultiResourceItemReader<>();
		multiResourceItemReader.setResources(getArquivos());
		multiResourceItemReader.setStrict(true);
		flatFileItemReader.setStrict(true);
		final DefaultLineMapper<FieldSet> defaultLineMapper = new DefaultLineMapper<>();
		final PatternMatchingCompositeLineTokenizer orderFileTokenizer = new PatternMatchingCompositeLineTokenizer();
		orderFileTokenizer.setTokenizers(setTokenizers());
		defaultLineMapper.setLineTokenizer(orderFileTokenizer);

		defaultLineMapper.setFieldSetMapper(new PassThroughFieldSetMapper());

		flatFileItemReader.setLineMapper(defaultLineMapper);
		flatFileItemReader.afterPropertiesSet();
		defaultLineMapper.afterPropertiesSet();
		multiResourceItemReader.setDelegate(flatFileItemReader);
		return multiResourceItemReader;
	}

	private Map<String, LineTokenizer> setTokenizers() {
		final Map<String, LineTokenizer> tokenizers = new HashMap<>();
		ExtratoHeaderArquivoLayout extratoHeaderArquivoLayout = new ExtratoHeaderArquivoLayout();
		ExtratoHeaderLoteLayout extratoHeaderLoteLayout = new ExtratoHeaderLoteLayout();
		ExtratoDetailLoteLayout extratoDetailLoteLayout = new ExtratoDetailLoteLayout();
		ExtratoTrailerLoteLayout extratoTrailerLoteLayout = new ExtratoTrailerLoteLayout();
		ExtratoTrailerArquivoLayout extratoTrailerArquivoLayout = new ExtratoTrailerArquivoLayout();

		tokenizers.put(HEADER_EXTRATO_ARQUIVO, extratoHeaderArquivoLayout.configurarParser());
		tokenizers.put(HEADER_EXTRATO_LOTE, extratoHeaderLoteLayout.configurarParser());
		tokenizers.put(BODY_EXTRATO_LOTE, extratoDetailLoteLayout.configurarParser());
		tokenizers.put(TRAILER_EXTRATO_LOTE, extratoTrailerLoteLayout.configurarParser());
		tokenizers.put(TRAILER_EXTRATO_ARQUIVO, extratoTrailerArquivoLayout.configurarParser());

		return tokenizers;
	}

	private Resource[] getArquivos() {
		ResourceArrayPropertyEditor resourceLoader = new ResourceArrayPropertyEditor();
		resourceLoader.setAsText(CaminhoArquivoEnum.BANCO_ITAU_EXTRATO_CAMINHO_ARQUIVO_EXECUCAO.getCaminho());
		Resource[] resources = (Resource[]) resourceLoader.getValue();
		return resources;
	}

	@Override
	public void open(ExecutionContext arg0) throws ItemStreamException {
		multiResourceItemReader = new MultiResourceItemReader<>();
		multiResourceItemReader.setResources(getArquivos());
		// Lançar uma exception caso não existam recursos(arquivos) para serem lidos.
		multiResourceItemReader.setStrict(true);
		multiResourceItemReader.open(arg0);
		flatFileItemReader.setStrict(true);

	}

	@Override
	public void update(ExecutionContext executionContext) throws ItemStreamException {
	}

	@Override
	public void close() throws ItemStreamException {
	}
}
