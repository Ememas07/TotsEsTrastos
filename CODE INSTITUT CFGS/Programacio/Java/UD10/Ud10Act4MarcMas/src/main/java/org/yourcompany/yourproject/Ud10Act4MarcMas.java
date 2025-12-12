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

    public static float[] StringToFloats(String[] array) {
        float taula[] = new float[array.length]; //cream un array de floats
        for (int i = 0; i < array.length; i++) { // recorrem tot l'array i l'omplim amb floats
            taula[i] = StringToFloats(array[i]); 
        }
        return taula;
    }

    public static float StringToFloats(String text) {
        float numero = 0;
        String[] separat = text.split("\\."); //separam la part entera i decimal
        String entera = separat[0]; //part entera (abans del punt)
        String decimal = separat[1]; //part decimal (despres del punt)
        for (int i = entera.length(); i > 0; i--) { //tota la part entera
            numero += (float) (StringToFloats(entera.charAt(i - 1))) * i; //sumam la part entera
        }
        for (int i = decimal.length(); i > 0; i--) { //tota la part decimal
            numero += (float) ((StringToFloats(decimal.charAt(i - 1)))) / (i * 10); //sumam la part decimal
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
            float taula[] = null;
            while ((c = fitxer.readLine()) != null) { //llegim linea, si no es null
                taula = StringToFloats(c.split(" ")); //cridam la funcio de StringToFloats amb un array de Strings cridat per el c.split, que donarà cada numero
                for (int i = 0; i < taula.length; i++) {
                    System.out.println(taula[i]);
                }
            }
            fitxer.close(); //tancam el fitxer
        } catch (FileNotFoundException e) { //si no trobam el fitxer
            System.out.println("No s'ha trobat el fitxer!");
        } catch (IOException ex) { //o tenim un error de IO
            System.out.println("Error de IO!");
        }
    }
}
