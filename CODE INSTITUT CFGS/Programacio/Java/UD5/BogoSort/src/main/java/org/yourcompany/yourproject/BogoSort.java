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
        while (!checkSort(taulaAleatoria)) {
            buidarTaula(taulaAleatoria);
            for (int i = 0; i < taula.length;) {
                numeroAleatori = (int) (Math.random() * (taula.length));
                if (taulaAleatoria[numeroAleatori] == 0) {
                    taulaAleatoria[numeroAleatori] = taula[i];
                    i++;
                    iteracions++;
                }
                System.out.print("Iteracio " + iteracions + "     ");
            }
        }
        for (int i = 0; i < taulaAleatoria.length; i++) {
            System.out.println(taulaAleatoria[i]);
        }
    }

    public static boolean checkSort(int[] taula) {
        for (int i = 0; i < taula.length - 1; i++) {
            for (int j = 0; j < taula.length - i - 1; j++) {
                if (taula[j] > taula[j + 1] || taula[j] == taula[j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void buidarTaula(int[] taula) {
        for (int i = 0; i < taula.length; i++) {
            taula[i] = 0;
        }
    }

    public static void main(String[] args) {
        int taulaAleatoris[] = new int[5]; //cream array
        for (int i = 0; i < taulaAleatoris.length; i++) { //recorrem tot l'array
            taulaAleatoris[i] = (int) (1 + Math.random() * 100); //omplim amb nombres de 1 a 100
        }
        bogoSort(taulaAleatoris);
    }
}
