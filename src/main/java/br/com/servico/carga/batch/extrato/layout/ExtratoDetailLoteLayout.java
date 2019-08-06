package br.com.servico.carga.batch.extrato.layout;

import org.springframework.batch.item.file.transform.Range;

import br.com.servico.carga.batch.layout.LayoutArquivo;
import br.com.servico.carga.batch.layout.TiposCampos;

public class ExtratoDetailLoteLayout extends LayoutArquivo {

	private static final long serialVersionUID = 5861701768420741238L;
	
	private static final String CODIGO_BANCO = "codigoBanco";
	private static final Range RANGE_CODIGO_BANCO = new Range(1, 3);

	private static final String CODIGO_LOTE = "codigoLote";
	private static final Range RANGE_CODIGO_LOTE = new Range(4, 7);

	private static final String TIPO_REGISTRO = "tipoRegistro";
	private static final Range RANGE_TIPO_REGISTRO = new Range(8, 8);

	private static final String NUMERO_REGISTRO = "numeroRegistro";
	private static final Range RANGE_NUMERO_REGISTRO = new Range(9, 13);

	private static final String SEGMENTO = "codigoSegmento";
	private static final Range RANGE_SEGMENTO = new Range(14, 14);

	private static final String LANCAMENTO = "lancamento";
	private static final Range RANGE_LANCAMENTO = new Range(15, 15);

	private static final String COMPLEMENTO_REGISTRO_I = "complementoRegistroI";
	private static final Range RANGE_COMPLEMENTO_REGISTRO_I= new Range(16, 17);

	private static final String TIPO_INSCRICAO = "tipoInscricao";
	private static final Range RANGE_TIPO_INSCRICAO = new Range(18, 18);

	private static final String NUMERO_INSCRICAO = "numeroInscricao";
	private static final Range RANGE_NUMERO_INSCRICAO = new Range(19, 32);

	private static final String COMPLEMENTO_REGISTRO_II = "complementoRegistroII";
	private static final Range RANGE_COMPLEMENTO_REGISTRO_II = new Range(33, 47);

	private static final String CONVENIO = "convenio";
	private static final Range RANGE_CONVENIO = new Range(48, 52);

	private static final String COMPLEMENTO_REGISTRO_III = "complementoRegistroIII";
	private static final Range RANGE_COMPLEMENTO_REGISTRO_III = new Range(53, 53);

	private static final String AGENCIA = "agencia";
	private static final Range RANGE_AGENCIA = new Range(54, 57);

	private static final String DAC = "dac";
	private static final Range RANGE_DAC = new Range(58, 58);

	private static final String COMPLEMENTO_REGISTRO_IV = "complementoRegistroIV";
	private static final Range RANGE_COMPLEMENTO_REGISTRO_IV = new Range(59, 65);

	private static final String CONTA = "conta";
	private static final Range RANGE_CONTA = new Range(66, 70);

	private static final String COMPLEMENTO_REGISTRO_V = "complementoRegistroV";
	private static final Range RANGE_COMPLEMENTO_REGISTRO_V = new Range(71, 71);

	private static final String DIGITO = "digito";
	private static final Range RANGE_DIGITO = new Range(72, 72);

	private static final String NOME_EMPRESA = "nomeEmpresa";
	private static final Range RANGE_NOME_EMPRESA = new Range(73, 102);

	private static final String RESERVADO_BANCO = "reservadoBanco";
	private static final Range RANGE_RESERVADO_BANCO = new Range(103, 108);

	private static final String NATUREZA_LANCAMENTO = "naturezaLancamento";
	private static final Range RANGE_NATUREZA_LANCAMENTO = new Range(109, 111);

	private static final String TIPO_COMPLEMENTO = "tipoComplemento";
	private static final Range RANGE_TIPO_COMPLEMENTO = new Range(112, 113);

	private static final String BANCO_ORIGEM = "bancoOrigem";
	private static final Range RANGE_BANCO_ORIGEM = new Range(114, 116);

	private static final String AGENCIA_ORIGEM = "agenciaOrigem";
	private static final Range RANGE_AGENCIA_ORIGEM = new Range(117, 121);

	private static final String CONTA_ORIGEM = "contaOrigem";
	private static final Range RANGE_CONTA_ORIGEM = new Range(122, 133);

	private static final String CPMF = "cpmf";
	private static final Range RANGE_CPMF = new Range(134, 134);

	private static final String DATA_CONTABIL = "dataContabil";
	private static final Range RANGE_DATA_CONTABIL = new Range(135, 142);

	private static final String DATA_LANCAMENTO = "dataLancamento";
	private static final Range RANGE_DATA_LANCAMENTO = new Range(143, 150);

	private static final String VALOR_LANCAMENTO = "valorLancamento";
	private static final Range RANGE_VALOR = new Range(151, 168);

	private static final String TIPO_LANCAMENTO = "tipoLancamento";
	private static final Range RANGE_TIPO_LANCAMENTO = new Range(169, 169);

	private static final String CATEGORIA_LANCAMENTO = "categoriaLancamento";
	private static final Range RANGE_CATEGORIA_LANCAMENTO = new Range(170, 172);

