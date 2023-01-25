package com.mycompany.dscproject.tests;

import com.mycompany.dscproject.model.Cliente;

import jakarta.persistence.TypedQuery;

import org.junit.Test;
import static org.junit.Assert.*;

public class ClienteTeste extends BaseTests {
    @Test
    public void persistirCliente() {
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
        
        TypedQuery<Cliente> query = em.createNamedQuery("Cliente.byCPF", Cliente.class);
        query.setParameter("cpf", "169.853.330-60");
        Cliente cliente = query.getSingleResult();
        assertNotNull(cliente);
        cliente.setCpf("555.444.333-22");
        em.flush();
        assertEquals(0, query.getResultList().size());
        query.setParameter("nome", "555.444.333-22");
        cliente = query.getSingleResult();
        assertNotNull(cliente);
    }

    @Test
    public void atualizarClienteMerge() {
        
        TypedQuery<Cliente> query = em.createNamedQuery("Cliente.byCPF", Cliente.class);
        query.setParameter("cpf", "840.136.830-83");
        Cliente cliente = query.getSingleResult();
        assertNotNull(cliente);
        cliente.setCpf("999.888.777-66");
        em.clear();       
        em.merge(cliente);
        em.flush();
        assertEquals(0, query.getResultList().size());
    }

    @Test
    public void removerCliente() {
        
        TypedQuery<Cliente> query = em.createNamedQuery("Cliente.byCPF", Cliente.class);
        query.setParameter("cpf", "840.136.830-83");
        Cliente cliente = query.getSingleResult();
        assertNotNull(cliente);
        em.remove(cliente);
        em.flush();
        assertEquals(0, query.getResultList().size());
    }

}
