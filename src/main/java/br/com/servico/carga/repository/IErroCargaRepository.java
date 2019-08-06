package br.com.servico.carga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.servico.carga.dto.ErroCarga;

@Repository
public interface IErroCargaRepository extends JpaRepository<ErroCarga, Long>{

}
