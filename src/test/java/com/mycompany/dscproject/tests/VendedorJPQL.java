package com.mycompany.dscproject.tests;

import com.mycompany.dscproject.model.Vendedor;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class VendedorJPQL extends BaseTests {
    @Test
    public void quantidadeVendedorComTelefone() {
        logger.info("Executando quantidadeVendedorComTelefone()");
        
        TypedQuery<Long> query = em.createQuery("SELECT COUNT(c) FROM Vendedor c WHERE c.telefone IS NOT NULL", Long.class);
        Long resultado = query.getSingleResult();
        
        assertEquals(Long.valueOf(3), resultado);
    }
    
    @Test
    public void nomeEEmailVendedores() {
        TypedQuery<Object []> query = em.createQuery("SELECT c.nome, c.email FROM Vendedor c ORDER BY c.nome ASC", Object[].class);

        List<Object[]> resultado = query.getResultList();
        assertEquals(3, resultado.size());
        assertEquals("Marcelo Carlos:marcelo.carlos.ramos@outlook.com",resultado.get(0)[0] + ":" + resultado.get(0)[1]);
        assertEquals("Pedro Ricardo:pRickGS@gmail.com",resultado.get(1)[0] + ":" + resultado.get(1)[1]);
        assertEquals("Tomás Francisco:tomas.francisco.moreira@yahoo.com",resultado.get(2)[0] + ":" + resultado.get(2)[1]);
        
    }
    
    @Test
    public void vendedoresComNotaFiscal() {
        Query query = em.createQuery("SELECT c FROM Vendedor c WHERE c.compras IS NOT EMPTY");
        List <Vendedor> resultado = query.getResultList();
        
        assertEquals(0, resultado.size());
    }
    
    @Test
    public void concatCNPJELogin() {
        TypedQuery<String> query =  em.createQuery("SELECT CONCAT(c.CNPJ, ' ', c.login) FROM Vendedor c", String.class);
        List<String> resultado = query.getResultList();
        
        assertEquals(3, resultado.size());
        assertEquals("32.227.328/0001-31 pedroRic147", resultado.get(0));
        assertEquals("08.232.732/0001-19 marcelo_carlos", resultado.get(1));
        assertEquals("53.976.015/0001-56 tomas_cerveja", resultado.get(2));
    }

}
