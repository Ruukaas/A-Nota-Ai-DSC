package com.mycompany.dscproject.tests;

import com.mycompany.dscproject.model.Item;
import com.mycompany.dscproject.model.Loja;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.hamcrest.CoreMatchers;
import static org.hamcrest.CoreMatchers.startsWith;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class itemJPQL extends BaseTests {
    @Test
    public void maximoEMinimoValor() {
        Query query = em.createQuery(
                "SELECT MAX(c.valorUnitario.valor), MIN(c.valorUnitario.valor) FROM Item c"); //valorUnitario ou preco
        Object[] resultado = (Object[]) query.getSingleResult();
        
        Double maiorValor =  (Double) resultado[0];
        Double menorValor =  (Double) resultado[1];
        assertEquals(Double.valueOf(134.99), maiorValor);
        assertEquals(Double.valueOf(4.99), menorValor);
    }
}
