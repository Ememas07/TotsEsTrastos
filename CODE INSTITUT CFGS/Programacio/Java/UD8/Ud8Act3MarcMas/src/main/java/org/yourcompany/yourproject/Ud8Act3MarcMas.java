/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license


Afegir a la classe HoraExacta un mètode que compari si dos hores(la
invocant i una altra passada per paràmetre d'entrada al mètode) són iguals o
distints
 */
package org.yourcompany.yourproject;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class Ud8Act3MarcMas {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Introdueixi el valor de hores");
        int hora = s.nextInt();
        System.out.println("Introdueixi el valor de minuts");
        int minut = s.nextInt();
        System.out.println("Introdueixi el valor de segons");
        int segon = s.nextInt();
        HoraExacta h = new HoraExacta(hora, minut, segon);
        int opcio = 1;
        while (opcio > 0) { //-1 sortira
            try {
                System.out.println("1: Augmentar minuts");
                System.out.println("2: Augmentar segons");
                System.out.println("3: Posar hores");
                System.out.println("4: Posar minuts");
                System.out.println("5: Posar segons");
                System.out.println("6: Comparar hores");
                System.out.println("-1: Sortir");
                opcio = s.nextInt();
                switch (opcio) {
                    case 1 -> { //Augmentar Minuts
                        h.incMinuts();
                    }
                    case 2 -> { //Augmentar Segons
                        h.inc();
                    }
                    case 3 -> { //Posar Hores
                        System.out.println("Introdueixi la hora que vol assignar");
                        hora = s.nextInt();
                        h.setHora(hora);
                    }
                    case 4 -> { //Posar Minuts
                        System.out.println("Introdueixi el minut que vol assignar");
                        minut = s.nextInt();
                        h.setMinut(minut);
                    }
                    case 5 -> { //Posar Segons
                        System.out.println("Introdueixi el segon que vol assignar");
                        segon = s.nextInt();
                        h.setSegon(segon);
                    }
                    case 6 -> { //comparar
                        System.out.println("Introdueixi el valor de hores");
                        hora = s.nextInt();
                        System.out.println("Introdueixi el valor de minuts");
                        minut = s.nextInt();
                        System.out.println("Introdueixi el valor de segons");
                        segon = s.nextInt();
                        HoraExacta h2 = new HoraExacta(hora, minut, segon);
                        h.equals(h2);
                    }
                }
                System.out.println("Hora actual:" + h.toString());

            } catch (InputMismatchException e) {
                System.out.println("Per favor introdueix una opcio valida");
                s.next();
                opcio = s.nextInt();
            }
        }

    }
}
