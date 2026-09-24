/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Soci;

import java.util.Comparator;

/**
 *
 * @author Marc Mas
 */
public class ComparaEdatCC implements Comparator<Soci> {

    @Override
    public int compare(Soci s1, Soci s2) {
        return s1.edat - s2.edat;
    }
}
