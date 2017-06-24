package br.com.tecnonoticias.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tecnonoticias.ecommerce.model.Contato;

public interface Contatos extends JpaRepository<Contato, Long>{

}
