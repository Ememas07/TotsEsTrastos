/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Pila;

import org.Llista.Llista;

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
        llista.insertarPrincipi(numero); //posariem un plat al principi de la pila
    }

    public void desapilar() {
        llista.eliminarElement(0); //llevam el plat d'adalt de tot
    }

    public void mostrarElements() {
        llista.mostrarElements(); //mostram els elements
    }

}
