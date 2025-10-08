/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class Ud3Act5MarcMas {

    public static void main(String[] args) {
        System.out.println("Joc per millorar la suma mental");
        System.out.println("Introdueix la suma correcta per continuar.");
        System.out.println("En cas d'error, el joc acabara");
        Scanner s = new Scanner(System.in);
        Short puntuacio = -1; //inicialitzam variables, puntuacio comença a -1 perque en el bucle suma 1 la primera vegada hagui encertat o no
        Integer suma1 = 0;
        Integer suma2 = 0;
        Integer solucio = 0;
        Byte input = 0;
        do {
            suma1 = 1 + (int) (Math.random() * 10);
            suma2 = 1 + (int) (Math.random() * 10);
            // Math.random genera un nombre entre 0.0 i 1.0,
            // el multiplicare per 10 per tenir un valor entre 0 i 10
            // i sumaré 1 perque sigui entre 1 i 10
            solucio = suma1 + suma2; // calcul la solucio correcta
            System.out.println(suma1 + " + " + suma2 + " = ?"); //deman el nombre per consola i l'agaf com a byte
            input = s.nextByte();
            puntuacio++;
        } while ((int) input == solucio);
        System.out.println("La teva puntuacio es de " + puntuacio + " Punts");
    }
}

