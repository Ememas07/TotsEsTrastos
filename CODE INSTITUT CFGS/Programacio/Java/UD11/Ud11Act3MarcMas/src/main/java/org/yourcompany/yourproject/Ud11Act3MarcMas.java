/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 * Definir la interfície Pila amb paràmetre genèrics. A continuació implementar
 * la interfície Pila genèrica en la classe Contenidor
 *
 * Per últim, escriure un programa on s'empri un objecte contenidor com a pila.
 *
 * Dins la pila apilem nombres enters llegits del teclat fins que s'hi
 * introdueixi un nombre negatiu
 *
 * Després, mitjançant un bucle es desapilen tots els nombres fins que la pila
 * sigui buida i els mostrem per consola.
 *
 * @author Marc Mas
 */
public class Ud11Act3MarcMas {

    public static void main(String[] args) {
        Contenidor<Integer> contenidor = new Contenidor();
        Scanner s = new Scanner(System.in);
        System.out.println("Introdueixi nombres enters per omplir la pila, Introdueixi un nombre negatiu per aturar");
        int n = 1;
        while (n > 0) {
            n = s.nextInt();
            if (n > 0) {
                contenidor.push(n);
            }
        }
        while (!contenidor.esBuida()) {
            Integer num = contenidor.pop();
            System.out.println(num);
        }

    }
}
