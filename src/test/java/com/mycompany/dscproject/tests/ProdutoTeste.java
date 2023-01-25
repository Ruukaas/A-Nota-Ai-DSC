package com.mycompany.dscproject.tests;

import com.mycompany.dscproject.model.Item;
import com.mycompany.dscproject.model.Loja;
import com.mycompany.dscproject.model.Preco;
import com.mycompany.dscproject.model.Produto;

import jakarta.persistence.TypedQuery;

import java.util.Calendar;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProdutoTeste extends BaseTests {
    @Test
    public void persistirProduto() {
        Produto produto = new Produto();
        
        produto.setNome("Cadeira Gamer");
        
        Preco p1 = new Preco();
        p1.setValor(Double.valueOf(235.45));
        Calendar c1 = Calendar.getInstance();
        c1.set(2022, Calendar.OCTOBER, 25, 10, 0, 0);
        p1.setDataDeRegistro(c1.getTime());
        
        Preco p2 = new Preco();
        p2.setValor(Double.valueOf(315.55));
        Calendar c2 = Calendar.getInstance();
        c2.set(2022, Calendar.OCTOBER, 26, 11, 0, 0);
        p2.setDataDeRegistro(c2.getTime());
        
        produto.adicionarPreco(p1);
        produto.adicionarPreco(p2);
        
        Item i1 = new Item();
        i1.setQuantidade(Integer.valueOf(1));
        
        Item i2 = new Item();
        i2.setQuantidade(Integer.valueOf(1));
        
        produto.adicionarItem(i1);
        produto.adicionarItem(i2);
        
        Loja loja = new Loja();
        loja.setCNPJ("37.686.628/0001-00");
        loja.setEndereco("1ª Travessa Pedro de Souza Lopes");
        loja.setNome("Mundo Gamer");
        
        produto.adicionarLoja(loja);
        
        em.persist(produto);
        em.flush();
        
        assertNotNull(produto.getCodigo());
    }
    
    @Test
    public void consultarProduto() {
        Produto produto = em.find(Produto.class, 1L);
        
        assertNotNull(produto);
        assertEquals("Barra de chocolate", produto.getNome());
    }


    @Test
    public void atualizarProduto() {
        TypedQuery<Produto> query = em.createNamedQuery("Produto.byNome", Produto.class);
        query.setParameter("nome", "Barra de chocolate");
        Produto produto = query.getSingleResult();
        assertNotNull(produto);
        produto.setNome("Chocolate em barra");
        em.flush();
        assertEquals(0, query.getResultList().size());
        query.setParameter("nome", "Chocolate em barra");
        produto = query.getSingleResult();
        assertNotNull(produto);
    }

    @Test
    public void atualizarProdutoMerge() {
        TypedQuery<Produto> query = em.createNamedQuery("Produto.byNome", Produto.class);
        query.setParameter("nome", "Televisão 34");
        Produto produto = query.getSingleResult();
        assertNotNull(produto);
        produto.setNome("Televisão LCD 34 Polegadas");
        em.clear();       
        em.merge(produto);
        em.flush();
        assertEquals(0, query.getResultList().size());
    }

    @Test
    public void removerProduto() {
        TypedQuery<Produto> query = em.createNamedQuery("Produto.byNome", Produto.class);
        query.setParameter("nome", "Televisão 34");
        Produto produto = query.getSingleResult();
        assertNotNull(produto);
        em.remove(produto);
        em.flush();
        assertEquals(0, query.getResultList().size());
    }
}
