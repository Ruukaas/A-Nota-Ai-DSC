package com.mycompany.dscproject.tests;

import com.mycompany.dscproject.dao.ManagerDao;
import com.mycompany.dscproject.model.NotaFiscal;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import com.mycompany.dscproject.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class userTest 
{

    
    @Test
    public void writeTest() {
        Usuario user = new Usuario();
        NotaFiscal nota = new NotaFiscal();
        
        nota.setChaveDeAcesso("qualquerOCIsa");      
        
        user.setCpf("s56465465465168");
        user.setEmail("sadsadasdasfasf@sim.br");
        user.setNome("amarildo");
        user.setSenha("Pikamon");
        user.setTelefone("44651684134561");
        user.setUsuario("Issoéumeste");
        user.setCompras(nota);

        ManagerDao.getCurrentInstance().insert(user);

        
    }
    
    @Test
    public void ReadTest() {
        EntityManagerFactory emf = null;
        emf = Persistence.createEntityManagerFactory("persistence");
        EntityManager em = emf.createEntityManager();
        Usuario user = em.find(Usuario.class, 1);
        assertNotNull(user);
        assertNotNull(user.getCompras());
        assertEquals("s56465465465168", user.getCpf());
        assertEquals("sadsadasdasfasf@sim.br", user.getEmail());
        assertEquals("amarildo", user.getNome());
        assertEquals("Pikamon", user.getSenha());
        assertEquals("44651684134561", user.getTelefone());
        assertEquals("Issoéumeste", user.getUsuario());
    }
}
