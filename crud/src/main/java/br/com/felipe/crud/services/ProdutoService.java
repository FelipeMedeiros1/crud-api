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
  // obtendo optional de produto por id
  Optional<Produto> produto = produtoRepository.findById(id);

  if (produto.isEmpty()) {
    throw new ResourceNotFoundException("Produto com id:" +id+ ", não encontrado.");
  }
 
  // convertendo o optional de produto em um produtoDTO
  ProdutoDTO dto = new ModelMapper().map(produto.get(), ProdutoDTO.class);
 
  //criando e retornando um optional de dto
  return Optional.of(dto);
  
}

  /**
   * Adiciona produto na lista
   * @param produtoDTO que será adicionado
   * @return Retorna produto adicionado na lista
   */
  public ProdutoDTO adicionar(ProdutoDTO produtoDTO){
    //regra de negocio aqui..
    produtoDTO.setId(null);
    
    //criar objeto de mapeamento
    ModelMapper mapper = new  ModelMapper();
    
    //converte produtoDTO em produto model
    Produto produto = mapper.map(produtoDTO, Produto.class);
    
    //salva produto no banco de dados
    produto = produtoRepository.save(produto);
    produtoDTO.setId(produto.getId());
    //retorna produtoDTO 
    return produtoDTO;

  }

    /**
   * Deleta produto por id
   * @param id do produto para ser deletado
   */
  public void deletar(Integer id){
    //logica de validação
    //verificar se existe
    Optional<Produto> produto = produtoRepository.findById(id);
    
    if(produto.isEmpty()){
      throw new ResourceNotFoundException("Produto com id:"+id+" não existe.");
    } 
    produtoRepository.deleteById(id);
  }

  /**
 * Atualizar produto na lista
 * @param produto que será atualizado
 * @param id do produto
 * @return Retorna produto após atualizar a lista
 */
public ProdutoDTO atualizar(Integer id, ProdutoDTO produtoDTO){
  //logica de validação
  //passar o id para produtoDTO
  produtoDTO.setId(id);

  //cria objeto de mapeamento
  ModelMapper mapper = new ModelMapper();
  
  //converte produtoDto em produto model
  Produto produto =  mapper.map(produtoDTO, Produto.class);

  //atualiza o produto no banco de dados
  produtoRepository.save(produto);

  //retorna o produto atualizado
  return produtoDTO;

}
    
}