	private static final String CODIGO_LANCAMENTO = "codigoLancamento";
	private static final Range RANGE_CODIGO_LANCAMENTO = new Range(173, 176);

	private static final String HISTORICO_LANCAMENTO = "historicoLancamento";
	private static final Range RANGE_HISTORICO_LANCAMENTO = new Range(177, 201);
	
	private static final String COMPLEMENTO_REGISTRO_VI = "complementoRegistroVI";
	private static final Range RANGE_COMPLEMENTO_REGISTRO_VI = new Range(202, 234);

	private static final String NUMERO_DOCUMENTO = "numeroDocumento";
	private static final Range RANGE_NUMERO_DOCUMENTO = new Range(235, 240);

	public ExtratoDetailLoteLayout() {
		this.campos = new String[] { CODIGO_BANCO, CODIGO_LOTE, TIPO_REGISTRO, NUMERO_REGISTRO, SEGMENTO, 
				LANCAMENTO, COMPLEMENTO_REGISTRO_I, TIPO_INSCRICAO, NUMERO_INSCRICAO, COMPLEMENTO_REGISTRO_II,
				CONVENIO, COMPLEMENTO_REGISTRO_III, AGENCIA, DAC, COMPLEMENTO_REGISTRO_IV, 
				CONTA, COMPLEMENTO_REGISTRO_V, DIGITO, NOME_EMPRESA, RESERVADO_BANCO, NATUREZA_LANCAMENTO, 
				TIPO_COMPLEMENTO, BANCO_ORIGEM ,AGENCIA_ORIGEM, CONTA_ORIGEM, CPMF, DATA_CONTABIL, 
				DATA_LANCAMENTO, VALOR_LANCAMENTO, TIPO_LANCAMENTO, CATEGORIA_LANCAMENTO, CODIGO_LANCAMENTO, 
				HISTORICO_LANCAMENTO,COMPLEMENTO_REGISTRO_VI, NUMERO_DOCUMENTO
				};

		this.tamanhos = new Range[] { RANGE_CODIGO_BANCO, RANGE_CODIGO_LOTE,RANGE_TIPO_REGISTRO, RANGE_NUMERO_REGISTRO, RANGE_SEGMENTO,
				RANGE_LANCAMENTO, RANGE_COMPLEMENTO_REGISTRO_I, RANGE_TIPO_INSCRICAO, RANGE_NUMERO_INSCRICAO, RANGE_COMPLEMENTO_REGISTRO_II,
				RANGE_CONVENIO, RANGE_COMPLEMENTO_REGISTRO_III, RANGE_AGENCIA, RANGE_DAC, RANGE_COMPLEMENTO_REGISTRO_IV, 
				RANGE_CONTA, RANGE_COMPLEMENTO_REGISTRO_V, RANGE_DIGITO, RANGE_NOME_EMPRESA, RANGE_RESERVADO_BANCO, RANGE_NATUREZA_LANCAMENTO,
				RANGE_TIPO_COMPLEMENTO, RANGE_BANCO_ORIGEM, RANGE_AGENCIA_ORIGEM, RANGE_CONTA_ORIGEM, RANGE_CPMF, RANGE_DATA_CONTABIL,
				RANGE_DATA_LANCAMENTO, RANGE_VALOR, RANGE_TIPO_LANCAMENTO, RANGE_CATEGORIA_LANCAMENTO, RANGE_CODIGO_LANCAMENTO,  
				RANGE_HISTORICO_LANCAMENTO, RANGE_COMPLEMENTO_REGISTRO_VI, RANGE_NUMERO_DOCUMENTO
				};

		this.configurarTiposCampos();
		this.configurarObrigatoriedade();
	}

