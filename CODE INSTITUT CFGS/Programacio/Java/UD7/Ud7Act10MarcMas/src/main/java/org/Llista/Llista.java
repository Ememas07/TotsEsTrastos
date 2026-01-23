/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Llista;

import java.util.Arrays;

/**
 *
 * @author Marc Mas
 */
public class Llista {

    int[] numeros;

    public Llista(int mida) {
        this.numeros = new int[mida];
    }

    public Llista() {
        this(0);
    }

    public void omplirAleatori(int mida) {
        int numero;
        for (int i = 0; i < mida; i++) {
            numero = (int) (Math.random() * 100);
            insertarFinal(numero);
        }
    }

    public void insertarPrincipi(int[] insercions) {
        for (int i = 0; i < insercions.length; i++) {
            this.insertarPrincipi(insercions[i]);
        }
    }

    public void insertarPrincipi(int numero) {
        int[] llistaNova = Arrays.copyOf(numeros, numeros.length + 1);
        for (int i = 0; i < numeros.length; i++) { //feim una copia amb totes les posicions avançades per un
            llistaNova[i + 1] = numeros[i];
        }
        llistaNova[0] = numero; //canviam primer element
        this.numeros = llistaNova;
    }

    public void insertarFinal(int numero) {
        int[] llistaNova = Arrays.copyOf(numeros, numeros.length + 1); //feim una copia 
        llistaNova[llistaNova.length - 1] = numero; //canviam el darrer element
        this.numeros = llistaNova;
    }

    public void insertarFinal(int[] insercions) {
        for (int i = 0; i < insercions.length; i++) {
            this.insertarFinal(insercions[i]);
        }
    }

    public void insertarEnmig(int numero, int index) {
        try {
            int[] llistaNova = Arrays.copyOf(numeros, numeros.length + 1);
            for (int i = 0; i < index; i++) {
                llistaNova[i] = numeros[i]; //copiam fins a index
            }
            llistaNova[index] = numero; //assignam index
            for (int i = index; i < numeros.length; i++) {
                llistaNova[i + 1] = numeros[i]; //copiam desde index fins al final de la llista
            }
            this.numeros = llistaNova;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("L'index insertat no és valid!");
        }
    }

    public void eliminarElement(int index) {
        try {
            int[] llistaNova = Arrays.copyOf(numeros, numeros.length - 1);
            for (int i = 0; i < index; i++) {
                llistaNova[i] = numeros[i]; //copiam fins a index
            }
            for (int i = index; i < numeros.length; i++) {
                llistaNova[i - 1] = numeros[i]; //copiam desde index fins al final de la llista
            }
            this.numeros = llistaNova;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("L'index insertat no és valid!");
        }
    }

    public int obtenirElement(int index) {
        if (index >= this.numeros.length) { //si l'index es massa gran, mostram error i retornam 0
            System.out.println("Aquest valor no existeix a la teva llista!");
            return 0;
        }
        return numeros[index];
    }

    public int cercarElement(int numero) {
        for (int i = 0; i < numeros.length; i++) { //recorrem tot l'array
            if (numero == numeros[i]) {
                return i; //si en algun moment trobam el numero, retornam l'index
            }
        }
        return -1; //si no el trobam, retornam -1
    }

    public void mostrarElements() {
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Posicio " + (i + 1) + ": " + numeros[i]);
        }
    }

}
