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

/**
 *
 * @author Marc Mas
 */
public class GrupDAO {

    EntityManager em;

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
        System.out.println("S'ha creat el grup amb exit");
    }

    public void afegirUsuaris(int idGrup, String mailUsuari) {
        Grup g = this.obtenirGrup(idGrup);
        if (g != null) {
            afegirUsuaris(g, mailUsuari);
        }
    }

    public void afegirUsuaris(Grup g, String mailUsuari) {
        List<Usuari> usuarisAntics = g.getUsuariList();
        UsuariDAO uDAO = new UsuariDAO(em);
        Usuari u = uDAO.obtenirUsuari(mailUsuari);
        if (usuarisAntics.contains(u)) {
            System.out.println("L'usuari ja està al grup!");
        } else {
            if (u != null) {
                EntityTransaction tx = em.getTransaction();
                tx.begin();
                usuarisAntics.add(u);
                g.setUsuariList(usuarisAntics);
                em.flush();
                tx.commit();
                System.out.println("S'ha afegit l'usuari " + u.toString() + " al grup " + g.getId());
            }
        }
    }

    public void menuAfegirUsuaris(Scanner s) {
        System.out.println("Introdueix l'ID del grup on vol afegir usuaris");
        int idGrup = s.nextInt();
        Grup g = this.obtenirGrup(idGrup);
        if (g != null) {
            String correu = "";
            s.nextLine(); //per resetejar scanner
            while (!correu.equals("Atura")) {
                System.out.println("Introduint Usuaris al grup: " + g.getId());
                System.out.println("Usuaris actuals:");
                this.veureUsuaris(g.getId());
                System.out.println("Per aturar d'introduir, escrigui \"Atura\"");
                System.out.println("Introdueixi el correu de l'usuari");
                correu = s.nextLine();
                if (!correu.equals("Atura")) {
                    this.afegirUsuaris(g, correu);
                }
            }
        }
    }

    public void veureUsuaris(int id) {
        Grup g = obtenirGrup(id);
        if (g != null) {
            List<Usuari> l = g.getUsuariList(); //agafam la llista dins el grup
            Object usuaris[] = l.toArray(); //ho convertesc a un array
            if (usuaris.length == 0) {
                System.out.println("Actualment no hi ha usuaris al grup!");
            } else {
                System.out.println("Usuaris actuals:");
                for (int i = 0; i < usuaris.length; i++) {
                    System.out.println((Usuari) usuaris[i]); //imprimesc tots els usuaris del grup
                }
            }
        }
    }

    public Grup obtenirGrup(int id) {
        Query q = em.createNamedQuery("Grup.findById").setParameter("id", id); //trob el grup per el seu id (es unic)
        Grup g = null;
        try {
            g = (Grup) q.getSingleResult(); //recuper el primer grup amb l'id indicat (només n'hi ha un)
        } catch (javax.persistence.NoResultException e) { //si no hi ha resultats, mostram l'error
            System.out.println("Aquest grup no està a la BBDD");
        }
        return g;
    }
}
