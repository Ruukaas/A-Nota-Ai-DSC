package com.mycompany.dscproject.model;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.CascadeType;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int codigo;
    private String nome;

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

    public List<Loja> getLojas() {
        return lojas;
    }
    
    public void adicionarLoja(Loja l) {
        if (lojas == null) { lojas = new ArrayList<>(); }
        
        lojas.add(l);
        l.adicionarProduto(this);
    }

    public void setLojas(List<Loja> lojas) {
        this.lojas = lojas;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Preco> getHistoricoDeValores() {
        return historicoDeValores;
    }

    public void setHistoricoDeValores(List<Preco> historicoDeValores) {
        this.historicoDeValores = historicoDeValores;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
}
