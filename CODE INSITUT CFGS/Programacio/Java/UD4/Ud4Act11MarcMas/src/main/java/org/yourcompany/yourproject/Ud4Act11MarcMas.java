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

    public static void calcularNombres(int n, int min, int max) {
        System.out.print((min + (int) (Math.random() * max))); //calculam i imprimim el nombre
        // es igual que si fessim:
        // Integer x = 0; //generam variable
        // x = min + (int) (Math.random() * max); //generam nombre aleatori
        // System.out.print(x); //imprimim el nombre
        if (n > 1) { //si n es major a 1, tornam a executar el bucle
            System.out.print(", ");
            calcularNombres(n-1, min, max);
        }
    }

    public static void calcularNombres(int n) {
        System.out.print((Math.random())); //calculam i imprimim el nombre
        // es igual que si fessim:
        // Integer x = 0; //generam variable
        // x = Math.random(); //generam nombre aleatori
        // System.out.print(x); //imprimim el nombre
        if (n > 1) { //si n es major a 1, tornam a executar el bucle
            System.out.print(", ");
            calcularNombres(n-1);
        }
    }

    public static void main(String[] args) {
        System.out.println("Programa per calcular nombres enters a un rang determinat"); //informacio a l'usuari
        Scanner s = new Scanner(System.in); //iniciam scanner
        System.out.println("Quants de nombres"); // demanam quants de nombres volem
        Integer n = s.nextInt(); //assignam
        System.out.println("Quin sera el nombre minim?"); // demanam el nombre mes baix
        // Integer min = s.nextInt(); //assignam
        // System.out.println("Quin sera el nombre maxim?"); // demanam el nombres mes alt
        // Integer max = s.nextInt(); //assignam
        calcularNombres(n);
    }
}
