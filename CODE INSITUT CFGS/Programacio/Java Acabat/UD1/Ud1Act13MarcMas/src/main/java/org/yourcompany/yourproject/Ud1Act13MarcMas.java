/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class Ud1Act13MarcMas {

    public static void main(String[] args) {
        // Activitat 13
        Scanner s = new Scanner(System.in);
        System.out.println("Indica un numero"); //deman el nombre per consola
        Float numero = s.nextFloat();
        Float ivaNumero = (float) (numero * 0.21); //multiplic per 0.21 per saber només l'IVA
        Float sumaTotal = numero + ivaNumero; //conseguesc la suma total suamnt l'iVA al producte
        System.out.println("L'IVA del teu producte es " + ivaNumero + " i el total seria de " + sumaTotal); //ho imprimesc
    }
}
