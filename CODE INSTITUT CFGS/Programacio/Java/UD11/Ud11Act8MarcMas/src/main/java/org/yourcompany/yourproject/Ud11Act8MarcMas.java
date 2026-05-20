/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Implementar una aplicació que on s'inserten 20 nombres enters aleatoris dins
 * una col·lecció.
 *
 * A continuació, s'ordenen de menor a major, convertint-la en taula i
 * tornant-la convertir en col·lecció.
 *
 * Repeteix el procés per a ordenar-la de major a menor.
 *
 * @author Marc Mas
 */
public class Ud11Act8MarcMas {

    public static void main(String[] args) {
        ArrayList<Integer> l = new ArrayList();
        Collection<Integer> c = l;
        for (int i = 0; i < 19; i++) {
            int n = 1 + (int) (Math.random() * 99);
            c.add(n);
        }
        System.out.println("Collecio desordenada"+c.toString());
        Collections.sort(l);
        Object[] taula = l.toArray();
        System.out.println("Taula: " + Arrays.toString(taula));
        Collection<Object> c2 = new ArrayList();
        c2.addAll(Arrays.asList(taula));
        System.out.println("Coleccio " + c2.toString());
        Collections.sort(l);
        Collections.reverse(l);
        Object[] taula2 = l.toArray();
        System.out.println("Taula: " + Arrays.toString(taula2));
        Collection<Object> c3 = new ArrayList();
        c3.addAll(Arrays.asList(taula2));
        System.out.println("Coleccio 2" + c3.toString());
    }
}
