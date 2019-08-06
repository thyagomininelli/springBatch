package br.com.servico.carga.batch.extrato.componentes;

import java.text.SimpleDateFormat;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import br.com.infraestrutura.batch.interfaces.IValidarEstruturaArquivo;
import br.com.infraestrutura.exception.LinhaInvalidaException;
import br.com.infraestrutura.numero.VerificadorNumerico;
import br.com.servico.carga.batch.extrato.layout.ExtratoDetailLoteLayout;
import br.com.servico.carga.batch.extrato.layout.ExtratoHeaderArquivoLayout;
import br.com.servico.carga.batch.extrato.layout.ExtratoHeaderLoteLayout;
import br.com.servico.carga.batch.extrato.layout.ExtratoTrailerArquivoLayout;
import br.com.servico.carga.batch.extrato.layout.ExtratoTrailerLoteLayout;
import br.com.servico.carga.batch.layout.TiposCampos;
import br.com.servico.carga.dto.ErroCarga;
import br.com.servico.carga.extrato.dto.ExtratoDTO;
import br.com.servico.carga.orquestracao.OrquestradorCargaExtrato;
import br.com.servico.carga.repository.IErroCargaRepository;

/**
 * As validacoes da estrutura do arquivo que a classe VerificadorArquivoSkipper.java nao conseguir resolver no parser, serao feitas.
 * Validacoes dos campos do HEADER, DETAIL e TRAILER: 
 * 
 *    1)OBRIGATORIEDADE
 *    2)TAMANHO
 *    3)TIPAGEM
 */
public class ExtratoValidaEstruturaArquivoProcessor implements ItemProcessor<FieldSet, ExtratoDTO>, IValidarEstruturaArquivo {

	private final static String LAYOUT_HEADER_ARQUIVO = "HEADER_ARQUIVO";
	private final static String LAYOUT_HEADER_LOTE = "HEADER_LOTE";
	private final static String LAYOUT_DETAIL_LOTE = "DETAIL_LOTE";
	private final static String LAYOUT_TRAILER_LOTE = "TRAILER_LOTE";
	private final static String LAYOUT_TRAILER_ARQUIVO = "TRAILER_ARQUIVO";
	
	private static final String HEADER_EXTRATO_ARQUIVO = "0";
	private static final String HEADER_EXTRATO_LOTE = "1";
	private static final String BODY_EXTRATO_LOTE = "3";
	private static final String TRAILER_EXTRATO_LOTE = "5";
	private static final String TRAILER_EXTRATO_ARQUIVO = "9";
	
	@Autowired
	private OrquestradorCargaExtrato orquestradorCargaExtrato;

	private ExtratoHeaderArquivoLayout extratoHeaderArquivoLayout = new ExtratoHeaderArquivoLayout();
	private ExtratoHeaderLoteLayout extratoHeaderLoteLayout = new ExtratoHeaderLoteLayout();
	private ExtratoDetailLoteLayout extratoDetailLoteLayout = new ExtratoDetailLoteLayout();
	private ExtratoTrailerLoteLayout extratoTrailerLoteLayout = new ExtratoTrailerLoteLayout();
	private ExtratoTrailerArquivoLayout extratoTrailerArquivoLayout = new ExtratoTrailerArquivoLayout();

	SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat formatSimple = new SimpleDateFormat("yyMMdd");

	@Autowired
	private IErroCargaRepository erroCargaRepository;

