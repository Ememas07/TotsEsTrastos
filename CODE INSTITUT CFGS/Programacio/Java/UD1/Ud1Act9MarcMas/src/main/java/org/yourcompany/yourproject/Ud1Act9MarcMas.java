/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class Ud1Act9MarcMas {

    public static void main(String[] args) {
        // Activitat 9

        Scanner s = new Scanner(System.in);
        System.out.println("Plou? (respon amb 'true' or 'false')");
        Boolean plou = s.nextBoolean(); 
        System.out.println("Has acabat les feines? (respon amb 'true' or 'false')");
        Boolean feinesAcabades = s.nextBoolean();
        System.out.println("Has d'anar a classe? (respon amb 'true' or 'false')");
        Boolean classe = s.nextBoolean();
        boolean potsSortir = ((plou == false && feinesAcabades == true) || classe == true);
        System.out.println("Pots sortir? "+potsSortir);

        // Manera amb IFs
        // if (plou == false && feines == true || classe == true) { 
        //     System.out.println("Pots sortir de casa");
        // } else {
        //     System.out.println("No pots sortir de casa");
        // }   
    }
}
