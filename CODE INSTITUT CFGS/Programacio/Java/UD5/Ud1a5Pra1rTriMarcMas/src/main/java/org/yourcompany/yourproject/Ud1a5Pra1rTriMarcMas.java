/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class Ud1a5Pra1rTriMarcMas {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK_TEXT = "\u001B[30m";
    public static final String ANSI_RED_TEXT = "\u001B[31m";
    public static final String ANSI_GREEN_TEXT = "\u001B[32m";
    public static final String ANSI_YELLOW_TEXT = "\u001B[33m";
    public static final String ANSI_BLUE_TEXT = "\u001B[34m";
    public static final String ANSI_PURPLE_TEXT = "\u001B[35m";
    public static final String ANSI_CYAN_TEXT = "\u001B[36m";
    public static final String ANSI_WHITE_TEXT = "\u001B[37m";

    public static void color(int colorSeleccionat) {

        String colorText[] = new String[8];
        colorText[0] = ANSI_BLACK_TEXT;
        colorText[1] = ANSI_RED_TEXT;
        colorText[2] = ANSI_GREEN_TEXT;
        colorText[3] = ANSI_YELLOW_TEXT;
        colorText[4] = ANSI_BLUE_TEXT;
        colorText[5] = ANSI_PURPLE_TEXT;
        colorText[6] = ANSI_CYAN_TEXT;
        colorText[7] = ANSI_WHITE_TEXT;

        System.out.print(colorText[colorSeleccionat]);

    }

    public static void resetColor() {
        System.out.print(ANSI_RESET);
    }

    public static int[] demanarNombres() {
        Scanner s = new Scanner(System.in);
        int[] nombres = new int[0];
        int input = 0;
        do {
            System.out.println("Introdueixi un nombre");
            System.out.println("Per aturar d'introduir nombres, introdueixi 0");
            input = s.nextInt();
            nombres = insertarValor(input, nombres);
        } while (input != 0);

        return nombres;
    }

    public static int[] insertarValor(int input, int[] array) {
        int[] array2 = copiarArray(array, array.length + 1);
        array2[array.length] = input;
        return array2;
    }

    public static int[] llevarPrimerValor(int[] array) {
        int[] array2 = new int[array.length - 1];
        for (int i = 1; i < array2.length; i++) {
            array2[i - 1] = array[i];
        }
        return array2;
    }

    public static int[] copiarArray(int[] array) {
        int[] array2 = new int[array.length];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = array[i];
        }
        return array2;
    }

    public static int[] copiarArray(int[] arrayOriginal, int midaArrayNou) {
        if (midaArrayNou == arrayOriginal.length) {
            return copiarArray(arrayOriginal);
        } else {
            int[] array2 = new int[midaArrayNou];
            for (int i = 0; i < arrayOriginal.length && i < array2.length; i++) {
                array2[i] = arrayOriginal[i];
            }
            return array2;
        }
    }

    public static void imprimirArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println("");

    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.setOut(new PrintStream(System.out, true, "UTF-8"));
        int[] nombres = demanarNombres();
        menu(nombres);
    }

    public static boolean comprovarOrdenacio(int[] array) {
        int index = 0;
        while (index < (array.length - 1)) {
            if (array[index] > array[index + 1]) {
                return false;
            }
            index++;
        }
        return true;
    }

    public static int[] ordenacioAvançada(int[] array, int algorisme) {
        if (algorisme == 1) {
            return mergeSort(array); // NO FUNCIONA
        } else {
            return quickSort(array);
        }
    }

    public static int[] mergeSort(int[] arrayOriginal) {
        int[] test = new int[0];

        /* com funciona mergesort
        1: divideix l'array en dues mitats, fins que cada item esta tot sol
        2: va agafant els items de 2 en 2 i les junta en arrays temporals ordenats

        28539417 ->
        2 8 5 3 9 4 1 7 ->
        28 53 94 17 ->
        2358 1479 ->
        12345789
         */
        return test;
    }

    public static void girarNombres(int[] array, int indexA, int indexB) {
        int temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
    }

    public static int[] quickSort(int[] array) {
        return quickSort(array, 0, array.length);
    }

    public static int[] quickSort(int[] array, int min, int max) {
        int[] taulaOrdenada = copiarArray(array);
        int indexPivot = (int) taulaOrdenada.length / 2; //emprare el nombre denmig com a pivot
        // agaf un pivot, moc fins al final
        // agafam 3
        // 2 6 5 '3' 8 7 1 0
        // 2 6 5 0 8 7 1 '3'
        // agafes el PRIMER nombre mes GRAN que el pivot desde la esquerra
        // agafes el PRIMER nombre mes PETIT que el pivot desde la dreta 
        // gires
        // atures quan itemfromLeft > itemfromRight 
        // itemfromLeft swapWith pivot
        girarNombres(taulaOrdenada, indexPivot, taulaOrdenada.length - 1); //vull girar el pivot amb el darrer nombre
        int index = 0;
        int indexEsquerra = 0;
        int indexDreta = 0;
        while (taulaOrdenada[index] < taulaOrdenada[indexPivot] && index < taulaOrdenada.length) {
            index++;
        }
        indexEsquerra = index;
        index = taulaOrdenada.length - 2; //-1 per el darrer valor, -2 per el pivot
        while (taulaOrdenada[index] > taulaOrdenada[indexPivot] && index > 0) {
            index--;
        }
        indexDreta = index;
        System.out.println("Antes de ordenar");
        imprimirArray(taulaOrdenada);
        System.out.println("Despres de ordenar");
        girarNombres(taulaOrdenada, indexDreta, indexEsquerra);

        return taulaOrdenada;
        // return taulaOrdenada;
        // if (comprovarOrdenacio(taulaOrdenada)) {
        //     return taulaOrdenada;
        // } else {
        //     int midaArrayL = 0;
        //     if ((int) (taulaOrdenada.length / 2) % 2 == 0) {
        //         midaArrayL = (int) taulaOrdenada.length / 2;
        //     } else {
        //         midaArrayL = (int) taulaOrdenada.length / 2 + 1;
        //     }
        //     int[] arrayL = new int[midaArrayL];
        //     for (int i = 0; i < arrayL.length; i++) {
        //         // arrayL = quickSort(arrayL);
        //         quickSort(arrayL);
        //     }
        //     int[] arrayR = new int[(int) (taulaOrdenada.length / 2)];
        //     for (int i = arrayR.length - 1; i < taulaOrdenada.length; i++) {
        //         // arrayR = quickSort(arrayR);
        //         quickSort(arrayR);
        //     }
        // }
        // return taulaOrdenada;
    }

    public static int cercaBinaria(int[] array, int clau) {

        int index = 0;
        if (index > 0) {
            // Element X trobat a la posició Y
        } else {
            // Element X no trobat”, però no s'ha de mostrar -1.
        }
        return index;
    }

    public static void divisorsNombre(int[] array) {
        // Els divisors de X són A, B, C, … i Z

        // No mostris els resultats d'una posició, si ja has calculat els divisors d'aquell nombre.
    }

    public static void multiplesTres(int[] array) {
        int arrayMultiples[] = new int[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 3 == 0) {
                insertarValor(array[i], arrayMultiples);
            }
        }
    }

    public static void menorsIMajors(int[] array) {

    }

    public static void donarColor(boolean opcio) {
        donarColor(opcio, (byte) 2, (byte) 1); //sobrecarregada de la funcio amb colors estandar, vermell i verd
    }

    public static void donarColor(boolean opcio, byte colorTrue, byte colorFalse) { //per donar color als missatges
        if (opcio) {
            color(colorTrue);
        } else {
            color(colorFalse);
        }
    }

    public static void menu(int[] array) {
        Scanner s = new Scanner(System.in);
        System.out.println("Benvingut al meu programa! Amb l'array introduit pot fer diverses coses:");
        boolean comprovarOpcio1 = false; // boolean per saber si hem la opcio 1 o no 
        boolean sortir = false; //per saber si hem de seguir dins el bucle del menu o no
        while (!sortir) {
            donarColor(comprovarOrdenacio(array)); //si l'array esta ordenat, 
            System.out.println("1. Ordenació avançada d'array");
            resetColor();

            donarColor(comprovarOpcio1);
            System.out.println("2. Cerca binaria");
            resetColor();

            System.out.println("3. Mostrar Divisors");
            donarColor(comprovarOrdenacio(array));

            System.out.println("4. Multiples de 3");
            resetColor();

            System.out.println("5. Mostrar Menors i Majors a un nombre");
            System.out.println("Introdueix qualsevol nombre negatiu per sortir");
            int opcio = s.nextInt();
            if (opcio < 0) {
                sortir = true;
            } else {
                switch (opcio) {
                    case 1 -> {
                        System.out.println("Quin algoritme vol emprar?");
                        System.out.println("1: MergeSort");
                        System.out.println("2: QuickSort");
                        int algorisme = s.nextInt();
                        int[] arrayOrdenat = ordenacioAvançada(array, algorisme);
                        comprovarOpcio1 = true;
                        imprimirArray(arrayOrdenat);
                    }
                    case 2 -> {
                        System.out.println("Quin nombre vol cercar?");
                        int clau = s.nextInt();
                        cercaBinaria(array, clau);
                    }
                    case 3 -> {
                        divisorsNombre(array);
                    }
                    case 4 -> {
                        multiplesTres(array);
                    }
                    case 5 -> {
                        menorsIMajors(array);
                    }
                }
            }
        }
    }

    // color(2, 1); //comença a pintar verd
    // System.out.println("test");
    // color(1, 1); //comença a pintar vermell
    // System.out.println("test");
    // resetColor(); //deixa de pintar en color
}
