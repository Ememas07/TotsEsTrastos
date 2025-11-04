/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class Ud2ActEx1MarcMas {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Introdueix una temperatura en graus Celsius"); //informacio a l'usuari
        Integer temp = s.nextInt(); //agafam per consola
        if (temp <= 14) { //si esta per davall de 14 o a 14, fa fred
            System.out.println("Fa fred");
        } else if (temp >= 15 && temp <= 25) { //si esta entre 15 i 25 (inclosos), es templat
            System.out.println("Es templat");
        } else { //si no, fa calor (mes de 25)
            System.out.println("Fa calor");
        }
    }
}
