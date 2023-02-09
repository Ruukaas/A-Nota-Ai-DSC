package com.mycompany.dscproject.tests;

import com.mycompany.dscproject.model.Item;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ItemJPQL extends BaseTests {
    @Test
    public void maximoEMinimoValor() {
        logger.info("Executando maximoEMinimoValor()");
        
        Query query = em.createQuery("SELECT MAX(c.valorUnitario.valor), MIN(c.valorUnitario.valor) FROM Item c"); //valorUnitario ou preco
        Object[] resultado = (Object[]) query.getSingleResult();
        
        Double maiorValor =  (Double) resultado[0];
        Double menorValor =  (Double) resultado[1];
        assertEquals(Double.valueOf(134.99), maiorValor);
        assertEquals(Double.valueOf(4.99), menorValor);
    }
    
    @Test
    public void itemJoinNotaFiscal() {
        TypedQuery<Item> query = em.createQuery("SELECT c FROM Item c JOIN FETCH c.notaFiscal", Item.class);

        List<Item> itens = query.getResultList();

        assertEquals(4, itens.size());

        for(Item i : itens) {
            assertNotNull(i.getNotaFiscal());
        }

    }
//
//    @Test
//    public void concatProdutoPreco () {
//        logger.info("Executando concatProdutoPreco");
//
//        Query query = em.createQuery("SELECT CONCAT(c.produto.nome,'', c.valorUnitario.valor) FROM Item c");
//
//        Object[] resultado = (Object[]) query.getSingleResult();
//
//
//        assertEquals(4, resultado.length);
//       assertEquals("Barra de chocolate34.99",(String)resultado[0]);
//        assertEquals("Televisão 34 polegadas134.99",resultado[1]);
//        assertEquals("Trident4.99",resultado[2]);
//       assertEquals("Barra de chocolate34.99",(String)resultado[3]);
//
//    }
	
	    @Test
    public void itensComMaisDeUmaQtde() {
        TypedQuery<Item> query = em.createQuery("SELECT c FROM Item c WHERE c.quantidade > 1", Item.class);

        List<Item> itens = query.getResultList();

        assertEquals(3,itens.size());
    }

    
    
}
