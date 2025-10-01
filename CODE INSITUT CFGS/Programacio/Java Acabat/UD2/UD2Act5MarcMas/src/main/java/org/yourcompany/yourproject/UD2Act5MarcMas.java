/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class UD2Act5MarcMas {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Nombre A");
        Double numA = s.nextDouble();
        System.out.println("Nombre B");
        Double numB = s.nextDouble();
        System.out.println("Nombre C");
        Double numC = s.nextDouble();
        Double resultat1 = ((-numB + Math.sqrt(Math.pow(numB, 2) - (4 * numA * numC))) / (2 * numA));
        Double resultat2 = ((-numB - Math.sqrt(Math.pow(numB, 2) - (4 * numA * numC))) / (2 * numA));
        System.out.println("El resultat positiu es " + resultat1);
        System.out.println("El resultat negatiu es " + resultat2);      
    }
}
