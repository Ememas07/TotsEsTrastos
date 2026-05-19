/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Implementar una aplicació que on s'inserten 100 nombres enters aleatoris
 * entre 1 i 10 dins una col·lecció
 *
 * A continuació, s'eliminen tots els elements que valen 5 ● Mostrar la
 * col·lecció abans i després de l'eliminació
 *
 * @author Marc Mas
 */
public class Ud11Act6MarcMas {

    public static void main(String[] args) {
        ArrayList<Integer> l = new ArrayList();
        Collection<Integer> c = l;
        for (int i = 0; i < 99; i++) {
            int n = 1 + (int) (Math.random() * 10);
            c.add(n);
        }
        System.out.println("Coleccio abans:");
        System.out.println(c.toString());
        for (int i = 0; i < l.size(); i++) {
            if(l.get(i) == 5){
                l.remove(i);
            }
        }
        System.out.println("Coleccio despres:");
        System.out.println(c.toString());
    }
}
