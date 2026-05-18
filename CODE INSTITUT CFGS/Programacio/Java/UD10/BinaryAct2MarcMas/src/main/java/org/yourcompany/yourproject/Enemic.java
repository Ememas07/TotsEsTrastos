/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.yourcompany.yourproject;

/**
 *
 * @author Marc Mas
 */
public class Enemic {

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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public TipusEnemic getTipus() {
        return tipus;
    }

    public void setTipus(TipusEnemic tipus) {
        this.tipus = tipus;
    }

    public VariantEnemic getVariant() {
        return variant;
    }

    public void setVariant(VariantEnemic variant) {
        this.variant = variant;
    }

    public RangEnemic getRang() {
        return rang;
    }

    public void setRang(RangEnemic rang) {
        this.rang = rang;
    }

    public int getNivell() {
        return nivell;
    }

    public void setNivell(int nivell) {
        this.nivell = nivell;
    }

    public int getHpBase() {
        return hpBase;
    }

    public void setHpBase(int hpBase) {
        this.hpBase = hpBase;
    }

    public int getXpBase() {
        return xpBase;
    }

    public void setXpBase(int xpBase) {
        this.xpBase = xpBase;
    }

}
