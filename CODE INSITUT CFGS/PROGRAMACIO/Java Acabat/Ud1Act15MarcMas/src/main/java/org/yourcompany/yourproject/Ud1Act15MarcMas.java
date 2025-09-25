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
        System.out.println("Indiqui el nombre de formigues");
        Scanner s = new Scanner(System.in);
        Integer nFormigues = s.nextInt();
        System.out.println("Indiqui el nombre de aranyes");
        Scanner s2 = new Scanner(System.in);
        Integer nAranyes = s2.nextInt();
        System.out.println("Indiqui el nombre de centpeus");
        Scanner s3 = new Scanner(System.in);
        Integer nCentpeus = s3.nextInt();
        Double sumaPotes = (double) nFormigues * 6 + (double) nAranyes * 8 + (double) nCentpeus * 100;
        System.out.println("La suma de les potes es "+sumaPotes);
    }
}
