/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 * Dissenyar una aplicació que demani l'usuari que introdueixi una frase per
 * teclat i la mostri invertida.
 *
 * Per exemple: “Hola mon” seria “nom aloH”
 *
 * @author Marc Mas
 */
public class Ud6Act4MarcMas {

    public static String inversor(String frase) {
        String fraseInvertida = "";
        for (int i = frase.length() - 1; i > -1; i--) { //recorrem tot el string de forma inversa, del final cap al principi
            fraseInvertida += frase.charAt(i); //afegim els caracters a la frase invertida
        }
        return fraseInvertida;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Inversor de frases");
        System.out.println("Introdueixi la seva frase");
        String frase = s.nextLine(); //agafam la frase per consola
        System.out.println("La teva frase al reves seria: " + inversor(frase)); // imprimim la sortida de la funcio
    }
}
