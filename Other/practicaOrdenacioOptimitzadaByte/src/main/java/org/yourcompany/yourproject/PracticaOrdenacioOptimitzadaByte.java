/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author alumne
 */
public class PracticaOrdenacioOptimitzadaByte {

    public static void bubbleSort(byte taula[], byte debugMode) {
        long horaStart = System.currentTimeMillis();
        byte comparatives = 0;
        byte intercanvis = 0;
        for (byte i = 0; i < taula.length - 1; i++) { //recorr tot l'array menys 1
            for (byte j = 0; j < taula.length - i - 1; j++) { //recorr tot l'array menys 1 menys els que ja tenim ordenats
                comparatives++;
                if (taula[j] > taula[j + 1]) { //si no estan ordenats, les gir
                    intercanvis++;
                    girarNombres(j, (byte) (j + 1), taula, debugMode);
                }
            }
        }
        long horaEnd = System.currentTimeMillis();
        long deltaTime = horaEnd - horaStart; // deltaTime es la diferencia entre el temps de arrancada i el temps de finalitzacio de la funcio
        imprimirDades(deltaTime, comparatives, intercanvis);

    }

    public static void selectionSort(byte taula[], byte debugMode) {
        long horaStart = System.currentTimeMillis();
        byte comparatives = 0;
        byte intercanvis = 0;
        byte indexNombreMinim = 0;
        for (byte i = 0; i < taula.length - 1; i++) { //recorr tot l'array menys 1
            for (byte j = i; j < taula.length; j++) { //recorr tot l'array desde el primer desordenat fins al final
                comparatives++; //sumam les comparatives
                if (taula[j] <= taula[indexNombreMinim]) { //si el nombre que esteim comprovant es mes alt o igual que amb el que esteim comparant
                    indexNombreMinim = j; //  el marcam com a mes petit
                }
            }
            intercanvis++; //sumam els intercanvis
            girarNombres(i, indexNombreMinim, taula, debugMode);
        }
        long horaEnd = System.currentTimeMillis();
        long deltaTime = horaEnd - horaStart; // deltaTime es la diferencia entre el temps de arrancada i el temps de finalitzacio de la funcio
        imprimirDades(deltaTime, comparatives, intercanvis);

    }

    public static void insertionSort(byte taula[], byte debugMode) {
        long horaStart = System.currentTimeMillis();
        byte comparatives = 0;
        byte intercanvis = 0;
        for (byte i = 1; i < taula.length; i++) { //recorr tot l'array menys 1
            for (byte j = 0; j < taula.length; j++) { //recorr tot l'array desde 0 fins al darrer nombre ordenat
                comparatives++;
                while (taula[j] > taula[i]) {
                    intercanvis++;
                    girarNombres(i, j, taula, debugMode);
                }
            }
        }
        long horaEnd = System.currentTimeMillis();
        long deltaTime = horaEnd - horaStart; // deltaTime es la diferencia entre el temps de arrancada i el temps de finalitzacio de la funcio
        imprimirDades(deltaTime, comparatives, intercanvis);
    }

    public static void imprimirArray(byte taula[]) {
        System.out.println("Array Actual:");
        for (byte i = 0; i < taula.length; i++) {
            System.out.println(taula[i]);
        }
        System.out.println("Fi de l'array:");
    }

    public static void imprimirDades(long temps, byte comparatives, byte intercanvis) {
        System.out.println("Array ordenat!");
        imprimirTemps(temps);
        System.out.println("La funcio ha fet un total de " + comparatives + " comparacions");
        System.out.println("La funcio ha fet un total de " + intercanvis + " intercanvis");
    }

    public static void imprimirTemps(long temps) {
        System.out.println("La funcio ha tardat un total de " + temps + "ms en executar-se");
        long s = 0;
        long m = 0;
        m = temps / 60000;
        s = temps / 1000 - m * 60;
        temps -= m * 60000 + s * 1000;
        System.out.println("La funcio ha tardat " + m + " minuts, " + s + " segons i " + temps + "ms ");
    }

    public static void girarNombres(byte n1, byte n2, byte[] taula, byte debugMode) {
        byte temp = 0;
        temp = taula[n1];
        taula[n1] = taula[n2];
        taula[n2] = temp;
        if (debugMode == 1) {
            imprimirArray(taula);
        }
    }

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner s = new Scanner(System.in);
        byte midaArray = 0; //l'emprarem per la mida de l'array
        System.out.println("Quants d'elements voldra que tengui l'array?");
        midaArray = s.nextByte();
        byte bubbleArray[] = new byte[midaArray]; //cream un array per Bubble Sort
        byte selectionArray[] = new byte[midaArray]; //cream un array per Selection Sort
        byte insertionArray[] = new byte[midaArray]; //cream un array per Insertion Sort
        byte tipusOmplir = 0; // per averiguar si volem que l'array s'omplir amb nombres aleatoris o manuals
        System.out.println("Com vol que s'ompli l'array?");
        System.out.println("Introdueix 1 si vol introduir els nombres manualment");
        System.out.println("Introdueix un altre nombre si vol nombres autogenerats de 1 a 10");
        tipusOmplir = s.nextByte();
        byte debugMode = 0;
        System.out.println("Vol veure l'array cada vegada que es fa un canvi? introdueix 1 si ho vol veure");
        debugMode = s.nextByte();
        for (byte i = 0; i < bubbleArray.length; i++) { //omplirem l'array, o be amb nombres introduits per usuari o amb aleatoris 
            if (tipusOmplir == 1) {
                System.out.println("Introdueixi el nombre " + (i + 1));
                bubbleArray[i] = s.nextByte();
            } else {
                bubbleArray[i] = (byte) (Math.random() * 10); //els nombres aleatoris seran de 1 a 10
            }
            selectionArray[i] = bubbleArray[i];
            insertionArray[i] = selectionArray[i];
        }
        bubbleSort(bubbleArray, debugMode);
        selectionSort(selectionArray, debugMode);
        insertionSort(insertionArray, debugMode);
    }
}
