package br.com.tecnonoticias.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tecnonoticias.ecommerce.model.Cliente;

public interface Clientes extends JpaRepository<Cliente, Long>{

	public final static String FIND_BY_ADDRESS_QUERY = "select nome from cliente";
	
//	 @Query(FIND_BY_ADDRESS_QUERY)
	 public List<Cliente> findByNomeContaining(String nome);
	 
	 public Cliente findByEmail(String nome);
}
