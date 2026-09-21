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

    public int getHora() {
        return hora.getValor();
    }

    public int getMinut() {
        return minut.getValor();
    }

    public int getSegon() {
        return segon.getValor();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            System.out.println("Has posat el mateix objecte dues vegades!");
            return true;
        }
        if (obj == null) {
            System.out.println("Has posat un objecte nul!");
            return false;
        }
        if (getClass() != obj.getClass()) {
            System.out.println("Les classes no son iguals!");
            return false;
        }
        HoraExacta hora2 = (HoraExacta) obj;

        if (hora2.getHora() != this.getHora() || hora2.getMinut() != this.getMinut() || hora2.getSegon() != this.getSegon()) {
            System.out.println("Les hores no son iguals");
            return false;
        }
        System.out.println("Les hores son iguals");
        return true;
    }

    @Override
    public int hashCode() {
        return 0;
    }

}
