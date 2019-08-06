package br.com.servico.carga.batch.extrato.layout;

import org.springframework.batch.item.file.transform.Range;

import br.com.servico.carga.batch.layout.LayoutArquivo;
import br.com.servico.carga.batch.layout.TiposCampos;

public class ExtratoHeaderArquivoLayout extends LayoutArquivo {

	private static final long serialVersionUID = -3263592124372503752L;
	
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
	private static final Range RANGE_CONTA = new Range(66, 70);

	private static final String COMPLEMENTO_REGISTRO_V = "complementoRegistroV";
	private static final Range RANGE_COMPLEMENTO_REGISTRO_V = new Range(71, 71);
	
	private static final String DIGITO = "digito";
	private static final Range RANGE_DIGITO = new Range(72, 72);

	private static final String NOME_EMPRESA = "nomeEmpresa";
	private static final Range RANGE_NOME_EMPRESA = new Range(73, 102);

	private static final String NOME_BANCO = "nomeBanco";
	private static final Range RANGE_NOME_BANCO = new Range(103, 132);

	private static final String COMPLEMENTO_REGISTRO_VI = "complementoRegistroVI";
	private static final Range RANGE_COMPLEMENTO_REGISTRO_VI= new Range(133, 142);

	private static final String CODIGO_RETORNO = "codigoRetorno";
	private static final Range RANGE_CODIGO_RETORNO = new Range(143, 143);

	private static final String DATA_GERACAO = "dataGeracao";
	private static final Range RANGE_DATA_GERACAO = new Range(144, 151);

	private static final String HORA_GERACAO = "horaGeracao";
	private static final Range RANGE_HORA_GERACAO = new Range(152, 157);

	private static final String NUMERO_SEQUENCIA = "numeroSequencia";
	private static final Range RANGE_NUMERO_SEQUENCIA = new Range(158, 163);

	private static final String VERSAO_LAYOUT = "versaoLayout";
	private static final Range RANGE_VERSAO_LAYOUT = new Range(164, 166);

	private static final String COMPLEMENTO_REGISTRO_VII = "complementoRegistroVII";
	private static final Range RANGE_COMPLEMENTO_REGISTRO_VII = new Range(167, 171);

	private static final String RESERVADO_BANCO = "reservadoBanco";
	private static final Range RANGE_RESERVADO_BANCO = new Range(172, 191);

	private static final String COMPLEMENTO_REGISTRO_VIII = "complementoRegistroVIII";
	private static final Range RANGE_COMPLEMENTO_REGISTRO_VIII = new Range(192, 240);
	
	
	public ExtratoHeaderArquivoLayout() {
		
		super();
		
		this.campos = new String[] { CODIGO_BANCO, CODIGO_LOTE, TIPO_REGISTRO, COMPLEMENTO_REGISTRO_I, 
				TIPO_INSCRICAO, NUMERO_INSCRICAO, COMPLEMENTO_REGISTRO_II, CONVENIO, COMPLEMENTO_REGISTRO_III, 
				AGENCIA, DAC, COMPLEMENTO_REGISTRO_IV, CONTA, COMPLEMENTO_REGISTRO_V, DIGITO,
				NOME_EMPRESA, NOME_BANCO, COMPLEMENTO_REGISTRO_VI, CODIGO_RETORNO,
				DATA_GERACAO, HORA_GERACAO, NUMERO_SEQUENCIA, VERSAO_LAYOUT, COMPLEMENTO_REGISTRO_VII, 
				RESERVADO_BANCO, COMPLEMENTO_REGISTRO_VIII
				};
		
		this.tamanhos = new Range[] {RANGE_CODIGO_BANCO, RANGE_CODIGO_LOTE, RANGE_TIPO_REGISTRO, RANGE_COMPLEMENTO_REGISTRO_I, 
				RANGE_TIPO_INSCRICAO, RANGE_NUMERO_INSCRICAO, RANGE_COMPLEMENTO_REGISTRO_II, RANGE_CONVENIO, RANGE_COMPLEMENTO_REGISTRO_III,
				RANGE_AGENCIA, RANGE_DAC, RANGE_COMPLEMENTO_REGISTRO_IV, RANGE_CONTA, RANGE_COMPLEMENTO_REGISTRO_V, RANGE_DIGITO,
				RANGE_NOME_EMPRESA, RANGE_NOME_BANCO, RANGE_COMPLEMENTO_REGISTRO_VI, RANGE_CODIGO_RETORNO,
				RANGE_DATA_GERACAO, RANGE_HORA_GERACAO, RANGE_NUMERO_SEQUENCIA, RANGE_VERSAO_LAYOUT, RANGE_COMPLEMENTO_REGISTRO_VII,
				RANGE_RESERVADO_BANCO, RANGE_COMPLEMENTO_REGISTRO_VIII
				};

		configurarTiposCampos();
		configurarObrigatoriedade();
	}

