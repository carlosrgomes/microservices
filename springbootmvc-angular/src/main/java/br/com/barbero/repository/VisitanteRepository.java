package br.com.barbero.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.barbero.entity.Visitante;

public interface VisitanteRepository extends CrudRepository<Visitante, Long>, PagingAndSortingRepository<Visitante, Long> {
	
	List<Visitante> findByNome(String nome);
	
	List<Visitante> findByEmail(String email);
	
	List<Visitante> findByDataVisitaOrderByIdDesc(Date dataVisita);

}