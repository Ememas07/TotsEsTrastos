/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.yourcompany.yourproject.Pila;

import org.yourcompany.yourproject.Llista.Llista;

/**
 *
 * @author Marc Mas
 */
public class Pila {

    Llista llista;

    public Pila() {
        this.llista = new Llista();
    }

    public void apilar(int numero) {
        llista.insertarFinal(numero); //posariem un plat al principi de la pila
    }

    public int desapilar() {
        int num = (int) llista.obtenirElement(llista.length() - 1);
        llista.eliminarElement(llista.length()); //llevam el plat d'adalt de tot
        return num;
    }

    public void mostrarElements() {
        llista.mostrarElements(); //mostram els elements
    }

    public Object mostrarDarrerElement() {
        return llista.obtenirElement(llista.length() - 1);
    }

}
