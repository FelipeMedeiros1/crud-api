package br.com.felipe.crud.shared;

import lombok.Getter;
import lombok.Setter;

//comunicaccao entre controller e service
@Getter
@Setter 
public class ClienteDTO {

  private Integer id;
  private String nome;
  private String cpf;
  private String telefone;
  private String endereco;
    



}