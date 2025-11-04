/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 * RECURSIVITAT
 *
 * Escriu una funció que mostri per consola una sèrie de nombres aleatoris
 * enters.
 *
 * Els paràmetres de la funció seran:
 *
 * la quantitat de nombres aleatoris a mostrar,
 *
 * el valor mínimo del rang i el valor màxim del rang que poden prendre.
 *
 * @author Marc Mas
 */
public class Ud4Act10MarcMas {

    public static void calcularNombres(int n, int min, int max) {
        System.out.print((min + (int) (Math.random() * max))); //calculam i imprimim el nombre
        // es igual que si fessim:
        // Integer x = 0; //generam variable
        // x = min + (int) (Math.random() * max); //generam nombre aleatori
        // System.out.print(x); //imprimim el nombre
        n--; //restam 1 a n
        if (n > 0) { //si n es major a 0, tornam a executar el bucle
            System.out.print(", ");
            calcularNombres(n, min, max);
        }
    }

    public static void main(String[] args) {
        System.out.println("Programa per calcular nombres enters a un rang determinat"); //informacio a l'usuari
        Scanner s = new Scanner(System.in); //iniciam scanner
        System.out.println("Quants de nombres"); // demanam quants de nombres volem
        Integer n = s.nextInt(); //assignam
        System.out.println("Quin sera el nombre minim?"); // demanam el nombre mes baix
        Integer min = s.nextInt(); //assignam
        System.out.println("Quin sera el nombre maxim?"); // demanam el nombres mes alt
        Integer max = s.nextInt(); //assignam
        calcularNombres(n, min, max);
    }
}
