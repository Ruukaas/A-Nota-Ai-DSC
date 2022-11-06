package com.mycompany.dscproject.dao;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ManagerDao {

    private static ManagerDao myself = null;

    public static ManagerDao getCurrentInstance() {
        if (myself == null)
            myself = new ManagerDao();
        return myself;
    }

    private EntityManagerFactory emf = null;

    private ManagerDao() {
        this.emf = Persistence.createEntityManagerFactory("persistence");
    }

    public void insert(Object o) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(o);
        em.flush();
        em.getTransaction().commit();
        em.close();
    }


}
