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

import br.com.felipe.crud.model.cadastro.ProdutoDTO;
import br.com.felipe.crud.services.ProdutoService;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

  @Autowired
  private ProdutoService produtoService;
    
  @GetMapping
  public List<ProdutoDTO> buscarTodos(){
    return produtoService.buscarTodos();
  }


  @GetMapping("/{id}")
  public Optional<ProdutoDTO> buscarPorId(@PathVariable Integer id){
    return produtoService.buscarPorId(id);
  }

@PostMapping
  public ProdutoDTO adicionar(@RequestBody ProdutoDTO produto){
    return produtoService.adicionar(produto);
  }

  @DeleteMapping("/{id}")
  public String deletar(@PathVariable Integer id){
    produtoService.deletar(id);
    return "Produto com id: "+ id +" , foi deletado com sucesso!"; 
  }
@PutMapping("/{id}")
  public ProdutoDTO atualizar(@PathVariable Integer id,@RequestBody ProdutoDTO produto){
    return produtoService.atualizar(id,produto);
  }
}