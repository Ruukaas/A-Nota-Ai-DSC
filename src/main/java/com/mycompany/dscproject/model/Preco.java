package com.mycompany.dscproject.model;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Preco implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigo;
    private double valor;
    @Temporal(TemporalType.DATE)
    private Date dataDeRegistro;
    @OneToOne(mappedBy = "valorUnitario", optional = true)
    private Item item;
    @ManyToOne
    private Produto produto;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getDataDeRegistro() {
        return dataDeRegistro;
    }

    public void setDataDeRegistro(Date dataDeRegistro) {
        this.dataDeRegistro = dataDeRegistro;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Preco)) {
            return false;
        }
        
        Preco other = (Preco) object;

        return !((this.codigo == null && other.codigo != null) || 
                 (this.codigo != null && !this.codigo.equals(other.codigo)));
    }
}
