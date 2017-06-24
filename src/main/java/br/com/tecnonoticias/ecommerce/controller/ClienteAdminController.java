package br.com.tecnonoticias.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.tecnonoticias.ecommerce.model.Cliente;
import br.com.tecnonoticias.ecommerce.repository.Clientes;

@Controller
@RequestMapping(value = "clienteAdmin")
public class ClienteAdminController {
	
	@Autowired
	private Clientes clientes;

//	@RequestMapping
//	public String clienteAdmin(){
//		return "clienteAdmin";
//	}
	
	@RequestMapping
	public ModelAndView pesquisa(@RequestParam(defaultValue ="%") String cliente) {
		List<Cliente> todosClientes = clientes.findByNomeContaining(cliente);
		
		ModelAndView mv = new ModelAndView("clienteAdmin");
		mv.addObject("clientes", todosClientes);
		
		return mv;
	}
	
	@RequestMapping("{codigo}")
	public ModelAndView edcao(@PathVariable("codigo") Cliente cliente){
		
		ModelAndView mv = new ModelAndView("clienteAdmin");
		mv.addObject(cliente);
		return mv;
	}
}
