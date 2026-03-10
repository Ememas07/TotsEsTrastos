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

    int max;
    int valor;

    public Temps() {
        this.max = 0;
        this.valor = 0;
    }

    public Temps(int max, int valor) {
        if (valor > max) {
            valor = 0;
        }
        this.valor = valor;
        this.max = max;
    }

    public void inc() {
        this.valor += 1; //sumam 1
        if (this.valor >= this.max) { //si esteim al maxim, tornam a 0
            this.valor = 0;
        }
    }

    public boolean assignarValor(int v) {
        if (v > max) { //si el valor es major al maxim no el permetem
            System.out.println("Valor no valid");
            return false;
        } else {
            valor = v;
            return true;
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
