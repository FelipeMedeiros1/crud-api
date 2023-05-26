package br.com.felipe.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.felipe.crud.model.cadastro.Produto;




@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Integer> {



}