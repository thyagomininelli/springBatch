package br.com.servico.carga.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity(name = "t_controle_carga")
public class ControleCarga implements Serializable {

	private static final long serialVersionUID = 3683671554808122747L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "controleCargaSeq")
	@SequenceGenerator(name = "controleCargaSeq", sequenceName = "CONTROLE_CARGA_SEQ", allocationSize = 1)
	@Column(name="controle_carga_id")
	private Long idControleCarga;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="arquivo_carga_id")
	private ArquivoCarga arquivoCarga;
	
	@Column(name="status")
	private StatusCarga statusCarga;
	
	public ControleCarga() {
		super();
	}


	public Long getIdControleCarga() {
		return idControleCarga;
	}

	public void setIdControleCarga(Long idControleCarga) {
		this.idControleCarga = idControleCarga;
	}

	public StatusCarga getStatusCarga() {
		return statusCarga;
	}

	public void setStatusCarga(StatusCarga statusCarga) {
		this.statusCarga = statusCarga;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	public ArquivoCarga getArquivoCarga() {
		return arquivoCarga;
	}

	public void setArquivoCarga(ArquivoCarga arquivoCarga) {
		this.arquivoCarga = arquivoCarga;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idControleCarga == null) ? 0 : idControleCarga.hashCode());
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
		ControleCarga other = (ControleCarga) obj;
		if (idControleCarga == null) {
			if (other.idControleCarga != null)
				return false;
		} else if (!idControleCarga.equals(other.idControleCarga))
			return false;
		return true;
	}
}