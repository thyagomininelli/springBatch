package br.com.servico.carga.batch.extrato.componentes;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.servico.carga.dao.IErroCargaDAO;
import br.com.servico.carga.dto.ErroCarga;
import br.com.servico.carga.extrato.dao.IExtratoDAO;
import br.com.servico.carga.extrato.dto.ExtratoDTO;
import br.com.servico.carga.extrato.dto.ExtratoDetailLoteDTO;
import br.com.servico.carga.extrato.dto.ExtratoHeaderArquivoDTO;
import br.com.servico.carga.extrato.dto.ExtratoHeaderLoteDTO;
import br.com.servico.carga.extrato.dto.ExtratoTrailerArquivoDTO;
import br.com.servico.carga.extrato.dto.ExtratoTrailerLoteDTO;
import br.com.servico.carga.orquestracao.OrquestradorCargaExtrato;

/** 
 * 
 */
public class ExtratoWriter implements ItemWriter<ExtratoDTO> {

	private static final Logger LOGGER = Logger.getLogger(ExtratoWriter.class.getName());

	@Autowired
	OrquestradorCargaExtrato orquestradorCargaExtrato;

	@Autowired
	private IExtratoDAO extratoDAO;
	
	@Autowired
	private IErroCargaDAO erroCargaService;

	@Override
	public void write(List<? extends ExtratoDTO> listExtratoDTO) throws Exception {
		for (ExtratoDTO extratoDTO : listExtratoDTO) {
			if (ExtratoHeaderArquivoDTO.class.isInstance(extratoDTO)) {
				try{
					ExtratoHeaderArquivoDTO extratoHeaderArquivoDTO = (ExtratoHeaderArquivoDTO) extratoDTO;
					extratoDAO.incluirExtratoHeaderArquivo(extratoHeaderArquivoDTO);
				}catch (Exception e) {
					LOGGER.error("Erro ao executar metodo write: "+ e);
					orquestradorCargaExtrato.setArquivoValido(false);
					ExtratoHeaderArquivoDTO extratoHeaderArquivoDTO = (ExtratoHeaderArquivoDTO) extratoDTO;
					ErroCarga erroCarga = new ErroCarga(orquestradorCargaExtrato.getIdArquivoCarga(), extratoHeaderArquivoDTO.getTipoRegistro(), e.getCause().getMessage());
					erroCargaService.incluirErroCarga(erroCarga);					
				}
				
			} else if (ExtratoHeaderLoteDTO.class.isInstance(extratoDTO)) {
				try{
					ExtratoHeaderLoteDTO extratoHeaderLoteDTO = (ExtratoHeaderLoteDTO) extratoDTO;
					extratoDAO.incluirExtratoHeaderLote(extratoHeaderLoteDTO);
				}catch (Exception e) {
					LOGGER.error("Erro ao executar metodo write: "+ e);
					orquestradorCargaExtrato.setArquivoValido(false);
					ExtratoHeaderLoteDTO extratoHeaderLoteDTO = (ExtratoHeaderLoteDTO) extratoDTO;
					ErroCarga erroCarga = new ErroCarga(orquestradorCargaExtrato.getIdArquivoCarga(), extratoHeaderLoteDTO.getTipoRegistro(), e.getCause().getMessage());
					erroCargaService.incluirErroCarga(erroCarga);
				}
				
			} else if (ExtratoDetailLoteDTO.class.isInstance(extratoDTO)) {
				try{
					ExtratoDetailLoteDTO extratoDetailLoteDTO = (ExtratoDetailLoteDTO) extratoDTO;
					extratoDAO.incluirExtratoDetailLote(extratoDetailLoteDTO);
				}catch (Exception e) {
					LOGGER.error("Erro ao executar metodo write: "+ e);
					orquestradorCargaExtrato.setArquivoValido(false);
					ExtratoDetailLoteDTO extratoDetailLoteDTO = (ExtratoDetailLoteDTO) extratoDTO;
					ErroCarga erroCarga = new ErroCarga(orquestradorCargaExtrato.getIdArquivoCarga(), extratoDetailLoteDTO.getTipoRegistro(), e.getCause().getMessage());					
					erroCargaService.incluirErroCarga(erroCarga);
				}				
			} else if (ExtratoTrailerLoteDTO.class.isInstance(extratoDTO)) {
				try{
					ExtratoTrailerLoteDTO extratoTrailerLoteDTO = (ExtratoTrailerLoteDTO) extratoDTO;
					extratoDAO.incluirExtratoTrailerLote(extratoTrailerLoteDTO);
				}catch (Exception e) {
					LOGGER.error("Erro ao executar metodo write: "+ e);
					orquestradorCargaExtrato.setArquivoValido(false);
					ExtratoTrailerLoteDTO extratoTrailerLoteDTO = (ExtratoTrailerLoteDTO) extratoDTO;
					ErroCarga erroCarga = new ErroCarga(orquestradorCargaExtrato.getIdArquivoCarga(), extratoTrailerLoteDTO.getTipoRegistro(), e.getCause().getMessage());
					erroCargaService.incluirErroCarga(erroCarga);
				}				
			} else if (ExtratoTrailerArquivoDTO.class.isInstance(extratoDTO)) {
				try{
					ExtratoTrailerArquivoDTO extratoTrailerArquivoDTO = (ExtratoTrailerArquivoDTO) extratoDTO;
					extratoDAO.incluirExtratoTrailerArquivo(extratoTrailerArquivoDTO);
				}catch (Exception e) {
					LOGGER.error("Erro ao executar metodo write: "+ e);
					orquestradorCargaExtrato.setArquivoValido(false);
					ExtratoTrailerArquivoDTO extratoTrailerArquivoDTO = (ExtratoTrailerArquivoDTO) extratoDTO;
					ErroCarga erroCarga = new ErroCarga(orquestradorCargaExtrato.getIdArquivoCarga(), extratoTrailerArquivoDTO.getTipoRegistro(), e.getCause().getMessage());
					erroCargaService.incluirErroCarga(erroCarga);
				}				
			}
		}
	}
}