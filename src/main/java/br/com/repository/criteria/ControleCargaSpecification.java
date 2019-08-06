package br.com.repository.criteria;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import br.com.servico.carga.dto.ArquivoCarga;
import br.com.servico.carga.dto.ControleCarga;



public class ControleCargaSpecification {
	public static Specification<ControleCarga> byCriterio(ControleCarga controleCarga){
		return new Specification<ControleCarga>() {

			@Override
			public Predicate toPredicate(Root<ControleCarga> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				List<Predicate> predicates = new ArrayList<>();

				predicates.add(builder.like(builder.lower(root.<String>get("statusCarga")), "%"+ controleCarga.getStatusCarga() +"%"));
				

				Join<ControleCarga,ArquivoCarga> arquivoCarga = root.join("arquivoCarga");

				predicates.add(builder.equal(arquivoCarga.<String>get("parceiro"),  controleCarga.getArquivoCarga().getParceiro().getCodigo()));

				predicates.add(builder.equal(arquivoCarga.<String>get("layoutParceiro"), controleCarga.getArquivoCarga().getLayoutParceiro().getCodigo()));
				
				return builder.and(predicates.toArray(new Predicate[]{}));
			}		
		};
	}
}
