/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

/**
 *
 * @author Marc Mas
 */
public class BubbleSort {

    public static void bubbleSort(int[] taula) {
        for (int i = 0; i < taula.length - 1; i++) { //va de 0 fins al final
            for (int j = 0; j < taula.length - i - 1; j++) { //va de 0 fins al final -1 (ja que anam amb parelles)
                if (taula[j] > taula[j + 1]) { //si no estan ordenats, les gir
                    int temp = taula[j];
                    taula[j] = taula[j + 1];
                    taula[j + 1] = temp;
                }
            }

        }

    }

    public static void main(String[] args) {
        int taulaAleatoris[] = new int[10]; //cream array
        for (int i = 0; i < taulaAleatoris.length; i++) { //recorrem tot l'array
            taulaAleatoris[i] = (int) (1 + Math.random() * 100); //omplim amb nombres de 1 a 100
        }
        bubbleSort(taulaAleatoris);
        for (int i = 0; i < taulaAleatoris.length; i++) {
            System.out.println(taulaAleatoris[i]);
        }
    }
}
