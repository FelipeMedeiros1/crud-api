package br.com.felipe.crud.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.felipe.crud.model.cadastro.Produto;
import br.com.felipe.crud.model.exception.ResourceNotFoundException;
import br.com.felipe.crud.repository.ProdutoRepository;
import br.com.felipe.crud.shared.ProdutoDTO;


@Service
public class ProdutoService {
  @Autowired
  private ProdutoRepository produtoRepository;

    /**
   * Retorna uma lista de produtos
   * @return Lista Produtos
   */
  public List<ProdutoDTO> buscarTodos(){
    // retorna uma lista de produto model
    List<Produto> produtos =  produtoRepository.findAll();
    //transforma a lista de model para dto
    return produtos.stream().map(produto -> new ModelMapper().map(produto,ProdutoDTO.class))
    .collect(Collectors.toList());
  }

  /**
 * Retorna produto encontrado por id
 * @param id do produto para realizar a busca
 * @return Retorna produto 
 */
public Optional<ProdutoDTO> buscarPorId(Integer id){
  
  Optional<Produto> produto = produtoRepository.findById(id);

  if (produto.isEmpty()) {
    throw new ResourceNotFoundException("Produto com id:" +id+ ", não encontrado.");
  }
  
  ProdutoDTO dto = new ModelMapper().map( , getClass(), null)
  return 

  
}

  /**
   * Adiciona produto na lista
   * @param produto que será adicionado
   * @return Retorna produto adicionado na lista
   */
  public ProdutoDTO adicionar(ProdutoDTO produto){
    //regra de negocio aqui..
    return produtoRepository.adicionar(produto);
  }

    /**
   * Deleta produto por id
   * @param id do produto para ser deletado
   */
  public void deletar(Integer id){
    //logica de validação
    produtoRepository.deletar(id);
  }

  /**
 * Atualizar produto na lista
 * @param produto que será atualizado
 * @param id do produto
 * @return Retorna produto após atualizar a lista
 */
public ProdutoDTO atualizar(Integer id, ProdutoDTO produto){
  //logica de validação
  produto.setId(id);
  return produtoRepository.atualizar(produto);
}
    
}