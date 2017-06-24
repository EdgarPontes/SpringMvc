package br.com.tecnonoticias.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Pagamento {
	
	@RequestMapping("/pagamento")
    public ModelAndView novo(){
    	ModelAndView mv = new ModelAndView("pagamento");
    	
    	return mv;
    }
}
