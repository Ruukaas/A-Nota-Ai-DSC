package com.mycompany.dscproject.model;

import jakarta.persistence.Column;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;

/**
 *
 * @author euluc
 */
@Entity
@NamedQueries(
        {
            @NamedQuery(
                    name = "Categoria.PorValor",
                    query = "SELECT c FROM Preco c WHERE c.valor LIKE :valor ORDER BY c.id"
            )
        }
)
public class Preco implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @OneToOne(mappedBy = "valorUnitario", optional = true)
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_produto", referencedColumnName = "codigo")
    private Produto produto;
    
    @Column(name = "valor", nullable = false)
    private Double valor;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dataDeRegistro", nullable = false)
    private Date dataDeRegistro;
    
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }    

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
        this.item.setValorUnitario(this);
    }
    
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getDataDeRegistro() {
        return dataDeRegistro;
    }

    public void setDataDeRegistro(Date dataDeRegistro) {
        this.dataDeRegistro = dataDeRegistro;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Preco)) { return false; }
        Preco other = (Preco) object;
        return !((this.codigo == null && other.codigo != null) || 
                  (this.codigo != null && !this.codigo.equals(other.codigo)));
    }
    
    @Override
    public String toString() {
        return "com.mycompany.dscproject.model.Preco[ id=" + codigo + " ]";
    }
}
