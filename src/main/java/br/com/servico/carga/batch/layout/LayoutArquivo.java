package br.com.servico.carga.batch.layout;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.file.transform.FixedLengthTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.batch.item.file.transform.Range;

public abstract class LayoutArquivo implements Serializable {
	
	private static final long serialVersionUID = -6502064688433640080L;
	
	protected String[] campos;
	protected Range[] tamanhos;
	protected Map<String, TiposCampos> tipos = new HashMap<String, TiposCampos>();
	protected Map<String, Boolean> obrigatoriedade = new HashMap<String, Boolean>();

	public abstract void configurarTiposCampos();
	
	public abstract void configurarObrigatoriedade();
	
	public LineTokenizer configurarParser(){
		FixedLengthTokenizer tokenizer = new FixedLengthTokenizer();
        tokenizer.setColumns(tamanhos);
        tokenizer.setNames(campos);
        tokenizer.setStrict(true);
        return tokenizer;
	}

	public String[] getCampos() {
		return campos;
	}

	public Range[] getTamanhos() {
		return tamanhos;
	}

	public Map<String, TiposCampos> getTipos() {
		return tipos;
	}

	public Map<String, Boolean> getObrigatoriedade() {
		return obrigatoriedade;
	}


}
