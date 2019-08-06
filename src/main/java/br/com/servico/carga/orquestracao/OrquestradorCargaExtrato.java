package br.com.servico.carga.orquestracao;

import java.io.File;

import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.infraestrutura.diretorios.CaminhoArquivoEnum;
import br.com.infraestrutura.diretorios.NomeArquivoEnum;
import br.com.infraestrutura.orquestracao.interfaces.Orquestrador;
import br.com.servico.carga.dto.ArquivoCarga;
import br.com.servico.carga.dto.ControleCarga;
import br.com.servico.carga.dto.LayoutParceiro;
import br.com.servico.carga.dto.Parceiro;
import br.com.servico.carga.dto.StatusCarga;

/** 
 * O "Orquestrador" e uma classe responsavel em:
 * _ Realizar o log de inicio e fim de processamento nas tabelas de controle de carga: ARQUIVO_CARGA e CONTROLE_CARGA.
 * _ Mover os arquivos de RETORNO do diretorio de entrada para o diretorio de execucao
 * _ Solicitar ao Batch a carga, o parser e armazenamento dos arquivos de RETORNO.
 */ 
@Service
public class OrquestradorCargaExtrato extends Orquestrador {

	private static final Logger LOGGER = Logger.getLogger(OrquestradorCargaExtrato.class.getName());

	@Autowired
	@Qualifier("carregarExtratoJob")
	private Job carregarExtratoJob;
	


	
	@Override
	public void executarCarga() {
		
			LOGGER.info("Inicio - OrquestradorCargaExtrato.executarCarga");

			File diretorioEntrada = new File(CaminhoArquivoEnum.BANCO_ITAU_EXTRATO_CAMINHO_DIRETORIO_ENTRADA.getCaminho());
			File diretorioExecucao = new File(CaminhoArquivoEnum.BANCO_ITAU_EXTRATO_CAMINHO_DIRETORIO_EXECUCAO.getCaminho());
			File diretorioErro = new File(CaminhoArquivoEnum.BANCO_ITAU_EXTRATO_CAMINHO_DIRETORIO_ERRO.getCaminho());
			

			//1)Carrega os arquivos do diretorio /data/magazine-batch/bancoitau/entrada/*
			File arrayArquivosEntrada[] = diretorioEntrada.listFiles();
			
			if(arrayArquivosEntrada == null || arrayArquivosEntrada.length == 0) {
				LOGGER.info("OrquestradorCargaExtrato - Nao foram encontrados arquivos no diretorio.");				
				return;
			}
			
			for (File arquivoASerCarregado : arrayArquivosEntrada) {
				try {
					
					arquivoCarga = arquivoASerCarregado;
					this.arquivoValido = true;
					 
					LOGGER.info("Inserção de Arquivo Carga");
					ArquivoCarga arquivoCarga = new ArquivoCarga(Parceiro.BANCO_ITAU, LayoutParceiro.EXTRATO, arquivoASerCarregado.getName());
					idArquivoCarga = arquivoCargaService.incluirArquivoCarga(arquivoCarga);
					

					LOGGER.info("Inserção de Controle de Carga");
					ControleCarga controleCarga = new ControleCarga();
					controleCarga.setArquivoCarga(arquivoCarga);
					controleCarga.setStatusCarga(StatusCarga.EXECUCAO);
					idControleCarga = controleCargaService.incluirControleCarga(controleCarga);
					
		
					LOGGER.info("Tranferência de Arquivo - Entrada para Execução");
					gerenciadorArquivos.moveArquivoParaDiretorio(diretorioExecucao, arquivoASerCarregado);
	
					
					LOGGER.info("Execução do Batch " );
					JobParameters jobParameters = new JobParametersBuilder().addLong("time",System.currentTimeMillis())
							.addString("nomeArquivo", arquivoCarga.getNomeArquivo())
							.addString("renameArquivo", NomeArquivoEnum.ITAU_CARGA_EXTRATO.getNomeArquivo())
							.toJobParameters();
					execution = launcher.run(carregarExtratoJob, jobParameters);
										
					if(this.isArquivoValido()) {
						controleCarga = controleCargaService.obterControleCargaPorId(idControleCarga);
						controleCarga.setStatusCarga(StatusCarga.CARGA_SUCESSO);
						controleCargaService.atualizarControleCarga(controleCarga);
						LOGGER.info("OrquestradorCargaExtrato - Arquivo Valido");
					} else {
						controleCarga = controleCargaService.obterControleCargaPorId(idControleCarga);
						controleCarga.setStatusCarga(StatusCarga.CARGA_ERRO);
						controleCargaService.atualizarControleCarga(controleCarga);
						//extratoDAO.removerRegistrosRouboFurto(idArquivoCarga);
						LOGGER.info(">> Itau - OrquestradorCargaExtrato - Arquivo Invalido");
					}
					LOGGER.info("Fim - OrquestradorCargaExtrato.executarCarga " + execution.getExitStatus());
					
				} catch(Exception e) {
					//Para cada arquivo que tiver algum erro na validacao estrutural, a carga do mesmo sera considerada CARREGADO_ERRO.  
					e.printStackTrace(); 
					LOGGER.error("Erro de validacao estrutural." + e.getMessage());
					
					try {
						ControleCarga controleCarga = controleCargaService.obterControleCargaPorId(idControleCarga);
						controleCarga.setStatusCarga(StatusCarga.CARGA_ERRO);
						controleCargaService.atualizarControleCarga(controleCarga);
						//controleCargaRepository.removerRegistrosRouboFurto(idArquivoCarga);
					} catch (Exception e1) {
						e1.printStackTrace(); 
						LOGGER.error("Erro ao atualizar carga." + e1.getMessage());
					}
					gerenciadorArquivos.moveArquivoParaDiretorio(diretorioErro, arquivoCarga);
					LOGGER.info("Arquivo movido para o diretorio de erro.");
				}
			}
		}
}