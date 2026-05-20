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
public class Enemic implements Serializable{

    public enum TipusEnemic {
        LLIM, BANDIT, ORC, NO_MORT, BESTIA, ELEMENTAL, DIMONI, DRAC
    }

    public enum VariantEnemic {
        BASE, FOC, AIGUA, TERRA, AIRE, OMBRA, LLUM
    }

    public enum RangEnemic {
        MINIO, NORMAL, ELIT, CAP
    }

    private String nom;
    private TipusEnemic tipus;
    private VariantEnemic variant;
    private RangEnemic rang;
    private int nivell;
    private int hpBase;
    private int xpBase;

    public Enemic(String n, TipusEnemic t, VariantEnemic v, RangEnemic r,
            int lvl, int hp, int xp) {
        this.nom = n;
        this.tipus = t;
        this.variant = v;
        this.rang = r;
        this.nivell = lvl;
        this.hpBase = hp;
        this.xpBase = xp;
    }

    @Override
    public String toString() {
        return "Enemic [ n = " + nom + ", t = " + tipus + ", v = "
                + variant + ", r = " + rang + ", lvl = " + nivell + ", hp = "
                + hpBase + ", xp = " + xpBase + " ]";
    }

}