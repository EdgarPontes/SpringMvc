package br.com.tecnonoticias.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.tecnonoticias.ecommerce.model.Carrinho;

public interface Carrinhos extends JpaRepository<Carrinho, Long>{
	
 	 public List<Carrinho> findByCliente(String nome);
 	 	 
}
