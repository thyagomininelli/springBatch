package br.com.servico.carga.extrato.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name="ITAU_EXT_TRL_ARQUIVO")
public class ExtratoTrailerArquivoDTO extends ExtratoDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tItauTrlArqSeq")
	@SequenceGenerator(name = "tItauTrlArqSeq", sequenceName = "ITAU_EXT_TRL_ARQUIVO_SEQ", allocationSize = 1)
	@Column(name="itau_ext_trl_arquivo_id")
	private Long idHdrLoteArquivo;
	
	@Column(name="arquivo_carga_id")
	private Long idArquivoCarga;
	
	@Column(name="CODIGO_BANCO")
	private Integer codigoBanco;
		
	@Column(name="CODIGO_LOTE")
	private String codigoLote;
		
	@Column(name="TIPO_REGISTRO")
	private String tipoRegistro;
		
	@Column(name="COMPLEMENTO_REGISTRO_I")
	private String complementoRegistroI;
		
	@Column(name="QTE_LOTES")
	private Integer qteLotes;

	@Column(name="QTE_REGISTROS")
	private Integer qteRegistros;
		
	@Column(name="QTE_CONTAS_CONCIL")
	private Integer qteContasConcil;
	
	@Column(name="COMPLEMENTO_REGISTRO_II")
	private String complementoRegistroII;
		
	public ExtratoTrailerArquivoDTO() {
		super();
	}
	
	public ExtratoTrailerArquivoDTO( Integer codigoBanco, String codigoLote, String tipoRegistro, String complementoRegistroI,
			Integer qteLotes, Integer qteRegistros, Integer qteContasConcil, String complementoRegistroII ) 
	{
		
		super();
		
		this.codigoBanco = codigoBanco;
		this.codigoLote = codigoLote;
		this.tipoRegistro = tipoRegistro;
		this.complementoRegistroI = complementoRegistroI;
		this.qteLotes = qteLotes;
		this.qteRegistros = qteRegistros;
		this.qteContasConcil = qteContasConcil;
		this.complementoRegistroII = complementoRegistroII;
		
	}

	public Integer getCodigoBanco() {
		return codigoBanco;
	}

	public void setCodigoBanco(Integer codigoBanco) {
		this.codigoBanco = codigoBanco;
	}

	public String getCodigoLote() {
		return codigoLote;
	}

	public void setCodigoLote(String codigoLote) {
		this.codigoLote = codigoLote;
	}

	public String getTipoRegistro() {
		return tipoRegistro;
	}

	public void setTipoRegistro(String tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}

	public String getComplementoRegistroI() {
		return complementoRegistroI;
	}

	public void setComplementoRegistroI(String complementoRegistroI) {
		this.complementoRegistroI = complementoRegistroI;
	}

	public Integer getQteLotes() {
		return qteLotes;
	}

	public void setQteLotes(Integer qteLotes) {
		this.qteLotes = qteLotes;
	}

	public Integer getQteRegistros() {
		return qteRegistros;
	}

	public void setQteRegistros(Integer qteRegistros) {
		this.qteRegistros = qteRegistros;
	}

	public Integer getQteContasConcil() {
		return qteContasConcil;
	}

	public void setQteContasConcil(Integer qteContasConcil) {
		this.qteContasConcil = qteContasConcil;
	}

	public String getComplementoRegistroII() {
		return complementoRegistroII;
	}

	public void setComplementoRegistroII(String complementoRegistroII) {
		this.complementoRegistroII = complementoRegistroII;
	}

	public Long getIdArquivoCarga() {
		return idArquivoCarga;
	}

	public void setIdArquivoCarga(Long idArquivoCarga) {
		this.idArquivoCarga = idArquivoCarga;
	}
	
	
}
