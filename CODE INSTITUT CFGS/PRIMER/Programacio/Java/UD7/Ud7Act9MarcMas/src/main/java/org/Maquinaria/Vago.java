/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Maquinaria;

/**
 *
 * @author Marc Mas
 */
class Vago {

    int identificador;
    float cargaMaxima;
    float cargaActual;
    Mercaderies tipus;

    public enum Mercaderies {
        LIQUIDS, SOLIDS, TOXICS, EXPLOSIUS
    }

    public Vago(int identificador, float cargaMaxima, float cargaActual, Mercaderies tipus) {
        this.identificador = identificador;
        this.cargaMaxima = cargaMaxima;
        this.cargaActual = cargaActual;
        this.tipus = tipus;
    }

}
