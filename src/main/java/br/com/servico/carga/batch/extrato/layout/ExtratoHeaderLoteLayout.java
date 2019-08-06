package br.com.servico.carga.batch.extrato.layout;

import org.springframework.batch.item.file.transform.Range;

import br.com.servico.carga.batch.layout.LayoutArquivo;
import br.com.servico.carga.batch.layout.TiposCampos;

public class ExtratoHeaderLoteLayout extends LayoutArquivo {

	private static final long serialVersionUID = 4571933975865787023L;
	
	private static final String CODIGO_BANCO = "codigoBanco";
	private static final Range RANGE_CODIGO_BANCO = new Range(1, 3);

	private static final String CODIGO_LOTE = "codigoLote";
	private static final Range RANGE_CODIGO_LOTE = new Range(4, 7);

	private static final String TIPO_REGISTRO = "tipoRegistro";
	private static final Range RANGE_TIPO_REGISTRO = new Range(8, 8);

	private static final String TIPO_OPERACAO = "tipoOperacao";
	private static final Range RANGE_TIPO_OPERACAO = new Range(9, 9);

	private static final String SERVICO = "servico";
	private static final Range RANGE_SERVICO = new Range(10, 11);

	private static final String FORMA_LANCAMENTO = "formaLancamento";
	private static final Range RANGE_FORMA_LANCAMENTO = new Range(12, 13);

	private static final String VERSAO_LAYOUT = "versaoLayout";
	private static final Range RANGE_VERSAO_LAYOUT = new Range(14, 16);

	private static final String COMPLEMENTO_REGISTRO_I = "complementoRegistroI";
	private static final Range RANGE_COMPLEMENTO_REGISTRO_I = new Range(17, 17);

	private static final String TIPO_INSCRICAO = "tipoInscricao";
	private static final Range RANGE_TIPO_INSCRICAO= new Range(18, 18);

	private static final String NUMERO_INSCRICAO = "numeroInscricao";
	private static final Range RANGE_NUMERO_INSCRICAO = new Range(19, 32);

	private static final String TIPO_CONTA = "tipoConta";
	private static final Range RANGE_TIPO_CONTA = new Range(33, 36);

	private static final String COMPLEMENTO_REGISTRO_II = "complementoRegistroII";
	private static final Range RANGE_COMPLEMENTO_REGISTRO_II = new Range(37, 47);

	private static final String CONVENIO = "convenio";
	private static final Range RANGE_CONVENIO = new Range(48, 52);

	private static final String COMPLEMENTO_REGISTRO_III = "complementoRegistroIII";
	private static final Range RANGE_RANGE_COMPLEMENTO_REGISTRO_III = new Range(53, 53);

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

	private static final String COMPLEMENTO_REGISTRO_VI = "complementoRegistroVI";
	private static final Range RANGE_COMPLEMENTO_REGISTRO_VI = new Range(103, 142);

	private static final String DATA_INICIAL = "dataInicial";
	private static final Range RANGE_DATA_INICIAL = new Range(143, 150);

	private static final String VALOR_INICIAL = "valorInicial";
	private static final Range RANGE_VALOR_INICIAL = new Range(151, 168);

	private static final String SITUACAO_INICIAL = "situacaoInicial";
	private static final Range RANGE_SITUACAO_INICIAL = new Range(169, 169);

	private static final String STATUS_INICIAL = "statusInicial";
	private static final Range RANGE_STATUS_INICIAL = new Range(170, 170);

	private static final String TIPO_MOEDA = "tipoMoeda";
	private static final Range RANGE_TIPO_MOEDA = new Range(171, 173);

	private static final String NUMERO_SEQUENCIA = "numeroSequencia";
	private static final Range RANGE_NUMERO_SEQUENCIA = new Range(174, 178);

	private static final String COMPLEMENTO_REGISTRO_VII = "complementoRegistroVII";
	private static final Range RANGE_COMPLEMENTO_REGISTRO_VII = new Range(179, 240);


