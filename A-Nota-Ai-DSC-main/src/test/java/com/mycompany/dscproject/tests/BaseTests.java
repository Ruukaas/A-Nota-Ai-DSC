package com.mycompany.dscproject.tests;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
        
public abstract class BaseTests
{
    protected static EntityManagerFactory emf;
    protected EntityManager em;
    protected EntityTransaction et;
    
    @BeforeClass
    public static void setUpClass()
    {
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
        et = em.getTransaction();
        et.begin();
    }
    
    @After
    public void tearDown()
    {
        if (!et.getRollbackOnly()) { et.commit(); }
        em.close();
    }
}
