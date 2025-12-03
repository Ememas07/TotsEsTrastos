/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 * Introduir per el teclat dues frases i dir quina és la més curta
 *
 * @author Marc Mas
 */
public class Ud6Act1MarcMas {

    public static void main(String[] args) {
        System.out.println("Comprovador de quina frase es mes curta");
        Scanner s = new Scanner(System.in);
        System.out.println("Introdueixi frase 1:");
        String frase1 = s.nextLine(); //recollim les dues frases per consola
        System.out.println("Introdueixi frase 2:");
        String frase2 = s.nextLine();
        if (frase1.length() == frase2.length()) { //si les frases son iguals, mostram que ho són
            System.out.println("Les dues frases son iguals de llargues");
        } else if (frase1.length() > frase2.length()) {
            System.out.println("La frase 2 es mes curta"); //si la frase1 es mes llarga, frase 2 es mes curta
        } else {
            System.out.println("La frase 1 es mes curta"); //si no son igual de llargues i frase1 NO es mes llarga, ido frase1 es mes curta
        }
    }
}
