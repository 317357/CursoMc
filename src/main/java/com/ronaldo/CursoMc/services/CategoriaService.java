package com.ronaldo.CursoMc.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.Integer;
import com.ronaldo.CursoMc.domain.Categoria;
import com.ronaldo.CursoMc.repositories.CategoriaRepository;
import com.ronaldo.CursoMc.services.exceptions.ObjectNotFoundException;

import java.util.Optional;

@Service
public class CategoriaService {
	
@Autowired(required=false)
public CategoriaRepository repo;
	
@Autowired(required=false)
public Categoria find(Integer id) {
		 Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
		} 
}
