/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 * Dissenya la funció: int maxim(int t[]),
 *
 * que retorni el valor màxim de la taula t.
 *
 * @author Marc Mas
 */
public class Ud5Act4MarcMas {

    public static int maxim(int t[]) {
        int maxim = 0; //inicialitzam valor que despres retornare
        for (int i = 0; i < t.length; i++) {  //recorrem l'array
            if (t[i] > maxim) { //si el valor on provam es MAJOR que el maxim actual
                maxim = t[i]; // assignam el valor maxim a aquest valor
            }
        }
        return maxim; //retornam el maxim

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("quants de nombres vol introduir?"); //demanam mida array
        int midaArray = 0;
        midaArray = s.nextInt();
        int arrayNombres[] = new int[midaArray]; //cream array amb la mida introduida per l'usuaro
        for (int i = 0; i < arrayNombres.length; i++) { //recorrem l'array i l'omplim amb ints
            System.out.println("Introdueixi un nombre enter");
            arrayNombres[i] = s.nextInt();
        }
        System.out.println(maxim(arrayNombres));
    }
}
