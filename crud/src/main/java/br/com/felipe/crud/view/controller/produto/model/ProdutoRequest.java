package br.com.felipe.crud.view.controller.produto.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter 
public class ProdutoRequest {
  private String nome;
  private Integer quantidade;
  private Double valor;
  private String observacao;
    
}