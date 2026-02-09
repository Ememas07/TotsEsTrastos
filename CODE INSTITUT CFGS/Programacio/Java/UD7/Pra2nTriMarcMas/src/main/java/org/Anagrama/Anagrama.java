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

    char[] lletres;
    String[] paraules;

    public Anagrama(Paraula p) {
        this.paraules = new String[1];
        final String ALFABET = "abcdefghijklmnopqrstuvwxyz";
        int[] frequencia = Arrays.copyOf(p.getFrecuencies(), p.getFrecuencies().length);
        lletres = new char[p.getLongitut()];
        paraules[0] = p.getText();
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

    public void addParaules(Paraula p) {
        this.paraules = Arrays.copyOf(this.paraules, this.paraules.length + 1);
        paraules[paraules.length - 1] = p.getText();
    }

    public void mostrarParaules() {
        for (int i = 0; i < paraules.length; i++) {
            if (i != 0) {
                System.out.print(","); //pintam la coma a partir de la 2a paraula
            }
            System.out.print(paraules[i]); //pintam les paraules
        }
        System.out.println("");
    }

    public void mostrarParaulesDiferents(Paraula p) {
        for (String paraula : paraules) {
            if (!p.getText().equals(paraula)) {
                //no volem pintar la mateixa paraula
                System.out.print(paraula + " "); //pintam totes les paraules que no siguin iguals
            }
        }

    }

    public String getParaula() {
        try {
            return paraules[0];

        } catch (ArrayIndexOutOfBoundsException e) {
            return "";
        }
    }

    public String getLletres() {
        String lletres = "";
        for (int i = 0; i < this.lletres.length; i++) {
            lletres += this.lletres[i] + ", ";
        }
        return lletres;
    }

    public String[] getParaules() {
        return paraules;
    }
}
