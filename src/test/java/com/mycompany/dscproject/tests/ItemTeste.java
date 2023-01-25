package com.mycompany.dscproject.tests;

import com.mycompany.dscproject.model.Item;
import com.mycompany.dscproject.model.Loja;
import com.mycompany.dscproject.model.Preco;
import com.mycompany.dscproject.model.Produto;

import jakarta.persistence.TypedQuery;

import com.mycompany.dscproject.model.NotaFiscal;
import java.util.Calendar;
import org.junit.Test;
import static org.junit.Assert.*;

public class ItemTeste extends BaseTests {
    @Test
    public void persistirItem() {
        Item item = new Item();
        
        Preco preco = new Preco();
        preco.setValor(Double.valueOf(200.00));
        Calendar c = Calendar.getInstance();
        c.set(2022, c.OCTOBER, 25, 13, 0, 0);
        preco.setDataDeRegistro(c.getTime());
        item.setValorUnitario(preco);
        
        Produto produto = new Produto();
        produto.setNome("Suporte para notebook");
        item.setProduto(produto);
        
        Loja loja = new Loja();
        loja.setCNPJ("29.501.812/0001-00");
        loja.setEndereco("Rua dos comerciantes");
        loja.setNome("Nagem Informática");
        item.setLocalDeVenda(loja);
        
        NotaFiscal notaFiscal = new NotaFiscal();
        notaFiscal.setChaveDeAcesso("Chave#1");
        Calendar cn = Calendar.getInstance();
        cn.set(2022, cn.NOVEMBER, 5, 10, 0, 0);
        notaFiscal.setDataEmissao(cn.getTime());
        notaFiscal.setValor(Double.valueOf(450.00));
        item.setNotaFiscal(notaFiscal);
        
        item.setQuantidade(Integer.valueOf(1));
        
        em.persist(item);
        em.flush();
        
        assertNotNull(item.getCodigo());
    }
    
    @Test
    public void consultarItem() {
        Item item = em.find(Item.class, 1L);
        
        assertNotNull(item);
        assertEquals((long)1, (long)item.getValorUnitario().getCodigo());
        assertEquals((long)1, (long)item.getProduto().getCodigo());
        assertEquals((long)1, (long)item.getLocalDeVenda().getCodigo());
        assertEquals((long)1, (long)item.getNotaFiscal().getCodigo());
        assertEquals((long)3, (long)item.getQuantidade());
    }

    @Test
    public void atualizarItem() {
        TypedQuery<Item> query = em.createNamedQuery("Item.byQtde", Item.class);
        query.setParameter("qtde","3");
        Item item = query.getSingleResult();
        assertNotNull(item);
        item.setQuantidade(25);
        em.flush();
        assertEquals(0, query.getResultList().size());
        query.setParameter("qtde", 25);
        item = query.getSingleResult();
        assertNotNull(item);
    }

    @Test
    public void atualizarItemMerge() {
        TypedQuery<Item> query = em.createNamedQuery("Item.byQtde", Item.class);
        query.setParameter("qtde","5");
        Item item = query.getSingleResult();
        assertNotNull(item);
        item.setQuantidade(99);
        em.clear();
        em.merge(item);
        em.flush();
        assertEquals(0, query.getResultList().size());
        // query.setParameter("qtde", 99);
        // item = query.getSingleResult();
        // assertNotNull(item);
    }

    @Test
    public void removerItem() {
        TypedQuery<Item> query = em.createNamedQuery("Item.byQtde", Item.class);
        query.setParameter("qtde","5");
        Item item = query.getSingleResult();
        assertNotNull(item);
        em.remove(item);
        em.flush();
        assertEquals(0, query.getResultList().size());
    }
}
