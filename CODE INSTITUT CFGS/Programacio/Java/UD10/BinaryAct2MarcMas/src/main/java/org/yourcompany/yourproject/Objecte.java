/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.yourcompany.yourproject;

/**
 *
 * @author Marc Mas
 */
public class Objecte {

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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public TipusObjecte getTipus() {
        return tipus;
    }

    public void setTipus(TipusObjecte tipus) {
        this.tipus = tipus;
    }

    public RaresaObjecte getRaresa() {
        return raresa;
    }

    public void setRaresa(RaresaObjecte raresa) {
        this.raresa = raresa;
    }

    public String getEfecte() {
        return efecte;
    }

    public void setEfecte(String efecte) {
        this.efecte = efecte;
    }

    public double getDurabilitat() {
        return durabilitat;
    }

    public void setDurabilitat(double durabilitat) {
        this.durabilitat = durabilitat;
    }

    public int getValorBase() {
        return valorBase;
    }

    public void setValorBase(int valorBase) {
        this.valorBase = valorBase;
    }

    public double getPesBase() {
        return pesBase;
    }

    public void setPesBase(double pesBase) {
        this.pesBase = pesBase;
    }

}
