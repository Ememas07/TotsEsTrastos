/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class UD2Act3MarcMas {

    public static void main(String[] args) {
        // Activitat 3
        Scanner s = new Scanner(System.in);
        System.out.println("Introdueixi un numero");
        Double n1 = s.nextDouble();
        if (n1 <= 1 && n1 >= -1 && n1 != 0) {
            System.out.println("El numero es quasi-zero");
        } else{
            System.out.println("El numero no es quasi-zero");
        }
    }
}
