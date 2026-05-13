/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Implementar una aplicació que on s'inserten 20 nombres enters aleatoris entre
 * 1 i 10 dins una col·lecció
 *
 * A continuació, es crea una llista amb els mateixos elements sense
 * repeticions.
 *
 * @author Marc Mas
 */
public class Ud11Act5MarcMas {

    public static void main(String[] args) {
        ArrayList<Integer> l = new ArrayList();
        Collection<Integer> c = l;
        for (int i = 0; i < 19; i++) {
            int n = 1 + (int) (Math.random() * 10);
            c.add(n);
        }
        ArrayList llista = new ArrayList();
        for (Integer num : c) {
            if (!llista.contains(num)) {
                llista.add(num);
            }
        }
        System.out.println("Coleccio: "+c.toString());
        System.out.println("Llista sense repettits: "+llista.toString());
    }
}
