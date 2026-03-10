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
        if (max > valor) {
            valor = 0;
        }
        this.max = max;
        this.valor = valor;
    }

    public void inc() {
        this.valor += 1;
        if (this.valor >= this.max) {
            this.valor = 0;
        }
    }

    public boolean assignarValor(int v) {
        if (v > max) {
            System.out.println("Valor no valid");
            return false;
        } else {
            valor = v;
            return true;
        }
    }

    @Override
    public String toString() {
        if (valor < 10) {
            return "0" + valor;
        } else {
            return "" + valor;
        }
    }

    public int getValor() {
        return this.valor;
    }

}
