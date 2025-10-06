/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class Activitat5 {

   public static void main(String[] args) {
        // Activitat 5
        
        System.out.println("Mitjana aritmetica de dos enters");
        Scanner s = new Scanner(System.in); 
        System.out.println("Numero 1"); //Deman la primera nota 
        Double nota1 = s.nextDouble();
        System.out.println("Numero 2"); //Deman la segona nota
        Double nota2 = s.nextDouble();
        Double mitjaArit = (nota1 + nota2) / 2; //Faig la mitja
        System.out.println("La mitja de les teves notes es "+mitjaArit); //La imprimesc per pantalla        
        
    }
}
