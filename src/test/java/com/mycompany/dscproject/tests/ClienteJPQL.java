package com.mycompany.dscproject.tests;

import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class ClienteJPQL extends BaseTests {
    /*@Test
    public void quantidadeUsuariosClientes() {
        logger.info("Executando quantidadeUsuariosClientes()");
        TypedQuery<Object[]> query;
        query = em.createQuery(
               "SELECT c.cpf, u.nome FROM Cliente c JOIN c.codigo_usuario u",
                Object[].class
            );
        
        List<Object[]> clientes = query.getResultList();
        assertEquals(3, clientes.size());
    }*/
};
