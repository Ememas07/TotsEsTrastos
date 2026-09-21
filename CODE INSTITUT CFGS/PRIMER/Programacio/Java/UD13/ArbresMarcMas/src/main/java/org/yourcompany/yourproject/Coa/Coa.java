/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.yourcompany.yourproject.Coa;

import org.yourcompany.yourproject.Llista.Llista;

/**
 *
 * @author Marc Mas
 */
public class Coa {

    Llista llista;

    public Coa() {
        this.llista = new Llista();
    }

    public void encoar(String s) {
        llista.insertarFinal(s); //posariem un plat al principi de la pila
    }

    public String desencoar() {
        String num = (String) llista.obtenirElement(0);
        llista.eliminarElement(0);
        return num;
    }

    public void mostrarElements() {
        llista.mostrarElements(); //mostram els elements
    }

    public Object mostrarDarrerElement() {
        return llista.obtenirElement(0);
    }

    public int length() {
        return llista.length();
    }

}