	@Override
	public void configurarTiposCampos() {
		tipos.put(CODIGO_BANCO, TiposCampos.NUMERICO);
		tipos.put(CODIGO_LOTE, TiposCampos.NUMERICO);
		tipos.put(TIPO_REGISTRO, TiposCampos.ALFA_NUMERICO);
		tipos.put(COMPLEMENTO_REGISTRO_I, TiposCampos.ALFA_NUMERICO);
		tipos.put(TIPO_INSCRICAO, TiposCampos.ALFA_NUMERICO);
		tipos.put(NUMERO_INSCRICAO, TiposCampos.NUMERICO);
		tipos.put(COMPLEMENTO_REGISTRO_II, TiposCampos.ALFA_NUMERICO);
		tipos.put(CONVENIO, TiposCampos.ALFA_NUMERICO);
		tipos.put(COMPLEMENTO_REGISTRO_III, TiposCampos.NUMERICO);
		tipos.put(AGENCIA, TiposCampos.NUMERICO);
		tipos.put(DAC, TiposCampos.NUMERICO);
		tipos.put(COMPLEMENTO_REGISTRO_IV, TiposCampos.NUMERICO);
		tipos.put(CONTA, TiposCampos.NUMERICO);
		tipos.put(COMPLEMENTO_REGISTRO_V, TiposCampos.ALFA_NUMERICO);
		tipos.put(DIGITO, TiposCampos.ALFA_NUMERICO);
		tipos.put(NOME_EMPRESA, TiposCampos.ALFA_NUMERICO);
		tipos.put(NOME_BANCO, TiposCampos.ALFA_NUMERICO);
		tipos.put(COMPLEMENTO_REGISTRO_VI, TiposCampos.ALFA_NUMERICO);
		tipos.put(CODIGO_RETORNO, TiposCampos.ALFA_NUMERICO);
		tipos.put(DATA_GERACAO, TiposCampos.NUMERICO);
		tipos.put(HORA_GERACAO, TiposCampos.NUMERICO);
		tipos.put(NUMERO_SEQUENCIA, TiposCampos.NUMERICO);
		tipos.put(VERSAO_LAYOUT, TiposCampos.NUMERICO);
		tipos.put(COMPLEMENTO_REGISTRO_VII, TiposCampos.NUMERICO);
		tipos.put(RESERVADO_BANCO, TiposCampos.ALFA_NUMERICO);
		tipos.put(COMPLEMENTO_REGISTRO_VIII, TiposCampos.ALFA_NUMERICO);
	}


	@Override
	public void configurarObrigatoriedade() {
		obrigatoriedade.put(CODIGO_BANCO, Boolean.TRUE);
		obrigatoriedade.put(CODIGO_LOTE, Boolean.TRUE);
		obrigatoriedade.put(TIPO_REGISTRO, Boolean.FALSE);
		obrigatoriedade.put(COMPLEMENTO_REGISTRO_I, Boolean.FALSE);
		obrigatoriedade.put(TIPO_INSCRICAO, Boolean.FALSE);
		obrigatoriedade.put(NUMERO_INSCRICAO, Boolean.TRUE);
		obrigatoriedade.put(COMPLEMENTO_REGISTRO_II, Boolean.FALSE);
		obrigatoriedade.put(CONVENIO, Boolean.FALSE);
		obrigatoriedade.put(COMPLEMENTO_REGISTRO_III, Boolean.TRUE);
		obrigatoriedade.put(AGENCIA, Boolean.TRUE);
		obrigatoriedade.put(DAC, Boolean.TRUE);
		obrigatoriedade.put(COMPLEMENTO_REGISTRO_IV, Boolean.TRUE);
		obrigatoriedade.put(CONTA, Boolean.TRUE);
		obrigatoriedade.put(COMPLEMENTO_REGISTRO_V, Boolean.FALSE);
		obrigatoriedade.put(DIGITO, Boolean.FALSE);
		obrigatoriedade.put(NOME_EMPRESA, Boolean.FALSE);
		obrigatoriedade.put(NOME_BANCO, Boolean.FALSE);
		obrigatoriedade.put(COMPLEMENTO_REGISTRO_VI, Boolean.FALSE);
		obrigatoriedade.put(CODIGO_RETORNO, Boolean.FALSE);
		obrigatoriedade.put(DATA_GERACAO, Boolean.TRUE);
		obrigatoriedade.put(HORA_GERACAO, Boolean.TRUE);
		obrigatoriedade.put(NUMERO_SEQUENCIA, Boolean.TRUE);
		obrigatoriedade.put(VERSAO_LAYOUT, Boolean.FALSE);
		obrigatoriedade.put(COMPLEMENTO_REGISTRO_VII, Boolean.TRUE);
		obrigatoriedade.put(RESERVADO_BANCO, Boolean.FALSE);
		obrigatoriedade.put(COMPLEMENTO_REGISTRO_VIII, Boolean.FALSE);
	}

}
