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
        Scanner s = new Scanner(System.in);
        System.out.println("Indiqui la primera distancia, en milimetres");
        Integer mm = s.nextInt(); //agaf els milimetres per consola
        System.out.println("Indiqui la segona distancia, en centimetres");
        Integer cm = s.nextInt(); //agaf els centimetres per consola
        System.out.println("Indiqui la tercera distancia, en metres");
        Integer m = s.nextInt(); //agaf els metres per consola
        Float sumaDistancies = ((float) mm / 10) + cm + ((float) m * 100); //faig la suma total
        System.out.println("La suma de les distancies en centimetres es " + sumaDistancies); //imprimesc per consola
    }
}
