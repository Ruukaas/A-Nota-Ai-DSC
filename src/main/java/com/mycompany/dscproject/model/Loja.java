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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

/**
 *
 * @author euluc
 */
@Entity
public class Loja implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int Codigo;
    private String CNPJ;
    private String endereço;
    private String nome;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loja", fetch = FetchType.LAZY)
    private List<NotaFiscal> notasFiscais = new ArrayList<>();

    @ManyToMany(mappedBy = "lojas")
    private List<Produto> produtos = new ArrayList<>();

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Produto produtos) {
        produtos.setLojas(this);
        this.produtos.add(produtos);
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<NotaFiscal> getNotasFiscais() {
        return notasFiscais;
    }

    public void setNotasFiscais(NotaFiscal notasFiscais) {
        notasFiscais.setLoja(this);
        this.notasFiscais.add(notasFiscais);
    }
}
