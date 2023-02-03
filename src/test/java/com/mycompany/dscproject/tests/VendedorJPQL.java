package com.mycompany.dscproject.tests;

import com.mycompany.dscproject.model.Vendedor;
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
}
