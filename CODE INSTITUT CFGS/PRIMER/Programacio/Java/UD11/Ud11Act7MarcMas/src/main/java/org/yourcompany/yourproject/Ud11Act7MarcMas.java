/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Implementa l'activitat anterior amb mètodes globals
 *
 * @author Marc Mas
 */
public class Ud11Act7MarcMas {

    public static void main(String[] args) {
        ArrayList<Integer> l = new ArrayList();
        Collection<Integer> c = l;
        for (int i = 0; i < 99; i++) {
            int n = 1 + (int) (Math.random() * 10);
            c.add(n);
        }
        System.out.println("Coleccio abans:");
        System.out.println(c.toString());
        Collection<Integer> c2 = l;
        c2.add(5);
        if (l.containsAll(c2)) {
            l.removeAll(c2);
        }
        System.out.println("Coleccio despres:");
        System.out.println(c.toString());
    }
}
