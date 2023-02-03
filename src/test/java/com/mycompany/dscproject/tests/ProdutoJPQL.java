package com.mycompany.dscproject.tests;

import com.mycompany.dscproject.model.Produto;
import jakarta.persistence.TypedQuery;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.mycompany.dscproject.model.Preco;

public class ProdutoJPQL extends BaseTests{
    @Test
    public void ordenacaoProduto() {
        logger.info("Executando ordenacaoProduto()");
        
        TypedQuery<Produto> query = em.createQuery("SELECT p FROM Produto p ORDER BY p.nome DESC", Produto.class);
        List<Produto> produtos = query.getResultList();
        
        assertEquals(5, produtos.size());
        assertEquals("Trident", produtos.get(0).getNome());
        assertEquals("Televisão 34 polegadas", produtos.get(1).getNome());
        assertEquals("Printed Circuit Board Gigabyte", produtos.get(2).getNome());
        assertEquals("Garrafa Folgosa", produtos.get(3).getNome());
        assertEquals("Barra de chocolate", produtos.get(4).getNome());
    }
    
    @Test
    public void historicoDePrecosDeTrident() {
        logger.info("Executando historicoDePrecosDeTrident()");
        
        TypedQuery<Preco> query = em.createQuery("SELECT pp FROM Produto p JOIN p.historicoDeValores pp WHERE p.codigo = 3", Preco.class);
        List<Preco> precosTrident = query.getResultList();
        
        assertEquals(2, precosTrident.size());
        assertEquals(Double.valueOf(4.99), precosTrident.get(0).getValor());
        assertEquals(Double.valueOf(5.99), precosTrident.get(1).getValor());
    }
}
