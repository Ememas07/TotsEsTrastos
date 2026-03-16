/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.yourcompany.yourproject;

/**
 *
 * @author Marc Mas
 */
public interface Cua {

    void insertarPrincipi(int numero);

    void insertarPrincipi(int[] numeros);

    void insertarFinal(int numero);

    void insertarFinal(int[] insercions);

    void insertarEnmig(int numero, int index);

    void insertarEnmig(int[] numeros, int index);

    void eliminarElement(int index);
    /* 
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
    
    public void insertarEnmig(int[] numeros, int index) {
        for (int i = 0; i < numeros.length; i++) {
            insertarEnmig(numeros[i], index+i);  
        }
    }
     */
}
