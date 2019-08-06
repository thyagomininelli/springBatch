package br.com.servico.carga.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@Entity(name = "t_arquivo_carga")
public class ArquivoCarga implements Serializable {

	private static final long serialVersionUID = 3683671554808122747L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "arquivoCargaSeq")
	@SequenceGenerator(name = "arquivoCargaSeq", sequenceName = "arquivo_carga_seq", allocationSize = 1)
	@Column(name="arquivo_carga_id")
	private Long idArquivoCarga;
	
	@Column(name="nome_arquivo")
	private String nomeArquivo;
	
	@Column(name="data_carga")
	private Date dataCarga;
	
	@Column(name="layout_parceiro")
	private LayoutParceiro layoutParceiro;
	
	@Column(name="parceiro")
	private Parceiro parceiro;
	
	
	public ArquivoCarga() {
		super();
	}

	public ArquivoCarga(Long idArquivoCarga) {
		super();
		this.idArquivoCarga = idArquivoCarga;
	}

	public ArquivoCarga(Parceiro parceiro, LayoutParceiro layoutParceiro, String nomeArquivo) {
		super();
		this.parceiro = parceiro;
		this.nomeArquivo = nomeArquivo;
		this.layoutParceiro = layoutParceiro;
	}

	public Long getIdArquivoCarga() {
		return idArquivoCarga;
	}

	public void setIdArquivoCarga(Long idArquivoCarga) {
		this.idArquivoCarga = idArquivoCarga;
	}

	public Parceiro getParceiro() {
		return parceiro;
	}

	public void setParceiro(Parceiro parceiro) {
		this.parceiro = parceiro;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public Date getDataCarga() {
		return dataCarga;
	}

	public void setDataCarga(Date dataCarga) {
		this.dataCarga = dataCarga;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public LayoutParceiro getLayoutParceiro() {
		return layoutParceiro;
	}

	public void setLayoutParceiro(LayoutParceiro layoutParceiro) {
		this.layoutParceiro = layoutParceiro;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idArquivoCarga == null) ? 0 : idArquivoCarga.hashCode());
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
		ArquivoCarga other = (ArquivoCarga) obj;
		if (idArquivoCarga == null) {
			if (other.idArquivoCarga != null)
				return false;
		} else if (!idArquivoCarga.equals(other.idArquivoCarga))
			return false;
		return true;
	}

}