/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 * Llegir una frase del teclat i que ens detecti si és capicua.
 *
 * Per a simplificar suposarem que no hi ha accents a la frase.
 *
 * Si l'usuari introdueix accents, el programa els ha de canviar per les vocals.
 * També s'han de llevar espais o caràcters estranys. Només volem lletres
 * bàsiques.
 *
 * Una paraula capicua o políndroma pot ser: “Anna”, “Llull” o la frase “Meló
 * volem” o “Avui veu que viu, va!”
 *
 * @author Marc Mas
 */
public class Ud6Act7MarcMas {

    public static char llevarAccents(char c) {
        char cMinuscula = Character.toLowerCase(c);
        switch (cMinuscula) {
            case 'á', 'à' -> {
                if (cMinuscula == c) {
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
        return c;
    }

    public static String llevarAccents(String frase) {
        String novaFrase = "";
        char caracter = ' ';
        for (int i = 0; i < frase.length(); i++) { //recorrem tot el string de forma inversa, del final cap al principi
            caracter = llevarAccents(frase.charAt(i));
            novaFrase += caracter; //afegim els caracters a la nova frase
        }
        return novaFrase;
    }

    public static String llevarEspais(String frase) {
        String novaFrase = "";
        for (int i = 0; i < frase.length(); i++) { //recorrem tot el string de forma inversa, del final cap al principi
            if (!Character.isWhitespace(frase.charAt(i))) {
                novaFrase += frase.charAt(i); //afegim els caracters a la nova frase
            }
        }
        return novaFrase;
    }

    public static String inversor(String frase) {
        String fraseInvertida = "";
        char caracter = ' ';
        for (int i = frase.length() - 1; i > -1; i--) { //recorrem tot el string de forma inversa, del final cap al principi
            fraseInvertida += caracter; //afegim els caracters a la frase invertida
        }
        return fraseInvertida;
    }

    public static boolean sonIguals(String frase1, String frase2) {
        if (frase1.length() != frase2.length()) {
            return false;
        }
        for (int i = 0; i < frase1.length(); i++) {
            if (frase1.charAt(i) != frase2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Comprovador de frases capicua");
        System.out.println("Introdueixi la seva frase");
        String frase = s.nextLine(); //agafam la frase per consola
        frase = llevarAccents(frase);
        System.out.print("La frase \"" + frase + "\" ");
        if (!sonIguals(frase, inversor(frase))) {
            System.out.print("no ");
        }
        System.out.println("es capicua");
    }
}
