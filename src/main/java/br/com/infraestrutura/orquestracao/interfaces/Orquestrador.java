package br.com.infraestrutura.orquestracao.interfaces;

import java.io.File;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.infraestrutura.diretorios.IGerenciadorArquivos;
import br.com.servico.carga.dao.IArquivoCargaDAO;
import br.com.servico.carga.dao.IControleCargaDAO;
import br.com.servico.carga.dao.service.ArquivoCargaService;
import br.com.servico.carga.dao.service.ControleCargaService;



@Component
public abstract class Orquestrador {
	
	protected File arquivoCarga = null;
	protected Long idArquivoCarga = null;
	protected Long idControleCarga = null;
	protected boolean arquivoValido = true;
	
	@Autowired
	protected JobLauncher launcher;

	protected JobExecution execution;
	
	@Autowired
	protected IGerenciadorArquivos gerenciadorArquivos;
	
	@Autowired
	protected IArquivoCargaDAO arquivoCargaService;
	
	@Autowired
	protected IControleCargaDAO controleCargaService;
	
	public abstract void executarCarga();
	
	public void setArquivoValido(boolean arquivoValido) {
		this.arquivoValido = arquivoValido;
	}
	
	public boolean isArquivoValido() {
		return arquivoValido;
	}

	public Long getIdArquivoCarga() {
		return idArquivoCarga;
	}

	public Long getIdControleCarga() {
		return idControleCarga;
	}

}
