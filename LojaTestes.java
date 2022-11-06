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
import com.mycompany.dscproject.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author Inspiron 15 5566
 */
public class LojaTestes {

 
    @Test
    public void lojaWriteTest() {
        Loja loja = new Loja();
        List<NotaFiscal> nota = new ArrayList<NotaFiscal>();
        List<Produto> produtos = new ArrayList<Produto>();
        List<Item> items = new ArrayList<Item>();
       
        Produto sorvete = null;
        produtos.add(sorvete);
        Produto tequila = null;
        produtos.add(tequila);
        
        loja.setCNPJ("66548654946-4");
        loja.setEndereço("Em algum lugar no Recife");
        loja.setItens(items);
        loja.setNome("Emon");
        loja.setProdutos(produtos);
        loja.setNotasFiscais(nota);
                
        ManagerDao.getCurrentInstance().insert(loja); 
    }
    
    @Test
    public void lojaReadTest() {
        EntityManagerFactory emf = null;
        emf = Persistence.createEntityManagerFactory("persistence");
        EntityManager em = emf.createEntityManager();
        Loja loja = em.find(Loja.class, 1);
        
        assertNotNull(loja);
        assertNotNull(loja.getItens());
        assertEquals("66548654946-4", loja.getCNPJ());
        assertEquals("Emon", loja.getNome());
    }
}


