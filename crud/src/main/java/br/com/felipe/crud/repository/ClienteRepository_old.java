package br.com.felipe.crud.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.felipe.crud.model.cadastro.Cliente;
import br.com.felipe.crud.model.exception.ResourceNotFoundException;

@Repository
public class ClienteRepository_old {
  //*******Simulando Banco De Dados*********//
  private List<Cliente> clientes = new ArrayList<>();
  private Integer ultimoId = 0 ;
  //****************************************//  

public List<Cliente> buscarTodos(){
  return clientes;

}

public Optional<Cliente> buscarPorId(Integer id){
  return clientes.stream().filter(cliente -> cliente.getId() == id ).findFirst();
}

public Cliente adicionar(Cliente cliente){
  ultimoId++;

  cliente.setId(ultimoId);
  clientes.add(cliente);

  return cliente;
}

public void deletar(Integer id){
  clientes.removeIf(cliente -> cliente.getId() == id);
}

public Cliente atualizar(Cliente cliente){
  Optional<Cliente> clienteEncontrado = buscarPorId(cliente.getId());

  if (clienteEncontrado.isEmpty()) {
    throw new ResourceNotFoundException("Cliente não cadastrado!");
    }
    deletar(cliente.getId());
    clientes.add(cliente);
  
    return cliente;

}
    
}