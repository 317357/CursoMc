package com.ronaldo.CursoMc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ronaldo.CursoMc.domain.Pedido;
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

}
