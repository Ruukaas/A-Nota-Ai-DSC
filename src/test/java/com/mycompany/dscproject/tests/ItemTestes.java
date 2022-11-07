/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dscproject.tests;

import com.mycompany.dscproject.dao.ManagerDao;
import com.mycompany.dscproject.model.Item;
import com.mycompany.dscproject.model.Loja;
import com.mycompany.dscproject.model.NotaFiscal;
import com.mycompany.dscproject.model.Preco;
import com.mycompany.dscproject.model.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author Inspiron 15 5566
 */
public class ItemTestes {
       @Test
    public void ItemWriteTest() {
        Item item = new Item();
        NotaFiscal nota = new NotaFiscal();
        Loja loja = new Loja();
        Preco preco = new Preco();
        Produto produto = new Produto();
        
        produto.setNome("picole");
        loja.setNome("LojaDeRecife");
        preco.setValor(10);
        
        item.setValorUnitario(preco);
        item.setNotaFiscal(nota);
        item.setQuantidade(3);
        item.setProduto(produto);
        item.setLocalDeVenda(loja);
    
        ManagerDao.getCurrentInstance().insert(item); 
    
    };    
    
    @Test
    public void NotaFiscalReadTest(){
        EntityManagerFactory emf = null;
        emf = Persistence.createEntityManagerFactory("persistence");
        EntityManager em = emf.createEntityManager();
        Item item = em.find(Item.class, 1); 
        
        assertNotNull(item.getCodigo());
        assertEquals("", item.getLocalDeVenda());
        assertEquals(10, item.getValorUnitario());
        assertEquals(3, item.getQuantidade());

    };
}
