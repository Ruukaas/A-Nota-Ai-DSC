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
@DiscriminatorValue(value = "Vendedor")
@PrimaryKeyJoinColumn(
  name = "codigo_usuario",
  referencedColumnName = "codigo"
)
public class Vendedor extends Usuario implements Serializable
{
  @Column(unique = true, nullable = true)
  private String CNPJ;

  public String getCNPJ() {
    return CNPJ;
  }

  public void setCNPJ(String CNPJ) {
    this.CNPJ = CNPJ;
  }
}
