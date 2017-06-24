package br.com.tecnonoticias.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.tecnonoticias.ecommerce.model.Banner;
import br.com.tecnonoticias.ecommerce.model.EmailPromocional;
import br.com.tecnonoticias.ecommerce.repository.Banners;

@Controller
@RequestMapping("/banner")
public class BannerController {

	@Autowired
	private Banners banners;
	
	@RequestMapping
	public ModelAndView banner(){
		ModelAndView mv = new ModelAndView("banner");
		mv.addObject(new Banner());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(Banner banner) {		
		ModelAndView mv = new ModelAndView("banner");
		
		banners.save(banner);
		return mv;
	}
	
	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") Banner banner) {
		ModelAndView mv = new ModelAndView("banner");
		mv.addObject(banner);
		return mv;
	}
	
	public ModelAndView pesquisa() {
		List<Banner> todosBanners = banners.findAll();
		ModelAndView mv = new ModelAndView("banner");
		mv.addObject("banner", todosBanners);
		return mv;
	}
}
