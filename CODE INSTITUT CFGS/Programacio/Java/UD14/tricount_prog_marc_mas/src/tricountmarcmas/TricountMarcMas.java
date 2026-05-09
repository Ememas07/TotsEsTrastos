/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tricountmarcmas;

import Usuaris.*;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
import javax.persistence.*;

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
                    menuUsuaris(s, uDAO);
                }
                case 2 -> {
                    GrupDAO gDAO = new GrupDAO(emf);
                    menuGrups(s, gDAO);
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

    public static void menuUsuaris(Scanner s, UsuariDAO uDAO) {
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
                    Usuari u = new Usuari(s);
                    uDAO.create(u);
                }
                case 2 -> {
                    s.nextLine();
                    System.out.println("Introdueix el correu de l'usuari que vol afegir a grups");
                    String correu = s.next();
                    uDAO.afegirGrups(s, correu);
                }
            }
        }
    }

    public static void menuGrups(Scanner s, GrupDAO gDAO) {
        int opcio = 0;
        while (opcio > -1) {
            System.out.println("Menú Grups:");
            System.out.println("1: Crear");
            System.out.println("2: Assignar usuaris a un grup");
            System.out.println("3: Veure usuaris d'un grup");
            System.out.println("4: Veure despeses d'un grup");
            System.out.println("-1: Tornar Enrere");
            opcio = s.nextInt();
            switch (opcio) {
                case 1 -> {
                    s.nextLine(); //buidam el búfer de scanner
                    Grup g = new Grup(s);
                    gDAO.create(g);
                }
                case 2 -> {
                    s.nextLine();
                    System.out.println("Introdueix l'ID del grup on vol afegir usuaris");
                    int idGrup = s.nextInt();
                    Grup g = gDAO.obtenirGrup(idGrup);
                    if (g != null) {
                        String correu = "";
                        s.nextLine(); //per resetejar scanner
                        while (!correu.equals("Atura")) {
                            System.out.println("Introduint Usuaris al grup: " + g.getId());
                            gDAO.veureUsuaris(g.getId());
                            System.out.println("Per aturar d'introduir, escrigui \"Atura\"");
                            System.out.println("Introdueixi el correu de l'usuari");
                            correu = s.nextLine();
                            if (!correu.equals("Atura")) {
                                gDAO.afegirUsuaris(g, correu);
                            }
                        }
                    }
                }
                case 22 -> {
                    gDAO.menuAfegirUsuaris(s); //no se que es millor :sob:
                }

                case 3 -> {
                    s.nextLine();
                    System.out.println("Introdueix l'id del grup");
                    int id = s.nextInt();
                    gDAO.veureUsuaris(id);
                }

                case 4 -> {
                    s.nextLine();
                    System.out.println("Introdueix l'id del grup");
                    int id = s.nextInt();
                    gDAO.veureDespeses(id);
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
                    System.out.println("Vol pagar a parts iguals o assignar imports manuals?");
                    System.out.println("1: Asignar imports manuals");
                    System.out.println("2: Parts iguals");
                    int distribucio = s.nextInt();
                    Usuari u = em.find(Usuari.class, correu);
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
                    importPendent = importPendent.subtract(contribucio);
                    pDAO.create(p);
                    for (int i = 0; i < numPagadors; i++) {
                        System.out.println("Quin es el correu del pagador " + (i + 1) + " ?");
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
            }
        }
    }

    public static void menuEstadistiques(Scanner s) {

    }

}
