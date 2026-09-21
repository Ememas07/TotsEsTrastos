/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Crear una llista de nombres enters positius introduits per consola fins que
 * entri un de negatiu. A continuació, recórrer la llista i mostrar per pantalla
 * els indexs dels elements de valor par, que serà multiplicat per 100.
 *
 * @author Marc Mas
 */
public class Ud11Act9MarcMas {

    public static void main(String[] args) {
        ArrayList<Integer> llista = new ArrayList();
        Scanner s = new Scanner(System.in);
        System.out.println("Introdueixi nombres enters per omplir la coleccio, Introdueixi un nombre negatiu per aturar");
        int n = 1;
        while (n > 0) {
            n = s.nextInt();
            if (n > 0) {
                llista.add(n);
            }
        }
        System.out.println("Llista desordenada: "+llista.toString());
        System.out.println("Valors pars: ");
        for (int i = 0; i < llista.size(); i++) {
            if (llista.get(i) % 2 == 0) {
                System.out.print((i * 100)+" ");
            }
        }
        System.out.println("");

    }
}
