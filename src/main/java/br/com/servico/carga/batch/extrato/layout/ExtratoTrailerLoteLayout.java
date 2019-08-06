package br.com.servico.carga.batch.extrato.layout;

import org.springframework.batch.item.file.transform.Range;

import br.com.servico.carga.batch.layout.LayoutArquivo;
import br.com.servico.carga.batch.layout.TiposCampos;

public class ExtratoTrailerLoteLayout extends LayoutArquivo {

	private static final long serialVersionUID = -2610865241217066104L;
	
	private static final String CODIGO_BANCO = "codigoBanco";
	private static final Range RANGE_CODIGO_BANCO = new Range(1, 3);

	private static final String CODIGO_LOTE = "codigoLote";
	private static final Range RANGE_CODIGO_LOTE = new Range(4, 7);

	private static final String TIPO_REGISTRO = "tipoRegistro";
	private static final Range RANGE_TIPO_REGISTRO = new Range(8, 8);

	private static final String COMPLEMENTO_REGISTRO_I = "complementoRegistroI";
	private static final Range RANGE_COMPLEMENTO_REGISTRO_I = new Range(9, 17);

	private static final String TIPO_INSCRICAO = "tipoInscricao";
	private static final Range RANGE_TIPO_INSCRICAO = new Range(18, 18);

	private static final String NUMERO_INSCRICAO = "numeroInscricao";
	private static final Range RANGE_NUMERO_INSCRICAO= new Range(19, 32);

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
	private static final Range RANGE_CONTA= new Range(66, 70);

	private static final String COMPLEMENTO_REGISTRO_V = "complementoRegistroV";
	private static final Range RANGE_COMPLEMENTO_REGISTRO_V = new Range(71, 71);

	private static final String DIGITO = "digito";
	private static final Range RANGE_DIGITO = new Range(72, 72);

	private static final String COMPLEMENTO_REGISTRO_VI = "complementoRegistroVI";
	private static final Range RANGE_COMPLEMENTO_REGISTRO_VI= new Range(73, 88);

	private static final String BLOQUEADO_ACIMA_24_HS = "bloqueadoAcima24Hs";
	private static final Range RANGE_BLOQUEADO_ACIMA_24_HS = new Range(89, 106);
	
	private static final String LIMITE_CONTA = "limiteConta";
	private static final Range RANGE_LIMITE_CONTA = new Range(107, 124);
	
	private static final String BLOQUEADO_ATE_24_HS = "bloqueadoAte24Hs";
	private static final Range RANGE_BLOQUEADO_ATE_24_HS = new Range(125, 142);

	private static final String DATA_FINAL = "dataFinal";
	private static final Range RANGE_DATA_FINAL = new Range(143, 150);

	private static final String SALDO_FINAL = "saldoFinal";
	private static final Range RANGE_SALDO_FINAL = new Range(151, 168);

	private static final String SITUACAO_SALDO = "situacaoSaldo";
	private static final Range RANGE_SITUACAO_SALDO = new Range(169, 169);

	private static final String STATUS_SALDO = "statusSaldo";
	private static final Range RANGE_STATUS_SALDO = new Range(170, 170);

	private static final String QTE_REGISTROS = "qteRegistros";
	private static final Range RANGE_QTE_REGISTROS = new Range(171, 176);

	private static final String SOMATORIA_DEBITOS = "somatoriaDebitos";
	private static final Range RANGE_SOMATORIA_DEBITOS = new Range(177, 194);

	private static final String SOMATORIA_CREDITOS = "somatoriaCreditos";
	private static final Range RANGE_SOMATORIA_CREDITOS = new Range(195, 212);

	private static final String SOMATORIA_NAO_CONTABEIS = "somatoriaNaoContabeis";
	private static final Range RANGE_SOMATORIA_NAO_CONTABEIS = new Range(213, 230);

	private static final String COMPLEMENTO_REGISTRO_VII = "complementoRegistrosVII";
	private static final Range RANGE_RANGE_COMPLEMENTO_REGISTRO_VII = new Range(231, 240);

