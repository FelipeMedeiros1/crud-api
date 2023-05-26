package br.com.felipe.crud.view;

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