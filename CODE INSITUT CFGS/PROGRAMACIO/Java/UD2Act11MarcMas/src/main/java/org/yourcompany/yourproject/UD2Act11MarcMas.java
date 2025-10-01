/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class UD2Act11MarcMas {

    public static void main(String[] args) {
        // Fer-la sense IFS
        Scanner s = new Scanner(System.in);
        System.out.println("Introdueix el valor del dau");
        Integer dau = s.nextInt();
        Integer oposat = 0;
        switch (dau) {
            case 1:
                oposat = 6;
                break;
            case 2:
                oposat = 5;
                break;
            case 3:
                oposat = 4;
                break;
            case 4:
                oposat = 3;
                break;
            case 5:
                oposat = 2;
                break;
            case 6:
                oposat = 1;
                break;
            default:
                oposat = 0;
        }
        // VERSIO SENSE IFs:
        switch (oposat) {
            case 0:
                System.out.println("ERROR: Nombre incorrecte");
                break;
            default:
                System.out.println("El valor oposat del dau es " + oposat);
        }
        // VERSIO AMB IFs:
        // if (oposat == 0) {
        //         System.out.println("ERROR: Nombre incorrecte");
        // } else{
        //         System.out.println("El valor oposat del dau es " + oposat);

        // }
    }
}
