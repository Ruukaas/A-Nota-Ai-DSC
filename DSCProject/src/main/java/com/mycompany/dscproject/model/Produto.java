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
public class Produto implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int codigo;
    private String nome;
    
    @OneToMany(mappedBy = "produto")
    private List<Preço> historicoDeValores;
    
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "produto")
    private List<Item> itens;


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

    public List<Preço> getHistoricoDeValores() {
        return historicoDeValores;
    }

    public void setHistoricoDeValores(List<Preço> historicoDeValores) {
        this.historicoDeValores = historicoDeValores;
    }
    
    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
}
