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
 * D'aquesta taula se'n faran dos ○ La primera amb els valors parells
 *
 * La segona amb els valors senars
 *
 * Ambdues taules s'han de mostrar amb els valors ordenats
 *
 * @author Marc Mas
 */
public class Ud5Act8MarcMas {

    public static void imprimirArray(int[] t) {
        for (int i = 0; i < t.length; i++) { //recorrem tot l'array
            System.out.print(t[i] + ", "); //imprimim un nombre i posam una ,
        }
        System.out.println(""); //imprimim una linea buida al final
    }

    public static void separarParellsSenars(int[] t) {
        int taulaSenars[] = new int[0]; //cream dos arrays, un de parells i un de senars
        int taulaParells[] = new int[0];
        for (int i = 0; i < t.length; i++) { //durant tot l'array original 
            if (t[i] % 2 == 0) { //is el nombre es parell
                taulaParells = Arrays.copyOf(taulaParells, taulaParells.length + 1); //copiam l'array, el feim mes llarg
                taulaParells[taulaParells.length - 1] = t[i]; //i assignam el valor nou al darrer index del nou array
            } else {
                taulaSenars = Arrays.copyOf(taulaSenars, taulaSenars.length + 1); //copiam l'array, el feim mes llarg
                taulaSenars[taulaSenars.length - 1] = t[i]; //i assignam el valor nou al darrer index del nou array
            }
        }
        Arrays.sort(taulaParells); //ordenam l'array
        Arrays.sort(taulaSenars);
        System.out.println("Taula Parells:"); //imprimim l'array
        imprimirArray(taulaParells);
        System.out.println("Taula Senars:");
        imprimirArray(taulaSenars);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Programa que mostra els nombres no repetits d'un array");
        int arrayNombres[] = new int[10];
        for (int i = 0; i < arrayNombres.length; i++) { //recorrem l'array i l'omplim amb ints
            // System.out.println("Introdueixi un nombre enter"); //en cas de voler omplir l'array manualment, descomentar aquesta linea i la seguent
            // arrayNombres[i] = s.nextInt();
            arrayNombres[i] = (int) (1 + Math.random() * 10);
        }
        separarParellsSenars(arrayNombres);
    }
}
