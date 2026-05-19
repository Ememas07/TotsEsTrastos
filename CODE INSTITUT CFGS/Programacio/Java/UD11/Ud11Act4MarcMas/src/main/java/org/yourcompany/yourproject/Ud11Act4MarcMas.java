/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Implementar una aplicació que demani per consola nombres enters positius fins
 * que s'hi introdueix un de negatiu. Els nombres es van insertant a una
 * col·lecció. Es poden repetir. Al acabar, es mostrarà la col·lecció per
 * pantalla
 *
 * A continuació, es mostraran tots els valors pars.
 *
 * En darrer lloc, s'eliminaran tots els múltiples de 3 i es mostrarà per
 * pantalla el resultat
 *
 * @author Marc Mas
 */
public class Ud11Act4MarcMas {

    public static void main(String[] args) {
        ArrayList<Integer> llista = new ArrayList();
        Collection<Integer> c = llista;
        Scanner s = new Scanner(System.in);
        System.out.println("Introdueixi nombres enters per omplir la coleccio, Introdueixi un nombre negatiu per aturar");
        int n = 1;
        while (n > 0) {
            n = s.nextInt();
            if (n > 0) {
                c.add(n);
            }
        }
        System.out.println("Nombres:");
        System.out.println(c.toString());
        System.out.println("Nombres parells:");
        for (Integer num : c) {
            if (num % 2 == 0) {
                System.out.print(num + " ");
            }
        }
        System.out.println("");
        System.out.println("Nombre que no son multiples de 3:");
        Iterator<Integer> it = c.iterator();
        while (it.hasNext()) {
            if (it.next() % 3 == 0) {
                it.remove();
            }
        }
        System.out.println(c.toString());

    }
}
