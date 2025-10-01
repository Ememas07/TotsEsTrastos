/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.elmeuprimerprojecte;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class Activitat11 {

    public static void main(String[] args) {
        // Activitat 11

        System.out.println("Nota 1");
        Scanner s = new Scanner(System.in);
        Integer nota1 = s.nextInt();
        System.out.println("Nota 2");
        Scanner s2 = new Scanner(System.in);
        Integer nota2 = s2.nextInt();
        System.out.println("Nota 3");
        Scanner s3 = new Scanner(System.in);
        Integer nota3 = s3.nextInt();
        Double mitjaDecimals = (nota1.doubleValue() + nota2.doubleValue() + nota3.doubleValue()) / 3;
        Integer mitjaEnters = (nota1 + nota2 + nota3) / 3;
        System.out.println("La teva mitja amb decimals es "+mitjaDecimals);
        System.out.println("La teva mitja sense decimals es "+mitjaEnters);
        
    }
}
