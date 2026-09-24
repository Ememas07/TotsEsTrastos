/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Arrays;

import org.Soci.Soci;

/**
 * Canviar la implementació de la classe Soci, per a que el seu criteri
 * d'ordenació natural sigui per ordre alfabètic creixent de nombres.
 */
/**
 *
 * @author Marc Mas
 */
public class Ud9Act8MarcMas {

    public static void main(String[] args) {

        Soci[] socis = new Soci[10];
        String[] noms = {
            "Marc", "Pere", "Toni", "Josep", "Tomeu", "Inaqui", "Maria", "Albert", "Ricard", "Gosha"
        };
        for (int i = 0; i < socis.length; i++) {
            int id = (int) (Math.random() * 100);
            socis[i] = new Soci(id, noms[i]);
        }
        Arrays.sort(socis);
        System.out.println(Arrays.toString(socis));

    }
}
