/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * Escriu la funció: int[] eliminarMajorsQue(int[] t, int valor), que a partir
 * de la taula t, retorna una taula nova que ha eliminat tots els valors majors
 * que valor
 *
 * @author Marc Mas
 */
public class Ud5Act10MarcMas {

    public static int[] eliminarMajorsQue(int[] t, int valor) {
        // int taulaNova[] = new int[0];
        int index = 0; //iniciam un index
        while (index < t.length) { //mentres no haguem acabat de recorrer l'array
            if (t[index] > valor) { //si el nombre que hem comprovat es mes gran que el valor, el volem eliminar
                t[index] = t[t.length - 1]; //giram amb el darrer nombre de la taula
                t = Arrays.copyOf(t, t.length - 1); //copiam l'array sense el darrer nombre
                index = 0; //reiniciam index
            } else {
                index++; //si no, sumam 1 a index i tornam a mirar
            }
        }
        return t;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Programa per eliminar tots els valors mes grans que l'especificat");
        int arrayNombres[] = new int[100];
        for (int i = 0; i < arrayNombres.length; i++) { //recorrem l'array i l'omplim amb ints
            // System.out.println("Introdueixi un nombre enter"); //en cas de voler omplir l'array manualment, descomentar aquesta linea i la seguent
            // arrayNombres[i] = s.nextInt();
            arrayNombres[i] = (int) (1 + Math.random() * 100);
        }
        System.out.println("Quin es el caracter maxim que vol al seu array?");
        int valor = s.nextInt();
        arrayNombres = eliminarMajorsQue(arrayNombres, valor); //reemplaça l'array actual amb l'array sense els valors més grans
        for (int i = 0; i < arrayNombres.length; i++) {
            System.out.print(arrayNombres[i] + ", "); //imprimim
        }

    }
}
