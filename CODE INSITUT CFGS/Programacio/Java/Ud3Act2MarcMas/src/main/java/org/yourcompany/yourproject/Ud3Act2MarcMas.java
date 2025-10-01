/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class Ud3Act2MarcMas {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Introdueixi una edat "); //deman el primer nombre per consola i l'agaf com a double
        Double n = s.nextDouble();
        Integer sumaTotal = 0; //inicialitzam variables
        Double mitjanaEdats = 0.0;
        Integer nombreAlumnes = 0;
        Integer majorsEdat = 0;
        while (n > 0) { //si n no es negatiu, entram
            nombreAlumnes++;
            sumaTotal += n.intValue();
            mitjanaEdats = sumaTotal / (double) nombreAlumnes;
            if (n >= 18) {
                majorsEdat++;
            }
            System.out.println("Introdueixi la seguent edat"); //deman el seguent nombre 
            n = s.nextDouble();
        }
        //un pic N es negatiu, surtim i donam totes les dades a l'usuari
        System.out.println("La suma total de les edats es"+sumaTotal);
        System.out.println("La mitjana de totes les edats es "+mitjanaEdats);
        System.out.println("Hi ha un total de "+nombreAlumnes+" alumnes");
        System.out.println("Hi ha un total de "+majorsEdat+" alumnes majors d'edat");
    }
}
