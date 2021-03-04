package com.ronaldo.CursoMc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ronaldo.CursoMc.domain.Produto;
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
