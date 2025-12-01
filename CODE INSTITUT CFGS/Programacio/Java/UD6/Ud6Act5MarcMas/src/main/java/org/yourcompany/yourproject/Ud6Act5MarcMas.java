/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 * Escriure un programa que demani el nom complet a l'usuari i el mostri sense
 * cap vocal, sigui majúscula, minúscula o amb accents.
 *
 * @author Marc Mas
 */
public class Ud6Act5MarcMas {

    public static boolean esVocal(char c) {
        c = Character.toLowerCase(c);
        switch (c) {
            case 'a', 'á', 'à', 'e', 'é', 'è', 'i', 'í', 'ì', 'o', 'ó', 'ò', 'u', 'ù', 'ú' -> { //si el caracter es una vocal 
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    public static String reconversor(String frase) {
        String nomNou = "";
        for (int i = 0; i < frase.length(); i++) { //recorrem tot el string
            if (!esVocal(frase.charAt(i))) { //si no es vocal, l'afegim al nou string
                nomNou += frase.charAt(i);
            }
        }
        return nomNou;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Aquest programa retornara el seu nom sense vocals");
        System.out.println("Introdueixi el seu nom complet");
        String frase = s.nextLine(); //agafam la frase per consola
        System.out.println(frase);
        System.out.println("El seu nom sense vocals seria: " + reconversor(frase)); // imprimim per l'usuari
    }
}
