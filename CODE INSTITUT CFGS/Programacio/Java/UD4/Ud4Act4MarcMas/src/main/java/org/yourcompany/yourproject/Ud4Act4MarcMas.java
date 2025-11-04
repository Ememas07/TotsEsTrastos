/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 * Escriure una funció booleana, de nom esVocal, a la qual se li passa un
 * caràcter i la funció retorna si és vocal
 *
 * @author Marc Mas
 */
public class Ud4Act4MarcMas {

    private static boolean esVocal(char c) { //funcio que ens retorna si un valor es vocal o no
        return switch (c) {
            case 'a', 'e', 'i', 'o', 'u' ->
                true; //si el caracter es una vocal retornam true
            default ->
                false; //si no, false
        };

    }

    public static void main(String[] args) {

        System.out.println("Programa per comprovar si un caracter es una vocal"); //informacio a l'usuari
        System.out.println("Introdueix un caracter");
        Scanner s = new Scanner(System.in); //iniciam scanner
        // System.out.println(esVocal('t')); //executam la funció (versio basica)
        Character c = s.next().charAt(0);
        System.out.println("El caracter '" + c + "' es una vocal? " + esVocal(c));
    }
}
