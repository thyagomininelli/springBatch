package br.com.servico.carga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.com.servico.carga.dto.ControleCarga;

@Repository
public interface IControleCargaRepository extends JpaRepository<ControleCarga,Long>, JpaSpecificationExecutor<ControleCarga> {

}
