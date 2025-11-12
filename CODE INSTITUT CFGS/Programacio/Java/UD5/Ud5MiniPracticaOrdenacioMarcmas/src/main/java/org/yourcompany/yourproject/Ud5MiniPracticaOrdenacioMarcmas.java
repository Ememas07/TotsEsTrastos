/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author alumne
 */
public class Ud5MiniPracticaOrdenacioMarcmas {

    public static void bubbleSort(int taula[]) {
        long horaStart = System.currentTimeMillis();
        int comparatives = 0;
        int intercanvis = 0;
        for (int i = 0; i < taula.length - 1; i++) { //recorr tot l'array menys 1
            for (int j = 0; j < taula.length - i - 1; j++) { //recorr tot l'array menys 1 menys els que ja tenim ordenats
                comparatives++;
                if (taula[j] > taula[j + 1]) { //si no estan ordenats, les gir
                    intercanvis++;
                    girarNombres(j, j + 1, taula);
                }
            }
        }
        long horaEnd = System.currentTimeMillis();
        long deltaTime = horaEnd - horaStart; // deltaTime es la diferencia entre el temps de arrancada i el temps de finalitzacio de la funcio
        imprimirDades(deltaTime, comparatives, intercanvis);

    }

    public static void selectionSort(int taula[]) {
        long horaStart = System.currentTimeMillis();
        int comparatives = 0;
        int intercanvis = 0;
        int indexNombreMinim = 0;
        for (int i = 0; i < taula.length - 1; i++) { //recorr tot l'array menys 1
            for (int j = i; j < taula.length; j++) { //recorr tot l'array desde el primer desordenat fins al final
                comparatives++; //sumam les comparatives
                if (taula[j] <= taula[indexNombreMinim]) { //si el nombre que esteim comprovant es mes alt o igual que amb el que esteim comparant
                    indexNombreMinim = j; //  el marcam com a mes petit
                }
            }
            intercanvis++; //sumam els intercanvis
            girarNombres(i, indexNombreMinim, taula);
        }
        long horaEnd = System.currentTimeMillis();
        long deltaTime = horaEnd - horaStart; // deltaTime es la diferencia entre el temps de arrancada i el temps de finalitzacio de la funcio
        imprimirDades(deltaTime, comparatives, intercanvis);

    }

    public static void insertionSort(int taula[]) {
        long horaStart = System.currentTimeMillis();
        int comparatives = 0;
        int intercanvis = 0;
        for (int i = 1; i < taula.length; i++) { //recorr tot l'array menys 1
            for (int j = 0; j < taula.length; j++) { //recorr tot l'array desde 0 fins al darrer nombre ordenat
                comparatives++;
                while (taula[j] > taula[i]) {
                    intercanvis++;
                    girarNombres(i, j, taula);
                }
            }
        }
        long horaEnd = System.currentTimeMillis();
        long deltaTime = horaEnd - horaStart; // deltaTime es la diferencia entre el temps de arrancada i el temps de finalitzacio de la funcio
        imprimirDades(deltaTime, comparatives, intercanvis);

    }

    public static void imprimirArray(int taula[]) {
        System.out.println("Array Actual:");
        for (int i = 0; i < taula.length; i++) {
            System.out.println(taula[i]);
        }
        System.out.println("Fi de l'array:");
    }

    public static void imprimirDades(long temps, int comparatives, int intercanvis) {
        imprimirTemps(temps);
        System.out.println("La funcio ha fet un total de " + comparatives + " comparacions");
        System.out.println("La funcio ha fet un total de " + intercanvis + " intercanvis");
    }

    public static void imprimirTemps(long temps) {
        System.out.println("La funcio ha tardat un total de " + temps + "ms en executar-se");
        long ms = 0;
        long s = 0;
        long m = 0;
        m = temps / 60000;
        s = temps / 1000 - m * 60;
        temps -= s * 1000;
        System.out.println("La funcio ha tardat " + m + " minuts, " + s + " segons i " + temps + "ms ");
    }

    public static void girarNombres(int n1, int n2, int[] taula) {
        int temp = 0;
        temp = taula[n1];
        taula[n1] = taula[n2];
        taula[n2] = temp;
        imprimirArray(taula);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int midaArray = 0; //l'emprarem per la mida de l'array
        System.out.println("Quants d'elements voldra que tengui l'array?");
        midaArray = s.nextInt();
        int bubbleArray[] = new int[midaArray]; //cream un array per Bubble Sort
        int selectionArray[] = new int[midaArray]; //cream un array per Selection Sort
        int insertionArray[] = new int[midaArray]; //cream un array per Insertion Sort
        int tipusOmplir = 0; // per averiguar si volem que l'array s'omplir amb nombres aleatoris o manuals
        System.out.println("Com vol que s'ompli l'array?");
        System.out.println("Introdueix 1 si vol introduir els nombres manualment");
        System.out.println("Introdueix un altre nombre si vol nombres autogenerats de 1 a 10");
        tipusOmplir = s.nextInt();
        for (int i = 0; i < bubbleArray.length; i++) { //omplirem l'array, o be amb nombres introduits per usuari o amb aleatoris 
            if (tipusOmplir == 1) {
                System.out.println("Introdueixi el nombre " + (i + 1));
                bubbleArray[i] = s.nextInt();
                selectionArray[i] = bubbleArray[i];
                insertionArray[i] = selectionArray[i];
            } else {
                bubbleArray[i] = (int) (Math.random() * 10); //els nombres aleatoris seran de 1 a 10
                selectionArray[i] = bubbleArray[i];
                insertionArray[i] = selectionArray[i];
            }
        }
        bubbleSort(bubbleArray);
        selectionSort(selectionArray);
        insertionSort(insertionArray);
    }
}
