package br.com.felipe.crud.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.felipe.crud.model.cadastro.Cliente;
import br.com.felipe.crud.model.exception.ResourceNotFoundException;
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
    List<Cliente> clientes = clienteRepository.findAll();

    return clientes.stream().map(cliente -> new ModelMapper().map(cliente,ClienteDTO.class))
    .collect(Collectors.toList());
  
  }
  /**
   * @param id do cliente para realizaer busca
   * @return cliente encontrado
   */
  public Optional<ClienteDTO> buscarPorId(Integer id){
    
    Optional<Cliente> cliente =  clienteRepository.findById(id);
   
    if (cliente.isEmpty()) {
      throw new ResourceNotFoundException("Cliente com id:" +id+ ", não encontrado.");
    }
    
    ClienteDTO dto = new ModelMapper().map(cliente.get(), ClienteDTO.class);

    return Optional.of(dto);
  }

  /**
   * @param cliente que será adicionado
   * @return cliente adicionado na lista
   */
  public ClienteDTO adicionar(ClienteDTO clienteDTO){
    clienteDTO.setId(null);

    Cliente cliente = new ModelMapper().map(clienteDTO, Cliente.class);

    cliente = clienteRepository.save(cliente);

    clienteDTO.setId(cliente.getId());

   return clienteDTO;
  }

  /** 
   * @param id do cliente que será deletado
   */
  public void deletar(Integer id){
    Optional<Cliente> cliente = clienteRepository.findById(id);

    if(cliente.isEmpty()){
      throw new ResourceNotFoundException("Cliente com id:"+id+" não existe.");
    }
    
    clienteRepository.deleteById(id);
  }

  /**
   * @param id do cliente
   * @param cliente que será atualizado
   * @return cliente atualizado
   */
  public ClienteDTO atualizar(Integer id, ClienteDTO clienteDTO){
    clienteDTO.setId(id);
     
    Cliente cliente = new ModelMapper().map(clienteDTO, Cliente.class);

    clienteRepository.save(cliente);

    return clienteDTO;
  }
    
}