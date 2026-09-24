/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tricountmarcmas;

import Usuaris.Usuari;
import Usuaris.UsuariDAO;
import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Marc Mas
 */
public class DespesaDAO implements Serializable {

    private static EntityManager em;

    DespesaDAO(EntityManagerFactory emf) {
        DespesaDAO.em = emf.createEntityManager();
    }

    DespesaDAO(EntityManager em) {
        DespesaDAO.em = em;
    }

    public void create(Despesa d) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(d);
        tx.commit(); //i feim commit
    }

    public void updateDatabase() {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.flush();
        tx.commit(); //i feim commit
    }

    public void destroy(Despesa d) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.remove(d);
        tx.commit();
    }

    public static Despesa find(int id) {
        return em.find(Despesa.class, id);
    }

    public static Despesa find(int id, EntityManager em) {
        return em.find(Despesa.class, id);
    }
    
    public static void setEntityManager(EntityManager e){
        em = e;
    }
}
