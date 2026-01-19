/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.Domotica.Casa;

/**
 * Modelar una casa amb moltes bombilles, de tal manera que cada una es pot
 * encendre o apagar individualment.
 *
 * Per a això, es demana fer una classe Bombilla, amb una variable privada que
 * indiqui si és encesa o aturada, així com un mètode que ens digui l'estat
 * concret.
 *
 * A més a més, volem tenir un interruptor general, de tal manera que si aquest
 * s'apaga, totes les bombilles queden aturades. Quan es torna a activar, les
 * bombilles passen a l'estat que tenien anteriorment.
 *
 * Cada bombilla s'encén i s'apaga individualment, però només respon que està
 * encesa si el seu interruptor particular està encès i a més a més hi ha llum
 * general.
 *
 * @author Marc Mas
 */
public class Ud7Act8MarcMas {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Casa c = Casa.construirCasa();
        System.out.println("Quina operacio vol fer?");
        int opcio = 0;
        while (opcio > -1) { //-1 sortirà 
            try {
                System.out.println("1: Informacio de casa");
                System.out.println("2: Interruptor de bombilla especifica");
                System.out.println("3: Interruptor General");
                opcio = s.nextInt();
                switch (opcio) {
                    case 1 -> { //Info
                        System.out.println("1: Informacio amb emojis");
                        System.out.println("2: Informacio amb text");
                        byte info = s.nextByte();
                        if (info == 1) {
                            c.mostrarInformacio(true);
                        } else {
                            c.mostrarInformacio(false);
                        }
                    }
                    case 2 -> { //Bombilla especifica
                        System.out.println("Quina bombilla vol canviar?");
                        int bombilla = s.nextInt();
                        c.canviarEstat(bombilla);
                    }
                    case 3 -> { //General
                        c.interruptorGeneral();
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Introdueixi un numero valid!");
            }
        }
    }
}
