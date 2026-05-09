/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuaris;

import javax.persistence.*;
import tricountmarcmas.*;

/**
 *
 * @author Marc Mas
 */
public class PagadorDAO {

    private EntityManager em;
    
    PagadorDAO(){
    }

    public PagadorDAO(EntityManagerFactory emf) {
        this.em = emf.createEntityManager();
    }

    PagadorDAO(EntityManager em) {
        this.em = em;
    }

    public void create(Pagador p) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(p);
        tx.commit(); //i feim commit
    }

}
