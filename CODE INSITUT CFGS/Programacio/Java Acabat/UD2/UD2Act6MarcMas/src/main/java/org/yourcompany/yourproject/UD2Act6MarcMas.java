/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class UD2Act6MarcMas {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Introdueix un numero entre -99.999 i 99.999");
        Integer numero = s.nextInt();
        if (numero > 99999 || numero < -99999) {
            System.out.println("Nombre massa gran");
        } else {
            if (numero < 0) {
                numero = -numero;
            }
            String llargaria = numero.toString();
            System.out.println("El teu numero te " + llargaria.length() + " xifres");
        }
    }
}
