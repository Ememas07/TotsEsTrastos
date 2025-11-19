/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * Llegir i emmagatzemar n nombres enters a una taula.
 *
 * D’aquesta taula se’n faran dos ○ La primera amb els valors parells
 *
 * La segona amb els valors senars
 *
 * Ambdues taules s’han de mostrar amb els valors ordenats
 *
 * @author Marc Mas
 */
public class Ud5Act8MarcMas {

    public static void insertarValor(int[] taulaSenars, int valor) {
        taulaSenars = Arrays.copyOf(taulaSenars, taulaSenars.length + 1);
        taulaSenars[taulaSenars.length - 1] = valor;
    }

    public static void imprimirArray(int[] t) {
        for (int i = 0; i < t.length; i++) {
            System.out.print(t[i] + ", ");
        }
        System.out.println("");
    }

    public static void separarParellsSenars(int[] t) {
        int taulaSenars[] = new int[0];
        int taulaParells[] = new int[0];
        for (int i = 0; i < t.length; i++) {
            if (t[i] % 2 == 0) {
                taulaParells = Arrays.copyOf(taulaParells, taulaParells.length + 1);
                taulaParells[taulaParells.length - 1] = t[i];
            } else {
                taulaSenars = Arrays.copyOf(taulaSenars, taulaSenars.length + 1);
                taulaSenars[taulaSenars.length - 1] = t[i];
            }
        }
        Arrays.sort(taulaParells);
        Arrays.sort(taulaSenars);
        System.out.println("Taula Parells:");
        imprimirArray(taulaParells);
        System.out.println("Taula Senars:");
        imprimirArray(taulaSenars);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Programa que mostra els nombres no repetits d'un array");
        int arrayNombres[] = new int[10];
        for (int i = 0; i < arrayNombres.length; i++) { //recorrem l'array i l'omplim amb ints
            // System.out.println("Introdueixi un nombre enter"); //en cas de voler omplir l'array manualment
            // arrayNombres[i] = s.nextInt();
            arrayNombres[i] = (int) (1 + Math.random() * 10);
        }
        separarParellsSenars(arrayNombres);
    }
}