	@Override
	public void configurarTiposCampos() {
		tipos.put(CODIGO_BANCO, TiposCampos.NUMERICO);
		tipos.put(CODIGO_LOTE, TiposCampos.NUMERICO);
		tipos.put(TIPO_REGISTRO, TiposCampos.ALFA_NUMERICO);
		tipos.put(NUMERO_REGISTRO, TiposCampos.NUMERICO);
		tipos.put(SEGMENTO, TiposCampos.ALFA_NUMERICO);
		tipos.put(LANCAMENTO, TiposCampos.NUMERICO);
		tipos.put(COMPLEMENTO_REGISTRO_I, TiposCampos.ALFA_NUMERICO);
		tipos.put(TIPO_INSCRICAO, TiposCampos.ALFA_NUMERICO);
		tipos.put(NUMERO_INSCRICAO, TiposCampos.NUMERICO);
		tipos.put(COMPLEMENTO_REGISTRO_II, TiposCampos.ALFA_NUMERICO);
		tipos.put(CONVENIO, TiposCampos.ALFA_NUMERICO);
		tipos.put(COMPLEMENTO_REGISTRO_III, TiposCampos.NUMERICO);
		tipos.put(AGENCIA, TiposCampos.NUMERICO);
		tipos.put(DAC, TiposCampos.ALFA_NUMERICO);
		tipos.put(COMPLEMENTO_REGISTRO_IV, TiposCampos.NUMERICO);
		tipos.put(CONTA, TiposCampos.NUMERICO);
		tipos.put(COMPLEMENTO_REGISTRO_V, TiposCampos.ALFA_NUMERICO);
		tipos.put(DIGITO, TiposCampos.ALFA_NUMERICO);
		tipos.put(NOME_EMPRESA, TiposCampos.ALFA_NUMERICO);
		tipos.put(RESERVADO_BANCO, TiposCampos.ALFA_NUMERICO);
		tipos.put(NATUREZA_LANCAMENTO, TiposCampos.ALFA_NUMERICO);
		tipos.put(TIPO_COMPLEMENTO, TiposCampos.NUMERICO);
		tipos.put(BANCO_ORIGEM, TiposCampos.NUMERICO);
		tipos.put(AGENCIA_ORIGEM, TiposCampos.NUMERICO);
		tipos.put(CONTA_ORIGEM, TiposCampos.NUMERICO);
		tipos.put(CPMF, TiposCampos.ALFA_NUMERICO);
		tipos.put(DATA_CONTABIL, TiposCampos.NUMERICO);
		tipos.put(DATA_LANCAMENTO, TiposCampos.NUMERICO);
		tipos.put(VALOR_LANCAMENTO, TiposCampos.NUMERICO);
		tipos.put(TIPO_LANCAMENTO, TiposCampos.ALFA_NUMERICO);
		tipos.put(CATEGORIA_LANCAMENTO, TiposCampos.NUMERICO);
		tipos.put(CODIGO_LANCAMENTO, TiposCampos.ALFA_NUMERICO);
		tipos.put(HISTORICO_LANCAMENTO, TiposCampos.ALFA_NUMERICO);
		tipos.put(COMPLEMENTO_REGISTRO_VI, TiposCampos.ALFA_NUMERICO);
		tipos.put(NUMERO_DOCUMENTO, TiposCampos.ALFA_NUMERICO);
	}

	@Override
	public void configurarObrigatoriedade() {
		obrigatoriedade.put(CODIGO_BANCO, Boolean.TRUE);
		obrigatoriedade.put(CODIGO_LOTE, Boolean.TRUE);
		obrigatoriedade.put(TIPO_REGISTRO, Boolean.FALSE);
		obrigatoriedade.put(NUMERO_REGISTRO, Boolean.TRUE);
		obrigatoriedade.put(SEGMENTO, Boolean.FALSE);
		obrigatoriedade.put(LANCAMENTO, Boolean.TRUE);
		obrigatoriedade.put(COMPLEMENTO_REGISTRO_I, Boolean.FALSE);
		obrigatoriedade.put(TIPO_INSCRICAO, Boolean.FALSE);
		obrigatoriedade.put(NUMERO_INSCRICAO, Boolean.TRUE);
		obrigatoriedade.put(COMPLEMENTO_REGISTRO_II, Boolean.FALSE);
		obrigatoriedade.put(CONVENIO, Boolean.FALSE);
		obrigatoriedade.put(COMPLEMENTO_REGISTRO_III, Boolean.TRUE);
		obrigatoriedade.put(AGENCIA, Boolean.TRUE);
		obrigatoriedade.put(DAC, Boolean.FALSE);
		obrigatoriedade.put(COMPLEMENTO_REGISTRO_IV, Boolean.TRUE);
		obrigatoriedade.put(CONTA, Boolean.TRUE);
		obrigatoriedade.put(COMPLEMENTO_REGISTRO_V, Boolean.FALSE);
		obrigatoriedade.put(DIGITO, Boolean.FALSE);
		obrigatoriedade.put(NOME_EMPRESA, Boolean.FALSE);
		obrigatoriedade.put(RESERVADO_BANCO, Boolean.FALSE);
		obrigatoriedade.put(NATUREZA_LANCAMENTO, Boolean.FALSE);
		obrigatoriedade.put(TIPO_COMPLEMENTO, Boolean.TRUE);
		obrigatoriedade.put(BANCO_ORIGEM, Boolean.TRUE);
		obrigatoriedade.put(AGENCIA_ORIGEM, Boolean.TRUE);
		obrigatoriedade.put(CONTA_ORIGEM, Boolean.TRUE);
		obrigatoriedade.put(CPMF, Boolean.FALSE);
		obrigatoriedade.put(DATA_CONTABIL, Boolean.FALSE);
		obrigatoriedade.put(DATA_LANCAMENTO, Boolean.TRUE);
		obrigatoriedade.put(VALOR_LANCAMENTO, Boolean.FALSE);
		obrigatoriedade.put(TIPO_LANCAMENTO, Boolean.FALSE);
		obrigatoriedade.put(CATEGORIA_LANCAMENTO, Boolean.FALSE);
		obrigatoriedade.put(CODIGO_LANCAMENTO, Boolean.FALSE);
		obrigatoriedade.put(HISTORICO_LANCAMENTO, Boolean.FALSE);
		obrigatoriedade.put(COMPLEMENTO_REGISTRO_VI, Boolean.FALSE);
		obrigatoriedade.put(NUMERO_DOCUMENTO, Boolean.FALSE);
	}
}
