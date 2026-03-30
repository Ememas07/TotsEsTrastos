/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Soci;

/**
 *
 * @author Marc Mas
 */
public class Soci {

    String nom;
    int edat;

    public Soci(String nom, int edat) {
        this.nom = nom;
        this.edat = edat;
    }

    @Override
    public String toString() {
        return "Aquest soci se nom " + this.nom + " i té una edat de " + this.edat;
    }

}
