package com.mycompany.dscproject.tests;

import com.mycompany.dscproject.model.NotaFiscal;
import com.mycompany.dscproject.model.Usuario;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NotaFiscalJPQL extends BaseTests {
    @Test
    public void notasEntreDatasEspecificas() {
        logger.info("Executando notasEntreDatasEspecificas()");
        
        TypedQuery<NotaFiscal> query = em.createQuery("SELECT u FROM NotaFiscal u WHERE u.dataEmissao BETWEEN ?1 AND ?2", NotaFiscal.class);
        query.setParameter(1, getData(1, Calendar.OCTOBER, 2020));
        query.setParameter(2, getData(1, Calendar.JANUARY, 2021));
        List<NotaFiscal> notasFiscais = query.getResultList();
        
        assertEquals(1, notasFiscais.size());
    }

    @Test
    public void notafiscalMaisAntiga() {
        logger.info("Executando notafiscalMaisAntiga()");
        
        Query query = em.createQuery("SELECT MIN(n.dataEmissao) FROM NotaFiscal n");
        Object resultado = query.getSingleResult();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH:mm:ss");
        String data = dateFormat.format((Date) resultado);

        assertEquals("01-10-2020_10:00:00", data);
    }
    
    @Test
    public void notaFiscalMaisRecente() {
        logger.info("Executando notaFiscalMaisRecente()");
        
        Query query = em.createQuery("SELECT MAX(n.dataEmissao) FROM NotaFiscal n");
        Object resultado = query.getSingleResult();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH:mm:ss");
        String data = dateFormat.format((Date) resultado);
        
        assertEquals("13-11-2022_10:00:00", data);
    }
    
    @Test
    public void mediaDeValorDeNotasFiscais() {
        logger.info("Executando mediaDeValorDeNotasFiscais()");
        
        Query query = em.createQuery("SELECT AVG(n.valor) FROM NotaFiscal n");
        Object resultado = query.getSingleResult();
        Double valueAverage = Double.valueOf(resultado.toString());
        
        assertEquals(valueAverage, Double.valueOf(137.79));
    }

    @Test
    public void quantidadeDeNotasFiscais() {
        logger.info("Executando quantidadeDeNotasFiscais()");
        
        Query query = em.createQuery("SELECT COUNT(n) FROM NotaFiscal n");
        Object resultado = query.getSingleResult();
        Integer quantidadeDeNotasFiscais = Integer.valueOf(resultado.toString());
        
        assertEquals(quantidadeDeNotasFiscais, Integer.valueOf(4));
    }
    
    @Test
    public void somaDeValoresDeNotasFiscais() {
        logger.info("Executando somaDeValoresDeNotasFiscais()");
        
        Query query = em.createQuery("SELECT SUM(n.valor) FROM NotaFiscal n");
        Object resultado = query.getSingleResult();
        Double somaDeValores = Double.valueOf(resultado.toString());
        
        assertEquals(somaDeValores, Double.valueOf(551.16));
    }
    
    private String getNotaFiscalAgrupada(Object[] resultado) {
        String nomeCliente = (String) resultado[0];
        Long quantidadeDeNotasFiscais = (Long) resultado[1];
        return nomeCliente.toString() +" : "+ quantidadeDeNotasFiscais;
    }
    
    @Test
    public void usuarioPorQuantidadeDeNotasFiscais() {
        logger.info("Executando usuarioPorQuantidadeDeNotasFiscais()");
        
        Query query = em.createQuery("SELECT n.donoDaNota.nome, COUNT(n) FROM NotaFiscal n GROUP BY n.donoDaNota");
        List<Object[]> notasFiscaisAgrupadas = query.getResultList();
     
        assertEquals(3, notasFiscaisAgrupadas.size());
        assertEquals("José Luiz : 1", getNotaFiscalAgrupada(notasFiscaisAgrupadas.get(0)));
        assertEquals("Laura Nunes : 2", getNotaFiscalAgrupada(notasFiscaisAgrupadas.get(1)));
        assertEquals("Fernanda Gonçalves : 1", getNotaFiscalAgrupada(notasFiscaisAgrupadas.get(2)));
    }
    
    @Test
    public void donoDeNotaFiscal() {
        logger.info("Executando donoDeNotaFiscal()");
        
        TypedQuery<Usuario> query = em.createQuery("SELECT d FROM NotaFiscal n JOIN n.donoDaNota d WHERE n.codigo = 1", Usuario.class);
        Usuario usuario = query.getSingleResult();
        
        assertEquals(usuario.getNome(), "José Luiz");
    }
}
