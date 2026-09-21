/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Domotica;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class Casa {

    int nombreBombilles;
    Bombilla[] Bombilles;
    boolean estatGeneral;

    public Casa(int nombreBombilles, Bombilla[] Bombilles, boolean estatGeneral) {
        this.nombreBombilles = nombreBombilles;
        this.Bombilles = Bombilles;
        this.estatGeneral = estatGeneral;
    }

    public Casa(int nombreBombilles) {
        this(nombreBombilles, crearArrayBombilles(nombreBombilles), true);
    }

    public static Bombilla[] crearArrayBombilles(int nombreBombilles) {
        Bombilla[] Bombilles = new Bombilla[nombreBombilles];
        for (int i = 0; i < Bombilles.length; i++) {
            Bombilles[i] = new Bombilla(false); //cream dos arrays de bombilles, i les posam a totes com a false ja que la casa estarà tota apagada
        }
        return Bombilles;
    }

    public static Casa construirCasa() {
        Scanner s = new Scanner(System.in);
        System.out.println("Quantes bombilles vol a la casa?");
        int numBombilles = s.nextInt();
        return new Casa(numBombilles);
    }

    public void interruptorGeneral() {
        estatGeneral = !estatGeneral;
    }

    public void mostrarInformacio(boolean emojis) {
        this.getNombreBombilles();
        this.getEstatGeneral();
        this.getEstatBombilles(emojis);
    }

    public void canviarEstat(int bombilla) {
        Bombilles[bombilla - 1].girarEstat();
    }

    public void getEstatGeneral() {
        System.out.print("Interruptor General: ");
        if (estatGeneral) {
            System.out.println(" Ences");
        } else {
            System.out.println(" Apagat");
        }
    }

    public void getEstatBombilles(boolean emojis) {
        System.out.println("Estats per bombilla:");
        for (int i = 0; i < Bombilles.length; i++) { //per a cada bombilla, mostram un numero i el seu estat
            System.out.print("Bombilla " + (i + 1) + ": ");
            if (estatGeneral && Bombilles[i].getEstat()) { //si hi ha llum general i la bombilla està encesa, mostrar encés
                if (emojis) {
                    System.out.println("💡");
                } else {
                    System.out.println(" Encesa");
                }
            } else { //si no, apagat
                if (emojis) {
                    System.out.println(" ");
                } else {
                    System.out.println(" Apagada");
                }
            }
        }
    }

    public void getNombreBombilles() {
        System.out.println("Nombre de bombilles: " + this.nombreBombilles);
    }
}
