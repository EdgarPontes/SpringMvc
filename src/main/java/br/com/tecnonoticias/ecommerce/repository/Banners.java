package br.com.tecnonoticias.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tecnonoticias.ecommerce.model.Banner;

public interface Banners extends JpaRepository<Banner, Long>{

}
