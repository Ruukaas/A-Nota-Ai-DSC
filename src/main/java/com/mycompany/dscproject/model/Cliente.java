package com.mycompany.dscproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import java.io.Serializable;

/**
 * @author Lucas Gomes
 **/

@Entity
@DiscriminatorValue(value = "Cliente")
@PrimaryKeyJoinColumn(
  name = "codigo_usuario",
  referencedColumnName = "codigo"
)
public class Cliente extends Usuario implements Serializable
{
  @Column(unique = true)
  private String cpf;

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }
}