	public ExtratoTrailerLoteLayout() {
		this.campos = new String[] { CODIGO_BANCO, CODIGO_LOTE, TIPO_REGISTRO, COMPLEMENTO_REGISTRO_I, 
				TIPO_INSCRICAO, NUMERO_INSCRICAO, COMPLEMENTO_REGISTRO_II, CONVENIO, COMPLEMENTO_REGISTRO_III,
				AGENCIA, DAC, COMPLEMENTO_REGISTRO_IV, CONTA, COMPLEMENTO_REGISTRO_V, DIGITO, 
				COMPLEMENTO_REGISTRO_VI, BLOQUEADO_ACIMA_24_HS, LIMITE_CONTA, BLOQUEADO_ATE_24_HS,
				DATA_FINAL, SALDO_FINAL, SITUACAO_SALDO, STATUS_SALDO, QTE_REGISTROS,
				SOMATORIA_DEBITOS, SOMATORIA_CREDITOS, SOMATORIA_NAO_CONTABEIS, COMPLEMENTO_REGISTRO_VII
		};

		this.tamanhos = new Range[] { RANGE_CODIGO_BANCO, RANGE_CODIGO_LOTE, RANGE_TIPO_REGISTRO, RANGE_COMPLEMENTO_REGISTRO_I, 
				RANGE_TIPO_INSCRICAO, RANGE_NUMERO_INSCRICAO, RANGE_COMPLEMENTO_REGISTRO_II, RANGE_CONVENIO, RANGE_COMPLEMENTO_REGISTRO_III,
				RANGE_AGENCIA, RANGE_DAC, RANGE_COMPLEMENTO_REGISTRO_IV, RANGE_CONTA, RANGE_COMPLEMENTO_REGISTRO_V, RANGE_DIGITO, 
				RANGE_COMPLEMENTO_REGISTRO_VI, RANGE_BLOQUEADO_ACIMA_24_HS, RANGE_LIMITE_CONTA, RANGE_BLOQUEADO_ATE_24_HS, 
				RANGE_DATA_FINAL, RANGE_SALDO_FINAL, RANGE_SITUACAO_SALDO, RANGE_STATUS_SALDO,  RANGE_QTE_REGISTROS, 
				RANGE_SOMATORIA_DEBITOS, RANGE_SOMATORIA_CREDITOS, RANGE_SOMATORIA_NAO_CONTABEIS, RANGE_RANGE_COMPLEMENTO_REGISTRO_VII
		};

		this.configurarTiposCampos();
		this.configurarObrigatoriedade();
	}

	@Override
	public void configurarTiposCampos() {
		tipos.put(CODIGO_BANCO, TiposCampos.NUMERICO);
		tipos.put(CODIGO_LOTE, TiposCampos.NUMERICO);
		tipos.put(TIPO_REGISTRO, TiposCampos.ALFA_NUMERICO);
		tipos.put(COMPLEMENTO_REGISTRO_I, TiposCampos.ALFA_NUMERICO);
		tipos.put(TIPO_INSCRICAO, TiposCampos.NUMERICO);
		tipos.put(NUMERO_INSCRICAO, TiposCampos.NUMERICO);
		tipos.put(COMPLEMENTO_REGISTRO_II, TiposCampos.ALFA_NUMERICO);
		tipos.put(CONVENIO, TiposCampos.NUMERICO);
		tipos.put(COMPLEMENTO_REGISTRO_III, TiposCampos.ALFA_NUMERICO);
		tipos.put(AGENCIA, TiposCampos.ALFA_NUMERICO);
		tipos.put(DAC, TiposCampos.NUMERICO);
		tipos.put(COMPLEMENTO_REGISTRO_IV, TiposCampos.NUMERICO);
		tipos.put(CONTA, TiposCampos.NUMERICO);
		tipos.put(COMPLEMENTO_REGISTRO_V, TiposCampos.ALFA_NUMERICO);
		tipos.put(DIGITO, TiposCampos.NUMERICO);
		tipos.put(COMPLEMENTO_REGISTRO_VI, TiposCampos.ALFA_NUMERICO);
		tipos.put(BLOQUEADO_ACIMA_24_HS, TiposCampos.NUMERICO);
		tipos.put(LIMITE_CONTA, TiposCampos.ALFA_NUMERICO);
		tipos.put(BLOQUEADO_ATE_24_HS, TiposCampos.ALFA_NUMERICO);
		tipos.put(DATA_FINAL, TiposCampos.NUMERICO);
		tipos.put(SALDO_FINAL, TiposCampos.NUMERICO);
		tipos.put(SITUACAO_SALDO, TiposCampos.ALFA_NUMERICO);
		tipos.put(STATUS_SALDO, TiposCampos.ALFA_NUMERICO);
		tipos.put(QTE_REGISTROS, TiposCampos.NUMERICO);
		tipos.put(SOMATORIA_DEBITOS, TiposCampos.NUMERICO);
		tipos.put(SOMATORIA_CREDITOS, TiposCampos.NUMERICO);
		tipos.put(SOMATORIA_NAO_CONTABEIS, TiposCampos.NUMERICO);
		tipos.put(COMPLEMENTO_REGISTRO_VII, TiposCampos.ALFA_NUMERICO);
	}

