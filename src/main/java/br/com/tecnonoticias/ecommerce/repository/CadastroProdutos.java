package br.com.tecnonoticias.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tecnonoticias.ecommerce.model.IndexAdmin;

public interface CadastroProdutos extends JpaRepository<IndexAdmin,Long>{
//
//	public final static String FIND_BY_ADDRESS_QUERY = "select nome_categoria from categoria";
//	

	 public List<IndexAdmin> findByNomeContaining(String categoria);
	 
	 public List<IndexAdmin> findByCodigo(Long codigo);
	
	
}
