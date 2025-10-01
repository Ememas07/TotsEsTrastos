/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class UD2ActExtra1MarcMas {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Introdueix una temperatura en graus Celsius");
        Integer temp = s.nextInt();
        if (temp <= 14) {
            System.out.println("Fa fred");
        } else if (temp >= 15 && temp <= 25) {
            System.out.println("Es templat");
        } else {
            System.out.println("Fa calor");
        }
    }
}
