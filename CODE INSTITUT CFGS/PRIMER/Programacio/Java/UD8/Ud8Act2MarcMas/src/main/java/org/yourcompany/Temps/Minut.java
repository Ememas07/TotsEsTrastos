/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.yourcompany.Temps;

/**
 *
 * @author Marc Mas
 */
public class Minut extends Temps {

    public static final int MAX = 60;

    public Minut(int valor) {
        super(valor);
    }

    public boolean setMinut(int v) {
        return super.assignarValor(v, Minut.MAX);
    }

    public void inc() {
        super.inc(Minut.MAX);
    }
}
