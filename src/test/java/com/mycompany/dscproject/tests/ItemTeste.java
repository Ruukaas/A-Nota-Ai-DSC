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
        logger.info("Executando persistirItem()");
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
        logger.info("Executando consultarItem()");
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
        logger.info("Executando atualizarItem");
        
        Integer novaQuantidade = Integer.valueOf(15);
        
        TypedQuery<Item> query = em.createNamedQuery("Item.porQuantidade", Item.class);
        query.setParameter("qtde", Integer.valueOf(1));
        Item item = query.getSingleResult();
        assertNotNull(item);
        item.setQuantidade(novaQuantidade);
        em.flush();
        assertEquals(0, query.getResultList().size());
        query.setParameter("qtde", novaQuantidade);
        item = query.getSingleResult();
        assertNotNull(item);
    }

    @Test
    public void atualizarItemMerge() {
        logger.info("Executando atualizarItemMerge()");
        
        Integer novaQuantidade = Integer.valueOf(25);
        
        TypedQuery<Item> query = em.createNamedQuery("Item.porQuantidade", Item.class);
        query.setParameter("qtde", Integer.valueOf(5));
        Item item = query.getSingleResult();
        assertNotNull(item);
        item.setQuantidade(novaQuantidade);
        em.clear();
        em.merge(item);
        em.flush();
        assertEquals(0, query.getResultList().size());
    }

    @Test
    public void removerItem() {
        logger.info("Executando removerItem()");
        
        TypedQuery<Item> query = em.createNamedQuery("Item.porQuantidade", Item.class);
        query.setParameter("qtde", Integer.valueOf(10));
        Item item = query.getSingleResult();
        assertNotNull(item);
        em.remove(item);
        em.flush();
        assertEquals(0, query.getResultList().size());
    }
}
