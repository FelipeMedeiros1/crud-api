package br.com.felipe.crud.view.controller.cliente;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter 
public class ClienteRequest {
  private String nome;
  private String cpf;
  private String telefone;
  private String endereco;
    
}