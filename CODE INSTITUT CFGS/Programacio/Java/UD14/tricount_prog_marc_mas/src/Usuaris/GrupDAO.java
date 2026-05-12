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
public class GrupDAO {

    private static EntityManager em;

    public GrupDAO(EntityManagerFactory emf) {
        GrupDAO.em = emf.createEntityManager();
    }

    public GrupDAO(EntityManager em) {
        GrupDAO.em = em;
    }

    public void create(Grup g) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(g);
        tx.commit();
    }

    public void edit(Grup g) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.flush();
        tx.commit(); //i feim commit
    }
    
    public static Grup find(int id){
        return em.find(Grup.class, id);
    }
    
    public static Grup find(int id, EntityManager em){
        return em.find(Grup.class, id);
    }
}
