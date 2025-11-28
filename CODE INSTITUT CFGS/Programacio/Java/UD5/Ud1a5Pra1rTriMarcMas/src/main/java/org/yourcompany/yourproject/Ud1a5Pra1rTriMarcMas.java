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

    // codis ANSI per colors
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK_TEXT = "\u001B[30m";
    public static final String ANSI_RED_TEXT = "\u001B[31m";
    public static final String ANSI_GREEN_TEXT = "\u001B[32m";
    public static final String ANSI_YELLOW_TEXT = "\u001B[33m";
    public static final String ANSI_BLUE_TEXT = "\u001B[34m";
    public static final String ANSI_PURPLE_TEXT = "\u001B[35m";
    public static final String ANSI_CYAN_TEXT = "\u001B[36m";
    public static final String ANSI_WHITE_TEXT = "\u001B[37m";

    //funcio de color per pintar amb un color especific
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

    public static int[] demanarNombres() { //demanarem nombres fins que s'introduesqui un 0
        Scanner s = new Scanner(System.in);
        int input = 0;
        System.out.println("Per generar un array aleatori amb 10 entrades de 0 a 100, introdueixi -1"); //com a extra, mode de debugging
        System.out.println("Per introduir el nombres manualment introdueixi qualsevol altre nombre");
        int[] nombres = new int[0]; //generam un array amb longitut 0, l'anirem ampliant
        if (s.nextInt() != -1) { //si NO hem activat el mode de debugging, anam demanant valors fins a introduir un 0
            do {
                System.out.println("Introdueixi un nombre");
                System.out.println("Per aturar d'introduir nombres, introdueixi 0");
                input = s.nextInt();
                nombres = insertarValor(input, nombres); //anam insertant els valors a nombres
            } while (input != 0);
        } else {
            for (int i = 0; i < 10; i++) { //si hem posat mode debug, generam un array de 10 posicions amb nombres de 0 a 100
                input = (int) (Math.random() * 100);
                nombres = insertarValor(input, nombres);
            }
        }
        return nombres;
    }

    public static int[] insertarValor(int input, int[] array) { //per insertar valors
        int[] array2 = copiarArray(array, array.length + 1); // copiam l'array amb una posicio mes
        array2[array.length] = input; // assignam a la darrera posicio el valor que volem insertar
        return array2;
    }

    public static int[] copiarArray(int[] array) { //copia de array amb mides iguals
        int[] array2 = new int[array.length];
        for (int i = 0; i < array2.length; i++) { //recorrem tot l'array i ho copiam a array2
            array2[i] = array[i];
        }
        return array2;
    }

    public static int[] copiarArray(int[] arrayOriginal, int midaArrayNou) { //sobrecarrega, en cas de voler una mida diferent
        if (midaArrayNou == arrayOriginal.length) {
            return copiarArray(arrayOriginal);
        } else {
            int[] array2 = new int[midaArrayNou]; //cream un array amb la mida nova
            for (int i = 0; i < arrayOriginal.length && i < array2.length; i++) { //com no sabem si sera mes curt o mes llarg, comprovam que no estiguem mirant un valor que no existeix a un dels dos arrays
                array2[i] = arrayOriginal[i];
            }
            return array2;
        }
    }

    public static boolean arraysIguals(int[] ar1, int[] ar2) {
        if (ar1.length == ar2.length) { //si las mides son iguals, comprovam, si no ho son no feim res i retornam false
            for (int i = 0; i < ar1.length; i++) { //recorrem tot l'array, i anam comprovant si totes les posicions son iguals
                if (ar1[i] != ar2[i]) {
                    return false; //si una d'elles no es igual, retornam false
                }
            }
            return true; //si hem completat l'array i no hem sortit del bucle, els arrays son iguals
        }
        return false;
    }

    public static void imprimirArray(int[] array) {
        for (int i = 0; i < array.length; i++) { //recorrem tot l'array i imprimim tots els valors un darrera l'altre amb comes
            System.out.print(array[i] + ", ");
        }
        System.out.println("");
    }

    public static void main(String[] args) throws UnsupportedEncodingException { //throws UnsupportedEncoding -> per poder tenir accents
        System.setOut(new PrintStream(System.out, true, "UTF-8"));
        int[] nombres = demanarNombres(); // cream un array amb la funcio demanarNombres i cridam el menu amb ell
        menu(nombres);
    }

    public static boolean comprovarOrdenacio(int[] array) { //per saber si un array esta ordenat o no
        int index = 0;
        while (index < (array.length - 1)) { //recorrem tot l'array
            if (array[index] > array[index + 1]) { //si el nombre actual es mes gran que el seguent, no esta en ordre
                return false;
            }
            index++;
        }
        return true; //si no hem sortit, esta ordenat
    }

    public static void girarNombres(int[] array, int indexA, int indexB) { //funcio per girar nombres
        int temp = array[indexA]; //cream una variable temporal i guardam el valor 1
        array[indexA] = array[indexB]; //assignam valor2 a valor1
        array[indexB] = temp; //assignam el valor1 que esta a temporal a valor2
    }

    public static int[] quickSort(int array[]) {
        int[] taulaOrdenada = copiarArray(array); //feim una copia de l'array
        return quickSort(taulaOrdenada, 0, taulaOrdenada.length - 1); //l'ordenam
    }

    public static int[] quickSort(int[] array, int min, int max) {
        if (min < max) { //si max es major a minim, es a dir, esteim ordenant un subarray amb més d'un item
            int pivot = calcularPivot(array, min, max); // calcul el pivot i faig les iteracions a dins el subarray
            quickSort(array, min, pivot - 1); // feim quicksort de la banda esquerra (desde 0 fins al darrer numero comprovat)
            quickSort(array, pivot + 1, max); // feim quicksort de la banda dreta (desde el darrer numero comprovat fins al final)
        }
        return array;
    }

    public static int calcularPivot(int[] taula, int min, int max) {
        int pivot = taula[max]; //el pivot serà el darrer nombre
        int punter1 = min - 1; // prepar un altre variable desde min -1
        for (int punter2 = min; punter2 < max; punter2++) { //començ un bucle desde i+1, i tendrem un punter al principi-1 i l'altre al principi
            if (taula[punter2] <= pivot) { //si el nombre que esteim mirant es igual o menor al pivot, sumam I i giram els nombres
                punter1++;
                girarNombres(taula, punter1, punter2);
            }
        }

        girarNombres(taula, punter1 + 1, max); //al final del bucle, giram el primer punter amb el pivot
        return punter1 + 1;
    }

    public static int cercaBinaria(int[] array, int clau) {
        return cercaBinaria(array, clau, 0, array.length - 1); //sobrecarrega, cridam binarySearch amb l'array sencer
    }

    public static int cercaBinaria(int[] array, int clau, int min, int max) {
        //cerca binaria, vull comprovar l'element del mig de l'array (entre els dos nombres que esteim comprovant)
        // exemple: si anam entre 0 i 10, volem mirar el numero 5, si anam entre 5 i 10, volem mirar l'element 7 (10/5 = 2 + 5 = 7)
        int index = (int) ((max - min) / 2) + min;
        if (index < 0) { //si l'index es negatiu donam un error i surtim
            System.out.println("Error");
            return index;
        }

        if (array[index] == clau) { //si trobam l'element, ho mostram per pantalla
            System.out.println("Element " + array[index] + " trobat a la posició " + index + 1);
            // Element X trobat a la posició Y
            return index;
        }
        if (min == max) { //si no l'hem trobat i només esteim mirant un nombre, confirmam que l'element no hi és
            System.out.println("Element " + clau + " no trobat!");
            //Element X no trobat
            return -1;
        }
        if (clau < array[index]) { //si la clau es mes petita que el nombre que hem comprovat, llevam la meitat superior de l'array
            max = index;
        } else { // si no, llevam la meitat inferior + 1 (hem comprovat el 5 de 0 a 10, la seguent comparativa serà de 6 (5 ja està comprovat) a 10 )
            min = index + 1;
        }
        cercaBinaria(array, clau, min, max); //com no hem sortit, tornam a cridar la funció
        return index;
    }

    public static int cercaSequencial(int[] array, int clau) {
        int i = 0;
        while (i < array.length) { //recorrem tot l'array 
            if (array[i] == clau) { //si trobam la clau, sortim i retornam l'index
                return i;
            }
            i++; //cada vegada que no el trobem, sumam 1
        }
        return -1; //si no l'hem trobat, retornam -1
    }

    public static void divisorsNombre(int[] array) {
        int[] nombresMostrats = new int[0]; //array per saber quins nombres hem calculat i quins no
        for (int i = 0; i < array.length; i++) { //recorrem tot l'array
            calcularDivisors(array[i], nombresMostrats); //calculam els divisors
            nombresMostrats = insertarValor(array[i], nombresMostrats); //afegim el nombre a la taula de nombresMostrats
        }
    }

    public static void calcularDivisors(int nombre, int[] nombresMostrats) {
        if (cercaSequencial(nombresMostrats, nombre) == -1) { //si ja hem mostrat el numero, no feim res
            int[] divisorsNombre = new int[0]; //cream un array buit 
            for (int i = 1; i < nombre; i++) {
                if (nombre % i == 0) { //si el nombre es divisible, l'afegim a la taula de divisorsNombre
                    divisorsNombre = insertarValor(i, divisorsNombre);
                }
            }
            if (divisorsNombre.length > 2) { //si hi ha més de dos divisors 
                System.out.print("Els divisors de " + nombre + " són ");
                for (int i = 1; i < divisorsNombre.length - 1; i++) {
                    if (i != 1) {
                        System.out.print(", ");
                    }
                    System.out.print(divisorsNombre[i]);
                }
                System.out.print(" i ");
                System.out.println(divisorsNombre[divisorsNombre.length - 1]);
            } else {
                System.out.println("El nombre " + nombre + " és primer, no té divisors");
            }
        }
    }

    public static int[] multiplesTres(int[] array) {
        int arrayMultiples[] = new int[0]; //cream un array de longitut 0
        if (!comprovarOrdenacio(array)) {
            for (int i = 0; i < array.length; i++) { //recorrem tot l'array
                if (array[i] % 3 == 0) {
                    arrayMultiples = insertarValor(array[i], arrayMultiples); //anam omplint el nou array cada vegada que el valor sigui multiple de 3
                }
            }
        } else {
            System.out.println("L'array introduit està ordenat!");
            System.out.println("Aquesta opció no es possible si està ordenat");
            arrayMultiples = copiarArray(array);
        }
        return arrayMultiples;
    }

    public static void menorsIMajors(int[] array) {
        Scanner s = new Scanner(System.in);
        System.out.println("Introdueixi un numero");
        int input = s.nextInt();
        while (valorMin(array) > input && input < valorMax(array)) {
            System.out.println("Introdueixi un numero valid entre els valors minim i maxim de l'array!");
            input = s.nextInt();
        }
        System.out.println("Array original: ");
        imprimirArray(array);
        System.out.print("Input de l'usuari: ");
        System.out.println(input);
        mostrarMenors(array, input);
        mostrarMajors(array, input);
    }

    public static void mostrarMenors(int[] array, int input) {
        System.out.println("Nombre inferiors a " + input + ":");
        for (int i = 0; i < array.length; i++) {
            if (array[i] < input) {
                System.out.print(array[i] + ", ");
            }
        }
        System.out.println("");
    }

    public static void mostrarMajors(int[] array, int input) {
        System.out.println("Nombre superiors a " + input + ":");
        for (int i = 0; i < array.length; i++) {
            if (array[i] > input) {
                System.out.print(array[i] + ", ");
            }
        }
        System.out.println("");
    }

    public static int valorMin(int[] array) {
        int minim = array[0]; //el primer valor sera sempre el primer valor de l'array, ja que no vull posar un nombre massa baix mai
        for (int i = 1; i < array.length; i++) { //recorrem tot l'array, si trobam un nombre més petit que l'actual, el canviam
            if (minim < array[i]) {
                minim = array[i];
            }
        }
        return minim;
    }

    public static int valorMax(int[] array) {
        int maxim = array[0]; //el primer valor sera sempre el primer valor de l'array, ja que no vull posar un nombre massa alt mai
        for (int i = 1; i < array.length; i++) { //recorrem tot l'array, si trobam un nombre més gran que l'actual, el canviam
            if (maxim > array[i]) {
                maxim = array[i];
            }
        }
        return maxim;
    }

    public static void donarColor(boolean opcio) {
        donarColor(opcio, (byte) 2, (byte) 1); //sobrecarrega de la funcio amb colors estandar, vermell i verd
    }

    public static void donarColor(boolean opcio, byte colorTrue, byte colorFalse) { //per donar color als missatges, li passariem quin color hem d'emprar (si el de true o el de false) i els dos colors que s'empraràn
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
        int[] arrayOrdenat = new int[0];
        while (!sortir) {
            donarColor(!comprovarOrdenacio(array)); //si l'array esta ordenat, pintarem aquesta opcio en verd, si no, la pintarem en vermell 
            System.out.println("1. Ordenació avançada d'array");
            resetColor();

            donarColor(comprovarOpcio1); //si hem fet l'opcio 1 abans, podem fer cerca binaria, aixi que pintarem verd, si no, vermell
            System.out.println("2. Cerca binaria");
            resetColor();

            System.out.println("3. Mostrar Divisors");

            donarColor(!comprovarOrdenacio(array));
            System.out.println("4. Multiples de 3");
            resetColor();

            System.out.println("5. Mostrar Menors i Majors a un nombre");
            resetColor();

            System.out.println("6. Re-introduir array de nombres");

            resetColor();
            System.out.println("Introdueix qualsevol nombre negatiu per sortir");
            int opcio = s.nextInt();
            if (opcio < 0) {
                sortir = true;
            } else {
                switch (opcio) {
                    case 1 -> {
                        if (!comprovarOrdenacio(array)) {
                            System.out.println("Array original:");
                            imprimirArray(array);
                            arrayOrdenat = quickSort(array);
                            comprovarOpcio1 = true;
                            System.out.println("Array ordenat:");
                            imprimirArray(arrayOrdenat);
                        } else {
                            System.out.println("L'array ja esta ordenat!");
                        }
                    }
                    case 2 -> {
                        if (comprovarOpcio1) {
                            if (comprovarOrdenacio(arrayOrdenat)) {
                                System.out.println("Quin nombre vol cercar?");
                                int clau = s.nextInt();
                                cercaBinaria(arrayOrdenat, clau);
                            } else {
                                //si l'array no esta ordenat, no podem emprar cerca binaria i retornarem -1 com a error
                                System.out.println("No es pot fer cerca binaria sense ordenar!");
                            }
                        } else {
                            System.out.println("Has de fer l'opció 1 abans!");
                        }
                    }
                    case 3 -> {
                        divisorsNombre(array);
                    }
                    case 4 -> {
                        if (!comprovarOrdenacio(array)) {
                            int[] arrayMultiples3 = multiplesTres(array);
                            System.out.println("Array original:");
                            imprimirArray(array);
                            System.out.println("Multiples de 3:");
                            imprimirArray(arrayMultiples3);
                        } else {
                            System.out.println("L'array esta ordenat, no pots emprar aquesta opcio!");
                        }
                    }
                    case 5 -> {
                        menorsIMajors(array);
                    }
                    case 6 -> {
                        int[] arrayNou = demanarNombres(); //cream un array nou on guardarem tots els nombres
                        if (!arraysIguals(arrayNou, array)) {
                            array = copiarArray(arrayNou); //si els arrays NO son iguals, guardarem arrayNou com el array a emprar per les altres opcions
                            comprovarOpcio1 = false; //reiniciam la opcio 1
                        }
                    }
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
// restos de quicksort
/* int test{};
        // int[] test2;
        // int test3 = new int[10];
        // int[] test4 = {1,2,3};
        // System.out.println("Primer numero mes gran: " + taula[indexEsquerra]);
        // // casi funciona !!
        // imprimirArray(taula);
        // int opcio = 0;
        // int finalSort = 0;
        // Scanner s = new Scanner(System.in);
        // while (opcio != 2) {
        //     System.out.println("Part a ordenar (1 es esquerra)");
        //     opcio = s.nextInt();
        //     if (opcio == 1) {
        //         if (indexDreta > 0) {
        //             System.out.println("Antes");
        //             imprimirArray(taula);
        //             taula = quickSort(taula, primerIndexDesordenat(taula), indexDreta);
        //             System.out.println("Despues");
        //             imprimirArray(taula);
        //             System.out.println("Els nombres fins a " + primerIndexDesordenat(taula) + " Estan ordenats");
        //         } else {
        //             System.out.println("Else");
        //             imprimirArray(taula);
        //             System.out.println("Els nombres fins a " + primerIndexDesordenat(taula) + " Estan ordenats");
        //         }
        //     }
        // }
        // if (indexEsquerra > 1) {
        //     taula = quickSort(taula, indexDreta + 1, taula.length);
        // }
        // SUBDIVISIO
        /* aixo funciona, pero no serveix per quickSort lol
        System.out.println("Crear subtaula amb nombres mes petits");
        int subTaulaEsq[] = copiarArray(taula, indexEsquerra);
        // int subTaulaEsq[] = new int[taula.length];
        // for (int i = 0; i < indexEsquerra; i++) {
        //     subTaulaEsq[i] = taula[i];
        // }
        // imprimirArray(taula);
        System.out.println("Antes");
        imprimirArray(subTaulaEsq);
        subTaulaEsq = quickSort(subTaulaEsq);
        System.out.println("Despues");
        imprimirArray(subTaulaEsq);
 */
// casi funciona !!
// int opcio = 0;
// int finalSort = 0;
// Scanner s = new Scanner(System.in);
// while (opcio != 2) {
//     System.out.println("Part a ordenar (1 es esquerra)");
//     opcio = s.nextInt();
//     if (opcio == 1) {
//         if (indexDreta > 0) {
//             System.out.println("Antes");
//             imprimirArray(taula);
//             taula = quickSort(taula, 0, indexDreta);
//             System.out.println("Despues");
//             imprimirArray(taula);
//         } else {
//             System.out.println("Else");
//             imprimirArray(taula);
//         }
//     }
// }
// public static int nombreDreta(int[] array, int pivot, int min, int max) {
//     int index = max - 1;
//     while (array[index] > pivot && index > min) {
//         index--;
//     }
//     return index;
// }
// public static int nombreDreta(int[] array, int pivot) {
//     return nombreDreta(array, pivot, 0, array.length);
// }
// public static int nombreEsquerra(int[] array, int pivot, int min, int max) {
//     int index = min;
//     while (index < max - 1 && array[index] < pivot) {
//         index++;
//     }
//     return index;
// }
// public static int nombreEsquerra(int[] array, int pivot) {
//     return nombreDreta(array, pivot, 0, array.length);
// }
// public static int[] quickSort(int[] array) {
//     // for (int i = 0; i < array.length; i++) {
//     //     array[i] = (int) (Math.random() * 100);
//     //     // return quickSort(array, 0, 5);
//     // }
//     return quickSort(array, 0, array.length);
// }
// public static int[] quickSort(int[] array, int min, int max) {
//     // agaf un pivot, moc fins al final
//     // agafam 3
//     // 2 6 5 '3' 8 7 1 0
//     // 2 6 5 0 8 7 1 '3'
//     // agafes el PRIMER nombre mes GRAN que el pivot desde la esquerra
//     // agafes el PRIMER nombre mes PETIT que el pivot desde la dreta 
//     // gires
//     // atures quan itemfromLeft > itemfromRight 
//     int[] taula = copiarArray(array);
//     imprimirArray(taula);
//     int pivotIndex = max - 1;
//     if (pivotIndex < 0) {
//         return taula;
//     }
//     int pivot = taula[pivotIndex];
//     int indexEsquerra = 0;
//     int indexDreta = 0;
//     do {
//         indexDreta = nombreDreta(taula, pivot);
//         // indexDreta = nombreDreta(taula, pivot, min, max);
//         System.out.println("A: " + indexDreta);
//         // indexEsquerra = nombreEsquerra(taula, pivot, min, max);
//         indexEsquerra = nombreEsquerra(taula, pivot);
//         System.out.println("B: " + indexEsquerra);
//         if (indexDreta > indexEsquerra) {
//             girarNombres(taula, indexDreta, indexEsquerra);
//         }
//     } while (indexDreta > indexEsquerra);
//     if (min < max) {
//         taula = quickSort(taula, min, pivotIndex - 1);
//         taula = quickSort(taula, pivotIndex + 1, max - 1);
//     }
//     return taula;
    // }
