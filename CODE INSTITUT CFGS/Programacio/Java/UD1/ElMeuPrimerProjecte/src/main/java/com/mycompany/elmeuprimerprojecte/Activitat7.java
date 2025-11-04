/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.elmeuprimerprojecte;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class Activitat7 {

    public static void main(String[] args) {
        // Activitat 7

        System.out.println("Quants d'anys tens");
        Scanner s = new Scanner(System.in);
        Integer edat = s.nextInt();
        boolean majoria = edat >= 18;
        System.out.println("Aquesta persona es major d'edat? "+majoria);            
        // if (edat >= 18) {
        //     System.out.println("Ets major d'edat");            
        // } else{
        //     System.out.println("Ets menor d'edat");           
        // }
        
        
    }
}
