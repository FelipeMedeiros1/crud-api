package br.com.felipe.crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.felipe.crud.model.Cliente;
import br.com.felipe.crud.repository.ClienteRepository;
import br.com.felipe.crud.shared.ClienteDTO;

@Service
public class ClienteService {
  
  @Autowired
  private ClienteRepository clienteRepository;

  /**
   * @return lista de clientes
   */
  public List<ClienteDTO> buscarTodos(){
    return clienteRepository.buscarTodos();
  
  }
  /**
   * @param id do cliente para realizaer busca
   * @return cliente encontrado
   */
  public Optional<ClienteDTO> buscarPorId(Integer id){
    return clienteRepository.buscarPorId(id);
  }

  /**
   * @param cliente que será adicionado
   * @return cliente adicionado na lista
   */
  public ClienteDTO adicionar(ClienteDTO cliente){
   return clienteRepository.adicionar(cliente);
  }

  /**
   * @param id do cliente que será deletado
   */
  public void deletar(Integer id){
    clienteRepository.deletar(id);
  }

  /**
   * @param id do cliente
   * @param cliente que será atualizado
   * @return cliente atualizado
   */
  public ClienteDTO atualizar(Integer id, ClienteDTO cliente){
    cliente.setId(id);
    return clienteRepository.atualizar(cliente);
  
  }
    
}