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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;

/**
 *
 * @author euluc
 */
@Entity
public class Loja implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigo;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loja", fetch = FetchType.LAZY)
    private List<NotaFiscal> notasFiscais;

    @ManyToMany(mappedBy = "lojas")
    private List<Produto> produtos;
    
    @Column(name = "CNPJ", nullable = false)
    private String CNPJ;
    
    @Column(name = "endereco", nullable = false)
    private String endereco;
    
    @Column(name = "nome", nullable = false)
    private String nome;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
    
    public List<NotaFiscal> getNotasFiscais() {
        return notasFiscais;
    }
    
    public void adicionarNotaFiscal(NotaFiscal nf) {
        if (this.notasFiscais == null) {
            this.notasFiscais = new ArrayList<>();
        }
        
        this.notasFiscais.add(nf);
        nf.setLoja(this);
    }
    
    public boolean removerNotaFiscal(NotaFiscal nf) {
        return notasFiscais.remove(nf);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void adicionarProduto(Produto p) {
        if (produtos == null) { produtos = new ArrayList<>(); }
        
        produtos.add(p);
        p.adicionarLoja(this);
    }
    
    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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
        if (!(object instanceof Loja)) { return false; }
        Loja other = (Loja) object;
        return !((this.codigo == null && other.codigo != null) ||
                  (this.codigo != null && !this.codigo.equals(other.codigo)));
    }

    @Override
    public String toString() {
        return "com.mycompany.dscproject.model.Loja[ id=" + codigo + " ]";
    }
}
