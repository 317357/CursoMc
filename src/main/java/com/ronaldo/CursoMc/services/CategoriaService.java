package com.ronaldo.CursoMc.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import java.lang.Integer;
import com.ronaldo.CursoMc.domain.Categoria;
import com.ronaldo.CursoMc.repositories.CategoriaRepository;
import com.ronaldo.CursoMc.services.exceptions.DataIntegrityException;
import com.ronaldo.CursoMc.services.exceptions.ObjectNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
	
@Autowired(required=false)
private CategoriaRepository repo;
	
@Autowired(required=false)
public Categoria find(Integer id) {
		 Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
		} 

public Categoria insert(Categoria obj) {
	obj.setId(null);
	return repo.save(obj);
}
public Categoria update (Categoria obj) {
	find(obj.getId());
	return repo.save(obj);
}
public void delete(Integer id) {
	find(id);
	try {
	repo.deleteById(id);
	
}
   catch(DataIntegrityViolationException e) {
	   throw new DataIntegrityException("Não é possivel excluir uma Categoria que possui Produtos");
   }
		
 }
public List<Categoria> findAll(){
	return repo.findAll();
}

}
