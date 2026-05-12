/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tricountmarcmas;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Usuaris.Grup;
import Usuaris.GrupDAO;
import Usuaris.Pagador;
import Usuaris.PagadorDAO;
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
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tricount_prog_marc_masPU");
        EntityManager em = emf.createEntityManager();
        Scanner s = new Scanner(System.in);

        int opcio = 0;
        while (opcio > -1) {
            System.out.println("Menús:");
            System.out.println("1: Usuaris");
            System.out.println("2: Grups");
            System.out.println("3: Despeses");
            System.out.println("4: Estadistiques");
            System.out.println("5: Debug");
            System.out.println("-1: Sortir");
            opcio = s.nextInt();
            // opcio = 4;

            switch (opcio) {
                case 1 -> {
                    UsuariDAO uDAO = new UsuariDAO(emf);
                    menuUsuaris(s, uDAO, em);
                }
                case 2 -> {
                    GrupDAO gDAO = new GrupDAO(emf);
                    menuGrups(s, em);
                }
                case 3 -> {
                    DespesaDAO dDAO = new DespesaDAO(emf);
                    menuDespeses(s, dDAO, emf);
                }
                case 4 -> {
                    menuEstadistiques(s);
                }
            }
        }
    }

    public static void menuUsuaris(Scanner s, UsuariDAO uDAO, EntityManager em) {
        int opcio = 0;
        while (opcio > -1) {
            System.out.println("Menú Usuaris:");
            System.out.println("1: Crear");
            System.out.println("2: Assignar grups a un usuari");
            System.out.println("-1: Tornar Enrere");
            opcio = s.nextInt();
            switch (opcio) {
                case 1 -> {
                    s.nextLine();
                    Usuari u = Usuari.crearUsuariConsola(s);
                    uDAO.create(u);
                }
                case 2 -> {
                    s.nextLine();
                    Usuari u = Usuari.obtenirUsuariConsola(s, em);
                    u.afegirGrups(s, em);
                }
            }
        }
    }

    public static void menuGrups(Scanner s, EntityManager em) {
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
                    s.nextLine(); //buidam el búfer de scanner
                    Grup g = Grup.crearGrupConsola(s);
                    GrupDAO gDAO = new GrupDAO(em);
                    gDAO.create(g);
                    System.out.println("S'ha creat el grup amb exit");
                    System.out.println("ID: " + g.getId());
                }
                case 2 -> {
                    s.nextLine();
                    Grup g = Grup.obtenirGrupConsola(s, em);
                    g.afegirUsuaris(s, em);
                }
                case 3 -> {
                    s.nextLine();
                    Grup g = Grup.obtenirGrupConsola(s, em);
                    g.veureUsuaris();
                }

                case 4 -> {
                    s.nextLine();
                    Grup g = Grup.obtenirGrupConsola(s, em);
                    g.veureDespeses();
                }
                case 5 -> {
                    s.nextLine();
                    Grup g = Grup.obtenirGrupConsola(s, em);
                    g.mostrarDeutes(em);
                }
                case 6 -> {
                    s.nextLine();
                    Grup g = Grup.obtenirGrupConsola(s, em);
                    g.mostrarDespesesPerCategoria(em);
                }
                case 7 -> {
                    s.nextLine();
                    Grup g = Grup.obtenirGrupConsola(s, em);
                    g.mostrarDespesesPerUsuari(em);
                }
            }
        }
    }

    public static void menuDespeses(Scanner s, DespesaDAO dDAO, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
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
                    s.nextLine();
                    Despesa d = new Despesa(s);
                    System.out.println("Introdueix el correu del pagador original");
                    String correu = s.next();
                    System.out.println("Introdueix l'id del grup per assignar la despesa");
                    int idGrup = s.nextInt();
                    dDAO.create(d, correu, idGrup);
                    int distribucio = 0;
                    System.out.println("Vol assignar un import manual o pagar a parts iguals entre els pagadors restants?");
                    System.out.println("1: Asignar imports manuals");
                    System.out.println("2: Parts iguals");
                    distribucio = s.nextInt();
                    Usuari u = em.find(Usuari.class, correu);
                    while (u == null) {
                        correu = s.nextLine();
                        u = em.find(Usuari.class, correu);
                        if (u == null) {
                            System.out.println("El correu introduit no existeix!");
                            System.out.println("Introdueix un correu valid");
                        }
                    }
                    System.out.println("Quants de pagadors més hi ha?");
                    int numPagadors = (int) s.nextFloat();
                    PagadorDAO pDAO = new PagadorDAO(emf);
                    BigDecimal importPendent = d.getImporttotal();
                    BigDecimal partsIguals = importPendent.divide(new BigDecimal(numPagadors), 2, RoundingMode.DOWN);
                    BigDecimal contribucio = partsIguals;
                    if (distribucio != 2) {
                        System.out.println("Import total: " + importPendent);
                        System.out.println("Quin es l'import que paga " + u.getFullName() + "?");
                        contribucio = new BigDecimal(s.nextFloat());
                    }
                    Pagador p = new Pagador(contribucio, u, d, true); //la primera se guarda com true perque es l'original
                    int valorsAssignats = 1;
                    pDAO.create(p);
                    importPendent = importPendent.subtract(contribucio);
                    for (int i = 0; i < numPagadors; i++) {
                        System.out.println("Quin es el correu del pagador extra " + (i + 1) + " ?");
                        correu = s.nextLine();
                        u = em.find(Usuari.class, correu);
                        while (u == null) {
                            correu = s.nextLine();
                            u = em.find(Usuari.class, correu);
                            if (u == null) {
                                System.out.println("El correu introduit no existeix!");
                                System.out.println("Introdueix un correu valid");
                            }
                        }
                        if (distribucio != 2) {
                            System.out.println("Si vol seguir assignants imports individuals, introdueix 1");
                            System.out.println("Si vol assignar imports iguals a tots els usuaris restants, introdueix 2");
                            distribucio = s.nextInt();
                        }
                        contribucio = importPendent.divide(new BigDecimal(numPagadors + 1 - valorsAssignats), 2, RoundingMode.DOWN);
                        if (distribucio != 2) {
                            valorsAssignats += 1;
                            System.out.println("Pendent per pagar: " + importPendent);
                            System.out.println("Quin es l'import que paga " + u.getFullName() + "?");
                            contribucio = new BigDecimal(s.nextFloat());
                            importPendent = importPendent.subtract(contribucio);
                        }
                        p = new Pagador(contribucio, u, d, false);
                        pDAO.create(p);
                    }
                    dDAO.actualitzarImport(d);
                }
                case 2 -> {
                    s.nextLine(); //reiniciam escaner
                    System.out.println("Quin es el seu correu?");
                    String correu = s.next();
                    Usuari u = em.find(Usuari.class, correu);
                    while (u == null) {
                        correu = s.nextLine();
                        u = em.find(Usuari.class, correu);
                        if (u == null) {
                            System.out.println("El correu introduit no existeix!");
                            System.out.println("Introdueix un correu valid");
                        }
                    }
                    System.out.println("Formes part de les seguents despeses: ");
                    u.mostrarDespeses();
                    System.out.println("Introdueixi l'id de la despesa que vol pagar");
                    int idDespesa = s.nextInt();
                    Despesa d = em.find(Despesa.class, idDespesa);
                    while (d == null) {
                        idDespesa = s.nextInt();
                        d = em.find(Despesa.class, idDespesa);
                        if (d == null) {
                            System.out.println("la id introduida no existeix!");
                            System.out.println("Introdueix una id valida");
                        }
                    }
                    d.marcarPagament(u, s, em);

                }
                case 3 -> {
                    s.nextLine(); //reiniciam escaner
                    System.out.println("Quin es el seu correu?");
                    Usuari u = null;
                    while (u == null) {
                        String correu = s.nextLine();
                        u = em.find(Usuari.class, correu);
                        if (u == null) {
                            System.out.println("El correu introduit no existeix!");
                            System.out.println("Introdueix un correu valid");
                        }
                    }
                    System.out.println("Formes part de les seguents despeses: ");
                    u.mostrarDespesesPendents();
                }
                case 4 -> {
                    s.nextLine();
                    System.out.println("Quin grup vol consultar?");
                    Grup g = null;
                    while (g == null) {
                        int idGrup = s.nextInt();
                        g = em.find(Grup.class, idGrup);
                        if (g == null) {
                            System.out.println("El grup introduit no existeix!");
                            System.out.println("Introdueix una id de grup valida");
                        }
                    }
                    g.mostrarDeutes(em);
                }
                case 5 -> {
                    s.nextLine();
                    System.out.println("Quin grup vol consultar?");
                    Grup g = null;
                    while (g == null) {
                        int idGrup = s.nextInt();
                        g = em.find(Grup.class, idGrup);
                        if (g == null) {
                            System.out.println("El grup introduit no existeix!");
                            System.out.println("Introdueix una id de grup valida");
                        }
                    }
                    g.mostrarDespesesPerCategoria(em);
                }
            }
        }
    }

    public static void menuEstadistiques(Scanner s) {

    }

}
