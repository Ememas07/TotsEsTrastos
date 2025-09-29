/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.elmeuprimerprojecte;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class Activitat10 {

    public static void main(String[] args) {
        // Activitat 10

        System.out.println("Indica un numero");
        Scanner s = new Scanner(System.in);
        Double numero = s.nextDouble();
        System.out.println("L'absolut del teu nombre es "+Math.abs(numero));
    }
}
