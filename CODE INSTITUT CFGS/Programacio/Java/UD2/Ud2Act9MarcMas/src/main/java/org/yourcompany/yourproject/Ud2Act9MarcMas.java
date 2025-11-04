/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class Ud2Act9MarcMas {

    public static void main(String[] args) {
        System.out.println("Calculador de lletra del DNI");
        Scanner s = new Scanner(System.in);
        System.out.println("Introdueix un DNI sense la lletra"); //deman un integer amb el DNI
        Integer input = s.nextInt();
        if (input > 99999999 || input < 9999999) {
            System.out.println("el DNI no es valid");
        } else {

            Integer resto = (input % 23); //calcul el residu amb l'operacio de modulo
            System.out.print("El teu DNI sencer es " + input); //inicialitz variable lletra
            switch (resto) { //switch amb totes les opcions posibles de resiuds
                case 0:
                    System.out.print("T");
                    break;
                case 1:
                    System.out.print("R");
                    break;
                case 2:
                    System.out.print("W");
                    break;
                case 3:
                    System.out.print("A");
                    break;
                case 4:
                    System.out.print("G");
                    break;
                case 5:
                    System.out.print("M");
                    break;
                case 6:
                    System.out.print("Y");
                    break;
                case 7:
                    System.out.print("F");
                    break;
                case 8:
                    System.out.print("P");
                    break;
                case 9:
                    System.out.print("D");
                    break;
                case 10:
                    System.out.print("X");
                    break;
                case 11:
                    System.out.print("B");
                    break;
                case 12:
                    System.out.print("N");
                    break;
                case 13:
                    System.out.print("J");
                    break;
                case 14:
                    System.out.print("Z");
                    break;
                case 15:
                    System.out.print("S");
                    break;
                case 16:
                    System.out.print("Q");
                    break;
                case 17:
                    System.out.print("V");
                    break;
                case 18:
                    System.out.print("H");
                    break;
                case 19:
                    System.out.print("L");
                    break;
                case 20:
                    System.out.print("C");
                    break;
                case 21:
                    System.out.print("K");
                    break;
                case 22:
                    System.out.print("E");
                    break;
                default:
                    System.out.println("Error"); //si no cau a cap dels 22 resiuds, imprimir error
            }
        }

    }
}
