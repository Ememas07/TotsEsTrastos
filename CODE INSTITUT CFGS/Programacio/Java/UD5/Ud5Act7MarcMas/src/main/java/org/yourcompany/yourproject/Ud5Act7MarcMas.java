/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * Escriu la funció: int[] senseRepetits(int[] t)
 *
 * que construeix i retorna una taula de la longitud que toqui ,
 *
 * amb els elements no repetits de la taula t
 *
 * @author Marc Mas
 */
public class Ud5Act7MarcMas {

    public static int[] senseRepetits(int[] t) {
        int taulaNeta[] = new int[0];
        for (int i = 0; i < t.length; i++) {
            if (!nombreDuplicat(t, t[i], i)) {
                taulaNeta = Arrays.copyOf(taulaNeta, taulaNeta.length + 1);
                taulaNeta[taulaNeta.length -1] = t[i];
            }
        }
        return taulaNeta;
    }

    public static boolean nombreDuplicat(int[] taula, int n, int indexOriginal) { //indexCerca es el principi de la cerca, ja que volem saber si el nombre hi és dues vegades o més
        boolean duplicat = false; //assignam false per començar
        for (int i = 0; i < taula.length; i++) {  //recorrem tota la taula
            if (taula[i] == n && i != indexOriginal) { //si trobam l'element a dins la taula i NO està a la posició on esteim comprovant, marcam com a duplicat
                duplicat = true;
            }
        }
        return duplicat;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Programa que mostra els nombres no repetits d'un array");
        int arrayNombres[] = new int[10];
        for (int i = 0; i < arrayNombres.length; i++) { //recorrem l'array i l'omplim amb ints
            System.out.println("Introdueixi un nombre enter");
            arrayNombres[i] = s.nextInt();
        }
        arrayNombres = senseRepetits(arrayNombres);
        for (int i = 0; i < arrayNombres.length; i++) {
            System.out.print(arrayNombres[i] + ", ");
        }
    }
}
