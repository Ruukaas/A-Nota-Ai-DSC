package com.mycompany.dscproject.tests;

import com.mycompany.dscproject.model.Loja;
import com.mycompany.dscproject.model.Produto;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LojaJPQL extends BaseTests {
    @Test
    public void lojasQueTemTelevisao() {
        logger.info("Executando lojasQueTemTelevisao()");
        
        Produto produto = em.find(Produto.class, Long.valueOf(2));
        TypedQuery<Loja> query = em.createQuery("SELECT l FROM Loja l WHERE :produto MEMBER OF l.produtos", Loja.class);
        query.setParameter("produto", produto);
        Loja loja = query.getSingleResult();
        
        assertEquals("Eletronic Arts", loja.getNome());
    }
    
    @Test
    public void quantidadeProdutosHyperFood() {
        logger.info("Executando quantidadeProdutosHyperFood()");
        
        TypedQuery<Object[]> query = em.createQuery("SELECT l.codigo, p.nome FROM Loja l JOIN l.produtos p WHERE l.nome = 'Hyper food'", Object[].class);
        List<Object[]> produtos = query.getResultList();
        
        assertEquals(2, produtos.size());
    }
    
    @Test
    public void ordenacaoLojaNome() {
        logger.info("Executando ordenacaoLojaNome()");
        
        TypedQuery<Object[]> query = em.createQuery("SELECT l.codigo, l.nome FROM Loja l ORDER BY l.nome ASC", Object[].class);
        List<Object[]> lojas = query.getResultList();
        
        assertEquals(4, lojas.size());
        assertEquals("Bar do Ceu", lojas.get(0)[1]);
        assertEquals("Eletronic Arts", lojas.get(1)[1]);
        assertEquals("Empresa de Ventiladores", lojas.get(2)[1]);
        assertEquals("Hyper food", lojas.get(3)[1]);
    }
    
    @Test
    public void quantidadeDeLojas() {
        logger.info("Executando quantidadeDeLojas()");
        
        TypedQuery<Long> query = em.createQuery("SELECT COUNT(l) FROM Loja l", Long.class);
        Long quantidadeDeLojas = query.getSingleResult();
        
        assertEquals(Long.valueOf(4), quantidadeDeLojas);
    }
    
    @Test
    public void lojasComMenosDe2Produtos() {
        Query query = em.createQuery("SELECT c, COUNT(i) from Loja c, Produto i WHERE i MEMBER OF c.produtos GROUP BY c HAVING COUNT(i) < 2");

        Object[] resultado = (Object []) query.getSingleResult();

        assertEquals("Bar do Ceu", ((Loja) resultado[0]).getNome());

    }
}
