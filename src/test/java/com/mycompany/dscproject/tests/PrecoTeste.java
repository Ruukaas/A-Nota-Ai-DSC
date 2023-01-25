package com.mycompany.dscproject.tests;

import com.mycompany.dscproject.model.Item;
import com.mycompany.dscproject.model.Preco;
import com.mycompany.dscproject.model.Produto;

import jakarta.persistence.TypedQuery;

import java.util.Calendar;
import org.junit.Test;
import static org.junit.Assert.*;

public class PrecoTeste extends BaseTests
{
    @Test
    public void persistirPreco() {
        Preco preco = new Preco();
        
        preco.setValor(Double.valueOf(12.00));
        Calendar c = Calendar.getInstance();
        c.set(2022, Calendar.OCTOBER, 29, 15, 35, 0);
        preco.setDataDeRegistro(c.getTime());
        
        Produto produto = em.find(Produto.class, 1L);
        produto.adicionarPreco(preco);
        
        em.persist(preco);
        em.flush();
        
        assertNotNull(preco.getCodigo());
    }
    
    @Test
    public void consultarPreco() {
        Preco preco = em.find(Preco.class, 1L);
        
        assertNotNull(preco);
        assertEquals(1, (long)preco.getProduto().getCodigo());
        assertEquals(Double.valueOf(34.99), preco.getValor());
        Calendar c = Calendar.getInstance();
        c.set(2022, Calendar.NOVEMBER, 3, 10, 0, 0);
        assertEquals(c.getTime().toString(), preco.getDataDeRegistro().toString());
    }

    @Test
    public void atualizarPreco() {
        TypedQuery<Preco> query = em.createNamedQuery("Preco.byValor", Preco.class);
        query.setParameter("valor", 34.99);
        Preco preco = query.getSingleResult();
        assertNotNull(preco);
        preco.setValor(188.88);
        em.flush();
        assertEquals(0, query.getResultList().size());
        query.setParameter("valor", 188.88);
        preco = query.getSingleResult();
        assertNotNull(preco);
    }

    @Test
    public void atualizarPrecoMerge() {
        TypedQuery<Preco> query = em.createNamedQuery("Preco.byValor", Preco.class);
        query.setParameter("valor", 4.99);
        Preco preco = query.getSingleResult();
        assertNotNull(preco);
        preco.setValor(28.55);
        em.clear();       
        em.merge(preco);
        em.flush();
        assertEquals(0, query.getResultList().size());
    }

    @Test
    public void removerPreco() {
        TypedQuery<Preco> query = em.createNamedQuery("Preco.byValor", Preco.class);
        query.setParameter("valor", 4.99);
        Preco preco = query.getSingleResult();
        assertNotNull(preco);
        em.remove(preco);
        em.flush();
        assertEquals(0, query.getResultList().size());
    }
}
