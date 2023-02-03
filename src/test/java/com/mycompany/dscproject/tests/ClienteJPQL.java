package com.mycompany.dscproject.tests;

import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import com.mycompany.dscproject.model.Cliente;

public class ClienteJPQL extends BaseTests {
    @Test
    public void quantidadeDeClientes() {
        logger.info("Executando quantidadeDeClientes()");
        
        Query query = em.createQuery("SELECT COUNT(c) FROM Cliente c");
        Long qtdClientes =(Long) query.getSingleResult();
        
        assertEquals(Long.valueOf(3), qtdClientes);
    }
    
    @Test
    public void clientePorNome() {
        logger.info("Executando clientePorNome()");
        
        Query query = em.createQuery("SELECT c FROM Cliente c WHERE c.nome = :nome");
        query.setParameter("nome", "Laura Nunes");
        Cliente clienteConsultado =(Cliente) query.getSingleResult();
        
        assertEquals("Laura Nunes", clienteConsultado.getNome());
    }
    
    @Test
    public void nomeCompletoDeClientes() {
        logger.info("Executando nomeCompletoDeClientes()");
        
        Query query = em.createQuery("SELECT CONCAT(c.nome, ' ', c.sobrenome) FROM Cliente c");
        List<String> clientesNomes = query.getResultList();
        
        assertEquals(3, clientesNomes.size());
        assertEquals("José Luiz Silva Filho", clientesNomes.get(0));
        assertEquals("Laura Nunes Nascimento", clientesNomes.get(1));
        assertEquals("Fernanda Gonçalves Alves", clientesNomes.get(2));
    }
    
    @Test
    public void comprimentosDeNomesDeUsuarios() {
        logger.info("Executando comprimentosDeNomesDeUsuarios()");
        
        Query query = em.createQuery("SELECT LENGTH(CONCAT(c.nome, ' ', c.sobrenome)) FROM Cliente c");
        List<Integer> clientesComprimentos = query.getResultList();
        
        assertEquals(3, clientesComprimentos.size());
        assertEquals("21 Caracteres", clientesComprimentos.get(0) + " Caracteres");
        assertEquals("22 Caracteres", clientesComprimentos.get(1) + " Caracteres");
        assertEquals("24 Caracteres", clientesComprimentos.get(2) + " Caracteres");
    }
};
