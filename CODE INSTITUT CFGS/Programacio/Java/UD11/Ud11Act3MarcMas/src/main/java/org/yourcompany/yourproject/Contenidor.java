/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.yourcompany.yourproject;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 *
 * @author Marc Mas
 * @param <T>
 */
public class Contenidor<T> implements Pila<T> {

    private T[] taula;

    public Contenidor() {
        this.taula = (T[]) new Object[0];
    }

    void insertarAlFinal(T nou) {
        taula = Arrays.copyOf(taula, taula.length + 1);
        taula[taula.length - 1] = nou;
    }

    T extreureDelFinal() {
        T object = taula[taula.length - 1];
        taula = Arrays.copyOf(taula, taula.length - 1);
        return object;
    }

    @Override
    public void push(T nou) {
        this.insertarAlFinal(nou);
    }

    @Override
    public T pop() {
        if (esBuida()) {
            throw new NoSuchElementException("La pila esta buida");
        }
        return this.extreureDelFinal();
    }

    @Override
    public boolean esBuida() {
        return taula.length == 0;
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
