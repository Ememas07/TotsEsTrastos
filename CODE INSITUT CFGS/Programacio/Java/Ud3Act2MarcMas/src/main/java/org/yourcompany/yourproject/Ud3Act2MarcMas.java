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
        float n = s.nextFloat();
        Integer sumaTotal = 0; //inicialitzam variables
        Float mitjanaEdats = (float) 0;
        Byte nombreAlumnes = 0;
        Byte majorsEdat = 0;
        while (n > 0) { //si n no es negatiu, entram
            nombreAlumnes++;
            sumaTotal += (int) n;
            if (n >= 18) {
                majorsEdat++;
            }
            System.out.println("Introdueixi la seguent edat"); //deman el seguent nombre 
            n = s.nextFloat();
        }
        mitjanaEdats = sumaTotal / (float) nombreAlumnes;
        //un pic N es negatiu, surtim i donam totes les dades a l'usuari
        System.out.println("La suma total de les edats es " + sumaTotal);
        System.out.println("La mitjana de totes les edats es " + mitjanaEdats);
        System.out.println("Hi ha un total de " + nombreAlumnes + " alumnes");
        System.out.println("Hi ha un total de " + majorsEdat + " alumnes majors d'edat");
    }
}
