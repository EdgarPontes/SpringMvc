package br.com.tecnonoticias.ecommerce.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
@RequestMapping("/produto_categoria")
public class ProdutoCategoriaController {

	@Autowired
	private Newsletters newsletters;

	@Autowired
	private Categorias categorias;

	@Autowired
	private Contatos contato;

	@Autowired
	private CadastroProdutos produto;

	@RequestMapping("{codigo}")
	public ModelAndView novo(@PathVariable String codigo) {
		ModelAndView mv = new ModelAndView("produto_categoria");
		mv.addObject("todasCategoria", pesquisa());
		mv.addObject("todosContatos", pesquisaContato());
		mv.addObject("todosProdutos", pesquisaProdutoPromocao(Long.parseLong(codigo)));
		// mv.addObject("todosProdutos", pesquisaProdutoMaisVendido());

		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(Newsletter newsletter, Sugestao sugestao) throws IOException {
		ModelAndView mv = new ModelAndView("produto_categoria");
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

	public List<Categoria> pesquisa() {
		List<Categoria> todosCategoria = categorias.findAll();
		ModelAndView mv = new ModelAndView("produto_categoria");

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

	public List<IndexAdmin> pesquisaProdutoPromocao(Long codigo) {
		List<IndexAdmin> todosProdutos = new ArrayList<>();
		Categoria cat = categorias.findOne(codigo);
		for (IndexAdmin produto : produto.findAll()) {
			if (produto.getCategoria().equals(cat.getNomeCategoria())) {
				todosProdutos.add(produto);
			}
		}
		return todosProdutos;
	}

}
