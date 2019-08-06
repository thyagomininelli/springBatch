package br.com.servico.carga.batch.extrato.componentes;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.dao.DataAccessException;

import br.com.infraestrutura.exception.LinhaInvalidaException;
import br.com.servico.carga.extrato.dto.ExtratoDTO;
import br.com.servico.carga.extrato.dto.ExtratoDetailLoteDTO;
import br.com.servico.carga.extrato.dto.ExtratoHeaderArquivoDTO;
import br.com.servico.carga.extrato.dto.ExtratoHeaderLoteDTO;
import br.com.servico.carga.extrato.dto.ExtratoTrailerArquivoDTO;
import br.com.servico.carga.extrato.dto.ExtratoTrailerLoteDTO;


/** 
 *  
 */ 
public class ExtratoProcessor implements ItemProcessor<FieldSet, ExtratoDTO> {
	
	private static final String HEADER_EXTRATO_ARQUIVO = "0";
	private static final String HEADER_EXTRATO_LOTE = "1";
	private static final String BODY_EXTRATO_LOTE = "3";
	private static final String TRAILER_EXTRATO_LOTE = "5";
	private static final String TRAILER_EXTRATO_ARQUIVO = "9";

	SimpleDateFormat formatDate = new SimpleDateFormat("ddMMyyyy");
	SimpleDateFormat formatDateTime = new SimpleDateFormat("ddMMyyyyHHmmss");
	

	@BeforeStep 
	public void beforeStep(StepExecution stepExecution) throws DataAccessException, IOException {
	}

