package com.example.api_equality_food.Produto;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

    List<Produto> findByCategoria(String categoria);

    List<Produto> findByNomeLike(String nome);
}
