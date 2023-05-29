package br.com.felipe.crud.view.controller.cliente;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.felipe.crud.services.ClienteService;
import br.com.felipe.crud.shared.ClienteDTO;
import br.com.felipe.crud.view.controller.cliente.model.ClienteRequest;
import br.com.felipe.crud.view.controller.cliente.model.ClienteResponse;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

  @Autowired
  private ClienteService clienteService;

  @GetMapping
  public ResponseEntity<List<ClienteResponse>> buscarTodos(){
    List<ClienteDTO> clientesDTO = clienteService.buscarTodos();
    
    List<ClienteResponse> clienteReponse = clientesDTO.stream()
    .map(clienteDTO -> new ModelMapper().map(clienteDTO, ClienteResponse.class))
    .collect(Collectors.toList());

    return new ResponseEntity<>(clienteReponse, HttpStatus.OK);

  }
  @GetMapping("/{id}")
  public ResponseEntity<Optional<ClienteResponse>> buscarPorId(@PathVariable Integer id){
    Optional<ClienteDTO> clienteDTO =  clienteService.buscarPorId(id);
    
    ClienteResponse clienteResponse = new ModelMapper().map(clienteDTO.get(),ClienteResponse.class);
    
    return new ResponseEntity<Optional<ClienteResponse>>(Optional.of(clienteResponse),HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<ClienteResponse> adicionar(@RequestBody ClienteRequest clienteRequest){
    ModelMapper mapper =  new ModelMapper();

    ClienteDTO clienteDTO = mapper.map(clienteRequest,ClienteDTO.class);

    clienteDTO =  clienteService.adicionar(clienteDTO);

    return new ResponseEntity<>(mapper.map(clienteDTO, ClienteResponse.class),HttpStatus.OK);
    
   }

   @DeleteMapping("/{id}") 
   public ResponseEntity<String> deletar(@PathVariable Integer id){
    clienteService.deletar(id);
    return new ResponseEntity<>("Cliente id:"+ id +", deletado com sucesso", HttpStatus.NO_CONTENT);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ClienteResponse> atualizar(@PathVariable Integer id, @RequestBody ClienteRequest clienteRequest){
    ModelMapper mapper =  new ModelMapper();

    ClienteDTO clienteDTO = mapper.map(clienteRequest,ClienteDTO.class);

    clienteDTO = clienteService.atualizar(id, clienteDTO);
    
    return new ResponseEntity<>(mapper.map(clienteDTO, ClienteResponse.class),HttpStatus.OK);
    
  }

}