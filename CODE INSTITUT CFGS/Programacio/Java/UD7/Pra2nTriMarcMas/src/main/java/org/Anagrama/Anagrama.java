/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Anagrama;

import java.util.Arrays;

import org.Paraula.Paraula;

/**
 *
 * @author Marc Mas
 */
public class Anagrama {

    final String ALFABET = "abcdefghijklmnopqrstuvwxyz";
    int[] frequencia;
    char[] lletres;

    public Anagrama(Paraula p) {
        frequencia = Arrays.copyOf(p.getFrecuencies(), p.getFrecuencies().length);
        lletres = new char[p.getLongitut()];
        int index = 0;
        while (index < p.getLongitut()) {
            for (int i = 0; i < frequencia.length; i++) {
                while (frequencia[i] > 0) {
                    lletres[index] = ALFABET.charAt(i);
                    frequencia[i]--;
                    index++;
                }
            }
        }
    }

    // public char[] getLletres() {
    //     return lletres;
    // }
    public String getLletres() {
        String lletres = "";
        for (int i = 0; i < this.lletres.length; i++) {
            lletres += this.lletres[i] + ", ";
        }
        return lletres;
    }
}
