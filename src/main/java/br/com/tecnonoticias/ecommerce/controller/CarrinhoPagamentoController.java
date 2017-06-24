package br.com.tecnonoticias.ecommerce.controller;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.tecnonoticias.ecommerce.model.Carrinho;
import br.com.tecnonoticias.ecommerce.model.Cliente;
import br.com.tecnonoticias.ecommerce.repository.Carrinhos;
import br.com.tecnonoticias.ecommerce.repository.Clientes;
import br.com.tecnoticias.ecommerce.aplicacoes.CalculaFrete;

@Controller
public class CarrinhoPagamentoController {

	@Autowired
	private Carrinhos carrinho;

	@Autowired
	private Clientes pesquisaCliente;
	
	private CalculaFrete calculaFrete = new CalculaFrete();
//	private DecimalFormat df = new DecimalFormat("0.00");

	static Carrinho produtos = new Carrinho();

	@RequestMapping("/carrinhoPagamento")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("carrinhoPagamento");
		Object usuarioLogado = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = null;
		BigDecimal valorTotalVenda = BigDecimal.ZERO;
		BigDecimal pesoTotal = BigDecimal.ZERO;
		BigDecimal freteUnitario= BigDecimal.ZERO;
		Integer produtosComFrete = 0;
		
		if (usuarioLogado instanceof UserDetails) {
			username = ((UserDetails) usuarioLogado).getUsername();
		}
		
		List<Carrinho> Compra = produtosNoCarrinho(username);
		
		for (Carrinho carrinho : Compra) {
			valorTotalVenda = valorTotalVenda.add(carrinho.getValorTotal());
			pesoTotal = pesoTotal.add(carrinho.getPeso());
			
			if (!carrinho.getFrete()) {
				produtosComFrete += carrinho.getQuantidade();
			}
		}
				
		Cliente cliente = pesquisaCliente.findByEmail(username);
		
//		freteTotal = Double.parseDouble(df.format(calculaFrete.calcula(cliente.getEstado(), pesoTotal)).replaceAll(",", "."));
		BigDecimal freteTotalBig = new BigDecimal(calculaFrete.calcula(cliente.getEstado(), pesoTotal.doubleValue())).setScale(2, BigDecimal.ROUND_UP);
		
		if (produtosComFrete > 1) {
			freteUnitario = freteTotalBig.divide(new BigDecimal(produtosComFrete), BigDecimal.ROUND_UP);			
		}
				
		mv.addObject("freteUnitario",freteUnitario);
		mv.addObject("valorFrete", freteTotalBig);
		mv.addObject("valorTotalVenda", valorTotalVenda);
		mv.addObject("produtoCarrinho", Compra);

		return mv;

	}
	
	public BigDecimal formataDecimal(BigDecimal vlrFator){  
		BigDecimal numFormatado  = vlrFator.setScale(2, BigDecimal.ROUND_UP); 
		return numFormatado;		
	}

	public List<Carrinho> produtosNoCarrinho(String cliente) {
		List<Carrinho> produto = carrinho.findByCliente(cliente);
		return produto;

	}
	
}
