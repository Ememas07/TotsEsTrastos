/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class UD2Act2MarcMas {

    public static void main(String[] args) {
        // Activitat 2
        Scanner s = new Scanner(System.in);
        System.out.println("Introdueixi un numero");
        Integer n1 = s.nextInt();
        System.out.println("Introdueixi un altre numero");
        Integer n2 = s.nextInt();
        if (n1 == n2) {
            System.out.println("El numeros son iguals");
        } else {
            System.out.println("El numeros no son iguals");
        }
    }
}
