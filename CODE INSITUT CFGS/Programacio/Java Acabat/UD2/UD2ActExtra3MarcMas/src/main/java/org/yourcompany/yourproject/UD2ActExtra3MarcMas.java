/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class UD2ActExtra3MarcMas {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Introdueix la nota de l'alumne");
        Double nota = s.nextDouble();
        if (nota == 10) {
            System.out.println("Matricula d'honor");
        } else if (nota < 10 && nota >= 9) {
            System.out.println("Notable");
        } else if (nota < 9 && nota >= 5) {
            System.out.println("Aprovat");
        } else {
            System.out.println("Suspes");
        }
    }
}
