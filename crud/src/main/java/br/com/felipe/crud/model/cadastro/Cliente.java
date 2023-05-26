package br.com.felipe.crud.model.cadastro;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
//Comunicacao entre service e repository
@Getter
@Setter 
@Entity
public class Cliente {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String nome;
  private String cpf;
  private String telefone;
  private String endereco;
    
}