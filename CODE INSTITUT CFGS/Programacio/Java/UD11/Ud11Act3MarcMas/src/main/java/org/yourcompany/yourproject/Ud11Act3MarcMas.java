/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class Ud11Act3MarcMas {

    public static void main(String[] args) {
        Contenidor<Integer> contenidor = new Contenidor();
        Scanner s = new Scanner(System.in);
        System.out.println("Introdueixi nombres enters per omplir la pila, Introdueixi un nombre negatiu per atura");
        int n = s.nextInt();
        contenidor.push(n);
        while (n > 0) {
            n = s.nextInt();
            contenidor.push(n);
        }
        while (!contenidor.esBuida()) {
            Integer num = contenidor.pop();
            System.out.println(num);
        }

    }
}
