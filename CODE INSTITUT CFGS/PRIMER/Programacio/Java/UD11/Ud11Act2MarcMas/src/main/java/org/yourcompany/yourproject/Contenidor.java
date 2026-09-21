/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.yourcompany.yourproject;

import java.util.Arrays;

/**
 *
 * @author Marc Mas
 * @param <T>
 */
public class Contenidor<T> {

    private T[] taula;

    public Contenidor() {
        this.taula = (T[]) new Object[0];
    }

    void insertarAlPrincipi(T nou) {
        T[] taulaNova = Arrays.copyOf(taula, taula.length + 1); //taula amb un element mes 
        System.arraycopy(taula, 0, taulaNova, 1, taula.length); //taulanova = copia de element 0 a 100 a posicions 1 a 101 (exemple)
        taula = taulaNova; //trepitjam taula antiga
        taula[0] = nou; //inserim element
    }

    void insertarAlFinal(T nou) {
        taula = Arrays.copyOf(taula, taula.length + 1);
        taula[taula.length - 1] = nou;
    }

    T extreureDelPrincipi() {
        T object = taula[0];
        T[] taulaNova = Arrays.copyOf(taula, taula.length - 1);
        for (int i = 0; i < taula.length - 1; i++) {
            taulaNova[i] = taula[i + 1];
        }
        taula = taulaNova;
        return object;
    }

    T extreureDelFinal() {
        T object = taula[taula.length - 1];
        taula = Arrays.copyOf(taula, taula.length - 1);
        return object;
    }

    void ordenar() {
        Arrays.sort(taula);
    }

    @Override
    public String toString() {
        System.out.println(Arrays.toString(taula));
        return Arrays.toString(taula);
    }
}
