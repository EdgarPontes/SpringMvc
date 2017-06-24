package br.com.tecnonoticias.ecommerce.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.tecnonoticias.ecommerce.model.Contato;
import br.com.tecnonoticias.ecommerce.repository.Contatos;

@Controller
@RequestMapping("/contato")
public class ContatoController {

	@Autowired
	private Contatos contatos;
	
	
	
	@RequestMapping
    public ModelAndView novo(){
    	ModelAndView mv = new ModelAndView("contato");
    	mv.addObject(new Contato());
    	return mv;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView update(Contato contato)throws IOException{
    	ModelAndView mv = new ModelAndView("contato");
    	
		contatos.save(contato);
    	return mv;
    }
    
    @RequestMapping("{codigo}")
	public ModelAndView edcao(@PathVariable("codigo") Contato contato){
		
		ModelAndView mv = new ModelAndView("contato");
		mv.addObject(contato);
		return mv;
	}
    public List<Contato> pesquisa() {
		List<Contato> todosContatos = contatos.findAll();
		ModelAndView mv = new ModelAndView("contato");
		mv.addObject("contato", todosContatos);
		return todosContatos;
	}

}