	@Override
	public ExtratoDTO process(FieldSet line) throws Exception {
		try {
			String tipoRegistro = line.readRawString("tipoRegistro");
			
			if (tipoRegistro.equals(HEADER_EXTRATO_ARQUIVO))
				validarHeaderArquivo(line);
			
			else if (tipoRegistro.equals(HEADER_EXTRATO_LOTE))
				validarHeaderLote(line);
			
			else if (tipoRegistro.equals(BODY_EXTRATO_LOTE))
				validarDetailLote(line);
			
			else if (tipoRegistro.equals(TRAILER_EXTRATO_LOTE))
				validarTrailerLote(line);
			
			else if (tipoRegistro.equals(TRAILER_EXTRATO_ARQUIVO)) {
				validarTrailerArquivo(line);
			}

		} catch (LinhaInvalidaException ex) {
			orquestradorCargaExtrato.setArquivoValido(false);
			ErroCarga erroCarga = new ErroCarga(orquestradorCargaExtrato.getIdControleCarga(),
					ex.getTipoRegistro(), ex.getDescricao());
			erroCargaRepository.save(erroCarga);
		} catch (Exception ex) {
			orquestradorCargaExtrato.setArquivoValido(false);
			ErroCarga erroCarga = new ErroCarga(orquestradorCargaExtrato.getIdControleCarga(), "NAO IDENTIFICADA",
					ex.toString());
			erroCargaRepository.save(erroCarga);
		}
		return null;
	}

	@Override
	public void validarObrigatoriedadeDoCampo(String nomeCampo, String valorCampo, String parteLayout)
			throws Exception {
		
		String valorCampoFormatado = null;
		if (nomeCampo.equals("filler") || nomeCampo.equals("fillerErro")) {
			valorCampoFormatado = valorCampo;
		} else {
			valorCampoFormatado = valorCampo.trim();
		}

		if (StringUtils.isEmpty(valorCampoFormatado) && verificarObrigatoriedadeCampo(nomeCampo, parteLayout)) {
			orquestradorCargaExtrato.setArquivoValido(false);
			ErroCarga erroCarga = new ErroCarga(orquestradorCargaExtrato.getIdControleCarga(), new LinhaInvalidaException(
					parteLayout, "O campo " + nomeCampo + " e obrigatorio. Valor [" + valorCampo.trim() + "]. "));
			erroCargaRepository.save(erroCarga);
		}

	}

	@Override
	public void validarTipagemDoCampo(String nomeCampo, String valorCampo, String parteLayout) throws Exception {
		TiposCampos tipoCampo = null;
		try {
			tipoCampo = verificarTipoCampo(nomeCampo, parteLayout);

			if (tipoCampo.equals(TiposCampos.NUMERICO))
				VerificadorNumerico.verificarSeValorNumerico(valorCampo.trim());
			else if (tipoCampo.equals(TiposCampos.DATA) && !valorCampo.trim().isEmpty())
				if (valorCampo.length() > 6) {
					format.parse(valorCampo);
				} else {
					formatSimple.parse(valorCampo);
				}

		} catch (Exception e) {
			orquestradorCargaExtrato.setArquivoValido(false);
			ErroCarga erroCarga = new ErroCarga(orquestradorCargaExtrato.getIdControleCarga(), new LinhaInvalidaException(
					parteLayout, "O campo " + nomeCampo + " nao e do tipo: " + tipoCampo + ". Valor [" + valorCampo.trim() + "]. " + e.toString()));
			erroCargaRepository.save(erroCarga);
		}

	}

	private void validarHeaderArquivo(FieldSet line) throws Exception {
		String[] lineNameField = line.getNames();
		String[] lineValueField = line.getValues();

		String nameField = "";
		String valueField = "";

		for (int i = 0; i < lineValueField.length; i++) {
			nameField = lineNameField[i];
			valueField = lineValueField[i];

			validarObrigatoriedadeDoCampo(nameField, valueField, LAYOUT_HEADER_ARQUIVO);
			validarTipagemDoCampo(nameField, valueField, LAYOUT_HEADER_ARQUIVO);
		}
	}

	private void validarHeaderLote(FieldSet line) throws Exception {
		String[] lineNameField = line.getNames();
		String[] lineValueField = line.getValues();

		String nameField = "";
		String valueField = "";

		for (int i = 0; i < lineValueField.length; i++) {
			nameField = lineNameField[i];
			valueField = lineValueField[i];

			validarObrigatoriedadeDoCampo(nameField, valueField, LAYOUT_HEADER_LOTE);
			validarTipagemDoCampo(nameField, valueField, LAYOUT_HEADER_LOTE);
		}
	}
		
