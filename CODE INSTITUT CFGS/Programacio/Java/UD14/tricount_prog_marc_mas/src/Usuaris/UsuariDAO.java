/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuaris;

import java.util.List;
import java.util.Scanner;
import javax.persistence.*;

/**
 *
 * @author Marc Mas
 */
public class UsuariDAO {

    private EntityManager em;

    public UsuariDAO(EntityManagerFactory emf) {
        this.em = emf.createEntityManager();
    }

    public UsuariDAO(EntityManager em) {
        this.em = em;
    }

    public void create(Usuari u) {
        if (!correuExisteix(u.getCorreu())) {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(u);
            tx.commit(); //i feim commit
            System.out.println("S'ha afegit l'usuari amb éxit:");
            u.printFull();
        } else {
            System.out.println("Aquest email ja està la BBDD!"); //si obtenc resultats, l'usuari ja està a la BBDD aixi que rollback i mostram error
        }
    }

    public void afegirGrups(Scanner s, String correu) {
        Usuari u = this.obtenirUsuari(correu); //si falla, bota un error i s'assigna null
        if (u != null) {
            int idGrup = 10; //per que el bucle s'executi
            s.nextLine(); //per resetejar scanner
            while (idGrup > 0) {
                System.out.println("Introduint l'usuari " + u.getCorreu() + " a grups: ");
                this.veureGrups(u.getCorreu());
                System.out.println("Per aturar d'introduir, escrigui un nombre negatiu");
                System.out.println("Introdueixi l'id del grup");
                idGrup = s.nextInt();
                // GrupDAO gDAO = new GrupDAO(em);
                Grup g = Grup.consultarGrupConsola(s, em);
                g.afegirUsuari(correu, em);
                // gDAO.afegirUsuaris(idGrup, correu); //idGrup es valida a gDAO
                em.refresh(u); //per actualitzar la llista interna de l'usuari
            }
        }
    }

    public void veureGrups(String correu) {
        Usuari u = obtenirUsuari(correu);
        if (u != null) {
            List<Grup> l = u.getGrupList(); //agafam la llista de l'usuari
            Object grups[] = l.toArray(); //ho convertesc a un array
            if (grups.length == 0) {
                System.out.println("Actualment no pertany a cap grup!");
            } else {
                System.out.println("Grups actuals:");
                for (int i = 0; i < grups.length; i++) {
                    System.out.println((Grup) grups[i]); //imprimesc tots els grups de l'usuari
                }
            }
        }
    }

    public Usuari obtenirUsuari(String correu) {
        Usuari u = null;
        Query q = em.createNamedQuery("Usuari.findByCorreu").setParameter("correu", correu); //cerc l'usuari per el seu correu (clau primaria)
        try {
            u = (Usuari) q.getSingleResult(); //faig la query            
        } catch (javax.persistence.NoResultException e) {
            System.out.println("Aquest email no està la BBDD!"); //si obtenc resultats, l'usuari ja està a la BBDD aixi que rollback i mostram error
        }
        return u;
    }

    public boolean correuExisteix(String correu) {
        Usuari u = obtenirUsuari(correu); //si no existeix, escriu una excepcio i assigna null
        if (u == null) {
            return false;
        }
        return true;
    }
}
