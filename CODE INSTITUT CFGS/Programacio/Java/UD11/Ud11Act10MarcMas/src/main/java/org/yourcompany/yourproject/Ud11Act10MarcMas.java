/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Insertar en una llista 20 enters aleatoris entre 1 i 10.
 *
 * A partir d'ella, crear un conjunt amb els elements de la llista sense repetir
 *
 * un altre amb els repetits
 *
 * i una altre amb els elements que apareixen una sola vegada a la llista
 * original.
 *
 * @author Marc Mas
 */
public class Ud11Act10MarcMas {

    public static void main(String[] args) {
        ArrayList<Integer> l = new ArrayList();
        for (int i = 0; i < 19; i++) {
            int n = 1 + (int) (Math.random() * 9);
            l.add(n);
        }
        l.sort(Integer::compareTo);
        System.out.println("Llista original: " + l.toString());
        // 1 2 2 3 4 4 4 6 -> llista
        HashSet noRepetits = new HashSet(); // 1 2 3 4 6
        HashSet repetits = new HashSet(); // 2 4
        // 1 3 6
        noRepetits.add(l.get(0)); //afegesc el primer element ja que agafaré el nombre +1 al bucle
        for (int i = 0; i < l.size() - 1; i++) {
            int numero1 = l.get(i);
            int numero2 = l.get(i + 1);
            noRepetits.add(numero2);
            if (numero1 == numero2) {
                repetits.add(numero1);
            }
        }
        HashSet unaVegada = new HashSet(noRepetits);
        unaVegada.removeAll(repetits);
        System.out.println("Set sense repetits: " + noRepetits.toString());
        System.out.println("Set nomes repetits: " + repetits.toString());
        System.out.println("Set nomes una vegada: " + unaVegada.toString());
    }
}
