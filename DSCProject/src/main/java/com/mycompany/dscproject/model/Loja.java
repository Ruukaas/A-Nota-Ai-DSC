/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dscproject.model;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="loja")
    private List<NotaFiscal> notasFiscais;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="localDeVenda")
    private List<Item> itens;

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

    public void setNotasFiscais(List<NotaFiscal> notasFiscais) {
        this.notasFiscais = notasFiscais;
    }

}
