package br.com.servico.carga.extrato.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

@Entity(name="ITAU_EXT_HDR_ARQUIVO")
public class ExtratoHeaderArquivoDTO extends ExtratoDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tItauHdrSeq")
	@SequenceGenerator(name = "tItauHdrSeq", sequenceName = "ITAU_EXT_HDR_ARQUIVO_SEQ", allocationSize = 1)
	@Column(name="itau_ext_hdr_arquivo_id")
	private Long idHdrArquivo;

	@Column(name="arquivo_carga_id")
	private Long idArquivoCarga;
	
	@Column(name="CODIGO_BANCO")
	private Integer codigoBanco;

	@Column(name="CODIGO_LOTE")
	private Integer codigoLote;
	
	@Column(name="TIPO_REGISTRO")
	private String tipoRegistro;
	
	@Column(name="complemento_registro_i")
	private String complementoRegistoI;
	
	@Column(name="TIPO_INSCRICAO")
	private String tipoInscricao;
	
	@Column(name="NUMERO_INSCRICAO")
	private Long numeroInscricao;
	
	@Column(name="complemento_registro_ii")
	private String complementoRegistoII;

	@Column(name="CONVENIO")
	private String convenio;

	@Column(name="complemento_registro_iii")
	private Integer complementoRegistoIII;

	@Column(name="AGENCIA")
	private Integer agencia;
	
	@Column(name="DAC")
	private String dac;
	
	@Column(name="COMPLEMENTO_REGISTRO_IV")
	private Integer complementoRegistoIV;
	
	@Column(name="CONTA")
	private Integer conta;
	
	@Column(name="COMPLEMENTO_REGISTRO_V")
	private String complementoRegistoV;
	
	@Column(name="DIGITO")
	private String digito;
	
	@Column(name="NOME_EMPRESA")
	private String nomeEmpresa;
	
	@Column(name="NOME_BANCO")
	private String nomeBanco;
	
	@Column(name="COMPLEMENTO_REGISTRO_VI")
	private String complementoRegistoVI;

	@Column(name="CODIGO_RETORNO")
	private String codigoRetorno;
	
	@Column(name="DATA_GERACAO")
	private Date dataGeracao;

	@Transient
	private Integer horaGeracao;

	@Column(name="NUMERO_SEQUENCIA")
	private Integer numeroSequencia;

	@Column(name="VERSAO_LAYOUT")
	private Integer versaoLayout;
	
	@Column(name="COMPLEMENTO_REGISTRO_VII")
	private Integer complementoRegistoVII;
	
	@Column(name="RESERVADO_BANCO")
	private String reservadoBanco;
	
	@Column(name="COMPLEMENTO_REGISTRO_VIII")
	private String complementoRegistoVIII;
	
	


	public ExtratoHeaderArquivoDTO(	Integer codigoBanco, Integer codigoLote, String tipoRegistro, String complementoRegistoI,
			String tipoInscricao, Long numeroInscricao, String complementoRegistoII, String convenio, Integer complementoRegistoIII,
			Integer agencia, String dac, Integer complementoRegistoIV, Integer conta, String complementoRegistoV, String digito, 
			String nomeEmpresa, String nomeBanco, String complementoRegistoVI, String codigoRetorno, Date dataGeracao,
			Integer horaGeracao, Integer numeroSequencia, Integer versaoLayout, Integer complementoRegistoVII, String reservadoBanco,
			String complementoRegistoVIII) 
		{
		
		super();
		
		this.codigoBanco = codigoBanco;
		this.codigoLote = codigoLote;
		this.tipoRegistro = tipoRegistro;
		this.complementoRegistoI = complementoRegistoI;
		this.tipoInscricao = tipoInscricao;
		this.numeroInscricao = numeroInscricao;
	    this.complementoRegistoII = complementoRegistoII;
	    this.convenio = convenio;
		this.complementoRegistoIII = complementoRegistoIII;
		this.agencia = agencia;
		this.dac = dac;
		this.complementoRegistoIV = complementoRegistoIV;
		this.conta = conta;
	    this.complementoRegistoV = complementoRegistoV;
	    this.digito = digito;
		this.nomeEmpresa = nomeEmpresa;
		this.nomeBanco = nomeBanco;
		this.complementoRegistoVI = complementoRegistoVI;
		this.codigoRetorno = codigoRetorno;
		this.dataGeracao = dataGeracao;
	    this.horaGeracao = horaGeracao;
		this.numeroSequencia = numeroSequencia;
		this.versaoLayout = versaoLayout;
		this.complementoRegistoVII = complementoRegistoVII;
		this.reservadoBanco = reservadoBanco;
		this.complementoRegistoVIII = complementoRegistoVIII;
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


	public String getComplementoRegistoI() {
		return complementoRegistoI;
	}


	public void setComplementoRegistoI(String complementoRegistoI) {
		this.complementoRegistoI = complementoRegistoI;
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


	public String getComplementoRegistoII() {
		return complementoRegistoII;
	}


	public void setComplementoRegistoII(String complementoRegistoII) {
		this.complementoRegistoII = complementoRegistoII;
	}


	public String getConvenio() {
		return convenio;
	}


	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}


	public Integer getComplementoRegistoIII() {
		return complementoRegistoIII;
	}


	public void setComplementoRegistoIII(Integer complementoRegistoIII) {
		this.complementoRegistoIII = complementoRegistoIII;
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


	public Integer getComplementoRegistoIV() {
		return complementoRegistoIV;
	}


	public void setComplementoRegistoIV(Integer complementoRegistoIV) {
		this.complementoRegistoIV = complementoRegistoIV;
	}


	public Integer getConta() {
		return conta;
	}


	public void setConta(Integer conta) {
		this.conta = conta;
	}


	public String getComplementoRegistoV() {
		return complementoRegistoV;
	}


	public void setComplementoRegistoV(String complementoRegistoV) {
		this.complementoRegistoV = complementoRegistoV;
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


	public String getNomeBanco() {
		return nomeBanco;
	}


	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}


	public String getComplementoRegistoVI() {
		return complementoRegistoVI;
	}


	public void setComplementoRegistoVI(String complementoRegistoVI) {
		this.complementoRegistoVI = complementoRegistoVI;
	}


	public String getCodigoRetorno() {
		return codigoRetorno;
	}


	public void setCodigoRetorno(String codigoRetorno) {
		this.codigoRetorno = codigoRetorno;
	}


	public Date getDataGeracao() {
		return dataGeracao;
	}


	public void setDataGeracao(Date dataGeracao) {
		this.dataGeracao = dataGeracao;
	}


	public Integer getHoraGeracao() {
		return horaGeracao;
	}


	public void setHoraGeracao(Integer horaGeracao) {
		this.horaGeracao = horaGeracao;
	}


	public Integer getNumeroSequencia() {
		return numeroSequencia;
	}


	public void setNumeroSequencia(Integer numeroSequencia) {
		this.numeroSequencia = numeroSequencia;
	}


	public Integer getVersaoLayout() {
		return versaoLayout;
	}


	public void setVersaoLayout(Integer versaoLayout) {
		this.versaoLayout = versaoLayout;
	}


	public Integer getComplementoRegistoVII() {
		return complementoRegistoVII;
	}


	public void setComplementoRegistoVII(Integer complementoRegistoVII) {
		this.complementoRegistoVII = complementoRegistoVII;
	}


	public String getReservadoBanco() {
		return reservadoBanco;
	}


	public void setReservadoBanco(String reservadoBanco) {
		this.reservadoBanco = reservadoBanco;
	}


	public String getComplementoRegistoVIII() {
		return complementoRegistoVIII;
	}


	public void setComplementoRegistoVIII(String complementoRegistoVIII) {
		this.complementoRegistoVIII = complementoRegistoVIII;
	}
	
	
	public Long getIdHdrArquivo() {
		return idHdrArquivo;
	}


	public void setIdHdrArquivo(Long idHdrArquivo) {
		this.idHdrArquivo = idHdrArquivo;
	}


	public ExtratoHeaderArquivoDTO() {
		super();
	}


	public Long getIdArquivoCarga() {
		return idArquivoCarga;
	}


	public void setIdArquivoCarga(Long idArquivoCarga) {
		this.idArquivoCarga = idArquivoCarga;
	}
	
	
}
