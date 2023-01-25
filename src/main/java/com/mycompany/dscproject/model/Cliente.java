package com.mycompany.dscproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
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
@NamedQueries(
        {
            @NamedQuery(
                    name = "Cliente.byCPF",
                    query = "SELECT c FROM Cliente c WHERE c.cpf LIKE :cpf "
            )
        }
)
public class Cliente extends Usuario implements Serializable {
    @Column(unique = true, nullable = true)
    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
