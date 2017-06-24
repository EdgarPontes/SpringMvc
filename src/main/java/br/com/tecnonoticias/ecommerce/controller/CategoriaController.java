package br.com.tecnonoticias.ecommerce.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.tecnonoticias.ecommerce.model.Categoria;
import br.com.tecnonoticias.ecommerce.repository.Categorias;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

	private static final String CATEGORIA_VIEW = "categoria";
	private static final String CATEGORIA_PESQUISA_VIEW = "categoriaPesquisa";
	
	@Autowired
	private Categorias categorias;

	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView(CATEGORIA_VIEW);
		mv.addObject(new Categoria());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(@Validated Categoria categoria, Errors errors) {		
		ModelAndView mv = new ModelAndView(CATEGORIA_VIEW);
		if (errors.hasErrors()) {
			return mv;
		}
		
		categorias.save(categoria);
		mv.addObject("mensagem", "Categoria salvo com sucesso!");
		return mv;
	}
	
	@RequestMapping
	public ModelAndView pesquisa(@RequestParam(defaultValue ="%") String categoria) {
		List<Categoria> todasCategorias = categorias.findByNomeCategoriaContaining(categoria);
		
		ModelAndView mv = new ModelAndView(CATEGORIA_PESQUISA_VIEW);
		mv.addObject("categorias", todasCategorias);
		
		return mv;
	}
	
	@RequestMapping("{codigo}")
	public ModelAndView edcao(@PathVariable("codigo") Categoria categoria){
		
		ModelAndView mv = new ModelAndView(CATEGORIA_VIEW);
		mv.addObject(categoria);
		return mv;
	}
	
	public Date getDataAtual(){
		Date agora = new Date();
		SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
		return agora;
	}

}
