/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class Ud1Act15MarcMas {

    public static void main(String[] args) {
        // Activitat 15
        System.out.println("Calculadora de potes capturades");
        Scanner s = new Scanner(System.in); 
        System.out.println("Indiqui el nombre de formigues capturades ");
        Short nFormigues = s.nextShort(); //agaf nombre per consola
        System.out.println("Indiqui el nombre de aranyes capturades");
        Short nAranyes = s.nextShort(); //agaf nombre per consola
        System.out.println("Indiqui el nombre de centpeus capturades");
        Short nCentpeus = s.nextShort(); //agaf nombre per consola
        Float sumaPotes = (float) nFormigues * 6 + (float) nAranyes * 8 + (float) nCentpeus * 100; //faig la suma de totes les potes
        System.out.println("La suma de les potes es " + sumaPotes); // imprimesc per pantalla
    }
}
