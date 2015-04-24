package br.com.ibp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.ibp.entity.Visitante;

@RepositoryRestResource(path = "visitante")
public interface VisitanteRepository extends CrudRepository<Visitante, Long> {

}
