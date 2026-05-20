/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.yourcompany.yourproject;

/**
 *
 * @author Marc Mas
 */
public class Jugador {

    private int dorsal;
    private String nombre;
    private String demarcacion;

    public Jugador() {
    }

    public Jugador(int dorsal, String nombre, String demarcación) {
        this.dorsal = dorsal;
        this.nombre = nombre;
        this.demarcacion = demarcación;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDemarcación() {
        return demarcacion;
    }

    public void setDemarcación(String demarcación) {
        this.demarcacion = demarcación;
    }

    @Override
    public String toString() {
        return this.dorsal + " -- " + this.nombre + " -- " + this.demarcacion;
    }
}
