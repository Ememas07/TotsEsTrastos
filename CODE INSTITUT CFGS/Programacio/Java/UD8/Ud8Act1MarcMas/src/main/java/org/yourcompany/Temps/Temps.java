/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.yourcompany.Temps;

/**
 *
 * @author Marc Mas
 */
public class Temps {

    int valor;

    public Temps() {
        this.valor = 0;
    }

    public Temps(int valor) {
        this.valor = valor;
    }

    public boolean assignarValor(int v, int max) {
        if (v > max) { //si el valor es major al maxim no el permetem
            System.out.println("Valor no valid");
            return false;
        } else {
            valor = v;
            return true;
        }
    }

    public void inc(int max) {
        this.valor += 1; //sumam 1
        if (this.valor >= max) { //si esteim al maxim, tornam a 0
            this.valor = 0;
        }
    }

    @Override
    public String toString() {
        if (valor < 10) { //si volem mostra un numero de una xifra afegim un 0 per mostrar com a "09:03"
            return "0" + valor;
        } else {
            return "" + valor;
        }
    }

    public int getValor() {
        return this.valor;
    }

}
