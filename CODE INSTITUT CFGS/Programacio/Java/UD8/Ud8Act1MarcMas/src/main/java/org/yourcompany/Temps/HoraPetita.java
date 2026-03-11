/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.yourcompany.Temps;

/**
 *
 * @author Marc Mas
 */
public class HoraPetita extends Temps {

    public static final int MAX = 24;

    public HoraPetita(int valor) {
        super(valor);
    }

    public boolean setHora(int v) {
        return super.assignarValor(v, HoraPetita.MAX);
    }

    public void inc() {
        super.inc(HoraPetita.MAX);
    }


}
