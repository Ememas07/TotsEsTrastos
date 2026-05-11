/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuaris;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.*;
import tricountmarcmas.Despesa;

/**
 *
 * @author Marc Mas
 */
public class GrupDAO {

    private EntityManager em;

    public GrupDAO(EntityManagerFactory emf) {
        this.em = emf.createEntityManager();
    }

    public GrupDAO(EntityManager em) {
        this.em = em;
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
    
    public Grup find(int id){
        return em.find(Grup.class, id);
    }
}
