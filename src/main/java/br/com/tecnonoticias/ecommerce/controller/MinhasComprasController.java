package br.com.tecnonoticias.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.tecnonoticias.ecommerce.model.Carrinho;
import br.com.tecnonoticias.ecommerce.model.Cliente;
import br.com.tecnonoticias.ecommerce.repository.Carrinhos;

@Controller
public class MinhasComprasController {
	
	@Autowired
	public Carrinhos carrinhos;
	
	@RequestMapping("/minhasCompras")
	public ModelAndView pesquisaCompras() {
		List<Carrinho> listaDeCompras = carrinhos.findAll();
		ModelAndView mv = new ModelAndView("minhasCompras");
		mv.addObject("carrinhos", listaDeCompras);
		return mv;
	}
}
