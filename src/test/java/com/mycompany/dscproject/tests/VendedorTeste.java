package com.mycompany.dscproject.tests;

import com.mycompany.dscproject.model.Vendedor;
import org.junit.Test;
import static org.junit.Assert.*;

public class VendedorTeste extends BaseTests {
    @Test
    public void persistirVendedor() {
        Vendedor vendedor = new Vendedor();
        
        vendedor.setNome("Aline Mirella");
        vendedor.setLogin("aliporto");
        vendedor.setSobrenome("Porto");
        vendedor.setEmail("mirellaaline12@outlook.com");
        vendedor.setSenha("mirellaaline21");
        vendedor.setTelefone("(81) 98659-6168");
        
        em.persist(vendedor);
        em.flush();
        
        assertNotNull(vendedor.getCodigo());
    }
    
    @Test
    public void consultarVendedor() {
        Vendedor vendedor = em.find(Vendedor.class, 2L);
        
        assertNotNull(vendedor);
        assertEquals("Pedro Ricardo", vendedor.getNome());
        assertEquals("pedroRic147", vendedor.getLogin());
        assertEquals("Gomes Santos", vendedor.getSobrenome());
        assertEquals("pRickGS@gmail.com", vendedor.getEmail());
        assertEquals("SGRP159", vendedor.getSenha());
        assertEquals("34487898", vendedor.getTelefone());
        assertEquals("32.227.328/0001-31", vendedor.getCNPJ());
    }
}
