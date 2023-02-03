package com.mycompany.dscproject.tests;

import com.mycompany.dscproject.model.Preco;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.text.DecimalFormat;
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
    
    @Test
    public void menorPrecoRegistrado() {
        logger.info("Executando menorPrecoRegistrado()");
        
        Query query = em.createQuery("SELECT MIN(p.valor) FROM Preco p");
        Double menorValor =(Double) query.getSingleResult();
        
        assertEquals(Double.valueOf(4.99), menorValor);
    }
    
    @Test
    public void maiorPrecoRegistrado() {
        logger.info("Executando maiorPrecoRegistrado()");
        
        Query query = em.createQuery("SELECT MAX(p.valor) FROM Preco p");
        Double maiorValor =(Double) query.getSingleResult();
        
        assertEquals(Double.valueOf(134.99), maiorValor);
    }
    
    @Test
    public void mediaPrecosRegistrados() {
        logger.info("Executando mediaPrecosRegistrado()");
        
        Query query = em.createQuery("SELECT AVG(p.valor) FROM Preco p");
        double mediaPreco =(double) query.getSingleResult();
        
        DecimalFormat df = new DecimalFormat("#.##");       
        assertEquals(df.format(55.19), df.format(mediaPreco));
    }
    
    @Test
    public void quantidadeDePrecosRegistrados() {
        logger.info("Executando quantidadeDePrecosRegistrados()");
        
        Query query = em.createQuery("SELECT COUNT(p) FROM Preco p");
        Long quantidadePrecosRegistrados =(Long) query.getSingleResult();
        
        assertEquals(Long.valueOf(5), quantidadePrecosRegistrados);
    }
}
