package br.com.tecnonoticias.ecommerce.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.tecnonoticias.ecommerce.model.Categoria;
import br.com.tecnonoticias.ecommerce.model.Contato;
import br.com.tecnonoticias.ecommerce.model.IndexAdmin;
import br.com.tecnonoticias.ecommerce.model.Newsletter;
import br.com.tecnonoticias.ecommerce.model.Sugestao;
import br.com.tecnonoticias.ecommerce.repository.CadastroProdutos;
import br.com.tecnonoticias.ecommerce.repository.Categorias;
import br.com.tecnonoticias.ecommerce.repository.Contatos;
import br.com.tecnonoticias.ecommerce.repository.Newsletters;
import br.com.tecnoticias.ecommerce.aplicacoes.EmailJava;

@Controller
@RequestMapping("/pesquisa")
public class PesquisaController {
	@Autowired
	private Newsletters newsletters;

	@Autowired
	private Categorias categorias;

	@Autowired
	private Contatos contato;

	@Autowired
	private CadastroProdutos produto;

	@RequestMapping
	public ModelAndView novo(@RequestParam(defaultValue = "%")String nome) {
		ModelAndView mv = new ModelAndView("pesquisa");
		mv.addObject("valorPesquisa", nome);
		mv.addObject("todasCategoria", pesquisaCategoria());
		mv.addObject("todosContatos", pesquisaContato());
		if(!nome.equals("%"))
			mv.addObject("pesquisa", pesquisar(nome));

		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(Newsletter newsletter, Sugestao sugestao) throws IOException {
		ModelAndView mv = new ModelAndView("index");
		if (newsletter.getCodigo() != null) {
			newsletters.save(newsletter);
		} else {
			enviarEmail(sugestao.getNome(), sugestao.getAssunto(), sugestao.getMensagem());
		}
		return mv;
	}

	public void enviarEmail(String nome, String assunto, String mensagem) {
		StringBuilder sb = new StringBuilder();
		sb.append(nome + "\n");
		sb.append(mensagem);
		EmailJava enviarEmail = new EmailJava("leonardoandriotte@hotmail.com", assunto, sb.toString());
		enviarEmail.enviar();
	}

	public List<Categoria> pesquisaCategoria() {
		List<Categoria> todosCategoria = categorias.findAll();
		ModelAndView mv = new ModelAndView("index");

		List<String> lista = new ArrayList<>();

		for (Categoria categoria : todosCategoria) {
			lista.add(categoria.getNomeCategoria());
		}
		return todosCategoria;
	}

	public List<Contato> pesquisaContato() {
		List<Contato> contatos = contato.findAll();
		return contatos;
	}
	

	public List<IndexAdmin> pesquisar(@RequestParam(defaultValue = "%")String produtos){
		List<IndexAdmin> pesquisa = produto.findByNomeContaining(produtos);
		//System.out.println(produtos);
//		ModelAndView mv = new ModelAndView("redirect:/index");
//		mv.addObject("pesquisa", pesquisa);
		
		return pesquisa;
	}
}
