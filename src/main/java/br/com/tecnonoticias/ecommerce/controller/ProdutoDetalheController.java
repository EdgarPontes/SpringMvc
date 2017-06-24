package br.com.tecnonoticias.ecommerce.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.tecnonoticias.ecommerce.model.Carrinho;
import br.com.tecnonoticias.ecommerce.model.Categoria;
import br.com.tecnonoticias.ecommerce.model.Contato;
import br.com.tecnonoticias.ecommerce.model.IndexAdmin;
import br.com.tecnonoticias.ecommerce.model.Newsletter;
import br.com.tecnonoticias.ecommerce.repository.CadastroProdutos;
import br.com.tecnonoticias.ecommerce.repository.Carrinhos;
import br.com.tecnonoticias.ecommerce.repository.Categorias;
import br.com.tecnonoticias.ecommerce.repository.Contatos;
import br.com.tecnonoticias.ecommerce.repository.Newsletters;
import br.com.tecnoticias.ecommerce.aplicacoes.EmailJava;

@Controller
@RequestMapping("/produto_detalhe")
public class ProdutoDetalheController {

	@Autowired
	private Newsletters newsletters;

	@Autowired
	private CadastroProdutos produtos;

	@Autowired
	private Categorias categorias;

	@Autowired
	private Contatos contato;

	@Autowired
	private Carrinhos carrinho;

	HashMap<String, String> produtoCarrinho = new HashMap<>();
	
	private static Long codigoProduto = 0L;

	@RequestMapping("{codigo}")
	public ModelAndView novo(@PathVariable Long codigo) {
		IndexAdmin produto = produtos.findOne(codigo);
		this.codigoProduto = codigo;
		
		ModelAndView mv = new ModelAndView("produto_detalhe");
		List<String> lista = pesquisa();
		mv.addObject("todasCategoria", lista);
		mv.addObject("todosContatos", pesquisaContato());
		mv.addObject("produtos", produto);
		
		return mv;

	}

	@RequestMapping( method = RequestMethod.POST)
	public ModelAndView salvar(@RequestParam(value = "quantidadePedido", required=false) String quantidadePedido ,Newsletter newsletter, Carrinho produto) throws IOException {
		ModelAndView mv = new ModelAndView("redirect:/carrinho/novo");
		
		if (newsletter.getEmail() != null) {
			newsletters.save(newsletter);
		} else {
			
			IndexAdmin produtoCarrinho = produtos.findOne(this.codigoProduto );
			
			produto.setCodigoProduto(produtoCarrinho.getCodigo());
			produto.setNome(produtoCarrinho.getNome());
			produto.setQuantidade(Integer.parseInt(quantidadePedido));
			produto.setPeso(produtoCarrinho.getPeso());
			
			if (produtoCarrinho.getFreteGratis().equals("on")) {
				produto.setFrete(true);
			}else{
				produto.setFrete(false);
			}
			
			if (produtoCarrinho.getProdutoPromocao().equals("on")) {
				produto.setValorUnitario(produtoCarrinho.getValorComDesconto());
			}else{
				produto.setValorUnitario(produtoCarrinho.getValorProduto());
			}
			

			new CarrinhoController().setProduto(produto);
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

	public List<String> pesquisa() {
		List<Categoria> todosCategoria = categorias.findAll();
		List<String> lista = new ArrayList<>();

		for (Categoria categoria : todosCategoria) {
			lista.add(categoria.getNomeCategoria());
		}
		return lista;
	}

	public List<Contato> pesquisaContato() {
		List<Contato> contatos = contato.findAll();
		return contatos;
	}

}