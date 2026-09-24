/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 * Fes un programa que demani un text a l'usuari i indiqui, per a cada lletra
 * que apareix a la frase, quantes vegades hi apareix.
 *
 * Per a simplificar converteix tot el text a minúscules i substitueix els
 * caràcters accentuats per aquells no accentuats.
 *
 * @author Marc Mas
 */
public class Ud6Act10MarcMas {

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

    public static int contadorVegades(String frase, char caracter) {
        int vegades = 0;
        for (int i = 0; i < frase.length(); i++) { //miram tota la frase
            if (frase.charAt(i) == caracter) { //si el caracter es el que esteim comprovant, sumam una vegada
                vegades++;
            }
        }
        return vegades;
    }

    public static void contadorVegades(String frase) {
        frase = frase.toLowerCase(); //passsam paraula a minuscula i llevam accents
        frase = llevarAccents(frase);
        String caractersComprovats = "";
        for (int i = 0; i < frase.length(); i++) { //recorrem la paraula
            char caracter = frase.charAt(i);
            if (contadorVegades(caractersComprovats, caracter) == 0) { //si no esta comprovat ja
                System.out.println("El caracter \"" + caracter + "\" apareix " + contadorVegades(frase, caracter) + " vegades ");
                caractersComprovats += caracter; //afegim el caracter a un string de caracters comprovats per no revisar la mateixa lletra dues vegades
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Introdueixi la frase per contar");
        String frase = s.nextLine(); //demanam la frase
        contadorVegades(frase); //executam la funcio
    }
}
