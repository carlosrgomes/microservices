package br.com.ibp;

import java.io.IOException;
import java.io.StringWriter;

import org.junit.Test;

import br.com.ibp.entity.Visitante;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestJson {
	
	
	//curl -H "Content-Type: application/json" -X POST -d '{"nome":"Carlos","email":"carlosrgomes@gmail.com"}' http://localhost:8081/api/visitante

	@Test
	public void gerarJson() throws JsonGenerationException, JsonMappingException, IOException{
		StringWriter json = new StringWriter();
		ObjectMapper mapper = new ObjectMapper();
		Visitante visitante =  new Visitante();
		visitante.setEmail("carlosrgomes@gmail.com");
		visitante.setNome("Carlos");
		
		mapper.writeValue(json, visitante);
		
		System.out.println(json.toString());
	}

}
