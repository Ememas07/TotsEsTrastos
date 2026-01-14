/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.yourcompany.yourproject.package2;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class CompteBancari {

    Dni dni;
    public String nomTitular;
    private int saldo;
    String nomBanc;

    public CompteBancari(Dni dni, String nomTitular, int saldo, String nomBanc) {
        this.dni = dni;
        this.nomTitular = nomTitular;
        this.saldo = saldo;
        this.nomBanc = nomBanc;
    }

    public CompteBancari(Dni dni, String nomTitular, String nomBanc) {
        this(dni, nomTitular, 0, nomBanc);
    }

    public CompteBancari(Dni dni, String nomTitular) {
        this(dni, nomTitular, 0, "Banca March");
    }

    public CompteBancari(Dni dni, int saldo) {
        this(dni, "Pepito de los Palotes", saldo, "Banca March");
    }

    public static CompteBancari crearCompte() {
        Scanner s = new Scanner(System.in);
        System.out.println("Introdueix el seu nom");
        String nom = s.nextLine();
        System.out.println("Quin banc empra?");
        String nomBanc = s.nextLine();
        System.out.println("Introdueix el seu DNI");
        int numerosDni = s.nextInt();
        Dni dni = new Dni(numerosDni);
        System.out.println("S'ha creat el compte amb el nom " + nom);
        return new CompteBancari(dni, nom, nomBanc);
    }

    public void treureDoblers(int quantitat) {
        if (quantitat > this.saldo) {
            System.out.println("No tens doblers suficients!");
        } else {
            System.out.println("Has tret " + quantitat + " euros del banc");
            this.saldo -= quantitat;
            System.out.println("Saldo actual: " + this.saldo);
        }
    }

    public void ingressarDoblers(int quantitat) {
        this.saldo += quantitat;
        System.out.println("Ara tens " + this.saldo + " euros al compte");
    }

    public void mostrarInformacio() {
        System.out.println("Nom: " + nomTitular);
        System.out.println("DNI: " + dni.imprimir());
        System.out.println("Saldo: " + saldo);
        System.out.println("Nom del Banc: " + nomBanc);
    }

    public void setNomBanc(String nomBanc) {
        this.nomBanc = nomBanc;
    }

    public String getNomBanc() {
        return nomBanc;
    }
}
