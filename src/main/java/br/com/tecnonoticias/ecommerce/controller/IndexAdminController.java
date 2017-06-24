package br.com.tecnonoticias.ecommerce.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.tecnonoticias.ecommerce.model.Categoria;
import br.com.tecnonoticias.ecommerce.model.IndexAdmin;
import br.com.tecnonoticias.ecommerce.repository.CadastroProdutos;
import br.com.tecnonoticias.ecommerce.repository.Categorias;

@Controller
@RequestMapping("/indexAdmin")
public class IndexAdminController extends Categoria {
	@Autowired
	CadastroProdutos produtos;

	@Autowired
	private Categorias categorias;
	
	BigDecimal porcento = new BigDecimal(100);

	@RequestMapping
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("indexAdmin");
		List<String> lista = pesquisa();
		mv.addObject("todasCategoria", lista);
		mv.addObject(new IndexAdmin());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(IndexAdmin produto) {
		if ((produto.getProdutoPromocao() != null) && (produto.getProdutoPromocao().equalsIgnoreCase("on"))) {
			produto.setValorComDesconto(calculoDesconto(produto));
		}else{
			produto.setProdutoPromocao("off");
		}
		
		if ((produto.getFreteGratis() != null) && (produto.getFreteGratis().equalsIgnoreCase("on"))) {
			produto.setPeso(BigDecimal.ZERO);		
		}else{
			produto.setFreteGratis("off");
		}
		
		produto.setCategoria(produto.getCategoria().replace(",", ""));
		produto.setQuantidadeVendida(0L);
		produtos.save(produto);
		ModelAndView mv = new ModelAndView("redirect:/indexAdmin");
		return mv;
	}

	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable Long codigo){
		IndexAdmin produto = produtos.findOne(codigo);
		ModelAndView mv = new ModelAndView("indexAdmin");
		mv.addObject(produto);
		return mv;
	}
	
	public List<String> pesquisa() {
		List<Categoria> todosCategoria = categorias.findAll();
		List<String> lista = new ArrayList<>();

		for (Categoria categoria : todosCategoria) {
			lista.add(categoria.getNomeCategoria());
		}
		return lista;
	}

	public BigDecimal calculoDesconto(IndexAdmin produto) {
		if (produto.getTipoDesconto().equals("%")) {
			return produto.getValorProduto().subtract((produto.getValorProduto().multiply(produto.getValorDesconto()).divide(porcento)));
		} else {
			return produto.getValorProduto().subtract(produto.getValorDesconto());
		}
	}
	
	

}
