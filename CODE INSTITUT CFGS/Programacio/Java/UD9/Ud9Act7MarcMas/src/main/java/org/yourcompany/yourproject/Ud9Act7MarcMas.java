/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Arrays;

import org.Soci.Soci;

/**
 *
 * @author Marc Mas
 */
public class Ud9Act7MarcMas {

    public static void main(String[] args) {

        Soci[] socis = new Soci[10];
        for (int i = 0; i < socis.length; i++) {
            int id = (int) (Math.random() * 100);
            socis[i] = new Soci(id);
        }
        Arrays.sort(socis);
        System.out.println(Arrays.toString(socis));

    }
}
