package br.com.tecnonoticias.ecommerce.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.tecnonoticias.ecommerce.model.Carrinho;
import br.com.tecnonoticias.ecommerce.repository.Carrinhos;
import br.com.tecnonoticias.ecommerce.repository.Clientes;

@Controller
@RequestMapping("/carrinho")
public class CarrinhoController {

	@Autowired
	private Carrinhos carrinho;
	
	@Autowired
	private Clientes pesquisaCliente;

	static Carrinho produtos = new Carrinho();

	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("redirect:/carrinho");
		Object usuarioLogado = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = null;
		Carrinho produto = new Carrinho();
		
		produto.setCodigoProduto(produtos.getCodigoProduto());
		produto.setValorUnitario(produtos.getValorUnitario());
		produto.setNome(produtos.getNome());
		produto.setQuantidade(produtos.getQuantidade());
		produto.setPeso(produtos.getPeso());
		produto.setFrete(produtos.getFrete());
		
		if (produto.getQuantidade() == 1 ) {
			produto.setValorTotal(produto.getValorUnitario());
		}else{
			produto.setValorTotal(produto.getValorUnitario().multiply(new BigDecimal(produto.getQuantidade())));
		}
		if (usuarioLogado instanceof UserDetails) {
			username = ((UserDetails) usuarioLogado).getUsername();
		}

		if (produto.getNome() != null) {
			produto.setCliente(username);
			carrinho.save(produto);
		}
		
		mv.addObject("produtoCarrinho",produtosNoCarrinho(username));
        //Cliente dadosCliente =  pesquisaCliente.findByNome(username);
		
		return mv;

	}
	
    @RequestMapping(path ="{codigo}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long codigo){
    	
		carrinho.delete(codigo);
		
		return "redirect:/carrinho";
	}
    
    @RequestMapping(method = RequestMethod.DELETE)
    public String excluirTudo(){
    	
    	carrinho.deleteAll();
    	
    	return "redirect:/carrinho";
    }
	
    @RequestMapping
	public ModelAndView produtosNoCarrinho (){
    	ModelAndView mv = new ModelAndView("carrinho");
		Object usuarioLogado = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = null;

		if (usuarioLogado instanceof UserDetails) {
			username = ((UserDetails) usuarioLogado).getUsername();
		}
		List<Carrinho> produto = carrinho.findByCliente(username);
		mv.addObject("produtoCarrinho",produto);

		return mv;
		
	}
    
    public List<Carrinho> produtosNoCarrinho (String cliente){
		List<Carrinho> produto = carrinho.findByCliente(cliente);
		return produto;
		
	}

	public void setProduto(Carrinho produto) {
		produtos.setCodigoProduto(produto.getCodigoProduto());
		produtos.setNome(produto.getNome());
		produtos.setValorUnitario(produto.getValorUnitario());
		produtos.setQuantidade(produto.getQuantidade());
		produtos.setPeso(produto.getPeso());
		produtos.setFrete(produto.getFrete());
	}

}