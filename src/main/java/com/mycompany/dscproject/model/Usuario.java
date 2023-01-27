package com.mycompany.dscproject.model;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;

/**
 *
 * @author euluc
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(
    name = "Discriminador_Usuario",
    discriminatorType = DiscriminatorType.STRING,
    length = 8
)
@NamedQueries(
        {
            @NamedQuery(
                    name = "Usuario.porNome",
                    query = "SELECT u FROM Usuario u WHERE u.nome LIKE :nome"
            )
        }
)
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long codigo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "donoDaNota", fetch = FetchType.LAZY)
    protected List<NotaFiscal> compras;
    
    @Column(name = "nome", nullable = false)
    protected String nome;
    
    @Column(name = "login", nullable = false)
    protected String login;
    
    @Column(name = "sobrenome", nullable = false)
    protected String sobrenome;
    
    @Column(name = "email", nullable = false)
    protected String email;
    
    @Column(name = "senha", nullable = false)
    protected String senha;
    
    @Column(name = "telefone", nullable = true)
    protected String telefone;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
    
    public List<NotaFiscal> getCompras() {
        return compras;
    }

    public void setCompras(List<NotaFiscal> compras) {
        this.compras = compras;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Usuario)) { return false; }
        Usuario other = (Usuario) object;
        return !((this.codigo == null && other.codigo != null) || 
                  (this.codigo != null && !this.codigo.equals(other.codigo)));
    }
    
    @Override
    public String toString() {
        return "com.mycompany.dscproject.model.Usuario[ id=" + codigo + " ]";
    }
}
