package br.com.barbero.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/visitante")
public class VisitanteController {
	

	@RequestMapping("/iniciar")
	public String welcome(Map<String, Object> model) {
		return "visitante";
	}
	
	

}