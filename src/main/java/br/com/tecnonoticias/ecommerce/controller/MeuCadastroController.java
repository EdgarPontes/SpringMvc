package br.com.tecnonoticias.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MeuCadastroController {
	
	@RequestMapping("/meuCadastro")
	public String carrinho() {
		
		return "meuCadastro";
		
	}
}
