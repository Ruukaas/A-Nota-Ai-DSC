package com.mycompany.dscproject.tests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.mycompany.dscproject.model.Cliente;

import jakarta.persistence.TypedQuery;

public class jpql_Cliente extends BaseTests {
    @Test
    public void clientePorCPF() {
        TypedQuery<Cliente> query = em.createQuery(
                "SELECT c FROM cliente c WHERE c.cpf LIKE :cpf",
                Cliente.class);
        query.setParameter("cpf", "169.853.330-60");
        List<Cliente> clientes = query.getResultList();

        assertEquals(1, clientes.size());
    }

    @Test
    public void clientePorCPFNamedQuery() {
        TypedQuery<Cliente> query = em.createNamedQuery("cliente.cpf", Cliente.class);
        query.setParameter("cpf", "840.136.830-83");
        List<Cliente> clientes = query.getResultList();

        assertEquals(1, clientes.size());
    }
}