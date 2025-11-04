/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class Ud2Act1MarcMas {

    public static void main(String[] args) {
        // Activitat 1
        System.out.println("Introdueixi un numero positiu o negatiu");
        Scanner s = new Scanner(System.in);
        Integer n1 = s.nextInt();
        String parellImparell = "Parell"; //Pos parell per començar
        if (Math.abs(n1) % 2 == 1) { //Comprov si es divisible entre 2 o no
            parellImparell = "Imparell"; //Si no es parell, canvii la variable
        }
        String positiuNegatiu = "Negatiu"; //Inicialitz com a negatiu
        if (n1 > 0) {
            positiuNegatiu = "Positiu"; //Si es positiu, ho canvii, si no, no
        }
        System.out.println("El numero es "+positiuNegatiu+" i "+parellImparell);
        
    }
}
