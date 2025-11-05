/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 * RECURSIVITAT
 *
 * Escriu una funció amb paràmetres d’entrada una quantitat de dies, hores i
 * minuts.
 *
 * La funció ha de calcular el nombre de segons que hi ha.
 *
 * @author Marc Mas
 */
public class Ud4Act9MarcMas {

    // RECURSIVE 
    public static Integer calcularSegons(int d, int h, int m, int v) {
        if (v == 1) {
            Integer s = 0;
            if (d != 0) {
                h += 24;
                d--;
            }
            if (h != 0) {
                m += 60;
                h--;
            }
            if (m != 0) {
                s += 60 + calcularSegons(d, h, m - 1, 1);
            }
            return s;
        } else {
            return calcularSegons(d, h, m);
        }
    }
    public static Integer calcularSegons(int d, int h, int m) {
        Integer s = 0;
        if (d != 0) {
            s += 86400 * d;
            d = 0;
        }
        if (h != 0) {
            s += 3600 * h;
            h = 0;
        }
        if (m != 0) {
            s += 60 + calcularSegons(d, h, m - 1);
        }
        return s;
    }

    // NO RECURSIVE
    // public static Integer calcularSegons(int d, int h, int m) {
    //     Integer s = 0;
    //     if (d != 0) {
    //         s += 86400 * d;
    //         d = 0;
    //     }
    //     if (h != 0) {
    //         s += 3600 * h;
    //         h = 0;
    //     }
    //     if (m != 0) {
    //         s += 60 * d;
    //         m = 0;
    //     }
    //     return s;
    // }

    public static void main(String[] args) {
        System.out.println("Programa per calcular segons a traves de dies hores i minuts"); //informacio a l'usuari
        Scanner s = new Scanner(System.in); //iniciam scanner
        System.out.println("Quina versio vols emprar?");
        System.out.println("1 per versio incial (pot explotar a partir de 3 dies)");
        System.out.println("2 per versio millorada amb mes robustesa");
        Integer v = s.nextInt(); // versio del programa
        System.out.println("Quants de dies?"); // demanam nombre de dies
        Integer d = s.nextInt(); //assignam
        System.out.println("Quantes hores?"); // demanam nombre de hores
        Integer h = s.nextInt(); //assignam
        System.out.println("Quants de minuts?"); // demanam nombre de minuts
        Integer m = s.nextInt(); //assignam
        System.out.println(calcularSegons(d, h, m, v));
    }
}
