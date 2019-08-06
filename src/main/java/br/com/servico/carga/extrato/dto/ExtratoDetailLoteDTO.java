package br.com.servico.carga.extrato.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name="ITAU_EXT_DTL_LOTE")
public class ExtratoDetailLoteDTO extends ExtratoDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tItauDtlLoteSeq")
	@SequenceGenerator(name = "tItauDtlLoteSeq", sequenceName = "ITAU_EXT_DTL_LOTE_SEQ", allocationSize = 1)
	@Column(name="itau_ext_dtl_lote_id")
	private Long idHdrArquivo;
	
	@Column(name="arquivo_carga_id")
	private Long idArquivoCarga;
	
	@Column(name="CODIGO_BANCO")
	private Integer codigoBanco;
	
	@Column(name="CODIGO_LOTE")
	private Integer codigoLote;

	@Column(name="TIPO_REGISTRO")
	private String tipoRegistro;
	
	@Column(name="NUMERO_REGISTRO")
	private Integer numeroRegistro;
	
	@Column(name="SEGMENTO")
	private String codigoSegmento;

	@Column(name="LANCAMENTO")
	private Long lancamento;
	
	@Column(name="COMPLEMENTO_REGISTRO_I")
	private String complementoRegistroI;

	@Column(name="TIPO_INSCRICAO")
	private String tipoInscricao;

	@Column(name="NUMERO_INSCRICAO")
	private Long numeroInscricao;

	@Column(name="COMPLEMENTO_REGISTRO_II")
	private String complementoRegistroII;

	@Column(name="CONVENIO")
	private String convenio;

	@Column(name="COMPLEMENTO_REGISTRO_III")
	private Integer complementoRegistroIII;

	@Column(name="AGENCIA")
	private Integer agencia;

	@Column(name="DAC")
	private String dac;
	
	@Column(name="COMPLEMENTO_REGISTRO_IV")
	private Integer complementoRegistroIV;
	
	@Column(name="CONTA")
	private Integer conta;

	@Column(name="COMPLEMENTO_REGISTRO_V")
	private String complementoRegistroV;

	@Column(name="DIGITO")
	private String digito;

	@Column(name="NOME_EMPRESA")
	private String nomeEmpresa;
	
	@Column(name="RESERVADO_BANCO")
	private String reservadoBanco;

	@Column(name="NATUREZA_LANCAMENTO")
	private String naturezaLancamento;

	@Column(name="TIPO_COMPLEMENTO")
	private Integer tipoComplemento;

	@Column(name="BANCO_ORIGEM")
	private Integer bancoOrigem;

	@Column(name="AGENCIA_ORIGEM")
	private Integer agenciaOrigem;

	@Column(name="CONTA_ORIGEM")
	private Long contaOrigem;

	@Column(name="CPMF")
	private String cpmf;

	@Column(name="DATA_CONTABIL")
	private Date dataContabil;

	@Column(name="DATA_LANCAMENTO")
	private Date dataLancamento;

	@Column(name="VALOR_LANCAMENTO")
	private Double valorLancamento;

	@Column(name="TIPO_LANCAMENTO")
	private String tipoLancamento;

	@Column(name="CATEGORIA_LANCAMENTO")
	private Integer categoriaLancamento;

	@Column(name="CODIGO_LANCAMENTO")
	private String codigoLancamento;

	@Column(name="HISTORICO_LANCAMENTO")
	private String historicoLancamento;
	
	@Column(name="COMPLEMENTO_REGISTRO_VI")
	private String complementoRegistroVI;
	
	@Column(name="NUMERO_DOCUMENTO")
	private String numeroDocumento;
	
	public ExtratoDetailLoteDTO() {
		super();
	}

	public ExtratoDetailLoteDTO( Integer codigoBanco, Integer codigoLote, String tipoRegistro, Integer numeroRegistro,
			String codigoSegmento, Long lancamento, String complementoRegistroI, String tipoInscricao, Long numeroInscricao,
			String complementoRegistroII, String convenio, Integer complementoRegistroIII, Integer agencia, String dac,
		    Integer complementoRegistroIV, Integer conta, String complementoRegistroV, String digito, String nomeEmpresa,
		    String reservadoBanco, String naturezaLancamento, Integer tipoComplemento, Integer bancoOrigem,
			Integer agenciaOrigem, Long contaOrigem, String cpmf, Date dataContabil, Date dataLancamento, Double valorLancamento,
			String tipoLancamento, Integer categoriaLancamento, String codigoLancamento, String historicoLancamento,
			String complementoRegistroVI, String numeroDocumento) 
		{
		super();
		
		this.codigoBanco = codigoBanco;
		this.codigoLote = codigoLote;
		this.tipoRegistro = tipoRegistro;
		this.numeroRegistro = numeroRegistro;
		this.codigoSegmento = codigoSegmento;
		this.lancamento = lancamento; 
		this.complementoRegistroI = complementoRegistroI;
		this.tipoInscricao = tipoInscricao;
		this.numeroInscricao = numeroInscricao;
		this.complementoRegistroII = complementoRegistroII;
		this.convenio = convenio;
		this.complementoRegistroIII = complementoRegistroIII;
		this.agencia = agencia; 
		this.dac = dac;
		this.complementoRegistroIV = complementoRegistroIV;
		this.conta = conta;
		this.complementoRegistroV = complementoRegistroV;
		this.digito = digito;
		this.nomeEmpresa = nomeEmpresa;
		this.reservadoBanco = reservadoBanco; 
		this.naturezaLancamento = naturezaLancamento;
		this.tipoComplemento = tipoComplemento;
		this.bancoOrigem = bancoOrigem;
		this.agenciaOrigem = agenciaOrigem;
		this.contaOrigem = contaOrigem;
		this.cpmf = cpmf;
		this.dataContabil = dataContabil;
		this.dataLancamento =  dataLancamento;
		this.valorLancamento = valorLancamento;
		this.tipoLancamento = tipoLancamento;
		this.categoriaLancamento = categoriaLancamento;
		this.codigoLancamento = codigoLancamento;
		this.historicoLancamento = historicoLancamento; 
		this.complementoRegistroVI = complementoRegistroVI;
		this.numeroDocumento = numeroDocumento;
	}

	public Integer getCodigoBanco() {
		return codigoBanco;
	}

	public void setCodigoBanco(Integer codigoBanco) {
		this.codigoBanco = codigoBanco;
	}

	public Integer getCodigoLote() {
		return codigoLote;
	}

	public void setCodigoLote(Integer codigoLote) {
		this.codigoLote = codigoLote;
	}

	public String getTipoRegistro() {
		return tipoRegistro;
	}

	public void setTipoRegistro(String tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}

	public Integer getNumeroRegistro() {
		return numeroRegistro;
	}

	public void setNumeroRegistro(Integer numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}

	public String getCodigoSegmento() {
		return codigoSegmento;
	}

	public void setCodigoSegmento(String codigoSegmento) {
		this.codigoSegmento = codigoSegmento;
	}

	public Long getLancamento() {
		return lancamento;
	}

	public void setLancamento(Long lancamento) {
		this.lancamento = lancamento;
	}

	public String getComplementoRegistroI() {
		return complementoRegistroI;
	}

	public void setComplementoRegistroI(String complementoRegistroI) {
		this.complementoRegistroI = complementoRegistroI;
	}

	public String getTipoInscricao() {
		return tipoInscricao;
	}

	public void setTipoInscricao(String tipoInscricao) {
		this.tipoInscricao = tipoInscricao;
	}

	public Long getNumeroInscricao() {
		return numeroInscricao;
	}

	public void setNumeroInscricao(Long numeroInscricao) {
		this.numeroInscricao = numeroInscricao;
	}

	public String getComplementoRegistroII() {
		return complementoRegistroII;
	}

	public void setComplementoRegistroII(String complementoRegistroII) {
		this.complementoRegistroII = complementoRegistroII;
	}

	public String getConvenio() {
		return convenio;
	}

	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}

	public Integer getComplementoRegistroIII() {
		return complementoRegistroIII;
	}

	public void setComplementoRegistroIII(Integer complementoRegistroIII) {
		this.complementoRegistroIII = complementoRegistroIII;
	}

	public Integer getAgencia() {
		return agencia;
	}

	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}

	public String getDac() {
		return dac;
	}

	public void setDac(String dac) {
		this.dac = dac;
	}

	public Integer getComplementoRegistroIV() {
		return complementoRegistroIV;
	}

	public void setComplementoRegistroIV(Integer complementoRegistroIV) {
		this.complementoRegistroIV = complementoRegistroIV;
	}

	public Integer getConta() {
		return conta;
	}

	public void setConta(Integer conta) {
		this.conta = conta;
	}

	public String getComplementoRegistroV() {
		return complementoRegistroV;
	}

	public void setComplementoRegistroV(String complementoRegistroV) {
		this.complementoRegistroV = complementoRegistroV;
	}

	public String getDigito() {
		return digito;
	}

	public void setDigito(String digito) {
		this.digito = digito;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getReservadoBanco() {
		return reservadoBanco;
	}

	public void setReservadoBanco(String reservadoBanco) {
		this.reservadoBanco = reservadoBanco;
	}

	public String getNaturezaLancamento() {
		return naturezaLancamento;
	}

	public void setNaturezaLancamento(String naturezaLancamento) {
		this.naturezaLancamento = naturezaLancamento;
	}

	public Integer getTipoComplemento() {
		return tipoComplemento;
	}

	public void setTipoComplemento(Integer tipoComplemento) {
		this.tipoComplemento = tipoComplemento;
	}

	public Integer getBancoOrigem() {
		return bancoOrigem;
	}

	public void setBancoOrigem(Integer bancoOrigem) {
		this.bancoOrigem = bancoOrigem;
	}

	public Integer getAgenciaOrigem() {
		return agenciaOrigem;
	}

	public void setAgenciaOrigem(Integer agenciaOrigem) {
		this.agenciaOrigem = agenciaOrigem;
	}

	public Long getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(Long contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public String getCpmf() {
		return cpmf;
	}

	public void setCpmf(String cpmf) {
		this.cpmf = cpmf;
	}

	public Date getDataContabil() {
		return dataContabil;
	}

	public void setDataContabil(Date dataContabil) {
		this.dataContabil = dataContabil;
	}

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Double getValorLancamento() {
		return valorLancamento;
	}

	public void setValorLancamento(Double valorLancamento) {
		this.valorLancamento = valorLancamento;
	}

	public String getTipoLancamento() {
		return tipoLancamento;
	}

	public void setTipoLancamento(String tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}

	public Integer getCategoriaLancamento() {
		return categoriaLancamento;
	}

	public void setCategoriaLancamento(Integer categoriaLancamento) {
		this.categoriaLancamento = categoriaLancamento;
	}

	public String getCodigoLancamento() {
		return codigoLancamento;
	}

	public void setCodigoLancamento(String codigoLancamento) {
		this.codigoLancamento = codigoLancamento;
	}

	public String getHistoricoLancamento() {
		return historicoLancamento;
	}

	public void setHistoricoLancamento(String historicoLancamento) {
		this.historicoLancamento = historicoLancamento;
	}

	public String getComplementoRegistroVI() {
		return complementoRegistroVI;
	}

	public void setComplementoRegistroVI(String complementoRegistroVI) {
		this.complementoRegistroVI = complementoRegistroVI;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public Long getIdArquivoCarga() {
		return idArquivoCarga;
	}

	public void setIdArquivoCarga(Long idArquivoCarga) {
		this.idArquivoCarga = idArquivoCarga;
	}
	
	
}
