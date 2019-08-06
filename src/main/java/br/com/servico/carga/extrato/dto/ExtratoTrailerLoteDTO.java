package br.com.servico.carga.extrato.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name="ITAU_EXT_TRL_LOTE")
public class ExtratoTrailerLoteDTO extends ExtratoDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tItauTrlLoteSeq")
	@SequenceGenerator(name = "tItauTrlLoteSeq", sequenceName = "ITAU_EXT_TRL_LOTE_SEQ", allocationSize = 1)
	@Column(name="itau_ext_trl_lote_id")
	private Long idHdrLoteArquivo;
	
	@Column(name="arquivo_carga_id")
	private Long idArquivoCarga;
	
	@Column(name="CODIGO_BANCO")
	private Integer codigoBanco;

	@Column(name="CODIGO_LOTE")
	private Integer codigoLote;
	
	@Column(name="TIPO_REGISTRO")
	private String tipoRegistro;
	
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

	@Column(name="COMPLEMENTO_REGISTRO_VI")
	private String complementoRegistroVI;
	
	@Column(name="BLOQUEADO_ACIMA_24")
	private Double bloqueadoAcima24Hs;
	
	@Column(name="LIMITE_CONTA")
	private Double limiteConta;
	 
	@Column(name="BLOQUEADO_ATE_24")
	private Double bloqueadoAte24Hs;
	
	@Column(name="DATA_FINAL")
	private Date dataFinal;
	
	@Column(name="SALDO_FINAL")
	private Double saldoFinal;
	
	@Column(name="SITUACAO_SALDO")
	private String situacaoSaldo;
		
	@Column(name="STATUS_SALDO")
	private String statusSaldo;
	
	@Column(name="QTE_REGISTROS")
	private Integer qteRegistros;

	@Column(name="SOMATORIA_DEBITOS")
	private Double somatoriaDebitos;
	
	@Column(name="SOMATORIA_CREDITOS")
	private Double somatoriaCreditos;
	
	@Column(name="SOMATORIA_NAO_CONTABEIS")
	private Double somatoriaNaoContabeis;
	
	@Column(name="COMPLEMENTO_REGISTRO_VII")
	private String complementoRegistrosVII;
	
	public ExtratoTrailerLoteDTO() {
		super();
	}
	
	public ExtratoTrailerLoteDTO( Integer codigoBanco, Integer codigoLote, String tipoRegistro, String complementoRegistroI, String tipoInscricao,
			Long numeroInscricao, String complementoRegistroII, String convenio, Integer complementoRegistroIII, Integer agencia,
			String dac, Integer complementoRegistroIV, Integer conta, String complementoRegistroV, String digito, String complementoRegistroVI,
			Double bloqueadoAcima24Hs, Double limiteConta, Double bloqueadoAte24Hs, Date dataFinal, Double saldoFinal, String situacaoSaldo,
			String statusSaldo, Integer qteRegistros, Double somatoriaDebitos, Double somatoriaCreditos, Double somatoriaNaoContabeis,
			String complementoRegistrosVII ) 
		{
		
		super();
		
		this.codigoBanco = codigoBanco;
		this.codigoLote = codigoLote;
		this.tipoRegistro = tipoRegistro;
		this.complementoRegistroI = complementoRegistroI;
		this.tipoInscricao = tipoInscricao;
		this.numeroInscricao = numeroInscricao;
		this.complementoRegistroII = complementoRegistroII;
		this.convenio = convenio;
		this.complementoRegistroIII =complementoRegistroIII;
		this.agencia = agencia;
		this.dac = dac;
		this.complementoRegistroIV = complementoRegistroIV;
		this.conta = conta;
		this.complementoRegistroV = complementoRegistroV;
		this.digito = digito;
		this.complementoRegistroVI = complementoRegistroVI;
		this.bloqueadoAcima24Hs = bloqueadoAcima24Hs;
		this.limiteConta = limiteConta;
		this.bloqueadoAte24Hs = bloqueadoAte24Hs;
		this.dataFinal = dataFinal;
		this.saldoFinal = saldoFinal;
		this.situacaoSaldo = situacaoSaldo;
		this.statusSaldo = statusSaldo;
		this.qteRegistros = qteRegistros;
		this.somatoriaDebitos = somatoriaDebitos;
		this.somatoriaCreditos = somatoriaCreditos;
		this.somatoriaNaoContabeis = somatoriaNaoContabeis;
		this.complementoRegistrosVII = complementoRegistrosVII;
		
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

	public String getComplementoRegistroVI() {
		return complementoRegistroVI;
	}

	public void setComplementoRegistroVI(String complementoRegistroVI) {
		this.complementoRegistroVI = complementoRegistroVI;
	}

	public Double getBloqueadoAcima24Hs() {
		return bloqueadoAcima24Hs;
	}

	public void setBloqueadoAcima24Hs(Double bloqueadoAcima24Hs) {
		this.bloqueadoAcima24Hs = bloqueadoAcima24Hs;
	}

	public Double getLimiteConta() {
		return limiteConta;
	}

	public void setLimiteConta(Double limiteConta) {
		this.limiteConta = limiteConta;
	}

	public Double getBloqueadoAte24Hs() {
		return bloqueadoAte24Hs;
	}

	public void setBloqueadoAte24Hs(Double bloqueadoAte24Hs) {
		this.bloqueadoAte24Hs = bloqueadoAte24Hs;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Double getSaldoFinal() {
		return saldoFinal;
	}

	public void setSaldoFinal(Double saldoFinal) {
		this.saldoFinal = saldoFinal;
	}

	public String getSituacaoSaldo() {
		return situacaoSaldo;
	}

	public void setSituacaoSaldo(String situacaoSaldo) {
		this.situacaoSaldo = situacaoSaldo;
	}

	public String getStatusSaldo() {
		return statusSaldo;
	}

	public void setStatusSaldo(String statusSaldo) {
		this.statusSaldo = statusSaldo;
	}

	public Integer getQteRegistros() {
		return qteRegistros;
	}

	public void setQteRegistros(Integer qteRegistros) {
		this.qteRegistros = qteRegistros;
	}

	public Double getSomatoriaDebitos() {
		return somatoriaDebitos;
	}

	public void setSomatoriaDebitos(Double somatoriaDebitos) {
		this.somatoriaDebitos = somatoriaDebitos;
	}

	public Double getSomatoriaCreditos() {
		return somatoriaCreditos;
	}

	public void setSomatoriaCreditos(Double somatoriaCreditos) {
		this.somatoriaCreditos = somatoriaCreditos;
	}

	public Double getSomatoriaNaoContabeis() {
		return somatoriaNaoContabeis;
	}

	public void setSomatoriaNaoContabeis(Double somatoriaNaoContabeis) {
		this.somatoriaNaoContabeis = somatoriaNaoContabeis;
	}

	public String getComplementoRegistrosVII() {
		return complementoRegistrosVII;
	}

	public void setComplementoRegistrosVII(String complementoRegistrosVII) {
		this.complementoRegistrosVII = complementoRegistrosVII;
	}

	public Long getIdArquivoCarga() {
		return idArquivoCarga;
	}

	public void setIdArquivoCarga(Long idArquivoCarga) {
		this.idArquivoCarga = idArquivoCarga;
	}
	
	
}
