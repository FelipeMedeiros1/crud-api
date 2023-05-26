package br.com.felipe.crud.view.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.felipe.crud.model.Cliente;
import br.com.felipe.crud.services.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

  @Autowired
  private ClienteService clienteService;

  @GetMapping
  public List<ClienteDTO> buscarTodos(){
    return clienteService.buscarTodos();
  
  }
  @GetMapping("/{id}")
  public Optional<ClienteDTO> buscarPorId(@PathVariable Integer id){
    return clienteService.buscarPorId(id);
  }

  @PostMapping
  public ClienteDTO adicionar(@RequestBody ClienteDTO cliente){
    return clienteService.adicionar(cliente);
   }
   @DeleteMapping("/{id}") 
   public String deletar(@PathVariable Integer id){
    clienteService.deletar(id);
    return "Cliente id:"+ id +", deletado com sucesso";
  }
  @PutMapping("/{id}")
  public ClienteDTO atualizar(@PathVariable Integer id, @RequestBody ClienteDTO cliente){
    cliente.setId(id);
    return clienteService.atualizar(id, cliente);
  
  }

}