package br.com.tecnonoticias.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tecnonoticias.ecommerce.model.Newsletter;

public interface Newsletters extends JpaRepository<Newsletter, Long> {

}
