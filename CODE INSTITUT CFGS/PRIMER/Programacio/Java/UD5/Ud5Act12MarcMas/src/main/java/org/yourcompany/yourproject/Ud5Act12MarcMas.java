/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 * En un joc de rol el mapa es pot implementar com una matriu on les files i les
 * columnes representen llocs (lloc 0, lloc 1, lloc 2, etc.) que estaran
 * connectats.
 *
 * Si des del lloc X podem anar cap al lloc Y, llavors la matriu a la posició
 * [x][y] valdrà cert; en cas contrari, valdrà fals.
 *
 * Escriu una funció que, atesa una matriu que representa el mapa i dos llocs,
 * indiqui si és possible viatjar des del primer lloc al segon (directament o
 * passant per llocs intermedis).
 *
 * @author Marc Mas
 */
public class Ud5Act12MarcMas {

    public static boolean comprovarTrajecte(boolean[][] mapa, int lloc1, int lloc2) {
        return mapa[lloc1][lloc2];

        // aquest return es equivalent a:
        // if (mapa[lloc1][lloc2] == 1) {
        //     return true;
        // } else {
        //     return false;
        // }
    }

    public static boolean[][] generarMapa() {
        boolean mapa[][] = new boolean[10][10]; //cream un array de 10x10 de booleans
        for (boolean[] mapa1 : mapa) {
            //recorrem totes les files de l'array
            for (int j = 0; j < mapa.length; j++) {
                //recorrem totes les columnes
                mapa1[j] = Math.random() >= 0.5; // generam un math.random, si el nombre es mes gran de 0.5, posam true, si no, posam false
                // equivalent a:
                // if (Math.random() >= 0.5) {
                //     mapa[i][j] = true;
                // } else {
                //     mapa[i][j] = false;
                // }
                // }
            }
        }
        return mapa;
    }

    public static void imprimirArray2D(boolean[][] array, char ocupats, char lliures) {
        for (boolean[] array1 : array) { //recorrem totes les columnes
            for (int j = 0; j < array.length; j++) { //recorrem totes les files 
                if (array1[j] == true) { //si la posicio es true, pintam el caracter de ocupat
                    System.out.print(ocupats);
                } else { //si no, pinta el caracter de lliure
                    System.out.print(lliures);
                }
                System.out.print(" | "); //pintam un separador entre elements de la mateixa fila
            }
            System.out.println(""); //bot de linea entre columnes
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Joc de rol amb mapa i coordenades");
        boolean mapa[][] = generarMapa(); //el nostre array serà generat per aquesta funcio
        System.out.println("Quin caracter vols per les posicions buides?");
        char buides = s.next().charAt(0); //agafam el caracter per console
        System.out.println("Quin caracter vols per les altres?");
        char ocupats = s.next().charAt(0);
        imprimirArray2D(mapa, ocupats, buides); //imprimim l'array (com a opcional)
        System.out.println("Introdueix primer lloc"); //introduim els dos llocs que volem mirar
        int lloc1 = s.nextInt();
        System.out.println("Introdueix segon lloc");
        int lloc2 = s.nextInt();
        if (comprovarTrajecte(mapa, lloc1, lloc2)) { //miram si hi podem anar, si hi podem anar imprimim "si que" i si no imprimim "no"
            System.out.print("Si que");
        } else {
            System.out.print("No");
        }
        System.out.println(" es pot anar"); //part final del print
    }
}
