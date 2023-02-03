package com.mycompany.dscproject.tests;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
        
public abstract class BaseTests
{
    protected static EntityManagerFactory emf;
    protected EntityManager em;
    protected EntityTransaction et;
    protected static Logger logger;
    
    @BeforeClass
    public static void setUpClass()
    {
        logger = Logger.getGlobal();
        logger.setLevel(Level.INFO);
        emf = Persistence.createEntityManagerFactory("persistence");
        DbUnitUtil.inserirDados();
    }
    
    @AfterClass
    public static void tearDownClass()
    {
        emf.close();
    }
    
    @Before
    public void setUp()
    {
        em = emf.createEntityManager();
        beginTransaction();
    }
    
    @After
    public void tearDown()
    {
        commitTransaction();
        em.close();
    }
    
    private void beginTransaction() {
        et = em.getTransaction();
        et.begin();
    }
    
    private void commitTransaction() {
        if (!et.getRollbackOnly()) {
            et.commit();
        }
    }
    
    protected Date getData(Integer dia, Integer mes, Integer ano) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, ano);
        c.set(Calendar.MONTH, mes);
        c.set(Calendar.DAY_OF_MONTH, dia);
        return c.getTime();
    }

    protected Date getDatatime(Integer dia, Integer mes, Integer ano, Integer hora, Integer minutos, Integer segundos, Integer milisegundos) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, ano);
        c.set(Calendar.MONTH, mes);
        c.set(Calendar.DAY_OF_MONTH, dia);
        c.set(Calendar.HOUR_OF_DAY, hora);
        c.set(Calendar.MINUTE, minutos);
        c.set(Calendar.SECOND, segundos);
        c.set(Calendar.MILLISECOND, milisegundos);
        return c.getTime();
    }
}
