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
        String frase1 = s.next();
        System.out.println("Introdueixi frase 2:");
        String frase2 = s.next();
        System.out.println(frase1);
        System.out.println(frase2);
        if (frase1.length() == frase2.length()) {
            System.out.println("Les dues frases son iguals de llargues");
        } else if (frase1.length() > frase2.length()) {
            System.out.println("La frase 2 es mes curta");
        } else {
            System.out.println("La frase 1 es mes curta");
        }
    }
}
