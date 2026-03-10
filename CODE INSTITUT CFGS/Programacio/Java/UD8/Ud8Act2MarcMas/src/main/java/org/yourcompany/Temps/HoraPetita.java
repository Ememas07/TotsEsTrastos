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

    public HoraPetita(int valor) {
        super(24, valor);
    }

    public boolean setHora(int v) {
        return super.assignarValor(v);
    }

}
