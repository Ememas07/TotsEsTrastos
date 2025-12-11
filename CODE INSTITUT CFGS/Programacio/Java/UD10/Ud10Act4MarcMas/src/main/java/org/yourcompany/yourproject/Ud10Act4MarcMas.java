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
        float taula[] = new float[array.length];
        for (int i = 0; i < array.length; i++) {
            System.out.println(StringToFloats(array[i]));
        }

        return taula;
    }

    public static float StringToFloats(String text) {
        float numero = 0;
        String[] separat = text.split("\\.");
        String entera = separat[0];
        String decimal = separat[1];
        for (int i = entera.length(); i > 0; i--) {
            numero += StringToFloats(entera.charAt(i - 1)) * i;
        }
        for (int i = decimal.length(); i > 0; i--) {
            numero += (StringToFloats(decimal.charAt(i - 1))) / (i * 10);
        }
        return numero;
    }

    public static float StringToFloats(char text) {
        return switch (text) {
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
                    "src\\main\\java\\org\\yourcompany\\yourproject\\NombresReals.txt"
            ));
            String c;
            String[] numeros = null;
            while ((c = fitxer.readLine()) != null) {
                StringToFloats(c.split(" "));
            }
            fitxer.close();
        } catch (FileNotFoundException e) {
            System.out.println("No s'ha trobat el fitxer!");
        } catch (IOException ex) {
            System.out.println("Error de IO!");
        }
    }
}
