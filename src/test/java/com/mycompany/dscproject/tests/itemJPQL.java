package com.mycompany.dscproject.tests;

import jakarta.persistence.Query;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

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
}
