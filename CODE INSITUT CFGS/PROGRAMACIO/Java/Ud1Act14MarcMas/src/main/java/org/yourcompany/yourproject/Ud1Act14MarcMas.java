/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class Ud1Act14MarcMas {

    public static void main(String[] args) {
        // Activitat 14
        /*Solicita a l’usuari tres distàncies:
        ○ La primera, en milímetres
        ○ La segona, en centímetres
        ○ La tercera, en metres
        ● Dissenya un programa que mostri la suma de les tres longituds en centímetres*/
        System.out.println("Indiqui la primera distancia, en milimetres");
        Scanner s = new Scanner(System.in);
        Integer distancia1 = s.nextInt();
        System.out.println("Indiqui la segona distancia, en centimetres");
        Scanner s2 = new Scanner(System.in);
        Integer distancia2 = s2.nextInt();
        System.out.println("Indiqui la tercera distancia, en metres");
        Scanner s3 = new Scanner(System.in);
        Integer distancia3 = s3.nextInt();
        Double sumaDistancies = ((double) distancia1 / 10) + distancia2 + ((double) distancia3 * 100);
        System.out.println("La suma de les distancies en centimetres es "+sumaDistancies);
        

    }
}
