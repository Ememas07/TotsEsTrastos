/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Arrays;

import org.Soci.ComparaEdatCC;
import org.Soci.ComparaEdatDC;
import org.Soci.Soci;

/**
 * A partir del comparador de Soci basat en les edats creixents, obtenir un
 * altre que els ordeni segons edats decreixents.
 */
/**
 *
 * @author Marc Mas
 */
public class Ud9Act9MarcMas {

    public static void main(String[] args) {

        Soci[] socis = new Soci[10];
        Soci[] socis2 = new Soci[10];
        String[] noms = {
            "Marc", "Pere", "Toni", "Josep", "Tomeu", "Inaqui", "Maria", "Albert", "Ricard", "Gosha"
        };
        for (int i = 0; i < socis.length; i++) {
            int edat = (int) (Math.random() * 100);
            socis[i] = new Soci(noms[i], edat);
            socis2[i] = new Soci(noms[i], edat);
        }
        ComparaEdatCC cc = new ComparaEdatCC();
        ComparaEdatDC dc = new ComparaEdatDC();
        
        Arrays.sort(socis, cc);
        System.out.println("Creixent:" + Arrays.toString(socis));
        Arrays.sort(socis, dc);
        System.out.println("Decreixent:" + Arrays.toString(socis));
    }
}
