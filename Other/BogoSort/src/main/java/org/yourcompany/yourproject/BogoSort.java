/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

/**
 *
 * @author Marc Mas
 */
public class BogoSort {

    public static void bogoSort(int[] taula) {
        int iteracions = 0;
        int taulaAleatoria[] = new int[taula.length];
        int numeroAleatori = 0;
        while (!checkSort(taulaAleatoria)) { //si la taula no esta ordenada 
            buidarTaula(taulaAleatoria); //buidar
            for (int i = 0; i < taula.length;) { //per cada registres de la taula
                numeroAleatori = (int) (Math.random() * (taula.length)); //generam nombre aleatori
                if (taulaAleatoria[numeroAleatori] == 0) { //si el nombres es 0 (es a dir, encara no hem omplit el registre)
                    taulaAleatoria[numeroAleatori] = taula[i]; //assignam el registre 0, despres el registre, 1 de la taula original al valor aleatori
                    i++; //sumam 1 al bucle
                    iteracions++; //sumam iteracions
                }
                System.out.print("Iteracio " + iteracions + "     "); //print de iteracions perque es gracios
            }
        }
        System.out.println("");
        System.out.println("Total de iteracions:" + iteracions);
        for (int i = 0; i < taula.length; i++) {
            taula[i] = taulaAleatoria[i]; //copiam el array a l'altre
        }
    }

    public static boolean checkSort(int[] taula) {
        for (int i = 0; i < taula.length - 1; i++) { //per cada element de la taula
            for (int j = 0; j < taula.length - i - 1; j++) { //per cada element de la taula a partir del que tenim abans
                if (taula[j] > taula[j + 1] || taula[j] == taula[j + 1]) { //si l'index i l'index seguent son iguals o el primer es major 
                    return false; //no esta ordenat
                }
            }
        }
        return true;
    }

    public static void buidarTaula(int[] taula) {
        for (int i = 0; i < taula.length; i++) {
            taula[i] = 0; //recorrem tot l'arrayy i l'omplim amb 0
        }
    }

    public static void omplirTaula(int[] taula, int minim, int maxim) {
        for (int i = 0; i < taula.length; i++) { //recorrem tot l'array
            taula[i] = (int) (minim + Math.random() * maxim); //omplim amb nombres de 1 a 100
        }
    }

    public static void imprimirTaula(int[] taula) {
        for (int i = 0; i < taula.length; i++) {
            System.out.println(taula[i]);
        }
    }

    public static void main(String[] args) {
        int taulaAleatoris[] = new int[6]; //cream array
        omplirTaula(taulaAleatoris, 1, 100);
        bogoSort(taulaAleatoris);
        imprimirTaula(taulaAleatoris);
    }
}
