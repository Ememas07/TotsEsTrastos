/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Crear amb un editor el fitxer de text NombresReals.txt a la carpeta del
 * projecte de NetBeans actual i escriu dins ell una sèrie de nombres decimals
 * separats per espais simples.
 *
 * Implementa un programa que accedeixi a aquest fitxer, llegeixi els nombres i
 * calculi la suma i la mitjana, mostrant els resultats per pantalla.
 *
 * @author Marc Mas
 */
public class Ud10Act4MarcMas {

    public static double[] StringToFloats(String[] array) {
        double taula[] = new double[array.length]; //cream un array de floats
        for (int i = 0; i < array.length; i++) { // recorrem tot l'array i l'omplim amb floats
            taula[i] = StringToFloats(array[i]);
        }
        return taula;
    }

    public static double StringToFloats(String text) {
        double numero = 0;
        String[] separat = text.split("\\."); //separam la part entera i decimal
        String entera = separat[0]; //part entera (abans del punt)
        String decimal = separat[1]; //part decimal (despres del punt)
        for (int i = 0; i < entera.length(); i++) { //recorrem la part entera
            numero += (float) (StringToFloats(entera.charAt(i)) * (Math.pow(10, entera.length() - 1 - i)));
            // operacio: Cast a float de:
            // executam funcio de StringToFloat d'un caracter de la part entera
            // el multiplicam per 10^(length-1-i) = multiplicarem per 1, o per 10, o per 100, depenent de quina xifra es ja que te diferents valors
            // aixo significa: primer valor multiplicat per 10^0 (1), segon valor per 10^1 (10), tecer valor per 10^2 (100... etc)
        }
        for (int i = decimal.length(); i > 0; i--) { //recorrem la part entera
            // System.out.println(decimal.charAt(i - 1));
            numero += (double) (StringToFloats(decimal.charAt(i - 1)) / (Math.pow(10, i)));
            // operacio: Cast a float de:
            // executam funcio de StringToFloat d'un caracter de la part entera
            // el dividim per 10^i = dividirem per 1, o per 10, o per 100, depenent de quina xifra es ja que te diferents valors
        }
        return numero;
    }

    public static int StringToFloats(char text) {
        return switch (text) { //switch de 0 a 9 que retorna el nombre en float per després
            case '0' ->
                0;
            case '1' ->
                1;
            case '2' ->
                2;
            case '3' ->
                3;
            case '4' ->
                4;
            case '5' ->
                5;
            case '6' ->
                6;
            case '7' ->
                7;
            case '8' ->
                8;
            case '9' ->
                9;
            default ->
                0;
        };
    }

    public static void main(String[] args) {
        try {
            BufferedReader fitxer = new BufferedReader(new FileReader(
                    "src\\main\\java\\org\\yourcompany\\yourproject\\NombresReals.txt" //especificam el fitxer que volem llegir i emprarem un BufferedReader
            ));
            String c;  // inicialitzam la variable com a string (sera una linea)
            double taula[] = null;
            double suma = 0.0;
            while ((c = fitxer.readLine()) != null) { //llegim linea, si no es null
                taula = StringToFloats(c.split(" ")); //cridam la funcio de StringToFloats amb un array de Strings cridat per el c.split, que donarà cada numero
                for (int i = 0; i < taula.length; i++) {
                    suma += taula[i];
                }
            }
            fitxer.close(); //tancam el fitxer
            double mitjana = suma / taula.length;
            System.out.println("La suma es " + suma);
            System.out.println("La mitjana es " + mitjana);

        } catch (FileNotFoundException e) { //si no trobam el fitxer
            System.out.println("No s'ha trobat el fitxer!");
        } catch (IOException ex) { //o tenim un error de IO
            System.out.println("Error de IO!");
        }
    }
}
