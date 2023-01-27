package com.mycompany.dscproject.tests;

import com.mycompany.dscproject.model.Cliente;
import jakarta.persistence.TypedQuery;
import org.junit.Test;
import static org.junit.Assert.*;

public class ClienteTeste extends BaseTests {
    @Test
    public void persistirCliente() {
        logger.info("Executando persistirCliente()");
        Cliente cliente = new Cliente();
        
        cliente.setNome("Maria Alice");
        cliente.setLogin("marialice");
        cliente.setSobrenome("Sales");
        cliente.setEmail("marialice@gmail.com");
        cliente.setSenha("maria123alice");
        cliente.setTelefone("(81) 78972-4528");
        cliente.setCpf("726.739.260-11");
        
        em.persist(cliente);
        em.flush();
        
        assertNotNull(cliente.getCodigo());
    }
    
    @Test
    public void consultarCliente() {
        logger.info("Executando consultarCliente()");
        Cliente cliente = em.find(Cliente.class, 1L);
        
        assertNotNull(cliente);
        assertEquals("José Luiz", cliente.getNome());
        assertEquals("luizjose123", cliente.getLogin());
        assertEquals("Silva Filho", cliente.getSobrenome());
        assertEquals("joseluiz@gmail.com", cliente.getEmail());
        assertEquals("123456789joseluiz", cliente.getSenha());
        assertEquals("40028922", cliente.getTelefone());
        assertEquals("169.853.330-60", cliente.getCpf());
    }

    @Test
    public void atualizarCliente() {
        logger.info("Executando atualizarCliente()");
        TypedQuery<Cliente> query = em.createNamedQuery("Cliente.porCPF", Cliente.class);
        query.setParameter("cpf", "840.136.830-83");
        Cliente cliente = query.getSingleResult();
        assertNotNull(cliente);
        cliente.setCpf("555.444.333-22");
        em.flush();
        assertEquals(0, query.getResultList().size());
        query.setParameter("cpf", "555.444.333-22");
        cliente = query.getSingleResult();
        assertNotNull(cliente);
    }

    @Test
    public void atualizarClienteMerge() { 
        logger.info("Executando atualizarClienteMerge()");
        TypedQuery<Cliente> query = em.createNamedQuery("Cliente.porCPF", Cliente.class);
        query.setParameter("cpf", "912.055.613-90");
        Cliente cliente = query.getSingleResult();
        assertNotNull(cliente);
        cliente.setCpf("312.142.156-37");
        em.clear();       
        em.merge(cliente);
        em.flush();
        assertEquals(0, query.getResultList().size());
    }

    @Test
    public void removerCliente() {
        logger.info("Executando removerCliente()");
        TypedQuery<Cliente> query = em.createNamedQuery("Cliente.porCPF", Cliente.class);
        query.setParameter("cpf", "726.739.260-11");
        Cliente cliente = query.getSingleResult();
        assertNotNull(cliente);
        em.remove(cliente);
        em.flush();
        assertEquals(0, query.getResultList().size());
    }
}