	public ExtratoHeaderLoteLayout() {
		
		super();

		this.campos = new String[] {CODIGO_BANCO, CODIGO_LOTE, TIPO_REGISTRO, TIPO_OPERACAO, SERVICO,
				FORMA_LANCAMENTO, VERSAO_LAYOUT, COMPLEMENTO_REGISTRO_I, TIPO_INSCRICAO, NUMERO_INSCRICAO, 
				TIPO_CONTA, COMPLEMENTO_REGISTRO_II, CONVENIO, COMPLEMENTO_REGISTRO_III, 
				AGENCIA, DAC, COMPLEMENTO_REGISTRO_IV, CONTA, COMPLEMENTO_REGISTRO_V, 
				DIGITO, NOME_EMPRESA, COMPLEMENTO_REGISTRO_VI, DATA_INICIAL, VALOR_INICIAL, 
				SITUACAO_INICIAL, STATUS_INICIAL, TIPO_MOEDA, NUMERO_SEQUENCIA, COMPLEMENTO_REGISTRO_VII
				};

		this.tamanhos = new Range[] {RANGE_CODIGO_BANCO, RANGE_CODIGO_LOTE, RANGE_TIPO_REGISTRO, RANGE_TIPO_OPERACAO, RANGE_SERVICO,
				RANGE_FORMA_LANCAMENTO, RANGE_VERSAO_LAYOUT, RANGE_COMPLEMENTO_REGISTRO_I, RANGE_TIPO_INSCRICAO, RANGE_NUMERO_INSCRICAO, 
				RANGE_TIPO_CONTA, RANGE_COMPLEMENTO_REGISTRO_II, RANGE_CONVENIO, RANGE_RANGE_COMPLEMENTO_REGISTRO_III,
				RANGE_AGENCIA, RANGE_DAC, RANGE_COMPLEMENTO_REGISTRO_IV, RANGE_CONTA, RANGE_COMPLEMENTO_REGISTRO_V, 
				RANGE_DIGITO, RANGE_NOME_EMPRESA, RANGE_COMPLEMENTO_REGISTRO_VI, RANGE_DATA_INICIAL, RANGE_VALOR_INICIAL, 
				RANGE_SITUACAO_INICIAL, RANGE_STATUS_INICIAL, RANGE_TIPO_MOEDA, RANGE_NUMERO_SEQUENCIA, RANGE_COMPLEMENTO_REGISTRO_VII
				};

		this.configurarTiposCampos();
		this.configurarObrigatoriedade();
	}

	@Override
	public void configurarTiposCampos() {
		tipos.put(CODIGO_BANCO, TiposCampos.NUMERICO);
		tipos.put(CODIGO_LOTE, TiposCampos.NUMERICO);
		tipos.put(TIPO_REGISTRO, TiposCampos.ALFA_NUMERICO);
		tipos.put(TIPO_OPERACAO, TiposCampos.ALFA_NUMERICO);
		tipos.put(SERVICO, TiposCampos.NUMERICO);
		tipos.put(FORMA_LANCAMENTO, TiposCampos.NUMERICO);
		tipos.put(VERSAO_LAYOUT, TiposCampos.ALFA_NUMERICO);
		tipos.put(COMPLEMENTO_REGISTRO_I, TiposCampos.ALFA_NUMERICO);
		tipos.put(TIPO_INSCRICAO, TiposCampos.ALFA_NUMERICO);
		tipos.put(NUMERO_INSCRICAO, TiposCampos.NUMERICO);
		tipos.put(TIPO_CONTA, TiposCampos.ALFA_NUMERICO);
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
		tipos.put(COMPLEMENTO_REGISTRO_VI, TiposCampos.ALFA_NUMERICO);
		tipos.put(DATA_INICIAL, TiposCampos.NUMERICO);
		tipos.put(VALOR_INICIAL, TiposCampos.NUMERICO);
		tipos.put(SITUACAO_INICIAL, TiposCampos.ALFA_NUMERICO);
		tipos.put(STATUS_INICIAL, TiposCampos.ALFA_NUMERICO);
		tipos.put(TIPO_MOEDA, TiposCampos.ALFA_NUMERICO);
		tipos.put(NUMERO_SEQUENCIA, TiposCampos.NUMERICO);
		tipos.put(COMPLEMENTO_REGISTRO_VII, TiposCampos.ALFA_NUMERICO);
	}

	@Override
	public void configurarObrigatoriedade() {
		obrigatoriedade.put(CODIGO_BANCO, Boolean.TRUE);
		obrigatoriedade.put(CODIGO_LOTE, Boolean.TRUE);
		obrigatoriedade.put(TIPO_REGISTRO, Boolean.FALSE);
		obrigatoriedade.put(AGENCIA, Boolean.FALSE);
		obrigatoriedade.put(TIPO_OPERACAO, Boolean.FALSE);
		obrigatoriedade.put(SERVICO, Boolean.TRUE);
		obrigatoriedade.put(FORMA_LANCAMENTO, Boolean.TRUE);
		obrigatoriedade.put(VERSAO_LAYOUT, Boolean.FALSE);
		obrigatoriedade.put(COMPLEMENTO_REGISTRO_I, Boolean.FALSE);
		obrigatoriedade.put(TIPO_INSCRICAO, Boolean.FALSE);
		obrigatoriedade.put(NUMERO_INSCRICAO, Boolean.TRUE);
		obrigatoriedade.put(TIPO_CONTA, Boolean.FALSE);
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
		obrigatoriedade.put(COMPLEMENTO_REGISTRO_VI, Boolean.FALSE);
		obrigatoriedade.put(DATA_INICIAL, Boolean.TRUE);
		obrigatoriedade.put(VALOR_INICIAL, Boolean.TRUE);
		obrigatoriedade.put(SITUACAO_INICIAL, Boolean.FALSE);
		obrigatoriedade.put(STATUS_INICIAL, Boolean.FALSE);
		obrigatoriedade.put(TIPO_MOEDA, Boolean.FALSE);
		obrigatoriedade.put(NUMERO_SEQUENCIA, Boolean.TRUE);
		obrigatoriedade.put(COMPLEMENTO_REGISTRO_VII, Boolean.FALSE);
	}
}
