/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class Ud3Act1MarcMas {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Introdueixi un numero"); //deman el primer nombre per consola i l'agaf com a double
        float n = s.nextFloat();
        while (n != 0) { //si n NO es 0, entram
            if (n % 2 == 0) { //si el nombre es divisible entre 0 es parell
                System.out.println("El nombre es Parell");
            } else { // si no, imparell
                System.out.println("El nombre es Senar");
            }
            System.out.println("El teu nombre al quadrat es " + Math.pow(n, 2)); //calcul el nombre al quadrat
            System.out.println("Introdueixi un numero"); //deman el seguent nombre 
            n = s.nextFloat();
        }
    }
}
