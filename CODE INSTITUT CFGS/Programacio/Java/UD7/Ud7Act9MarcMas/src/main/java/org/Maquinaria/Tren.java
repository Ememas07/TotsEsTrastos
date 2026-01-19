/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Maquinaria;

/**
 *
 * @author Marc Mas
 */
public class Tren {

    Locomotora locomotora;
    Vago[] Vagons;
    int nVagons;

    public Tren(Locomotora locomotora, Vago[] Vagons, int nVagons) {
        this.locomotora = locomotora;
        this.Vagons = Vagons;
        this.nVagons = nVagons;
    }

    public static Tren crearTren(Locomotora loc, int nVagons) {
        Vago[] Vagons = new Vago[5];
        for (int i = 0; i < nVagons; i++) {
            Vagons[i] = new Vago(0622, 300.0f, 0.0f, Vago.Mercaderies.EXPLOSIUS);
        }
        return new Tren(loc, Vagons, nVagons);
    }

}
