package com.ronaldo.CursoMc.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.Integer;
import com.ronaldo.CursoMc.domain.Cliente;
import com.ronaldo.CursoMc.repositories.ClienteRepository;
import com.ronaldo.CursoMc.services.exceptions.ObjectNotFoundException;

import java.util.Optional;

@Service
public class ClienteService {
	
@Autowired(required=false)
private ClienteRepository repo;
	
@Autowired(required=false)
public Cliente find(Integer id) {
		 Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
		} 
}
