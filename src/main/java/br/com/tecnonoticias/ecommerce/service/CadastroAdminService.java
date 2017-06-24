package br.com.tecnonoticias.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.tecnonoticias.ecommerce.model.CadastroAdmin;
import br.com.tecnonoticias.ecommerce.repository.CadastrosAdmin;

@Service
public class CadastroAdminService {

	@Autowired
	private CadastrosAdmin repository;

	public List<CadastroAdmin> findAll() {
		return repository.findAll();
	}

	public CadastroAdmin findOne(Long id) {
		return repository.findOne(id);
	}

	public CadastroAdmin save(CadastroAdmin post) {
		return repository.saveAndFlush(post);
	}

	public void delete(Long id) {
		repository.delete(id);
	}
}
