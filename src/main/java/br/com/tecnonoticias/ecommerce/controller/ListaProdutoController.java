package br.com.tecnonoticias.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.tecnonoticias.ecommerce.model.IndexAdmin;
import br.com.tecnonoticias.ecommerce.repository.CadastroProdutos;

@Controller
public class ListaProdutoController {
	
	@Autowired
	CadastroProdutos produtos;

	@RequestMapping("/listaProdutos")
	public ModelAndView novo(){
		ModelAndView mv = new ModelAndView("listaProdutos");
		mv.addObject("produtos", pesquisa());
		return mv;
	}
	
	public List<IndexAdmin> pesquisa() {
		List<IndexAdmin> todosCategoria = produtos.findAll();
		return todosCategoria;
	}
	
	
	
}
