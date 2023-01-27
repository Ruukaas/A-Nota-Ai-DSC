package com.mycompany.dscproject.tests;

import com.mycompany.dscproject.model.Cliente;
import com.mycompany.dscproject.model.NotaFiscal;

import jakarta.persistence.TypedQuery;

import com.mycompany.dscproject.model.Item;
import com.mycompany.dscproject.model.Loja;
import java.util.Calendar;
import org.junit.Test;
import static org.junit.Assert.*;

public class NotaFiscalTeste extends BaseTests {
    @Test
    public void persistirNotaFiscal() {
        logger.info("Executando persistirNotaFiscal()");
        NotaFiscal notaFiscal = new NotaFiscal();
        
        notaFiscal.setChaveDeAcesso("GPTXGPJ7RXU9T2JBX0LR");
        Calendar c = Calendar.getInstance();
        c.set(2022, Calendar.OCTOBER, 15, 11, 43, 54);
        notaFiscal.setDataEmissao(c.getTime());
        notaFiscal.setValor(Double.valueOf(115.25));
        
        Item i1 = new Item();
        i1.setQuantidade(Integer.valueOf(2));
        
        Item i2 = new Item();
        i2.setQuantidade(Integer.valueOf(1));
        
        notaFiscal.adicionarItem(i1);
        notaFiscal.adicionarItem(i2);
        
        Cliente cliente = new Cliente();
        cliente.setNome("Levi Gael");
        cliente.setSobrenome("Ramos");
        cliente.setEmail("levi_ramos@gmail.com");
        cliente.setLogin("leviramos");
        cliente.setSenha("senhamuitoforte");
        cliente.setTelefone("(81) 99325-4294");
        cliente.setCpf("464.610.150-51");
        
        notaFiscal.setDonoDaNota(cliente);
        
        Loja loja = new Loja();
        loja.setCNPJ("28.635.224/0001-99");
        loja.setEndereco("Rua Antônio Clementino dos Santos");
        loja.setNome("Mercadinho do povo");
        
        notaFiscal.setLoja(loja);
        
        em.persist(notaFiscal);
        em.flush();
        
        assertNotNull(notaFiscal.getCodigo());
    }
    
    @Test
    public void consultarNotaFiscal() {
        logger.info("Executando consultarNotaFiscal()");
        NotaFiscal notaFiscal = em.find(NotaFiscal.class, 1L);
        
        assertNotNull(notaFiscal);
        assertEquals((long)1, (long)notaFiscal.getDonoDaNota().getCodigo());
        assertEquals((long)1, (long)notaFiscal.getLoja().getCodigo());
        assertEquals("kaienhdaisdjkdfuyks8205", notaFiscal.getChaveDeAcesso());
    
        Calendar c = Calendar.getInstance();
        c.set(2022, Calendar.NOVEMBER, 13, 10, 0, 0);
        assertEquals(c.getTime().toString(), notaFiscal.getDataEmissao().toString());
        
        assertEquals(Double.valueOf(99.59), notaFiscal.getValor());
    }

    @Test
    public void atualizarNotaFiscal() {
        logger.info("Executando atualizarNotaFiscal()");

        Calendar c = Calendar.getInstance();
        c.set(2022, Calendar.JANUARY, 15, 11, 45, 0);
        
        TypedQuery<NotaFiscal> query = em.createNamedQuery("NotaFiscal.porChaveDeAcesso", NotaFiscal.class);
        query.setParameter("chaveDeAcesso", "duekloshekldhy20458sak");
        NotaFiscal notaFiscal = query.getSingleResult();
        assertNotNull(notaFiscal);
        
        notaFiscal.setChaveDeAcesso("06be7fa40ef1c818a299b2ab159b71f1");
        notaFiscal.setDataEmissao(c.getTime());
        notaFiscal.setValor(Double.valueOf(125.25));
        
        em.flush();
        assertEquals(0, query.getResultList().size());
        query.setParameter("chaveDeAcesso", "06be7fa40ef1c818a299b2ab159b71f1");
        notaFiscal = query.getSingleResult();
        assertNotNull(notaFiscal);
    }

    @Test
    public void atualizarNotaFiscalMerge() {
        logger.info("Executando atualizarNotaFiscalMerge()");

        Calendar c = Calendar.getInstance();
        c.set(2023, Calendar.JANUARY, 16, 13, 35, 25);
        
        TypedQuery<NotaFiscal> query = em.createNamedQuery("NotaFiscal.porChaveDeAcesso", NotaFiscal.class);
        query.setParameter("chaveDeAcesso", "ow92p0dnjh2nmso038");
        
        NotaFiscal notaFiscal = query.getSingleResult();
        assertNotNull(notaFiscal);
        
        notaFiscal.setChaveDeAcesso("a7015f75ed0758ad383690f428949395");
        notaFiscal.setDataEmissao(c.getTime());
        notaFiscal.setValor(Double.valueOf(157.35));
        
        em.clear();       
        em.merge(notaFiscal);
        em.flush();
        assertEquals(0, query.getResultList().size());
    }

    @Test
    public void removerNotaFiscal() {
        TypedQuery<NotaFiscal> query = em.createNamedQuery("NotaFiscal.porChaveDeAcesso", NotaFiscal.class);
        query.setParameter("chaveDeAcesso", "43e85df6a0d958387cc6690df88f2854");
        NotaFiscal notaFiscal = query.getSingleResult();
        assertNotNull(notaFiscal);
        em.remove(notaFiscal);
        em.flush();
        assertEquals(0, query.getResultList().size());
    }
}
