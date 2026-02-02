/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Personal;

import org.Dni.Dni;

/**
 *
 * @author Marc Mas
 */
public class Maquinista {

    String nom;
    Dni dni;
    int sou;
    Rangs rang;

    public enum Rangs {
        RANG1, RANG2, RANG3
    }

    public Maquinista(String nom, Dni dni, int sou, Rangs rang) {
        this.nom = nom;
        this.dni = dni;
        this.sou = sou;
        this.rang = rang;
    }

}