	@Override
	public void configurarObrigatoriedade() {
		obrigatoriedade.put(CODIGO_BANCO, Boolean.TRUE);
		obrigatoriedade.put(CODIGO_LOTE, Boolean.TRUE);
		obrigatoriedade.put(TIPO_REGISTRO, Boolean.FALSE);
		obrigatoriedade.put(COMPLEMENTO_REGISTRO_I, Boolean.FALSE);
		obrigatoriedade.put(TIPO_INSCRICAO, Boolean.TRUE);
		obrigatoriedade.put(NUMERO_INSCRICAO, Boolean.TRUE);
		obrigatoriedade.put(COMPLEMENTO_REGISTRO_II, Boolean.FALSE);
		obrigatoriedade.put(CONVENIO, Boolean.TRUE);
		obrigatoriedade.put(COMPLEMENTO_REGISTRO_III, Boolean.FALSE);
		obrigatoriedade.put(AGENCIA, Boolean.FALSE);
		obrigatoriedade.put(DAC, Boolean.TRUE);
		obrigatoriedade.put(COMPLEMENTO_REGISTRO_IV, Boolean.TRUE);
		obrigatoriedade.put(CONTA, Boolean.TRUE);
		obrigatoriedade.put(COMPLEMENTO_REGISTRO_V, Boolean.FALSE);
		obrigatoriedade.put(DIGITO, Boolean.TRUE);
		obrigatoriedade.put(COMPLEMENTO_REGISTRO_VI, Boolean.FALSE);
		obrigatoriedade.put(BLOQUEADO_ACIMA_24_HS, Boolean.FALSE);
		obrigatoriedade.put(LIMITE_CONTA, Boolean.FALSE);
		obrigatoriedade.put(BLOQUEADO_ATE_24_HS, Boolean.FALSE);
		obrigatoriedade.put(DATA_FINAL, Boolean.TRUE);
		obrigatoriedade.put(SALDO_FINAL, Boolean.TRUE);
		obrigatoriedade.put(SITUACAO_SALDO, Boolean.FALSE);
		obrigatoriedade.put(STATUS_SALDO, Boolean.FALSE);
		obrigatoriedade.put(QTE_REGISTROS, Boolean.TRUE);
		obrigatoriedade.put(SOMATORIA_DEBITOS, Boolean.TRUE);
		obrigatoriedade.put(SOMATORIA_CREDITOS, Boolean.TRUE);
		obrigatoriedade.put(SOMATORIA_NAO_CONTABEIS, Boolean.TRUE);
		obrigatoriedade.put(COMPLEMENTO_REGISTRO_VII, Boolean.FALSE);
	}

}
