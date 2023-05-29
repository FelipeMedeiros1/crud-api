package br.com.felipe.crud.view.controller;

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

import br.com.felipe.crud.services.ProdutoService;
import br.com.felipe.crud.shared.ProdutoDTO;
import br.com.felipe.crud.view.ProdutoRequest;
import br.com.felipe.crud.view.ProdutoResponse;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

  @Autowired
  private ProdutoService produtoService;
    
  @GetMapping
  public ResponseEntity<List<ProdutoResponse>> buscarTodos(){
    List<ProdutoDTO> produtos = produtoService.buscarTodos();
    
    ModelMapper mapper = new ModelMapper();
  
    List<ProdutoResponse> resposta = produtos.stream()
    .map(produtoDTO -> mapper.map(produtoDTO, ProdutoResponse.class)).collect(Collectors.toList());

    return new ResponseEntity<List<ProdutoResponse>>(resposta, HttpStatus.OK);
  
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<ProdutoResponse>> buscarPorId(@PathVariable Integer id){
   
    Optional<ProdutoDTO> produtoDTO = produtoService.buscarPorId(id);

    ProdutoResponse produto = new ModelMapper().map(produtoDTO.get(), ProdutoResponse.class);

    return new ResponseEntity<>(Optional.of(produto),HttpStatus.OK);
  }

@PostMapping
  public ResponseEntity<ProdutoResponse> adicionar(@RequestBody ProdutoRequest produtoRequest){
    ModelMapper mapper = new ModelMapper();

    ProdutoDTO produtoDTO = mapper.map(produtoRequest, ProdutoDTO.class);

    produtoDTO = produtoService.adicionar(produtoDTO);
 
    return new ResponseEntity<>(mapper.map(produtoDTO, ProdutoResponse.class),HttpStatus.OK);

  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deletar(@PathVariable Integer id){
    produtoService.deletar(id);
    return new ResponseEntity<String>("Produto com id: "+ id +" , foi deletado com sucesso!", HttpStatus.NO_CONTENT);

  }

@PutMapping("/{id}")
  public ResponseEntity<ProdutoResponse> atualizar(@PathVariable Integer id,@RequestBody ProdutoRequest produtoRequest){
    ModelMapper mapper = new ModelMapper();

    ProdutoDTO produtoDTO = mapper.map(produtoRequest,ProdutoDTO.class);
    
    produtoDTO=  produtoService.atualizar(id,produtoDTO);

    return new ResponseEntity<ProdutoResponse>(
      mapper.map(produtoDTO,ProdutoResponse.class),HttpStatus.OK);

  }
}