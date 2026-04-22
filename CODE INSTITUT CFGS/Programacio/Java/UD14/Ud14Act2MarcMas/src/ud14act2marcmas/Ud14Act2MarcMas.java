/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ud14act2marcmas;

import javax.persistence.*;

/**
 *
 * @author Marc Mas
 */
public class Ud14Act2MarcMas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Triam l'entitat de persistència pel seu nom
        EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("Ud14Act2MarcMasPU");

        //Cream l'objecte EntityManager 
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //Alumne a = new Alumne("Pep", "Binissalem", 20.5f);
        Alumne a = new Alumne("Marc", "Maria de la Salut", 9.5f);
        em.persist(a);
        tx.commit();

    }

}