	@Override
	public ExtratoDTO process(FieldSet line) throws LinhaInvalidaException, Exception {
		
		ExtratoDTO extratoDTO = null;
		String tipoRegistro = line.readString("tipoRegistro");
		
		if(tipoRegistro.equals(HEADER_EXTRATO_ARQUIVO)){
			
			Integer codigoBanco = 0;
			if (!line.readString("codigoBanco").isEmpty())
				codigoBanco = line.readInt("codigoBanco");
			
			Integer codigoLote = 0;
			if (!line.readString("codigoLote").isEmpty())
				codigoLote = line.readInt("codigoLote");
			
			tipoRegistro = line.readString("tipoRegistro");
			
			String complementoRegistroI = null;
			if (!line.readString("complementoRegistroI").isEmpty())
				complementoRegistroI = line.readString("complementoRegistroI");

			String tipoInscricao = null;
			if (!line.readString("tipoInscricao").isEmpty())
				tipoInscricao = line.readString("tipoInscricao");

			Long numeroInscricao = 0l;	
			if (!line.readString("numeroInscricao").isEmpty())
				numeroInscricao = line.readLong("numeroInscricao");
			
			String complementoRegistroII = null;
			if (!line.readString("complementoRegistroII").isEmpty())
				complementoRegistroII = line.readString("complementoRegistroII");
		
			String convenio = null;
			if (!line.readString("convenio").isEmpty())
				convenio = line.readString("convenio");

			Integer complementoRegistroIII = 0;
			if (!line.readString("complementoRegistroIII").isEmpty())
				complementoRegistroIII = line.readInt("complementoRegistroIII");
			
			Integer agencia = 0;
			if (!line.readString("agencia").isEmpty())
				agencia = line.readInt("agencia");

			String dac = null;
			if (!line.readString("dac").isEmpty())
				dac = line.readString("dac");

			Integer complementoRegistroIV = 0;
			if (!line.readString("complementoRegistroIV").isEmpty())
				complementoRegistroIV = line.readInt("complementoRegistroIV");

			Integer conta = 0;
			if (!line.readString("conta").isEmpty())
				conta = line.readInt("conta");

			String complementoRegistroV = null;
			if (!line.readString("complementoRegistroV").isEmpty())
				complementoRegistroV = line.readString("complementoRegistroV");
			
			String digito = null;
			if (!line.readString("digito").isEmpty())
				digito = line.readString("digito");

			String nomeEmpresa = null;
			if (!line.readString("nomeEmpresa").isEmpty())
				nomeEmpresa = line.readString("nomeEmpresa");

			String nomeBanco = null;
			if (!line.readString("nomeBanco").isEmpty())
				nomeBanco = line.readString("nomeBanco");

			String complementoRegistroVI = null;
			if (!line.readString("complementoRegistroVI").isEmpty())
				complementoRegistroVI = line.readString("complementoRegistroVI");

			String codigoRetorno = null;
			if (!line.readString("codigoRetorno").isEmpty())
				codigoRetorno = line.readString("codigoRetorno");

			Date dataGeracao = null;
			if (!line.readRawString("dataGeracao").isEmpty()) {
				String dataGeracaoS = line.readRawString("dataGeracao") + line.readRawString("horaGeracao");
				dataGeracao = formatDateTime.parse(dataGeracaoS);
			} else {
				dataGeracao = new Date();
			}
			
			Integer horaGeracao = 0;
			if (!line.readString("horaGeracao").isEmpty())
				horaGeracao = line.readInt("horaGeracao");
			
			Integer numeroSequencia = 0;
			if (!line.readString("numeroSequencia").isEmpty())
				numeroSequencia = line.readInt("numeroSequencia");

			Integer versaoLayout = 0;
			if (!line.readString("versaoLayout").isEmpty())
				versaoLayout = line.readInt("versaoLayout");

			Integer complementoRegistroVII = 0;
			if (!line.readString("complementoRegistroVII").isEmpty())
				complementoRegistroVII = line.readInt("complementoRegistroVII");

			String reservadoBanco = null;
			if (!line.readString("reservadoBanco").isEmpty())
				reservadoBanco = line.readString("reservadoBanco");

			String complementoRegistroVIII = null;
			if (!line.readString("complementoRegistroVIII").isEmpty())
				complementoRegistroVIII = line.readString("complementoRegistroVIII");
			
			extratoDTO = new ExtratoHeaderArquivoDTO(codigoBanco, codigoLote, tipoRegistro, complementoRegistroI,
					tipoInscricao, numeroInscricao,  complementoRegistroII, convenio, complementoRegistroIII,
					agencia, dac, complementoRegistroIV, conta, complementoRegistroV, digito, 
					nomeEmpresa, nomeBanco, complementoRegistroVI, codigoRetorno, dataGeracao,
				    horaGeracao, numeroSequencia, versaoLayout, complementoRegistroVII,  reservadoBanco,
					complementoRegistroVIII);
			
		} else if (tipoRegistro.equals(HEADER_EXTRATO_LOTE)) {
					
			Integer codigoBanco = 0;
			if (!line.readString("codigoBanco").isEmpty())
				codigoBanco = line.readInt("codigoBanco");
			
			Integer codigoLote = 0;
			if (!line.readString("codigoLote").isEmpty())
				codigoLote = line.readInt("codigoLote");
			
			tipoRegistro = line.readString("tipoRegistro");
			
			String tipoOperacao = null;
			if (!line.readString("tipoOperacao").isEmpty())
				tipoOperacao = line.readString("tipoOperacao");
			
			Integer servico = 0;
			if (!line.readString("servico").isEmpty())
				servico = line.readInt("servico");

			Integer formaLancamento = 0;
			if (!line.readString("formaLancamento").isEmpty())
				formaLancamento = line.readInt("formaLancamento");

			String versaoLayout = null;
			if (!line.readString("versaoLayout").isEmpty())
				versaoLayout = line.readString("versaoLayout");

			String complementoRegistroI = null;
			if (!line.readString("complementoRegistroI").isEmpty())
				complementoRegistroI = line.readString("complementoRegistroI");

			String tipoInscricao = null;
			if (!line.readString("tipoInscricao").isEmpty())
				tipoInscricao = line.readString("tipoInscricao");

			Long numeroInscricao = 0l;
			if (!line.readString("numeroInscricao").isEmpty())
				numeroInscricao = line.readLong("numeroInscricao");

			String tipoConta = null;
			if (!line.readString("tipoConta").isEmpty())
				tipoConta = line.readString("tipoConta");

			String complementoRegistroII = null;
			if (!line.readString("complementoRegistroII").isEmpty())
				complementoRegistroII = line.readString("complementoRegistroII");

			String convenio = null;
			if (!line.readString("convenio").isEmpty())
				convenio = line.readString("convenio");

			Integer complementoRegistroIII = 0;
			if (!line.readString("complementoRegistroIII").isEmpty())
				complementoRegistroIII = line.readInt("complementoRegistroIII");

			Integer agencia = 0;
			if (!line.readString("agencia").isEmpty())
				agencia = line.readInt("agencia");

			String dac = null;
			if (!line.readString("dac").isEmpty())
				dac = line.readString("dac");

			Integer complementoRegistroIV = 0;
			if (!line.readString("complementoRegistroIV").isEmpty())
				complementoRegistroIV = line.readInt("complementoRegistroIV");

			Integer conta = 0;
			if (!line.readString("conta").isEmpty())
				conta = line.readInt("conta");
			
			String complementoRegistroV = null;
			if (!line.readString("complementoRegistroV").isEmpty())
				complementoRegistroV = line.readString("complementoRegistroV");

			String digito = null;
			if (!line.readString("digito").isEmpty())
				digito = line.readString("digito");

			String nomeEmpresa = null;
			if (!line.readString("nomeEmpresa").isEmpty())
				nomeEmpresa = line.readString("nomeEmpresa");

			String complementoRegistroVI = null;
			if (!line.readString("complementoRegistroVI").isEmpty())
				complementoRegistroVI = line.readString("complementoRegistroVI");
		
			Date dataInicial = null;
			if (!line.readRawString("dataInicial").isEmpty()) {
				String dataInicialS = line.readRawString("dataInicial");
				dataInicial = formatDate.parse(dataInicialS);
			} else {
				//TODO retornar vazio senão for preenchido
				dataInicial = new Date();
			}
			
			Double valorInicial = 0.0;
			if (!line.readString("valorInicial").isEmpty()){
				String valorInicialString = line.readString("valorInicial");
				StringBuilder stringBuilderValorInicial = new StringBuilder(valorInicialString);
				stringBuilderValorInicial.insert(stringBuilderValorInicial.length() - 2, '.');
				valorInicial = new Double(stringBuilderValorInicial.toString());
			}

			String situacaoInicial = null;
			if (!line.readString("situacaoInicial").isEmpty())
				situacaoInicial = line.readString("situacaoInicial");
			
			String statusInicial = null;
			if (!line.readString("statusInicial").isEmpty())
				statusInicial = line.readString("statusInicial");
			
			String tipoMoeda = null;
			if (!line.readString("tipoMoeda").isEmpty())
				tipoMoeda = line.readString("tipoMoeda");

			Integer numeroSequencia = 0;
			if (!line.readString("numeroSequencia").isEmpty())
				numeroSequencia = line.readInt("numeroSequencia");

			String complementoRegistroVII = null;
			if (!line.readString("complementoRegistroVII").isEmpty())
				complementoRegistroVII = line.readString("complementoRegistroVII");

			
			extratoDTO = new ExtratoHeaderLoteDTO( codigoBanco, codigoLote, tipoRegistro, tipoOperacao, servico, formaLancamento, 
				 	 versaoLayout, complementoRegistroI, tipoInscricao, numeroInscricao, tipoConta, complementoRegistroII, 
				 	 convenio, complementoRegistroIII, agencia, dac, complementoRegistroIV, conta, complementoRegistroV, 
				 	 digito, nomeEmpresa, complementoRegistroVI, dataInicial, valorInicial, situacaoInicial, statusInicial, 
				 	 tipoMoeda, numeroSequencia, complementoRegistroVII);	
				
		}else if (tipoRegistro.equals(BODY_EXTRATO_LOTE)) {
			
			Integer codigoBanco = 0;
			if (!line.readString("codigoBanco").isEmpty())
				codigoBanco = line.readInt("codigoBanco");
			
			Integer codigoLote = 0;
			if (!line.readString("codigoLote").isEmpty())
				codigoLote = line.readInt("codigoLote");
		
			tipoRegistro = line.readString("tipoRegistro");
			
			Integer numeroRegistro = 0;
			if (!line.readString("numeroRegistro").isEmpty())
				numeroRegistro = line.readInt("numeroRegistro");
	
			String codigoSegmento = null;
			if (!line.readString("codigoSegmento").isEmpty())
				codigoSegmento = line.readString("codigoSegmento");
	
			Long lancamento = 0l;
			if (!line.readString("lancamento").isEmpty())
				lancamento = line.readLong("lancamento");
			
			String complementoRegistroI = null;
			if (!line.readString("complementoRegistroI").isEmpty())
				complementoRegistroI = line.readString("complementoRegistroI");
			
			String tipoInscricao = null;
			if (!line.readString("tipoInscricao").isEmpty())
				tipoInscricao = line.readString("tipoInscricao");

			Long numeroInscricao = 0l;
			if (! line.readString("numeroInscricao").isEmpty())
				numeroInscricao =  line.readLong("numeroInscricao");

			String complementoRegistroII = null;
			if (!line.readString("complementoRegistroII").isEmpty())
				complementoRegistroII = line.readString("complementoRegistroII");

			String convenio = null;
			if (!line.readString("convenio").isEmpty())
				convenio = line.readString("convenio");
			
			Integer complementoRegistroIII = 0;
			if (!line.readString("complementoRegistroIII").isEmpty())
				complementoRegistroIII = line.readInt("complementoRegistroIII");

			Integer agencia = 0;
			if (!line.readString("agencia").isEmpty())
				agencia = line.readInt("agencia");

			String dac = null;
			if (!line.readString("dac").isEmpty())
				dac = line.readString("dac");

			Integer complementoRegistroIV = 0;
			if (!line.readString("complementoRegistroIV").isEmpty())
				complementoRegistroIV = line.readInt("complementoRegistroIV");

			Integer conta = 0;
			if (!line.readString("conta").isEmpty())
				conta = line.readInt("conta");
			
			String complementoRegistroV = null;
			if (!line.readString("complementoRegistroV").isEmpty())
				dac = line.readString("complementoRegistroV");
	
			String digito = null;
			if (!line.readString("digito").isEmpty())
				dac = line.readString("digito");

			String nomeEmpresa = null;
			if (!line.readString("nomeEmpresa").isEmpty())
				nomeEmpresa = line.readString("nomeEmpresa");

			String reservadoBanco = null;
			if (!line.readString("reservadoBanco").isEmpty())
				reservadoBanco = line.readString("reservadoBanco");
			
			String naturezaLancamento = null;
			if (!line.readString("naturezaLancamento").isEmpty())
				naturezaLancamento = line.readString("naturezaLancamento");

			Integer tipoComplemento = 0;
			if (!line.readString("tipoComplemento").isEmpty())
				tipoComplemento = line.readInt("tipoComplemento");
			
			Integer bancoOrigem = 0;
			if (!line.readString("bancoOrigem").isEmpty())
				bancoOrigem = line.readInt("bancoOrigem");

			Integer agenciaOrigem = 0;
			if (!line.readString("agenciaOrigem").isEmpty())
				agenciaOrigem = line.readInt("agenciaOrigem");

			Long contaOrigem = 0l;
			if (!line.readString("contaOrigem").isEmpty())
				contaOrigem = line.readLong("contaOrigem");

			String cpmf = null;
			if (!line.readString("cpmf").isEmpty())
				cpmf = line.readString("cpmf");
			
			Date dataContabilDate = null;
			if (!line.readString("dataContabil").isEmpty()
					&& line.readRawString("dataContabil").length() == 8) {
				String dataContabil = line.readRawString("dataContabil");
				dataContabilDate = formatDate.parse(dataContabil);
			}

			Date dataLancamentoDate = null;
			if (!line.readString("dataLancamento").isEmpty()
					&& line.readRawString("dataLancamento").length() == 8) {
				String dataLancamento = line.readRawString("dataLancamento");
				dataLancamentoDate = formatDate.parse(dataLancamento);
			}
			
			Double valorLancamento = 0.0;
			if (!line.readString("valorLancamento").isEmpty()){
				String valorLancamentoString = line.readString("valorLancamento");
				StringBuilder stringBuilderValorLancamento = new StringBuilder(valorLancamentoString);
				stringBuilderValorLancamento.insert(stringBuilderValorLancamento.length() - 2, '.');
				valorLancamento = new Double(stringBuilderValorLancamento.toString());
			}

			String tipoLancamento = null;
			if (!line.readString("tipoLancamento").isEmpty())
				tipoLancamento = line.readString("tipoLancamento");

			Integer categoriaLancamento = 0;
			if (!line.readString("categoriaLancamento").isEmpty())
				categoriaLancamento = line.readInt("categoriaLancamento");

			String codigoLancamento = null;
			if (!line.readString("codigoLancamento").isEmpty())
				codigoLancamento = line.readString("codigoLancamento");

			String historicoLancamento = null;
			if (!line.readString("historicoLancamento").isEmpty())
				historicoLancamento = line.readString("historicoLancamento");

			String complementoRegistroVI = null;
			if (!line.readString("complementoRegistroVI").isEmpty())
				complementoRegistroVI = line.readString("complementoRegistroVI");
			
			String numeroDocumento = null;
			if (!line.readString("numeroDocumento").isEmpty())
				numeroDocumento = line.readString("numeroDocumento");
		
			extratoDTO = new ExtratoDetailLoteDTO( codigoBanco, codigoLote, tipoRegistro, numeroRegistro, codigoSegmento, 
				 	  lancamento, complementoRegistroI, tipoInscricao, numeroInscricao, complementoRegistroII, convenio, 
				 	  complementoRegistroIII, agencia, dac, complementoRegistroIV, conta, complementoRegistroV, digito, 
				 	  nomeEmpresa, reservadoBanco, naturezaLancamento, tipoComplemento, bancoOrigem, 
				 	  agenciaOrigem, contaOrigem, cpmf, dataContabilDate, dataLancamentoDate, valorLancamento, tipoLancamento, 
				 	  categoriaLancamento, codigoLancamento,  historicoLancamento, complementoRegistroVI, numeroDocumento);
			
		} else if (tipoRegistro.equals(TRAILER_EXTRATO_LOTE)) {
			
			Integer codigoBanco = 0;
			if (!line.readString("codigoBanco").isEmpty())
				codigoBanco = line.readInt("codigoBanco");
			
			Integer codigoLote = 0;
			if (!line.readString("codigoLote").isEmpty())
				codigoLote = line.readInt("codigoLote");
			
			tipoRegistro = line.readString("tipoRegistro");

			String complementoRegistroI = null;
			if (!line.readString("complementoRegistroI").isEmpty())
				complementoRegistroI = line.readString("complementoRegistroI");
			
			String tipoInscricao = null;
			if (!line.readString("tipoInscricao").isEmpty())
				tipoInscricao = line.readString("tipoInscricao");
			
			Long numeroInscricao = 0l;
			if (!line.readString("numeroInscricao").isEmpty())
				numeroInscricao = line.readLong("numeroInscricao");

			String complementoRegistroII = null;
			if (!line.readString("complementoRegistroII").isEmpty())
				complementoRegistroII = line.readString("complementoRegistroII");
			
			String convenio = null;
			if (!line.readString("convenio").isEmpty())
				convenio = line.readString("convenio");
			
			Integer complementoRegistroIII = 0;
			if (!line.readString("complementoRegistroIII").isEmpty())
				complementoRegistroIII = line.readInt("complementoRegistroIII");

			Integer agencia = 0;
			if (!line.readString("agencia").isEmpty())
				agencia = line.readInt("agencia");
			
			String dac = null;
			if (!line.readString("dac").isEmpty())
				dac = line.readString("dac");
	
			Integer complementoRegistroIV = 0;
			if (!line.readString("complementoRegistroIV").isEmpty())
				complementoRegistroIV = line.readInt("complementoRegistroIV");
			
			Integer conta = 0;
			if (!line.readString("conta").isEmpty())
				conta = line.readInt("conta");
			
			String complementoRegistroV = null;
			if (!line.readString("complementoRegistroV").isEmpty())
				complementoRegistroV = line.readString("complementoRegistroV");
		
			String digito = null;
			if (!line.readString("digito").isEmpty())
				digito = line.readString("digito");
			
			String complementoRegistroVI = null;
			if (!line.readString("complementoRegistroVI").isEmpty())
				complementoRegistroVI = line.readString("complementoRegistroVI");
			
			Double bloqueadoAcima24Hs = 0.0;
			if (!line.readString("bloqueadoAcima24Hs").isEmpty()){
				String bloqueadoAcima24HsString = line.readString("bloqueadoAcima24Hs");
				StringBuilder stringBuilderBloqueadoAcima24Hs = new StringBuilder(bloqueadoAcima24HsString);
				stringBuilderBloqueadoAcima24Hs.insert(stringBuilderBloqueadoAcima24Hs.length() - 2, '.');
				bloqueadoAcima24Hs = new Double(stringBuilderBloqueadoAcima24Hs.toString());
			}
			
			Double bloqueadoAte24Hs = 0.0;
			if (!line.readString("bloqueadoAte24Hs").isEmpty()){
				String bloqueadoAte24HsString = line.readString("bloqueadoAte24Hs");
				StringBuilder stringBuilderBloqueadoAte24Hs = new StringBuilder(bloqueadoAte24HsString);
				stringBuilderBloqueadoAte24Hs.insert(stringBuilderBloqueadoAte24Hs.length() - 2, '.');
				bloqueadoAte24Hs = new Double(stringBuilderBloqueadoAte24Hs.toString());
			}
			
			Double limiteConta = 0.0;
			if (!line.readString("limiteConta").isEmpty()){
				String limiteContaString = line.readString("limiteConta");
				StringBuilder stringBuilderLimiteConta = new StringBuilder(limiteContaString);
				stringBuilderLimiteConta.insert(stringBuilderLimiteConta.length() - 2, '.');
				limiteConta = new Double(stringBuilderLimiteConta.toString());
			}

			
			Date dataFinalDate = null;
			if (!line.readString("dataFinal").isEmpty()
					&& line.readString("dataFinal").length() == 8) {
				String dataFinal = line.readRawString("dataFinal");
				dataFinalDate = formatDate.parse(dataFinal);
			}
			
			Double saldoFinal = 0.0;
			if (!line.readString("saldoFinal").isEmpty()){
				String saldoFinalString = line.readString("saldoFinal");
				StringBuilder stringBuilderSaldoFinal = new StringBuilder(saldoFinalString);
				stringBuilderSaldoFinal.insert(stringBuilderSaldoFinal.length() - 2, '.');
				saldoFinal = new Double(stringBuilderSaldoFinal.toString());
			}

			String situacaoSaldo = null;
			if (!line.readString("situacaoSaldo").isEmpty())
				situacaoSaldo = line.readString("situacaoSaldo");
			
			String statusSaldo = null;
			if (!line.readString("statusSaldo").isEmpty())
				statusSaldo = line.readString("statusSaldo");

			Integer qteRegistros = 0;
			if (!line.readString("qteRegistros").isEmpty())
				qteRegistros = line.readInt("qteRegistros");
			
			Double somatoriaDebitos = 0.0;
			if (!line.readString("somatoriaDebitos").isEmpty()){
				String somatoriaDebitosString = line.readString("somatoriaDebitos");
				StringBuilder stringBuilderSomatoriaDebitos = new StringBuilder(somatoriaDebitosString);
				stringBuilderSomatoriaDebitos.insert(stringBuilderSomatoriaDebitos.length() - 2, '.');
				somatoriaDebitos = new Double(stringBuilderSomatoriaDebitos.toString());
			}
			
			Double somatoriaCreditos = 0.0;
			if (!line.readString("somatoriaCreditos").isEmpty()){
				String somatoriaCreditosString = line.readString("somatoriaCreditos");
				StringBuilder stringBuilderSomatoriaCreditos = new StringBuilder(somatoriaCreditosString);
				stringBuilderSomatoriaCreditos.insert(stringBuilderSomatoriaCreditos.length() - 2, '.');
				somatoriaCreditos = new Double(stringBuilderSomatoriaCreditos.toString());
			}

			Double somatoriaNaoContabeis = 0.0;
			if (!line.readString("somatoriaNaoContabeis").isEmpty()){
				String somatoriaNaoContabeisString = line.readString("somatoriaNaoContabeis");
				StringBuilder stringBuilderSomatoriaNaoContabeis = new StringBuilder(somatoriaNaoContabeisString);
				stringBuilderSomatoriaNaoContabeis.insert(stringBuilderSomatoriaNaoContabeis.length() - 2, '.');
				somatoriaNaoContabeis = new Double(stringBuilderSomatoriaNaoContabeis.toString());
			}
				
			String complementoRegistrosVII = null;
			if (!line.readString("complementoRegistrosVII").isEmpty())
				complementoRegistrosVII = line.readString("complementoRegistrosVII");
			
			extratoDTO = new ExtratoTrailerLoteDTO(codigoBanco, codigoLote, tipoRegistro, complementoRegistroI, tipoInscricao,
					 numeroInscricao, complementoRegistroII, convenio, complementoRegistroIII, agencia, dac, complementoRegistroIV,
					 conta, complementoRegistroV, digito, complementoRegistroVI, bloqueadoAcima24Hs, limiteConta, bloqueadoAte24Hs,
					 dataFinalDate, saldoFinal, situacaoSaldo, statusSaldo, qteRegistros, somatoriaDebitos, somatoriaCreditos,
					 somatoriaNaoContabeis, complementoRegistrosVII);
			
		} else if (tipoRegistro.equals(TRAILER_EXTRATO_ARQUIVO)) {
			
			Integer codigoBanco = 0;
			if (!line.readString("codigoBanco").isEmpty())
				codigoBanco = line.readInt("codigoBanco");
			
			String codigoLote = null;
			if (!line.readString("codigoLote").isEmpty())
				codigoLote = line.readString("codigoLote");

			tipoRegistro = line.readString("tipoRegistro");
				
			String complementoRegistroI = null;
			if (!line.readString("complementoRegistroI").isEmpty())
				tipoRegistro = line.readString("complementoRegistroI");
				
			Integer qteLotes = 0;
			if (!line.readString("qteLotes").isEmpty())
				qteLotes = line.readInt("qteLotes");
			
			Integer qteRegistros = 0;
			if (!line.readString("qteRegistros").isEmpty())
				qteRegistros = line.readInt("qteRegistros");
				
			Integer qteContasConcil = 0;
			if (!line.readString("qteContasConcil").isEmpty())
				qteContasConcil = line.readInt("qteContasConcil");
				
			String complementoRegistroII = null;
			if (!line.readString("complementoRegistroII").isEmpty())
				complementoRegistroII = line.readString("complementoRegistroII");
			
			extratoDTO = new ExtratoTrailerArquivoDTO(codigoBanco, codigoLote, tipoRegistro, complementoRegistroI, qteLotes,
					  qteRegistros, qteContasConcil, complementoRegistroII);
			
		}
		return extratoDTO;
	}

}
