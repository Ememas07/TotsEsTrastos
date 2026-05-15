/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tricountmarcmas;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Usuaris.Grup;
import Usuaris.GrupDAO;
import Usuaris.Usuari;
import Usuaris.UsuariDAO;

/**
 *
 * @author Marc Mas
 */
public class TricountMarcMas {

    /**
     * @param args the command line arguments
     * @throws java.io.UnsupportedEncodingException
     */
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.setOut(new PrintStream(System.out, true, "UTF8"));
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tricount_prog_marc_masPU"); //cream un entityManagerFactory amb l'unitat de persistència ja creada
        EntityManager em = emf.createEntityManager(); //cream un entityManager per passar-lo a mètodes que el necessitin
        // cream els DAO, ja que a vegades cridar els seus mètodes estàtics pot fallar si no hi ha cap instància creada, ja que el seu EntityManager seria null
        UsuariDAO uDAO = new UsuariDAO(emf);
        GrupDAO gDAO = new GrupDAO(emf);
        DespesaDAO dDAO = new DespesaDAO(emf);
        Scanner s = new Scanner(System.in); //cream un scanner per poder demanar a l'usuari coses per consola
        int opcio = 0;
        while (opcio > -1) { //si introduim un nombre negatiu, sortirem del bucle
            System.out.println("Menús:");
            System.out.println("1: Usuaris");
            System.out.println("2: Grups");
            System.out.println("3: Despeses");
            System.out.println("-1: Sortir");
            opcio = s.nextInt(); //agafam opcio per consola
            switch (opcio) {
                case 1 -> {
                    menuUsuaris(s, em, uDAO);
                }
                case 2 -> {
                    menuGrups(s, em, gDAO);
                }
                case 3 -> {
                    menuDespeses(s, em, dDAO);
                }
            }
        }
    }

    public static void menuUsuaris(Scanner s, EntityManager em, UsuariDAO uDAO) {
        int opcio = 0;
        while (opcio > -1) { //-1 tornarà enrere
            System.out.println("Menú Usuaris:");
            System.out.println("1: Crear");
            System.out.println("2: Assignar grups a un usuari");
            System.out.println("3: Consultar grups d'un usuari");
            System.out.println("4: Consultar dades personals d'un usuari");
            System.out.println("-1: Tornar Enrere");
            opcio = s.nextInt();
            switch (opcio) {
                case 1 -> {
                    Usuari u = Usuari.crearUsuariConsola(s); //cream l'usuari
                    uDAO.create(u); //el persistim a BBDD
                    System.out.println("S'ha creat l'usuari amb éxit"); //mostram un missatge a l'usuari per pantalla
                    u.printFull(); //imprimim totes les dades de l'usuari
                }
                case 2 -> {
                    Usuari u = Usuari.obtenirUsuariConsola(s, em);
                    u.afegirGrups(s, em);
                }
                case 3 ->{
                    Usuari u = Usuari.obtenirUsuariConsola(s, em);
                    u.veureGrups();
                }
                case 4 -> {
                    Usuari u = Usuari.obtenirUsuariConsola(s, em);
                    u.printFull();
                }
            }
        }
    }

    public static void menuGrups(Scanner s, EntityManager em, GrupDAO gDAO) {
        int opcio = 0;
        while (opcio > -1) {
            System.out.println("Menú Grups:");
            System.out.println("1: Crear");
            System.out.println("2: Assignar usuaris a un grup");
            System.out.println("3: Veure usuaris d'un grup");
            System.out.println("4: Veure despeses d'un grup");
            System.out.println("5: Veure deutes entre usuaris");
            System.out.println("6: Veure despeses per categoria");
            System.out.println("7: Veure despeses per usuari");
            System.out.println("-1: Tornar Enrere");
            opcio = s.nextInt();
            switch (opcio) {
                case 1 -> {
                    Grup g = Grup.crearGrupConsola(s);
                    gDAO.create(g);
                    System.out.println("S'ha creat el grup amb exit");
                    System.out.println("ID: " + g.getId());
                }
                case 2 -> {
                    Grup g = Grup.obtenirGrupConsola(s, em);
                    g.afegirUsuaris(s, em);
                }
                case 3 -> {
                    s.nextLine();
                    Grup g = Grup.obtenirGrupConsola(s, em);
                    g.veureUsuaris();
                }
                case 4 -> {
                    Grup g = Grup.obtenirGrupConsola(s, em);
                    g.veureDespeses();
                }
                case 5 -> {
                    Grup g = Grup.obtenirGrupConsola(s, em);
                    g.mostrarDeutes(em);
                }
                case 6 -> {
                    Grup g = Grup.obtenirGrupConsola(s, em);
                    g.mostrarDespesesPerCategoria(em);
                }
                case 7 -> {
                    Grup g = Grup.obtenirGrupConsola(s, em);
                    g.mostrarDespesesPerUsuari(em);
                }
            }
        }
    }

    public static void menuDespeses(Scanner s, EntityManager em, DespesaDAO dDAO) {
        int opcio = 0;
        while (opcio > -1) {
            System.out.println("Menú Despeses:");
            System.out.println("1: Crear");
            System.out.println("2: Marcar pagament");
            System.out.println("3: Mostrar pagaments pendents");
            System.out.println("4: Mostrar deutes d'un grup");
            System.out.println("5: Mostrar deutes d'una categoria");
            System.out.println("-1: Sortir");
            opcio = s.nextInt();
            switch (opcio) {
                case 1 -> {
                    Despesa d = Despesa.crearDespesaConsola(s, em); //genera la despesa com a tal
                    dDAO.create(d);
                    d.assignarPagadorsTeclat(s, em); //demana pagadors, i els assigna a la despesa assignada
                }
                case 2 -> {
                    Despesa.marcarPagament(s, em);
                }
                case 3 -> {
                    Usuari u = Usuari.obtenirUsuariConsola(s, em);
                    u.mostrarDespeses(true);
                }
                case 4 -> {
                    Grup g = Grup.obtenirGrupConsola(s, em);
                    g.mostrarDeutes(em);
                }
                case 5 -> {
                    Grup g = Grup.obtenirGrupConsola(s, em);
                    g.mostrarDespesesPerCategoria(em);
                }
            }
        }
    }

}
