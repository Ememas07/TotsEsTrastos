/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.yourcompany.yourproject;

import org.yourcompany.Temps.Segon;

/**
 *
 * @author Marc Mas
 */
public class HoraExacta extends Hora {

    Segon segon;

    public HoraExacta(int hora, int minut, int segon) {
        super(hora, minut);
        this.segon = new Segon(segon);
    }

    public boolean setSegon(int v) {
        return this.segon.assignarValor(v, Segon.MAX);
    }

    @Override
    public void inc() {
        this.segon.inc();
        if (this.segon.getValor() == 0) {
            this.minut.inc();
        }
        if (this.minut.getValor() == 0) {
            this.hora.inc();
        }
    }

    public void incMinuts() {
        super.inc();
    }

    @Override
    public String toString() {
        return this.hora.toString() + ":" + this.minut.toString() + ":" + this.segon.toString();
    }

}
