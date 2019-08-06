package br.com.servico.carga.extrato.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name="ITAU_EXT_HDR_LOTE")
public class ExtratoHeaderLoteDTO extends ExtratoDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tItauHdrLoteSeq")
	@SequenceGenerator(name = "tItauHdrLoteSeq", sequenceName = "ITAU_EXT_HDR_LOTE_SEQ", allocationSize = 1)
	@Column(name="itau_ext_hdr_lote_id")
	private Long idHdrLoteArquivo;
	
	@Column(name="arquivo_carga_id")
	private Long idArquivoCarga;
	
	@Column(name="CODIGO_BANCO")
	private Integer codigoBanco;

	@Column(name="CODIGO_LOTE")
	private Integer codigoLote;

	@Column(name="TIPO_REGISTRO")
	private String tipoRegistro;
	
	@Column(name="TIPO_OPERACAO")
	private String tipoOperacao;
	
	@Column(name="SERVICO")
	private Integer servico;

	@Column(name="FORMA_LANCAMENTO")
	private Integer formaLancamento;

	@Column(name="VERSAO_LAYOUT")
	private String versaoLayout;

	@Column(name="COMPLEMENTO_REGISTRO_I")
	private String complementoRegistroI;

	@Column(name="TIPO_INSCRICAO")
	private String tipoInscricao;

	@Column(name="NUMERO_INSCRICAO")
	private Long numeroInscricao;

	@Column(name="TIPO_CONTA")
	private String tipoConta;

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
	
	@Column(name="COMPLEMENTO_REGISTRO_VI")
	private String complementoRegistroVI;
	
	@Column(name="DATA_INICIAL")
	private Date dataInicial;
	
	@Column(name="VALOR_INICIAL")
	private Double valorInicial;
	
	@Column(name="SITUACAO_INICIAL")
	private String situacaoInicial;
	
	@Column(name="STATUS_INICIAL")
	private String statusInicial;
	
	@Column(name="TIPO_MOEDA")
	private String tipoMoeda;

	@Column(name="NUMERO_SEQUENCIA")
	private Integer numeroSequencia;
	
	@Column(name="COMPLEMENTO_REGISTRO_VII")
	private String complementoRegistroVII;
	
	public ExtratoHeaderLoteDTO() {
		super();
	}
	

	public ExtratoHeaderLoteDTO( Integer codigoBanco, Integer codigoLote, String tipoRegistro, String tipoOperacao, Integer servico,
			Integer formaLancamento, String versaoLayout, String complementoRegistroI, String tipoInscricao, Long numeroInscricao,
			String tipoConta, String complementoRegistroII, String convenio, Integer complementoRegistroIII, Integer agencia,
			String dac, Integer complementoRegistroIV, Integer conta, String complementoRegistroV, String digito, String nomeEmpresa,
			String complementoRegistroVI, Date dataInicial, Double valorInicial, String situacaoInicial, String statusInicial,
			String tipoMoeda, Integer numeroSequencia, String complementoRegistroVII
			) 
		{
		
		super();
		
		this.codigoBanco = codigoBanco;
		this.codigoLote = codigoLote;
		this.tipoRegistro = tipoRegistro;
		this.tipoOperacao = tipoOperacao;
		this.formaLancamento = formaLancamento;
		this.versaoLayout = versaoLayout;
	    this.complementoRegistroI = complementoRegistroI;
	    this.tipoInscricao = tipoInscricao;
		this.numeroInscricao = numeroInscricao;
		this.tipoConta = tipoConta;
		this.complementoRegistroII = complementoRegistroII;
		this.convenio = convenio;
		this.conta = conta;
	    this.complementoRegistroVI = complementoRegistroVI;
	    this.dataInicial = dataInicial;
		this.valorInicial = valorInicial;
		this.situacaoInicial = situacaoInicial;
		this.statusInicial = statusInicial;
		this.tipoMoeda = tipoMoeda;
		this.numeroSequencia = numeroSequencia;
	    this.complementoRegistroVII = complementoRegistroVII;
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


	public String getTipoOperacao() {
		return tipoOperacao;
	}


	public void setTipoOperacao(String tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}


	public Integer getServico() {
		return servico;
	}


	public void setServico(Integer servico) {
		this.servico = servico;
	}


	public Integer getFormaLancamento() {
		return formaLancamento;
	}


	public void setFormaLancamento(Integer formaLancamento) {
		this.formaLancamento = formaLancamento;
	}


	public String getVersaoLayout() {
		return versaoLayout;
	}


	public void setVersaoLayout(String versaoLayout) {
		this.versaoLayout = versaoLayout;
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


	public String getTipoConta() {
		return tipoConta;
	}


	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
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


	public String getComplementoRegistroVI() {
		return complementoRegistroVI;
	}


	public void setComplementoRegistroVI(String complementoRegistroVI) {
		this.complementoRegistroVI = complementoRegistroVI;
	}


	public Date getDataInicial() {
		return dataInicial;
	}


	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}


	public Double getValorInicial() {
		return valorInicial;
	}


	public void setValorInicial(Double valorInicial) {
		this.valorInicial = valorInicial;
	}


	public String getSituacaoInicial() {
		return situacaoInicial;
	}


	public void setSituacaoInicial(String situacaoInicial) {
		this.situacaoInicial = situacaoInicial;
	}


	public String getStatusInicial() {
		return statusInicial;
	}


	public void setStatusInicial(String statusInicial) {
		this.statusInicial = statusInicial;
	}


	public String getTipoMoeda() {
		return tipoMoeda;
	}


	public void setTipoMoeda(String tipoMoeda) {
		this.tipoMoeda = tipoMoeda;
	}


	public Integer getNumeroSequencia() {
		return numeroSequencia;
	}


	public void setNumeroSequencia(Integer numeroSequencia) {
		this.numeroSequencia = numeroSequencia;
	}


	public String getComplementoRegistroVII() {
		return complementoRegistroVII;
	}


	public void setComplementoRegistroVII(String complementoRegistroVII) {
		this.complementoRegistroVII = complementoRegistroVII;
	}


	public Long getIdArquivoCarga() {
		return idArquivoCarga;
	}


	public void setIdArquivoCarga(Long idArquivoCarga) {
		this.idArquivoCarga = idArquivoCarga;
	}

	
}
