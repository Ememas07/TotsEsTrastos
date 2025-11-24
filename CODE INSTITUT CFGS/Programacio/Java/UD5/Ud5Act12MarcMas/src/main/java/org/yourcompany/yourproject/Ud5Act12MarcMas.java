/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

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

    public static int[][] generarMapa() {
        int mapa[][] = new int[10][10];
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa.length; j++) {
                if (i == 0 || i == mapa.length - 1 || j == 0 || j == mapa.length) {
                    mapa[i][j] = 1;
                } else {
                    if (Math.random() >= 0.5) {
                        mapa[i][j] = 1;
                    } else {
                        mapa[i][j] = 0;
                    }
                }
            }
        }

        return mapa;
    }

    public static void imprimirArray2D(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + ", ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        System.out.println("Joc de rol amb mapa i coordenades");
        int mapa[][] = generarMapa();
        imprimirArray2D(mapa);
        
    }
}
