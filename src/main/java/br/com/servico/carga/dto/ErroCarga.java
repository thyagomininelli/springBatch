package br.com.servico.carga.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import br.com.infraestrutura.exception.LinhaInvalidaException;

@Entity(name="t_erro_carga")
public class ErroCarga implements Serializable {

	private static final long serialVersionUID = 3683671554808122747L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "erroCargaSeq")
	@SequenceGenerator(name = "erroCargaSeq", sequenceName = "ERRO_CARGA_SEQ", allocationSize = 1)
	@Column(name="ERRO_CARGA_ID")
	private Integer idErroCarga;

	@Column(name="CONTROLE_CARGA_ID")
	private Long idControleCarga;

	@Column(name="IDENTIFICACAO_REGISTRO")
	private String tipoRegistro;
	
	@Column(name="DESCRICAO")
	private String descricao;
	
	public ErroCarga() {
		super();
	}

	public ErroCarga(Long idControleCarga, String descricao) {
		super();
		this.idControleCarga = idControleCarga;
		this.descricao = descricao;
	}

	public ErroCarga(Long idControleCarga, String tipoRegistro, String descricao) {
		super();
		this.idControleCarga = idControleCarga;
		this.tipoRegistro = tipoRegistro;
		this.descricao = descricao;
	}

	public ErroCarga(Long idControleCarga, LinhaInvalidaException linhaInvalidaException) {
		super();
		this.idControleCarga = idControleCarga;
		this.tipoRegistro = linhaInvalidaException.getTipoRegistro();
		this.descricao = linhaInvalidaException.getDescricao();
	}


	public Integer getIdErroCarga() {
		return idErroCarga;
	}
	
	public String getTipoRegistro() {
		return tipoRegistro;
	}

	public void setTipoRegistro(String tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}

	public void setIdErroCarga(Integer idErroCarga) {
		this.idErroCarga = idErroCarga;
	}

	public Long getIdControleCarga() {
		return idControleCarga;
	}

	public void setIdControleCarga(Long idControleCarga) {
		this.idControleCarga = idControleCarga;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idErroCarga == null) ? 0 : idErroCarga.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ErroCarga other = (ErroCarga) obj;
		if (idErroCarga == null) {
			if (other.idErroCarga != null)
				return false;
		} else if (!idErroCarga.equals(other.idErroCarga))
			return false;
		return true;
	}

}
