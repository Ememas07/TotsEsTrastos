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
        int n = 1; //iniciam el bucle
        while (n > 0) { //demanam un numero mentre N sigui positiu
            n = s.nextInt(); 
            if (n > 0) { //si n es positiu, l'afegim
                contenidor.push(n);
            }
        }
        while (!contenidor.esBuida()) { //mentre el contenidor no estigui buit
            Integer num = contenidor.pop(); //treim un numero 
            System.out.println(num); //i el mostram per pantalla
        }

    }
}
