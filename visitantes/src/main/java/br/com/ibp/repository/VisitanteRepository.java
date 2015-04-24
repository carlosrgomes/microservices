package br.com.ibp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.ibp.entity.Visitante;

@RepositoryRestResource(path = "visitante")
public interface VisitanteRepository extends CrudRepository<Visitante, Long>, PagingAndSortingRepository<Visitante, Long> {
	
	List<Visitante> findByNome(@Param(value = "nome") String nome);
	
	List<Visitante> findByEmail(@Param(value = "email") String email);

}
