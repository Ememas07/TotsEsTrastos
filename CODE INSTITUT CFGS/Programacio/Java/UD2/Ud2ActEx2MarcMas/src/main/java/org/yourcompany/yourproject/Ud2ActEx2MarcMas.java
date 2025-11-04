/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class Ud2ActEx2MarcMas {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Introdueix la nota de l'alumne"); //informacio a l'usuari
        Float nota = s.nextFloat(); //la agafam per consola
        if (nota == 10) {
            System.out.println("Matricula d'honor"); //si la nota es un 10, es matricula d'honor
        } else if (nota < 10 && nota >= 9) {
            System.out.println("Notable"); //entre 9 i 10, notable
        } else if (nota < 9 && nota >= 5) { //entre 5 i 9, aprovat
            System.out.println("Aprovat");
        } else { //davall 5, suspes
            System.out.println("Suspes");
        }
    }
}
