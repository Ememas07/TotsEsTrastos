/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.yourcompany.yourproject.Llista;

import java.util.Arrays;

/**
 *
 * @author Marc Mas
 */
public class Llista {

    Object[] objectes;

    public Llista(int mida) {
        this.objectes = new Object[mida];
    }

    public Llista() {
        this(0);
    }

    public void omplirAleatori(int mida) {
        int numero;
        for (int i = 0; i < mida; i++) { //recorrem l'array i insertam al final amb objectes de 0 a 100
            numero = (int) (Math.random() * 100);
            insertarFinal(numero);
        }
    }

    public void insertarPrincipi(Object[] insercions) {
        for (int i = 0; i < insercions.length; i++) {
            this.insertarPrincipi(insercions[i]); //recorrem l'array i aficam al principi un per un
        }
    }

    public void insertarPrincipi(Object obj) {
        Object[] llistaNova = Arrays.copyOf(objectes, objectes.length + 1);
        for (int i = 0; i < objectes.length; i++) { //feim una copia amb totes les posicions avançades per un
            llistaNova[i + 1] = objectes[i];
        }
        llistaNova[0] = obj; //canviam primer element
        this.objectes = llistaNova;
    }

    public void insertarFinal(Object obj) {
        Object[] llistaNova = Arrays.copyOf(objectes, objectes.length + 1); //feim una copia 
        llistaNova[llistaNova.length - 1] = obj; //canviam el darrer element
        this.objectes = llistaNova;
    }

    public void insertarFinal(Object[] insercions) {
        for (int i = 0; i < insercions.length; i++) {
            this.insertarFinal(insercions[i]);
        }
    }

    public void insertarEnmig(Object obj, int index) {
        try {
            Object[] llistaNova = Arrays.copyOf(objectes, objectes.length + 1);
            for (int i = 0; i < index; i++) {
                llistaNova[i] = objectes[i]; //copiam fins a index
            }
            llistaNova[index] = obj; //assignam index
            for (int i = index; i < objectes.length; i++) {
                llistaNova[i + 1] = objectes[i]; //copiam desde index fins al final de la llista
            }
            this.objectes = llistaNova;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("L'index insertat no és valid!");
        }
    }

    public void insertarEnmig(Object[] objectes, int index) {
        for (int i = 0; i < objectes.length; i++) {
            insertarEnmig(objectes[i], index + i);
        }
    }

    public void eliminarElement(int index) {
        try {
            Object[] llistaNova = Arrays.copyOf(objectes, objectes.length - 1);
            if (index == 0) {
                for (int i = 0; i < objectes.length - 1; i++) {
                    llistaNova[i] = objectes[i + 1];
                    //si l'index es 0, copiam tot l'array llevant el primer valor, 
                    // però ho hem de posar en un ordre diferent ja que volem fer i+1, 
                    // de l'altra manera estariem assignant a un index negatiu
                }
            } else {
                for (int i = 0; i < objectes.length - 1; i++) {
                    if (i <= index) {
                        llistaNova[i] = objectes[i]; //copiam fins a index
                    } else {
                        llistaNova[i] = objectes[i - 1]; //copiam desde index fins al final de la llista
                    }
                }
            }
            this.objectes = llistaNova;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("L'index insertat no és valid!");
        }
    }

    public Object obtenirElement(int index) {
        if (index >= this.objectes.length) { //si l'index es massa gran, mostram error i retornam 0
            System.out.println("Aquest valor no existeix a la teva llista!");
            return 0;
        }
        return objectes[index];
    }

    public int cercarElement(Object obj) {
        for (int i = 0; i < objectes.length; i++) { //recorrem tot l'array
            if (obj == objectes[i]) {
                return i; //si en algun moment trobam el numero, retornam l'index
            }
        }
        return -1; //si no el trobam, retornam -1
    }

    public void mostrarElements() {
        for (int i = 0; i < objectes.length; i++) {
            System.out.println("Posicio " + (i + 1) + ": " + objectes[i]);
        }
    }

    public int length() {
        return this.objectes.length;
    }

}
