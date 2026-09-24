/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.yourcompany.yourproject;

import java.util.Comparator;

/**
 *
 * @author Marc Mas
 */
public class ComparaEntersDecreixents implements Comparator<Integer> {

    @Override
    public int compare(Integer n1, Integer n2) {
        return n2 - n1;
    }
}
