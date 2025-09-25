/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.elmeuprimerprojecte;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class Activitat12 {

    public static void main(String[] args) {
        // Activitat 12

        System.out.println("Indica un numero");
        Scanner s = new Scanner(System.in);
        Integer numero1 = s.nextInt();
        System.out.println("Indica un altre numero");
        Scanner s2 = new Scanner(System.in);
        Integer numero2 = s2.nextInt();
        boolean sonIguals = numero1 == numero2;
        System.out.println("Els numeros que has introduit son iguals? "+sonIguals);
        
        // if (numero1 == numero2) {
        //     System.out.println("Aquests dos enters son iguals");
        // } else {
        //     System.out.println("Aquests dos enters no son iguals");
        // }
        
        
    }
}
