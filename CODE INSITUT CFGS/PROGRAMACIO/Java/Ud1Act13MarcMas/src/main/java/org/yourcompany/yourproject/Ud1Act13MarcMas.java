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
        System.out.println("Indica un numero");
        Scanner s = new Scanner(System.in);
        Double numero = s.nextDouble();
        Double ivaNumero = numero*0.21;
        Double sumaTotal = numero + ivaNumero;
        System.out.println("L'IVA del teu producte es "+ivaNumero+" i el total seria de "+sumaTotal);
        
    }
}
