/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class UD2Act1MarcMas {

    public static void main(String[] args) {
        // Activitat 1
        System.out.println("Introdueixi un numero positiu o negatiu");
        Scanner s = new Scanner(System.in);
        Integer n1 = s.nextInt();
        String parellImparell = "Parell";         
        if (Math.abs(n1) % 2 == 1) {
            parellImparell = "Imparell";          
        }
        String positiuNegatiu = "Negatiu";
        if (n1 > 0) {
            positiuNegatiu = "Positiu";
        }
        System.out.println("El numero es "+positiuNegatiu+" i "+parellImparell);
        
    }
}
