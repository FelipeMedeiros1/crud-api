package br.com.felipe.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.felipe.crud.model.cadastro.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer>{


    
}