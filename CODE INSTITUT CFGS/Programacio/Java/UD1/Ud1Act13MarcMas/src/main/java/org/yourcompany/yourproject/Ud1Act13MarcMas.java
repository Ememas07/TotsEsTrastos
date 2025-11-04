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
        final Double IVA = 0.21;
        // Activitat 13
        Scanner s = new Scanner(System.in);
        System.out.println("Introdueixi 3");
        System.out.println("Opcio 1: Calcular l'IVA d'un preu sense IVA");
        System.out.println("Opcio 2: Calcular quina part d'un preu total es IVA");
        System.out.println("introdueix 1  o 2");
        Byte seleccio = s.nextByte();
        switch (seleccio) {
            case 1:
                System.out.println("Calculadora de preu amb IVA");
                System.out.println("Indica un preu"); // deman el nombre per consola
                Float preu = s.nextFloat();
                Float ivaPreu = (float) (preu * IVA); // multiplic per 0.21 per saber només l'IVA
                Float sumaTotal = preu + ivaPreu; // conseguesc la suma total suamnt l'iVA al producte
                System.out.println("L'IVA del teu producte es " + ivaPreu + " i el total seria de " + sumaTotal); // ho imprimesc
                break;
            case 2:
                System.out.println("Calculadora de IVA d'un preu total");
                System.out.println("Indica el preu total"); // deman el nombre per consola
                Float preuTotal = s.nextFloat();
                Float iva = (float) (preuTotal - (preuTotal / (IVA + 1))); // multiplic per 0.21 per saber només l'IVA
                System.out.println("L'IVA del teu producte es " + iva); // ho imprimesc
                break;
            default:
                System.out.println("Entrada incorrecte");
        }
    }
}
