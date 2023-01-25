package com.mycompany.dscproject.model;

import java.io.Serializable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;

/**
 *
 * @author euluc
 */
@Entity
@NamedQueries(
        {
            @NamedQuery(
                    name = "Item.byQtde",
                    query = "SELECT c FROM Item c WHERE c.quantidade LIKE :qtde"
            )
        }
)
public class Item implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "codigo_preco", referencedColumnName = "codigo")
    private Preco valorUnitario;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "codigo_produto", referencedColumnName = "codigo")
    private Produto produto;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "codigo_loja", referencedColumnName = "codigo")
    private Loja localDeVenda;
        
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "codigo_notafiscal", referencedColumnName = "codigo")
    private NotaFiscal notaFiscal;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
    
    public Preco getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Preco valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Loja getLocalDeVenda() {
        return localDeVenda;
    }

    public void setLocalDeVenda(Loja localDeVenda) {
        this.localDeVenda = localDeVenda;
    }
    
    public NotaFiscal getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(NotaFiscal notaFiscal) {
        this.notaFiscal = notaFiscal;
    }
    
    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Item)) { return false; }
        Item other = (Item) object;
        return !((this.codigo == null && other.codigo != null) ||
                  (this.codigo != null && !this.codigo.equals(other.codigo)));
    }

    @Override
    public String toString() {
        return "com.mycompany.dscproject.model.Item[ id=" + codigo + " ]";
    }
}
