package com.mycompany.dscproject.model;

import java.io.Serializable;
import java.util.ArrayList;
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
    private List<Preco> historicoDeValores = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
    private List<Item> itens = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "RELACAO_produto_loja", joinColumns = {
            @JoinColumn(name = "ID_Produto") }, inverseJoinColumns = {
                    @JoinColumn(name = "ID_Loja")
            })
    private List<Loja> lojas = new ArrayList<>();

    public List<Loja> getLojas() {
        return lojas;
    }

    public void setLojas(Loja lojas) {
        lojas.setProdutos(this);
        this.lojas.add(lojas);
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

    public void setItens(Item itens) {
        itens.setProduto(this);
        this.itens.add(itens);
    }
}
