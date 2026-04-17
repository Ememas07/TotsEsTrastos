/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ud13act11marcmas;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Scanner;

import ud13act11marcmas.pilots.Pilot;
import ud13act11marcmas.pilots.PilotDAO;

/**
 * Activitat 13.11
 *
 * Redissenyar la classe anterior per a que permeti una política distinta amb
 * respecte a la connexió de BD
 *
 * Connectam amb la BD al principi
 *
 * Es realitzen operacions
 *
 * Es tanca la connexió amb la BD quan ja no sigui necessari accedir-hi o en
 * sortir de l'aplicació.
 *
 * Per a implementar aquest enfoc, necessitam un atribut amb la connexió que
 * s'obrirà al constructor del PilotDAO.
 *
 * Ara els mètodes ja no podràn ser estàtics.
 *
 * Podem aprofitar l'enfocament no estàtic per a definir constants que serveixin
 * per a configurar els paràmetres de connexió de la BD
 *
 *
 *
 * @author Marc Mas
 */
public class Ud13Act11MarcMas {

    /**
     * @param args the command line arguments
     * @throws java.io.UnsupportedEncodingException
     */
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.setOut(new PrintStream(System.out, true, "UTF-8"));
        Scanner s = new Scanner(System.in);
        Pilot p = new Pilot(0, "null", "null", "null");
        int opcio = 0;
        PilotDAO pd = new PilotDAO();
        try {
            pd.connectar();
        } catch (SQLException ex) {
            System.out.println("Error");
            ex.printStackTrace();
        }
        while (opcio > -1) {
            System.out.println("Opcions:");
            System.out.println("1: Create");
            System.out.println("2: Read");
            System.out.println("3: Update");
            System.out.println("4: Delete");
            System.out.println("5: Mostrar Taula");
            System.out.println("-1: Sortir");
            opcio = s.nextInt();

            switch (opcio) {
                case 1 -> {
                    System.out.println("Introdueix el nom del pilot");
                    String nom = s.next();
                    System.out.println("Introdueix el llinatge del pilot");
                    String llinatge = s.next();
                    System.out.println("Introdueix la nacionalitat del pilot");
                    String nacionalitat = s.next();
                    p = new Pilot(0, nom, llinatge, nacionalitat);
                    pd.create(p);
                }
                case 2 -> {
                    System.out.println("Introdueixi el ID per llegir");
                    int id = s.nextInt();
                    try {
                        p = pd.read(id);
                        p.imprimir();
                    } catch (SQLException e) {
                        System.out.println("Error en la lectura!");
                    }
                }
                case 3 -> {
                    System.out.println("Introdueix el nou nom del pilot");
                    String nom = s.next();
                    System.out.println("Introdueix el nou llinatge del pilot");
                    String llinatge = s.next();
                    System.out.println("Introdueix la nova nacionalitat del pilot");
                    String nacionalitat = s.next();
                    System.out.println("Introdueix el id del pilot que vol actualitzar");
                    int id = s.nextInt();
                    p = new Pilot(id, nom, llinatge, nacionalitat);
                    pd.update(p);
                }
                case 4 -> {
                    System.out.println("Introdueixi el ID per eliminar");
                    int id = s.nextInt();
                    pd.delete(id);
                }
                case 5 -> {
                    pd.mostrarTaula();
                }
            }
        }
        try {
            pd.desconnectar();
        } catch (SQLException ex) {
            System.out.println("Error");
            ex.printStackTrace();
        }
    }
}
