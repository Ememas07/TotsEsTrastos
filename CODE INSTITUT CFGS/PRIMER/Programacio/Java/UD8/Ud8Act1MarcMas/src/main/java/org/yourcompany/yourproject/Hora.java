/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.yourcompany.yourproject;

import org.yourcompany.Temps.HoraPetita;
import org.yourcompany.Temps.Minut;

/**
 *
 * @author Marc Mas
 */
public class Hora {

    HoraPetita hora;
    Minut minut;

    public Hora(int hora, int minut) {
        this.hora = new HoraPetita(hora);
        this.minut = new Minut(minut);
    }

    public boolean setHora(int v) {
        return this.hora.assignarValor(v, HoraPetita.MAX);
    }

    public boolean setMinuts(int v) {
        return this.minut.assignarValor(v, Minut.MAX);
    }

    public void inc() {
        this.minut.inc();
        if (this.minut.getValor() == 0) {
            this.hora.inc();
        }
    }

    @Override
    public String toString() {
        return this.hora.toString() + ":" + this.minut.toString();
    }

}
