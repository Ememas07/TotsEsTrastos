/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.yourcompany.yourproject;

/**
 *
 * @author Marc Mas
 */
public class Bombilla {

    private boolean estat;

    public Bombilla(boolean estat) {
        this.estat = estat;
    }

    public boolean getEstat() {
        return estat;
    }

    public void setEstat(boolean estat) {
        this.estat = estat;
    }

    public void girarEstat() {
        this.estat = !this.estat;
    }

}
