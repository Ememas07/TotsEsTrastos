/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.yourcompany.yourproject;

import java.io.Serializable;

/**
 *
 * @author Marc Mas
 */
public class Objecte implements Serializable {

    public enum TipusObjecte {
        CONSUMIBLE, ARMA, ARMADURA, CLAU, MATERIAL, MISSIO
    }

    public enum RaresaObjecte {
        COMU, INFREQÜENT, RAR, EPIC, LLEGENDARI
    }

    private String nom;
    private TipusObjecte tipus;
    private RaresaObjecte raresa;
    private String efecte;
    private double durabilitat;
    private int valorBase;
    private double pesBase;

    public Objecte(String n, TipusObjecte t, RaresaObjecte r, String e,
            double d, int v, double p) {
        this.nom = n;
        this.tipus = t;
        this.raresa = r;
        this.efecte = e;
        this.durabilitat = d;
        this.valorBase = v;
        this.pesBase = p;
    }

    @Override
    public String toString() {
        return "Objecte [ n = " + nom + ", t = " + tipus + ", r = " + raresa
                + ", e = " + efecte + ", d = " + durabilitat + ", v = " + valorBase
                + ", p = " + pesBase + " ]";
    }

}
