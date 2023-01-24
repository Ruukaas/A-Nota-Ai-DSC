package com.mycompany.dscproject.tests;

import com.mycompany.dscproject.model.Item;
import com.mycompany.dscproject.model.Preco;
import com.mycompany.dscproject.model.Produto;
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
}
