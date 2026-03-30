/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Arrays;

/**
 * Implementar una classe comparadora que permeti ordenar nombres enters en
 * sentit decreixent.
 *
 * Crear una taula de 20 nombres aleatoris entre 1 i 100 i ordenar-la en sentit
 * decreixent.
 *
 * @author Marc Mas
 */
public class Ud9Act10MarcMas {

    public static void main(String[] args) {
        int[] taula = new int[20];
        for (int i = 0; i < 10; i++) {
            taula[i] = (int) ((Math.random() * 99)) + 1;
        }
        ComparaEntersDecreixents c = new ComparaEntersDecreixents();
        // Arrays.sort(taula, c);
        System.out.println("Aqui te la taula ordenada en ordre decreixent" + Arrays.toString(taula));
    }
}
