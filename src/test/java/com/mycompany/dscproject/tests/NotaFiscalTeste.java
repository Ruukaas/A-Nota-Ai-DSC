package com.mycompany.dscproject.tests;

import com.mycompany.dscproject.model.Cliente;
import com.mycompany.dscproject.model.NotaFiscal;
import com.mycompany.dscproject.model.Item;
import com.mycompany.dscproject.model.Loja;
import java.util.Calendar;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Lucas Gomes
 **/
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
}
