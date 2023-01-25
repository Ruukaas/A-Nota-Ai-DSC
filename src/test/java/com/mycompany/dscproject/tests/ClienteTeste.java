package com.mycompany.dscproject.tests;

import com.mycompany.dscproject.model.Cliente;
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
}
