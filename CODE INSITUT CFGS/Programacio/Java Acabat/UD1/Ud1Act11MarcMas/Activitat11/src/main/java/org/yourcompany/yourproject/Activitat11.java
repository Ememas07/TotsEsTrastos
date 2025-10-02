/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class Activitat11 {

    public static void main(String[] args) {
        // Activitat 11

        Scanner s = new Scanner(System.in);
        System.out.println("Nota 1"); //deman la primera nota per consola
        Byte nota1 = s.nextByte();
        System.out.println("Nota 2"); //deman la segona nota per consola
        Byte nota2 = s.nextByte();
        System.out.println("Nota 3"); //deman la tercera nota per consola
        Byte nota3 = s.nextByte();
        Float mitjaDecimals = ((float) nota1 + (float) nota2 + (float) nota3) / 3; //calcul la mitjana amb decimals
        Byte mitjaEnters = mitjaDecimals.byteValue(); // de la mitjana amb decimals trec la mitjana sense decimals
        System.out.println("La teva mitja amb decimals es " + mitjaDecimals);
        System.out.println("La teva mitja sense decimals es " + mitjaEnters);

    }
}
