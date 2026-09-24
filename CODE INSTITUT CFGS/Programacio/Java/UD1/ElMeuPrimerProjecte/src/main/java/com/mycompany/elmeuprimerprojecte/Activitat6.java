/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.elmeuprimerprojecte;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class Activitat6 {

    public static void main(String[] args) {
        // Activitat 6

        System.out.println("Longitud de circumferència i àrea d'un cercle");
        System.out.println("Radi");
        Scanner s = new Scanner(System.in);
        Double radi = s.nextDouble();
        Double longitud = 2 * Math.PI*radi;
        Double area = Math.PI*(Math.pow(radi, 2));
        System.out.println("La longitud es "+longitud);
        System.out.println("L'area es "+area);
    }
}
