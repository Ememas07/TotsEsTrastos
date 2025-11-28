/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Escriu la funció: int [] ficaParells(int longitud, int max), que crea i
 * retorna una taula ordenada de la longitud especificada per paràmetre, que
 * només té nombres parells aleatoris que poden anar desde 2 fins a max.
 *
 * @author Marc Mas
 */
public class Ud5Act5MarcMas {

    public static int[] ficaParells(int longitud, int max) {
        int taula[] = new int[longitud]; //cream una taula amb longitut especificada
        int numero = 0; //emprarem aquesta variable per omplir amb nombres
        for (int i = 0; i < longitud; i++) { //recorrem tota la taula
            numero = (int) (2 + Math.random() * max); //num aleatori desde 2 fins a max
            if (numero % 2 == 1) {
                numero -= 1; //si el nombre es inparell restam 1
            }
            taula[i] = numero; //assignam el valor
        }
        Arrays.sort(taula); //ordenam la taula

        return taula; //retornam la taula

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Programa que retorna una taula de parells");
        System.out.println("Quina longitut vol que tengui la taula?");
        int longitud = s.nextInt();
        System.out.println("Quin vols que sigui el nombre mes gran?");
        int max = s.nextInt();
        int taulaOrdenada[] = ficaParells(longitud, max);//taulaOrdenada sera el resultat de la variable
        System.out.println("Aqui te la seva taula ordenada");
        for (int i = 0; i < taulaOrdenada.length; i++) {
            System.out.print(taulaOrdenada[i] + ", "); //imprimim tots els valors
        }

    }
}
