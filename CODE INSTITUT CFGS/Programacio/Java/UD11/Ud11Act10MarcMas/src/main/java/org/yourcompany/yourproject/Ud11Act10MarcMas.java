/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Insertar en una llista 20 enters aleatoris entre 1 i 10. A partir d'ella,
 * crear un conjunt amb els elements de la llista sense repetir, un altre amb
 * els repetits i una altre amb els elements que apareixen una sola vegada a la
 * llista original.
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
        System.out.println("Llista original: "+l.toString());
        HashSet noRepetits = new HashSet();
        HashSet repetits = new HashSet();
        HashSet noRepetits2 = new HashSet();
        for (int i = 0; i < l.size(); i++) {
            int numero = l.get(i);
            if (!noRepetits.contains(numero)) {
                noRepetits.add(numero);
            }
            repetits.add(numero);
            if (!noRepetits2.contains(numero)) {
                noRepetits2.add(numero);
            }
        }
        System.out.println("Set sense repetits 1: " + noRepetits.toString());
        System.out.println("Set amb repetits: " + repetits.toString());
        System.out.println("Set sense repetits 2: " + noRepetits2.toString());
    }
}
