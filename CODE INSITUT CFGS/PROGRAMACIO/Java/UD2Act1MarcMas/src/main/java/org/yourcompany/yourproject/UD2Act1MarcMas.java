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
        String parellImparell;
        if (n1 % 2 == 1) {
            parellImparell = "Imparell";          
        }else{
            parellImparell = "Parell";          
        }
        if (n1 > 0) {
            System.out.println("El numero es positiu i "+parellImparell);
        } else{
            System.out.println("El numero es negatiu i "+parellImparell);
        }
        
    }
}
