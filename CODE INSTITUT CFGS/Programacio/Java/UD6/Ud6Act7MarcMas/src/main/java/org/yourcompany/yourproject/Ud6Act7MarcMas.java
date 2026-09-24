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

    public static String llevarEspais(String frase) {
        String novaFrase = "";
        for (int i = 0; i < frase.length(); i++) {
            if (!Character.isWhitespace(frase.charAt(i))) { //recorrem tot el string, si trobam un caracter que NO es un whitespace, el posam a la frase nova, i evitam els espais
                novaFrase += frase.charAt(i); //afegim els caracters a la nova frase
            }
        }
        return novaFrase;
    }

    public static String llevarPuntuacio(String frase) {
        String novaFrase = "";
        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) != '.' && frase.charAt(i) != ',') { //recorrem tot el string, si el caracter NO es un . o una , l'afegim a la nova frase, eliminant punts i comes
                novaFrase += frase.charAt(i);
            }
        }
        return novaFrase;
    }

    public static String inversor(String frase) {
        String fraseInvertida = "";
        for (int i = frase.length() - 1; i > -1; i--) { //recorrem tot el string de forma inversa, del final cap al principi
            fraseInvertida += frase.charAt(i); //afegim els caracters a la frase invertida
        }
        return fraseInvertida;
    }

    public static boolean sonIguals(String frase1, String frase2) {
        if (frase1.length() != frase2.length()) { //si les llargaries no son iguals, els strings tampoc
            return false;
        }
        for (int i = 0; i < frase1.length(); i++) { //recorrem tot el string
            if (frase1.charAt(i) != frase2.charAt(i)) { //si un caracter no coincideix, retornam false
                return false;
            }
        } 
        return true; //si tots han coincidit, els strings son iguals
    }

    public static String netejar(String frase) { //llevam accents, puntuacio, i passam la frase a minuscula 
        frase = llevarAccents(frase); 
        frase = llevarEspais(frase);
        frase = llevarPuntuacio(frase);
        frase = frase.toLowerCase();
        return frase;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Comprovador de frases capicua");
        System.out.println("Introdueixi la seva frase");
        String frase = s.nextLine(); //agafam la frase per consola
        String fraseNeta = netejar(frase); //agafam una frase i la passam a neta, per comprovar si es capicua
        System.out.print("La frase \"" + frase + "\" ");
        if (!sonIguals(fraseNeta, inversor(fraseNeta))) { //si la fraseNeta i la fraseNeta al reves NO son iguals, la frase no es capicua
            System.out.print("no ");
        }
        System.out.println("es capicua");
    }
}
