package com.ronaldo.CursoMc.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.Integer;
import com.ronaldo.CursoMc.domain.Pedido;
import com.ronaldo.CursoMc.repositories.PedidoRepository;
import com.ronaldo.CursoMc.services.exceptions.ObjectNotFoundException;

import java.util.Optional;

@Service
public class PedidoService {
	
@Autowired(required=false)
private PedidoRepository repo;
	
@Autowired(required=false)
public Pedido find(Integer id) {
		 Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
		} 
}
