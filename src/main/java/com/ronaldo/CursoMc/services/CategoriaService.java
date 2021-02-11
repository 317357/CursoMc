package com.ronaldo.CursoMc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ronaldo.CursoMc.domain.Categoria;
import com.ronaldo.CursoMc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repo;

	public Categoria buscar(Integer id) {
		Categoria obj= repo.getOne(id);
		return obj;
	}

}