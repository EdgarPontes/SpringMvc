package br.com.tecnonoticias.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.tecnonoticias.ecommerce.model.EmailPromocional;
import br.com.tecnonoticias.ecommerce.model.Newsletter;

public interface EmailPromocionais extends JpaRepository<EmailPromocional, Long>{
	
	public final static String FIND_BY_ADDRESS_QUERY = "SELECT email FROM newsletter";
	
	public List<EmailPromocional> findByCodigoContaining(Long codigo);
	
	@Query(FIND_BY_ADDRESS_QUERY)
	public List<Newsletter> findByEmail(String email);
	
}
