package com.ronaldo.CursoMc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ronaldo.CursoMc.domain.Produto;
import com.ronaldo.CursoMc.dto.ProdutoDTO;
import com.ronaldo.CursoMc.resources.utils.URL;
import com.ronaldo.CursoMc.services.ProdutoService;

@RestController
@RequestMapping(value="/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService service;
	

@RequestMapping(value="/{id}",method=RequestMethod.GET)	
public ResponseEntity<Produto> find(@PathVariable Integer id) {
	
	Produto obj= service.find(id);
	
	return ResponseEntity.ok().body(obj);
	
   }
@RequestMapping( method = RequestMethod.GET)
public ResponseEntity<Page<ProdutoDTO>> findAPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
		@RequestParam(value = "nome", defaultValue = "") String nome,
		@RequestParam(value = "categorias", defaultValue = "") String categorias,
		@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
		@RequestParam(value = "ordeBy", defaultValue = "nome") String ordeBy,
		@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
	    String nomeDecoded= URL.decodeParam(nome);
        List<Integer> ids= URL.decodeIntList(categorias);
	Page<Produto> list = service.search(nomeDecoded ,ids,linesPerPage, linesPerPage, ordeBy, direction);
	Page<ProdutoDTO> listDto = list.map(obj -> new ProdutoDTO(obj));

	return ResponseEntity.ok().body(listDto);
}
}
