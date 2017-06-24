package br.com.tecnonoticias.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tecnonoticias.ecommerce.model.CadastroAdmin;


@Repository
public interface CadastrosAdmin extends JpaRepository<CadastroAdmin, Long>{
	
	public List<CadastroAdmin> findByUsuarioContaining(String cadastroAdmin);

}
