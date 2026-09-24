/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class Ud1Act11MarcMas {

    public static void main(String[] args) {
        // Activitat 11
        Scanner s = new Scanner(System.in);
        System.out.println("Introdueixi 3 notes per a calcular la mitja amb decimals i sense decimals");
        System.out.println("Vols resoldre amb una variable o amb 5? introdueix 1 per 1 variable o 2 per més d'una variable");
        Byte seleccio = s.nextByte();
        switch (seleccio) {
            case 1:
                System.out.println("Nota 1"); //deman la primera nota per consola
                Float n1 = s.nextFloat();
                System.out.println("Nota 2"); //deman la segona nota per consola
                n1 += s.nextFloat();
                System.out.println("Nota 3"); //deman la tercera nota per consola
                n1 += s.nextFloat();
                n1 = n1 / 3;
                System.out.println("La teva mitja amb decimals es " + n1); // imprimesc per consola
                n1 = (float) Math.round(n1);
                System.out.println("La teva mitja sense decimals es " + n1); // imprimesc per consola
                break;
            case 2:
                System.out.println("Nota 1"); //deman la primera nota per consola
                Byte nota1 = s.nextByte();
                System.out.println("Nota 2"); //deman la segona nota per consola
                Byte nota2 = s.nextByte();
                System.out.println("Nota 3"); //deman la tercera nota per consola
                Byte nota3 = s.nextByte();
                Float mitjaDecimals = ((float) nota1 + (float) nota2 + (float) nota3) / 3; //calcul la mitjana amb decimals
                Byte mitjaEnters = mitjaDecimals.byteValue(); // de la mitjana amb decimals trec la mitjana sense decimals
                System.out.println("La teva mitja amb decimals es " + mitjaDecimals); // imprimesc per consola
                System.out.println("La teva mitja sense decimals es " + mitjaEnters); // imprimesc per consola
                break;
            default:
                System.out.println("Nombre invalid");
        }
    }
}
