
package com.mycompany.dscproject.tests;

import com.mycompany.dscproject.dao.ManagerDao;
import com.mycompany.dscproject.model.Item;
import com.mycompany.dscproject.model.Loja;
import com.mycompany.dscproject.model.NotaFiscal;
import com.mycompany.dscproject.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class NotaFiscalTestes {
    
    @Test
    public void NotaFiscalWriteTest() {
        NotaFiscal nota = new NotaFiscal();
        List<Item> items = new ArrayList<>();
        Usuario donoDaNota = new Usuario();
        Loja loja = new Loja();

        Item sorvete = null;
        items.add(sorvete);
        Item tequila = null;
        items.add(tequila);

        nota.setDataEmissao(LocalDateTime.now());
        nota.setItens(items);
        nota.setValor(5000);
        nota.setLoja(loja);
        nota.setDonoDaNota(donoDaNota);

        ManagerDao.getCurrentInstance().insert(nota); 
    
    };    
    
    @Test
    public void NotaFiscalReadTest(){
        EntityManagerFactory emf = null;
        emf = Persistence.createEntityManagerFactory("persistence");
        EntityManager em = emf.createEntityManager();
        NotaFiscal nota = em.find(NotaFiscal.class, 1); 
        
        assertNotNull(nota.getDataEmissao());
        assertNotNull(nota.getCodigo());
        assertEquals(5000, nota.getLoja());
        assertEquals("", nota.getItens());
        assertEquals("", nota.getLoja());

    };
}
