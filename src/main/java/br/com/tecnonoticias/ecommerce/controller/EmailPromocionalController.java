package br.com.tecnonoticias.ecommerce.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.tecnonoticias.ecommerce.model.EmailPromocional;
import br.com.tecnonoticias.ecommerce.model.Newsletter;
import br.com.tecnonoticias.ecommerce.repository.EmailPromocionais;
import br.com.tecnonoticias.ecommerce.repository.Newsletters;
import br.com.tecnoticias.ecommerce.aplicacoes.EmailJava;

@Controller
@RequestMapping("/emailPromocional")
public class EmailPromocionalController {

	@Autowired
	private EmailPromocionais emailPromocional;
	@Autowired
	private Newsletters newsletter;
	@Autowired

	@RequestMapping
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("emailPromocional");
		mv.addObject(new EmailPromocional());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(@Validated EmailPromocional email, Errors erro) throws IOException {
		ModelAndView mv = new ModelAndView("emailPromocional");
//		if (erro.hasErrors()) {
//			return mv;
//		}
		// String rota = new ImagemServidor().updateImage(email,
		// email.getImagem(),"emailPromocional");
		// email.setImagem(rota);
		

//		System.out.println(file.load("nuncaMais.png"));
//		System.out.println(file.loadAsResource("nuncaMais.png").getURL().toString().replaceAll("file:",""));
//		email.setImagem(file.load("nuncaMais.png").toString());

		enviarEmail(pesquisa(),email.getTitulo(),email.getImagem(),email.getAssunto());
		emailPromocional.save(email);
        mv.addObject("mensagem", "E-Mail Atualizado com sucesso");
		return mv;
	}

	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") EmailPromocional emailEdit) {
		ModelAndView mv = new ModelAndView("emailPromocional");
		mv.addObject(emailEdit);
		return mv;
	}

	public List<Newsletter> pesquisa() {
		List<Newsletter> todosClientes = newsletter.findAll();
		ModelAndView mv = new ModelAndView("emailPromocional");
		mv.addObject("emailPromocional", todosClientes);
		return todosClientes;
	}

	public void enviarEmail(List<Newsletter> listaEmail,String titulo,String imagem,String conteudo) {
		for (Newsletter email : listaEmail) {
//			System.out.println(email.getEmail());
			EmailJava enviarEmail = new EmailJava(email.getEmail(), titulo, conteudo);
			enviarEmail.enviar();
		}
	}
}
