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
        TypedQuery<NotaFiscal> query = em.createNamedQuery("NotaFiscal.byChaveDeAcesso", NotaFiscal.class);
        query.setParameter("chave", "kaienhdaisdjkdfuyks8205");
        NotaFiscal notaFiscal = query.getSingleResult();
        assertNotNull(notaFiscal);
        notaFiscal.setChaveDeAcesso("xajumxzhycdsowehsak129xda");
        em.flush();
        assertEquals(0, query.getResultList().size());
        query.setParameter("chave", "xajumxzhycdsowehsak129xda");
        notaFiscal = query.getSingleResult();
        assertNotNull(notaFiscal);
    }

    @Test
    public void atualizarNotaFiscalMerge() {
        TypedQuery<NotaFiscal> query = em.createNamedQuery("NotaFiscal.byChaveDeAcesso", NotaFiscal.class);
        query.setParameter("chave", "duekloshekldhy20458sak");
        NotaFiscal notaFiscal = query.getSingleResult();
        assertNotNull(notaFiscal);
        notaFiscal.setChaveDeAcesso("sdsadqwxz258asdsasadcoi");
        em.clear();       
        em.merge(notaFiscal);
        em.flush();
        assertEquals(0, query.getResultList().size());
    }

    @Test
    public void removerNotaFiscal() {
        TypedQuery<NotaFiscal> query = em.createNamedQuery("NotaFiscal.byChaveDeAcesso", NotaFiscal.class);
        query.setParameter("chave", "duekloshekldhy20458sak");
        NotaFiscal notaFiscal = query.getSingleResult();
        assertNotNull(notaFiscal);
        em.remove(notaFiscal);
        em.flush();
        assertEquals(0, query.getResultList().size());
    }
}
