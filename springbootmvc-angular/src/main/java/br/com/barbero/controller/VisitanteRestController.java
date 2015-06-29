package br.com.barbero.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.barbero.entity.Visitante;
import br.com.barbero.repository.VisitanteRepository;

@RestController
@RequestMapping("/visitante")
public class VisitanteRestController {
	
	@Autowired
	private VisitanteRepository visitanteRepository;
	
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public Iterable<Visitante> listar(){
		return visitanteRepository.findByDataVisitaOrderByIdDesc(new Date());
	}
	
	@RequestMapping(value="/salvar", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_VALUE})
	public void salvar(@RequestBody @Valid Visitante visitante){
		 visitante.setDataVisita(new Date());
		 visitanteRepository.save(visitante);
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET )
	public void delete(@PathVariable(value="id") Long id){
		visitanteRepository.delete(id);
	}
		
	
}
