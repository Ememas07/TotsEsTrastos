/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license


Dissenyeu la classe Hora, que representa un instant de temps compost per l'hora
(d'0 a 23) i els minuts. Disposa dels mètodes:

Hora (hora, minut), que construeix un objecte amb les dades passades com a paràmetres.

void inc(), que incrementa l'hora en un minut. 

boolean setMinuts (valor), que assigna un valor, si és vàlid, als
minuts. Torna true o false segons hagueu pogut modificar els minuts o
no.


boolean setHora (valor), que assigna un valor, si està comprès entre
0 i 23, a l'hora. Torna true o false segons hagueu pogut canviar l'hora o
no.

String toString(), que torna un String amb la representació de
l'hora.

 */
package org.yourcompany.yourproject;

import java.util.InputMismatchException;
import java.util.Scanner;

// import org.yourcompany.Hora.Hora;

/**
 *
 * @author Marc Mas
 */
public class Ud8Act1HerenciaMarcMas {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Introdueixi el valor de hores");
        int h = s.nextInt();
        System.out.println("Introdueixi el valor de minuts");
        int m = s.nextInt();
        // Hora hora = new Hora(h, m);
        int opcio = 1;
        while (opcio > 0) { //-1 sortira
            try {
                System.out.println("1: Augmentar minuts");
                System.out.println("2: Posar minuts");
                System.out.println("3: Posar hores");
                System.out.println("4: Mostrar hora exacta");
                opcio = s.nextInt();
                switch (opcio) {
                    case 1 -> { //Augmentar Minuts
                        // hora.inc();
                    }
                    case 2 -> { //Posar Minuts
                        System.out.println("Introdueixi el minut que vol assignar");
                        m = s.nextInt();
                        // hora.setMinuts(m);
                    }
                    case 3 -> { //Posar Hores
                        System.out.println("Introdueixi la hora que vol assignar");
                        h = s.nextInt();
                        // hora.setHora(h);
                    }
                }
                // System.out.println("Hora actual:" + hora.toString());

            } catch (InputMismatchException e) {
                System.out.println("Per favor introdueix una opcio valida");
            }
        }

    }
}
