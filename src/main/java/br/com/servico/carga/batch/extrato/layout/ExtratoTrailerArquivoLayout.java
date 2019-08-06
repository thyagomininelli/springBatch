package br.com.servico.carga.batch.extrato.layout;

import org.springframework.batch.item.file.transform.Range;

import br.com.servico.carga.batch.layout.LayoutArquivo;
import br.com.servico.carga.batch.layout.TiposCampos;

public class ExtratoTrailerArquivoLayout extends LayoutArquivo {

	private static final long serialVersionUID = -8099135219434199279L;
	
	private static final String CODIGO_BANCO = "codigoBanco";
	private static final Range RANGE_CODIGO_BANCO = new Range(1, 3);

	private static final String CODIGO_LOTE = "codigoLote";
	private static final Range RANGE_CODIGO_LOTE = new Range(4, 7);

	private static final String TIPO_REGISTRO = "tipoRegistro";
	private static final Range RANGE_TIPO_REGISTRO = new Range(8, 8);

	private static final String COMPLEMENTO_REGISTRO_I = "complementoRegistroI";
	private static final Range RANGE_COMPLEMENTO_REGISTRO_I = new Range(9, 17);

	private static final String QTE_LOTES = "qteLotes";
	private static final Range RANGE_QTE_LOTES = new Range(18, 23);

	private static final String QTE_REGISTROS = "qteRegistros";
	private static final Range RANGE_QTE_REGISTROS = new Range(24, 29);

	private static final String QTE_CONTAS_CONCIL = "qteContasConcil";
	private static final Range RANGE_QTE_CONTAS_CONCIL = new Range(30, 35);

	private static final String COMPLEMENTO_REGISTRO_II = "complementoRegistroII";
	private static final Range RANGE_COMPLEMENTO_REGISTRO_II = new Range(36, 240);


	public ExtratoTrailerArquivoLayout() {
		super();
		this.campos = new String[] { CODIGO_BANCO, CODIGO_LOTE, TIPO_REGISTRO, COMPLEMENTO_REGISTRO_I, 
				QTE_LOTES, QTE_REGISTROS, QTE_CONTAS_CONCIL, COMPLEMENTO_REGISTRO_II
				
		};

		this.tamanhos = new Range[] { RANGE_CODIGO_BANCO, RANGE_CODIGO_LOTE, RANGE_TIPO_REGISTRO, RANGE_COMPLEMENTO_REGISTRO_I, 
				RANGE_QTE_LOTES, RANGE_QTE_REGISTROS, RANGE_QTE_CONTAS_CONCIL, RANGE_COMPLEMENTO_REGISTRO_II 
				
		};

		configurarTiposCampos();
		configurarObrigatoriedade();
	}

	@Override
	public void configurarTiposCampos() {
		tipos.put(CODIGO_BANCO, TiposCampos.NUMERICO);
		tipos.put(CODIGO_LOTE, TiposCampos.ALFA_NUMERICO);
		tipos.put(TIPO_REGISTRO, TiposCampos.ALFA_NUMERICO);
		tipos.put(COMPLEMENTO_REGISTRO_I, TiposCampos.ALFA_NUMERICO);
		tipos.put(QTE_LOTES, TiposCampos.NUMERICO);
		tipos.put(QTE_REGISTROS, TiposCampos.NUMERICO);
		tipos.put(QTE_CONTAS_CONCIL, TiposCampos.NUMERICO);
		tipos.put(COMPLEMENTO_REGISTRO_II, TiposCampos.ALFA_NUMERICO);
	}

	@Override
	public void configurarObrigatoriedade() {
		obrigatoriedade.put(CODIGO_BANCO, Boolean.TRUE);
		obrigatoriedade.put(CODIGO_LOTE, Boolean.FALSE);
		obrigatoriedade.put(TIPO_REGISTRO, Boolean.FALSE);
		obrigatoriedade.put(COMPLEMENTO_REGISTRO_I, Boolean.FALSE);
		obrigatoriedade.put(QTE_LOTES, Boolean.TRUE);
		obrigatoriedade.put(QTE_REGISTROS, Boolean.TRUE);
		obrigatoriedade.put(QTE_CONTAS_CONCIL, Boolean.TRUE);
		obrigatoriedade.put(COMPLEMENTO_REGISTRO_II, Boolean.FALSE);
	}

}
