/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 * Introduir per teclat una seqüència de nombres separats per espais i en pitjar
 * intro, llegir-los amb la classe Scanner i sumar-los i fer-ne la mitjana.
 *
 * @author Marc Mas
 */
public class Ud10Act5MarcMas {

    public static int StringToInts(String numero) {
        int valor = 0;
        for (int i = numero.length(); i > 0; i--) {
            switch (numero.charAt(i - 1)) { //switch de 0 a 9 que retorna el nombre en float per després
                case '0' ->
                    valor += 0 * i * 10;
                case '1' ->
                    valor += 1 * i;
                case '2' ->
                    valor += 2 * i;
                case '3' ->
                    valor += 3 * i;
                case '4' ->
                    valor += 4 * i;
                case '5' ->
                    valor += 5 * i;
                case '6' ->
                    valor += 6 * i;
                case '7' ->
                    valor += 7 * i;
                case '8' ->
                    valor += 8 * i;
                case '9' ->
                    valor += 9 * i;
                default ->
                    valor += 0 * i;
            };
            System.out.println(valor);
        }
        return valor;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int suma = 0;
        String linea = s.nextLine(); // agafam tota la linea 
        String[] numeros = linea.split(" "); // la separam per espais
        for (String numero : numeros) { //per cada valor de la taula numeros, agafam
            suma += (StringToInts((numero)));
            // for (int j = numero.length(); j > 0; j--) {
            // suma += (StringToInts((char) (numero.charAt(j - 1)))) * j; //sumam la part entera
            // }
        }
        float mitjana = suma / (float) numeros.length;
        System.out.println("Suma: " + suma);
        System.out.println("Mitjana: " + mitjana);

    }
}
