/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dscproject.tests;

import com.mycompany.dscproject.dao.ManagerDao;
import com.mycompany.dscproject.model.Item;
import com.mycompany.dscproject.model.Loja;
import com.mycompany.dscproject.model.NotaFiscal;
import com.mycompany.dscproject.model.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class LojaTestes {

 
    @Test
    public void lojaWriteTest() {
        Loja loja = new Loja();
        List<NotaFiscal> nota = new ArrayList<>();
        List<Produto> produtos = new ArrayList<>();
        List<Item> items = new ArrayList<>();
       
        Produto sorvete = null;
        produtos.add(sorvete);
        Produto tequila = null;
        produtos.add(tequila);
        
        loja.setCNPJ("66548654946-4");
        loja.setEndereço("Em algum lugar no Recife");
        loja.setNome("Emon");
        
        produtos.forEach(produto -> {
            loja.setProdutos(produto);
        });
        // loja.setProdutos(produtos);

        nota.forEach(n -> {
            loja.setNotasFiscais(n);
        });
        // loja.setNotasFiscais(nota);
                
        ManagerDao.getCurrentInstance().insert(loja); 
    }
    
    @Test
    public void lojaReadTest() {
        EntityManagerFactory emf = null;
        emf = Persistence.createEntityManagerFactory("persistence");
        EntityManager em = emf.createEntityManager();
        Loja loja = em.find(Loja.class, 1);
        
        assertNotNull(loja);
        assertEquals("66548654946-4", loja.getCNPJ());
        assertEquals("Emon", loja.getNome());
    }
}


