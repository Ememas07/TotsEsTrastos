/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class UD2Act9MarcMas {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Introdueix un DNI sense la lletra"); //deman un integer amb el DNI
        Integer input = s.nextInt();
        Integer resto = (input % 23); //calcul el residu amb l'operacio de modulo
        String lletra = ""; //inicialitz variable lletra
        switch (resto) { //switch amb totes les opcions posibles de resiuds
            case 0:
                lletra = "T";
                break;
            case 1:
                lletra = "R";
                break;
            case 2:
                lletra = "W";
                break;
            case 3:
                lletra = "A";
                break;
            case 4:
                lletra = "G";
                break;
            case 5:
                lletra = "M";
                break;
            case 6:
                lletra = "Y";
                break;
            case 7:
                lletra = "F";
                break;
            case 8:
                lletra = "P";
                break;
            case 9:
                lletra = "D";
                break;
            case 10:
                lletra = "X";
                break;
            case 11:
                lletra = "B";
                break;
            case 12:
                lletra = "N";
                break;
            case 13:
                lletra = "J";
                break;
            case 14:
                lletra = "Z";
                break;
            case 15:
                lletra = "S";
                break;
            case 16:
                lletra = "Q";
                break;
            case 17:
                lletra = "V";
                break;
            case 18:
                lletra = "H";
                break;
            case 19:
                lletra = "L";
                break;
            case 20:
                lletra = "C";
                break;
            case 21:
                lletra = "K";
                break;
            case 22:
                lletra = "E";
                break;
            default:
                System.out.println("Error"); //si no cau a cap dels 22 resiuds, imprimir error
        }
        if (lletra != "") { //si la lletra no està buida (cosa que no pot passar si no hi ha cap error) imprimim el DNI
            System.out.println("El teu DNI complet es " + input + lletra); //un pic tenim el DNI amb la lletra, l'imprimim
        }

    }
}
