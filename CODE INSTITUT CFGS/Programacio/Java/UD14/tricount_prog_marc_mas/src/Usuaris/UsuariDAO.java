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
public class UsuariDAO {

    private static EntityManager em;

    public UsuariDAO(EntityManagerFactory emf) {
        UsuariDAO.em = emf.createEntityManager();
    }

    public UsuariDAO(EntityManager em) {
        UsuariDAO.em = em;
    }

    public void create(Usuari u) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(u);
        tx.commit(); //i feim commit
    }

    public void edit(Usuari u) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.flush();
        tx.commit(); //i feim commit
    }

    public static Usuari find(String correu) {
        return em.find(Usuari.class, correu);
    }
    
    public static Usuari find(String correu, EntityManager em){
        return em.find(Usuari.class, correu);
    }
}
