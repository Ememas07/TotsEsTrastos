/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.elmeuprimerprojecte;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class Activitat5 {

    public static void main(String[] args) {
        // Activitat 5
        
        System.out.println("Mitjana aritmètica de dos enters");
        System.out.println("Numero 1");
        Scanner s = new Scanner(System.in);
        Integer nota1 = s.nextInt();
        System.out.println("Numero 2");
        Scanner s2 = new Scanner(System.in);
        Integer nota2 = s2.nextInt();
        Integer mitjaArit = (nota1 + nota2) / 2;
        System.out.println("La mitja de les teves notes es "+mitjaArit);        
        
    }
}
