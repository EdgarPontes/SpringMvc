package br.com.tecnonoticias.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.tecnonoticias.ecommerce.model.Categoria;

public interface Categorias extends JpaRepository<Categoria, Long>{
	
	public final static String FIND_BY_ADDRESS_QUERY = "select nome_categoria from categoria";
	
	public List<Categoria> findByNomeCategoriaContaining(String categoria);

}
