/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 * Fer un programa que demani a l'usuari quants nombres vol introduir.
 *
 * A continuació, introduir per teclat aquella quantitat de nombres enters.
 *
 * A continuació, mostrar els nombres en l'ordre invers al que s'han introduït
 *
 * @author Marc Mas
 */
public class Ud5Act3MarcMas {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Quants de nombres vol introduir?"); //demanam mida array
        int midaArray = 0;
        midaArray = s.nextInt();
        int arrayNombres[] = new int[midaArray]; //cream array amb la mida introduida per l'usuari
        for (int i = 0; i < arrayNombres.length; i++) { //recorrem l'array i l'omplim amb ints
            System.out.println("Introdueixi un nombre enter");
            arrayNombres[i] = s.nextInt();
        }
        for (int i = arrayNombres.length - 1; i >= 0; i--) { //recorrem array amb ordre invers, amb >= perque també volem el valor a 0
            System.out.print(arrayNombres[i] + ", "); //anam imprimint tots els valors
        }
    }
}
