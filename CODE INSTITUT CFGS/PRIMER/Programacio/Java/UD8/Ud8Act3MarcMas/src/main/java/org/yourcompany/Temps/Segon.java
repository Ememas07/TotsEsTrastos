/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.yourcompany.Temps;

/**
 *
 * @author Marc Mas
 */
public class Segon extends Temps {

    public static final int MAX = 60;

    public Segon(int valor) {
        super(valor);
    }

    public boolean setSegon(int v) {
        return super.assignarValor(v, Segon.MAX);
    }

    public void inc() {
        super.inc(Minut.MAX);
    }
}
