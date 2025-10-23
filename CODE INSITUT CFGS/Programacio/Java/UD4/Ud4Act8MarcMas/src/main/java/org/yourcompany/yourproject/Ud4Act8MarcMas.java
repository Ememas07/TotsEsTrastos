/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 * RECURSIVITAT
 *
 * Crea la funció mostraPars(int n) que mostri per consola els primers n nombres
 * parells.
 *
 * @author Marc Mas
 */
public class Ud4Act8MarcMas {

    public static void mostraPars(int n) {
        if (n != 0) {
            n -= 1;
            System.out.print(n * 2 + ", ");
            mostraPars(n);
        }
    }

    public static void main(String[] args) {
        System.out.println("Programa per mostrar per consola els primers N nombres parells"); //informacio a l'usuari
        Scanner s = new Scanner(System.in); //iniciam scanner
        System.out.println("Quants de nombres parells vols?"); // demanam primer nombre
        Integer n = s.nextInt(); //assignam
        mostraPars(n);
    }
}
