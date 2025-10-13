/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class Ud2Act3MarcMas {

    public static void main(String[] args) {
        // Activitat 3
        System.out.println("Comprovador de numeros quasi-zero");
        Scanner s = new Scanner(System.in);
        System.out.println("Introdueixi un numero");
        Float n1 = s.nextFloat(); // Llegesc input d'usuari
        if (n1 < 1 && n1 > -1 && n1 != 0) { //si el nombre es major a -1, menor que 1, i no es 0 és quasi-zero
            System.out.println("El numero es quasi-zero");
        } else {
            System.out.println("El numero no es quasi-zero");
        }
    }
}
