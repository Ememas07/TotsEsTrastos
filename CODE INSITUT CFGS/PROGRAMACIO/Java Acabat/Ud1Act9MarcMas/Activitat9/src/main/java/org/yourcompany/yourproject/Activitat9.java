/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class Activitat9 {

    public static void main(String[] args) {
        // Activitat 9

        System.out.println("Plou? (respon amb 'true' or 'false')");
        Scanner s = new Scanner(System.in);
        Boolean plou = s.nextBoolean();
        System.out.println("Has acabat les feines? (respon amb 'true' or 'false')");
        Boolean feines = s.nextBoolean();
        System.out.println("Has d'anar a classe? (respon amb 'true' or 'false')");
        Boolean classe = s.nextBoolean();

        // boolean potsSortir = (plou == false && feines == true && classe == false) ? true : false;

        boolean potsSortir = (plou == false && feines == true && classe == false);
        System.out.println("Pots sortir? "+potsSortir);

        // if (plou == false && feines == true && classe == false) {
        //     System.out.println("Pots sortir de casa");
        // } else {
        //     System.out.println("No pots sortir de casa");
        // }   
    }
}
