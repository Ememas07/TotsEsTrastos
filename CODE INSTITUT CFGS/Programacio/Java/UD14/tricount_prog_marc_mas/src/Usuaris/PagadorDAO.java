/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuaris;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Marc Mas
 */
public class PagadorDAO {

    private static EntityManager em;

    public PagadorDAO() {
    }

    public PagadorDAO(EntityManagerFactory emf) {
        PagadorDAO.em = emf.createEntityManager();
    }

    public PagadorDAO(EntityManager em) {
        PagadorDAO.em = em;
    }

    public void create(Pagador p) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(p);
        tx.commit(); //i feim commit
    }

    public void updateDatabase() {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.flush();
        tx.commit(); //i feim commit
    }

    public void destroy(Pagador p) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.remove(p);
        tx.commit();
    }

    public static Pagador find(int id) {
        return em.find(Pagador.class, id);
    }

    public static void setEntityManager(EntityManager e) {
        em = e;
    }

}
