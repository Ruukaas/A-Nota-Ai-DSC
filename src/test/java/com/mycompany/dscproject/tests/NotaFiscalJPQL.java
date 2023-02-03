package com.mycompany.dscproject.tests;

import com.mycompany.dscproject.model.NotaFiscal;
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
        logger.info("notasEntreDatasEspecificas()");
        TypedQuery<NotaFiscal> query;
        query = em.createQuery(
                "SELECT u FROM NotaFiscal u WHERE u.dataEmissao BETWEEN ?1 AND ?2",
                NotaFiscal.class);
        
        
        query.setParameter(1, getData(1, Calendar.OCTOBER, 2020));
        query.setParameter(2, getData(1, Calendar.JANUARY, 2021));
        List<NotaFiscal> notasFiscais = query.getResultList();
        assertEquals(1, notasFiscais.size());
    }

    @Test
    public void notafiscalMaisAntiga() {
        logger.info("notafiscalMaisAntiga()");
        Query query;
        query = em.createQuery(
                "SELECT MIN(n.dataEmissao) FROM NotaFiscal n"
            );
        
        Object resultado = query.getSingleResult();
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String data = dateFormat.format((Date) resultado);

        assertEquals("01-10-2020", data);
    }
}