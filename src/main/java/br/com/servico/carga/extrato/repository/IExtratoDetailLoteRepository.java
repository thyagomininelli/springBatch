package br.com.servico.carga.extrato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.servico.carga.extrato.dto.ExtratoDetailLoteDTO;

@Repository
public interface IExtratoDetailLoteRepository extends JpaRepository<ExtratoDetailLoteDTO, Long>{
	
}
