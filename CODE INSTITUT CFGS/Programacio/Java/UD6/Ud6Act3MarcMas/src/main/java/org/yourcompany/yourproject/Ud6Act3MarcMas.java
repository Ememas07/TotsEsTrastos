/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 * Dissenyar una aplicació que demani l'usuari que introdueixi una frase per
 * teclat i indiqui el nombre d'espais en blanc que té
 *
 * @author Marc Mas
 */
public class Ud6Act3MarcMas {

    public static int contadorEspais(String frase) {
        int espais = 0; //variable per contar espais
        for (int i = 0; i < frase.length(); i++) { //recorrem tot el string
            if (Character.isSpaceChar(frase.charAt(i))) { //si es un espai, afegim 1 al contador
                espais++;
            }
        }
        return espais;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Contador d'espais a una frase");
        System.out.println("Introdueixi la seva frase");
        String frase = s.nextLine(); //agafam frase per console
        System.out.println("La teva frase te " + contadorEspais(frase) + " espais"); //imprimim a l'usuari
    }
}
