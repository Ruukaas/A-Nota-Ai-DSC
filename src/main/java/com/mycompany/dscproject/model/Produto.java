package com.mycompany.dscproject.model;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;

/**
 *
 * @author euluc
 */
@Entity
public class Produto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
    private List<Preco> historicoDeValores;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
    private List<Item> itens;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "TB_PRODUTOS_LOJAS", 
        joinColumns = {
            @JoinColumn(name = "ID_Produto")
        },
        inverseJoinColumns = {
            @JoinColumn(name = "ID_Loja")
        }
    )
    private List<Loja> lojas;
    
    @Column(name = "nome", nullable = false)
    private String nome;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
    
    public List<Preco> getHistoricoDeValores() {
        return historicoDeValores;
    }
    
    public void adicionarPreco(Preco p) {
       if (historicoDeValores == null) { historicoDeValores = new ArrayList<>(); }
       
       historicoDeValores.add(p);
       p.setProduto(this);
    }
    
    public boolean removerPreco(Preco p) {
       return historicoDeValores.remove(p);
    }
    
    public List<Item> getItens() {
        return itens;
    }
    
    public void adicionarItem(Item i) {
        if (itens == null) { itens = new ArrayList<>(); }
        
        itens.add(i);
        i.setProduto(this);
    }
    
    public boolean removerItem(Item i) {
        return itens.remove(i);
    }
    
    public List<Loja> getLojas() {
        return lojas;
    }
    
    public void adicionarLoja(Loja l) {
        if (lojas == null) { lojas = new ArrayList<>(); }
        
        lojas.add(l);
        l.adicionarProduto(this);
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Produto)) { return false; }
        Produto other = (Produto) object;
        return !((this.codigo == null && other.codigo != null) || 
                  (this.codigo != null && !this.codigo.equals(other.codigo)));
    }
    
    @Override
    public String toString() {
        return "com.mycompany.dscproject.model.Produto[ id=" + codigo + " ]";
    }
}
