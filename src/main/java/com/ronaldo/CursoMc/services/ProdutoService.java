package com.ronaldo.CursoMc.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ronaldo.CursoMc.domain.Categoria;
import com.ronaldo.CursoMc.domain.Produto;
import com.ronaldo.CursoMc.repositories.CategoriaRepository;
import com.ronaldo.CursoMc.repositories.ProdutoRepository;
import com.ronaldo.CursoMc.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	
@Autowired(required=false)
private ProdutoRepository repo;

@Autowired
private CategoriaRepository categoriaRepository;
	
@Autowired(required=false)
public Produto find(Integer id) {
		 Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
}	
		public Page<Produto> search(String nome, List<Integer> ids,Integer page,Integer linesPerPage,String ordeBy,String direction){
			PageRequest pageRequest=  PageRequest.of(page,linesPerPage, Direction.valueOf(direction),ordeBy);
			List<Categoria> categorias= categoriaRepository.findAllById(ids);
			return repo.findDistinctByNomeContainingAndCategoriasIn(nome,categorias,pageRequest);
			
		
		} 
}
