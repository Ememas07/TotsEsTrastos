/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Arrays;

/**
 *
 * @author Marc Mas
 */
public class Ud11Act1MarcMas {

    public static void main(String[] args) {
        Integer llista[] = new Integer[1];
        llista[0] = 420;
        llista = Ud11Act1MarcMas.inserir(3, llista);
        llista = Ud11Act1MarcMas.inserir(50, llista);
        System.out.println(Arrays.toString(llista));
        String llista2[] = new String[1];
        llista2[0] = "hola";
        llista2 = Ud11Act1MarcMas.inserir("bon", llista2);
        llista2 = Ud11Act1MarcMas.inserir("dia", llista2);
        System.out.println(Arrays.toString(llista2));
        Double llista3[] = new Double[1];
        llista3[0] = 4.6;
        llista3 = Ud11Act1MarcMas.inserir(1.2, llista3);
        llista3 = Ud11Act1MarcMas.inserir(3.4, llista3);
        System.out.println(Arrays.toString(llista3));
    }

    public static <T> T[] inserir(T objecte, T[] array) {
        T[] array2 = Arrays.copyOf(array, array.length + 1);
        array2[array2.length - 1] = objecte;
        return array2;
    }
}
