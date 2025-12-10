/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 * Un anagrama és una paraula que resulta de canviar l'ordre dels caràcters
 * d'una altra.
 *
 * Exemples d'anagrama per a la paraula roma són: amor o mora.
 *
 *
 * Construeix un programa que demani a l'usuari dos paraules i indiqui si són
 * anagrames o no
 *
 * Per simplificar, ignora majúscules i caràcters accentuats
 *
 * @author Marc Mas
 */
public class Ud6Act9MarcMas {

    public static char llevarAccents(char c) {
        char cMinuscula = Character.toLowerCase(c); //convertim el caracter a minuscula i el guardam com un caracter nou
        switch (cMinuscula) { //miram el caracter, si és una vocal accentuada, entram al case respectiu
            case 'á', 'à' -> {
                if (cMinuscula == c) { //si el caracter original i en minuscula son iguals, retornam el caracter en minuscula, si no, en majuscula
                    return 'a';
                } else {
                    return 'A';
                }
            }
            case 'é', 'è' -> {
                if (cMinuscula == c) {
                    return 'e';
                } else {
                    return 'E';
                }
            }
            case 'í', 'ì' -> {
                if (cMinuscula == c) {
                    return 'i';
                } else {
                    return 'I';
                }
            }
            case 'ó', 'ò' -> {
                if (cMinuscula == c) {
                    return 'o';
                } else {
                    return 'O';
                }
            }
            case 'ù', 'ú' -> {
                if (cMinuscula == c) {
                    return 'u';
                } else {
                    return 'U';
                }
            }
        }
        return c; //si no hem entrat a cap case, retornam el caracter original
    }

    public static String llevarAccents(String frase) {
        String novaFrase = "";
        char caracter = ' ';
        for (int i = 0; i < frase.length(); i++) { //recorrem tot el string i feim la funcio llevarAccents per cada caracter
            caracter = llevarAccents(frase.charAt(i));
            novaFrase += caracter; //afegim els caracters a la nova frase
        }
        return novaFrase;
    }

    public static boolean estaAFrase(String frase, char caracter) {
        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == caracter) {
                return true;
            }
        }
        return false;
    }

    public static boolean comprovarAnagrames(String p1, String p2) {
        p1 = p1.toLowerCase(); //passsam paraules a minuscula i llevam accents
        p2 = p2.toLowerCase();
        p1 = llevarAccents(p1);
        p2 = llevarAccents(p2);
        for (int i = 0; i < p1.length(); i++) { //miram la paraula 1
            if (!estaAFrase(p2, p1.charAt(i))) {
                return false; //si el caracter no esta a la paraula 2 no pot ser un anagrama mai
            }
        }
        return true; //si no hem sortit abans, es un anagrama
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Programa per detectar anagrames");
        System.out.println("Introdueixi paraula 1");
        String p1 = s.next(); //demanam les dues paraules per consola
        System.out.println("Introdueixi paraula 2");
        String p2 = s.next();
        System.out.print("paraules " + p1 + " i " + p2);
        if (!comprovarAnagrames(p1, p2)) { //executam funcio, si el resultat es false, imprimim un no
            System.out.print(" no");
        }
        System.out.println(" son anagrames");
    }
}