		private void validarDetailLote(FieldSet line) throws Exception {
			String[] lineNameField = line.getNames();
			String[] lineValueField = line.getValues();

			String nameField = "";
			String valueField = "";

			for (int i = 0; i < lineValueField.length; i++) {
				nameField = lineNameField[i];
				valueField = lineValueField[i];

				validarObrigatoriedadeDoCampo(nameField, valueField, LAYOUT_DETAIL_LOTE);
				validarTipagemDoCampo(nameField, valueField, LAYOUT_DETAIL_LOTE);
			}
	}
		
		private void validarTrailerLote(FieldSet line) throws Exception {
			String[] lineNameField = line.getNames();
			String[] lineValueField = line.getValues();

			String nameField = "";
			String valueField = "";

			for (int i = 0; i < lineValueField.length; i++) {
				nameField = lineNameField[i];
				valueField = lineValueField[i];

				validarObrigatoriedadeDoCampo(nameField, valueField, LAYOUT_TRAILER_LOTE);
				validarTipagemDoCampo(nameField, valueField, LAYOUT_TRAILER_LOTE);
			}
	}
		
		private void validarTrailerArquivo(FieldSet line) throws Exception {
			String[] lineNameField = line.getNames();
			String[] lineValueField = line.getValues();

			String nameField = "";
			String valueField = "";

			for (int i = 0; i < lineValueField.length; i++) {
				nameField = lineNameField[i];
				valueField = lineValueField[i];

				validarObrigatoriedadeDoCampo(nameField, valueField, LAYOUT_TRAILER_ARQUIVO);
				validarTipagemDoCampo(nameField, valueField, LAYOUT_TRAILER_ARQUIVO);
			}
	}

	private Boolean verificarObrigatoriedadeCampo(String nomeCampo, String layout) {

		Boolean obrigatorio = false;
		
		if (layout.equals(LAYOUT_HEADER_ARQUIVO))
			obrigatorio = (Boolean) extratoHeaderArquivoLayout.getObrigatoriedade().get(nomeCampo);
		else if (layout.equals(LAYOUT_HEADER_LOTE))
			obrigatorio = (Boolean) extratoHeaderLoteLayout.getObrigatoriedade().get(nomeCampo);
		else if (layout.equals(LAYOUT_DETAIL_LOTE))
			obrigatorio = (Boolean) extratoDetailLoteLayout.getObrigatoriedade().get(nomeCampo);
		else if (layout.equals(LAYOUT_TRAILER_LOTE))
			obrigatorio = (Boolean) extratoTrailerLoteLayout.getObrigatoriedade().get(nomeCampo);
		else if (layout.equals(LAYOUT_TRAILER_ARQUIVO))
			obrigatorio = (Boolean) extratoTrailerArquivoLayout.getObrigatoriedade().get(nomeCampo);
		
		return obrigatorio;
	}

	private TiposCampos verificarTipoCampo(String nomeCampo, String layout) {

		TiposCampos tipoCampo = null;

		if (layout.equals(LAYOUT_HEADER_ARQUIVO))
			tipoCampo = (TiposCampos) extratoHeaderArquivoLayout.getTipos().get(nomeCampo);
		else if (layout.equals(LAYOUT_HEADER_LOTE))
			tipoCampo = (TiposCampos) extratoHeaderLoteLayout.getTipos().get(nomeCampo);
		else if (layout.equals(LAYOUT_DETAIL_LOTE))
			tipoCampo = (TiposCampos) extratoDetailLoteLayout.getTipos().get(nomeCampo);
		else if (layout.equals(LAYOUT_TRAILER_LOTE))
			tipoCampo = (TiposCampos) extratoTrailerLoteLayout.getTipos().get(nomeCampo);
		else if (layout.equals(LAYOUT_TRAILER_ARQUIVO))
			tipoCampo = (TiposCampos) extratoTrailerArquivoLayout.getTipos().get(nomeCampo);

		return tipoCampo;
	}

}
