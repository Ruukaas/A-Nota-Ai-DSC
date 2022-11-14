package com.mycompany.dscproject.tests;

import com.mycompany.dscproject.model.Loja;
import com.mycompany.dscproject.model.Produto;
import com.mycompany.dscproject.model.NotaFiscal;
import java.util.Calendar;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Lucas Gomes
 **/
public class LojaTeste extends BaseTests {
    @Test
    public void persistirLoja() {
        Loja loja = new Loja();
        
        loja.setCNPJ("50.560.744/0001-39");
        loja.setEndereco("Rua Cento e Vinte e Oito");
        loja.setNome("Mercadinho Preço Baixo");
        
        Produto p1 = new Produto();
        p1.setNome("Cereal Nescau");
        
        Produto p2 = new Produto();
        p2.setNome("1KG de Queijo Coalho");
        
        loja.adicionarProduto(p1);
        loja.adicionarProduto(p2);
        
        NotaFiscal nf1 = new NotaFiscal();
        nf1.setChaveDeAcesso("RF9P4EVD09");
        Calendar c1 = Calendar.getInstance();
        c1.set(2022, Calendar.SEPTEMBER, 20, 10, 50, 0);
        nf1.setDataEmissao(c1.getTime());
        nf1.setValor(Double.valueOf(120.00));
        
        NotaFiscal nf2 = new NotaFiscal();
        nf2.setChaveDeAcesso("E1G9RG154W");
        Calendar c2 = Calendar.getInstance();
        c2.set(2022, Calendar.SEPTEMBER, 25, 14, 25, 30);
        nf2.setDataEmissao(c2.getTime());
        nf2.setValor(Double.valueOf(85.35));
        
        loja.adicionarNotaFiscal(nf1);
        loja.adicionarNotaFiscal(nf2);
        
        em.persist(loja);
        em.flush();
        
        assertNotNull(loja.getCodigo());
    }
    
    @Test
    public void consultarLoja() {
        Loja loja = em.find(Loja.class, 1L);
        
        assertNotNull(loja);
        assertEquals("37.695.129/0001-71", loja.getCNPJ());
        assertEquals("Rua José de Oliveira 18 - Recife", loja.getEndereco());
        assertEquals("Hyper food", loja.getNome());
    }
}
