package com.mycompany.dscproject.tests;

import com.mycompany.dscproject.model.Preco;
import jakarta.persistence.TypedQuery;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PrecoJPQL extends BaseTests {
    @Test
    public void precosMaioresQue30() {
        logger.info("Executando precosMaioresQue30()");
        
        TypedQuery<Preco> query = em.createQuery("SELECT c FROM Preco c WHERE c.valor > ?1", Preco.class);
        query.setParameter(1, Integer.valueOf(30));
        List<Preco> precos = query.getResultList();
        
        assertEquals(3, precos.size());
    }
}
