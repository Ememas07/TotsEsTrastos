/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 * RECURSIVITAT
 *
 * Sobrecarrega la funció de l’activitat 4.10 per a que l’únic paràmetre sigui
 * la quantitat de nombres aleatoris a mostrar per consola.
 *
 * Els nombres aleatoris seran decimals entre 0 i 1.
 *
 * @author Marc Mas
 */
public class Ud4Act11MarcMas {

    // VERSIO AMB SOBRECARREGA
    // public static void calcularNombres(int n, int min, int max) {
    //     System.out.print((min + (int) (Math.random() * max))); //calculam i imprimim el nombre
    //     // es igual que si fessim:
    //     // Integer x = 0; //generam variable
    //     // x = min + (int) (Math.random() * max); //generam nombre aleatori
    //     // System.out.print(x); //imprimim el nombre
    //     if (n > 1) { //si n es major a 1, tornam a executar el bucle
    //         System.out.print(", ");
    //         calcularNombres(n-1, min, max);
    //     }
    // }
    // public static void calcularNombres(int n) {
    //     System.out.print((Math.random())); //calculam i imprimim el nombre
    //     // es igual que si fessim:
    //     // Integer x = 0; //generam variable
    //     // x = Math.random(); //generam nombre aleatori
    //     // System.out.print(x); //imprimim el nombre
    //     if (n > 1) { //si n es major a 1, tornam a executar el bucle
    //         System.out.print(", ");
    //         calcularNombres(n-1);
    //     }
    // }
    // VERSIO AMB NOMES UNA FUNCIO (amb ambes funcionalitats)
    public static void calcularNombres(int n, int min, int max) {
        if (min == 0 && max == 0) { //si min i max son 0, imprimirem nombres decimals entre 1 i 0
            System.out.print(Math.random()); //calculam i imprimim el nombre
        } else { //si min i max no son 0, farem la funcio amb min i max
            System.out.print((min + (int) (Math.random() * max))); //calculam i imprimim el nombre
        }
        // es igual que si fessim:
        // Integer x = 0; //generam variable
        // x = min + (int) (Math.random() * max); //generam nombre aleatori
        // System.out.print(x); //imprimim el nombre
        if (n > 1) { //si n es major a 1, tornam a executar el bucle
            System.out.print(", ");
            calcularNombres(n - 1, min, max);
        }
    }
    // VERSIO SENSE RECURSIVITAT
    // public static void calcularNombres(int n, int min, int max) {
    //     while (n > 1) {
    //         if (min == 0 && max == 0) { //si min i max son 0, imprimirem nombres decimals entre 1 i 0
    //             System.out.print(Math.random()); //calculam i imprimim el nombre
    //         } else { //si min i max no son 0, farem la funcio amb min i max
    //             System.out.print((min + (int) (Math.random() * max))); //calculam i imprimim el nombre
    //         }
    //         System.out.print(", ");
    //         n -= 1;
    //     }
    // }

    public static void main(String[] args) {
        System.out.println("Programa per calcular nombres enters a un rang determinat (o entre 0 i 1)"); //informacio a l'usuari
        Scanner s = new Scanner(System.in); //iniciam scanner
        System.out.println("Quants de nombres"); // demanam quants de nombres volem
        Integer n = s.nextInt(); //assignam
        System.out.println("Vol un rang de nombres determinat o nombres decimals de 0 a 1?");
        System.out.println("Introdueix 0 per un rang, 1 per nombres de 0 a 1");
        Integer a = s.nextInt(); //assignam variable per determinar si volem un rang o 0-1
        Integer min = 0;
        Integer max = 0;
        if (a == 0) {
            System.out.println("Quin sera el nombre minim?"); // demanam el nombre mes baix
            min = s.nextInt(); //assignam
            System.out.println("Quin sera el nombre maxim?"); // demanam el nombres mes alt
            max = s.nextInt(); //assignam
        }
        calcularNombres(n, min, max);
    }
}
