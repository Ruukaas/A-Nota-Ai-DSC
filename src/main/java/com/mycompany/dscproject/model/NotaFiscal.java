package com.mycompany.dscproject.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

/**
 *
 * @author euluc
 */
@Entity
public class NotaFiscal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int codigo;

    @ManyToOne(cascade = CascadeType.ALL)
    private Usuario donoDaNota;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = true)
    private Loja loja;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "notaFiscal", fetch = FetchType.EAGER)
    private List<Item> itens = new ArrayList<>();
    private String chaveDeAcesso;

    private LocalDateTime dataEmissao;

    private double valor;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Usuario getDonoDaNota() {
        return donoDaNota;
    }

    public void setDonoDaNota(Usuario donoDaNota) {
        this.donoDaNota = donoDaNota;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(Item itens) {
        itens.setNotaFiscal(this);
        this.itens.add(itens);
    }

    public String getChaveDeAcesso() {
        return chaveDeAcesso;
    }

    public void setChaveDeAcesso(String chaveDeAcesso) {
        this.chaveDeAcesso = chaveDeAcesso;
    }

    public LocalDateTime getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDateTime dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
