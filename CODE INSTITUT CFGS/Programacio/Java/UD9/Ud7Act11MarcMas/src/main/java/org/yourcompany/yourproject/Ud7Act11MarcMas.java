/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.Pila.Pila;

/**
 * Una pila és una estructura dinàmica de dades on els elements s'insereixen
 * (s'apilen) i es retiren (es desapilen) seguint la norma que l'últim que
 * s'apila serà el primer a despilar-se, com passa amb una pila de plats.
 *
 *
 * Quan retirarem un plat d'una pila a ningú se li acudeix estirar un dels de
 * baix; retirem (desapilem) el que està a sobre de tots, que va ser l'últim a
 * ser apilat. S'anomena cim de la pila l'últim element apilat (o el primer
 * element per desapilar). Els mètodes fonamentals d'una pila són apilar() i
 * desapilar().
 *
 *
 * Implementar la classe Pila per a números Integer, on s'usa una llista (un
 * objecte de la classe Llista implementada a l'Activitat resolta 7.10) per
 * guardar els elements apilats.
 *
 * @author Marc Mas
 */
public class Ud7Act11MarcMas {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Pila p = new Pila();
        System.out.println("Quina operacio vol fer?");
        int opcio = 0;
        while (opcio > -1) { //-1 sortirà 
            try {
                System.out.println("1: Apilar un numero ");
                System.out.println("2: Desapilar ");
                System.out.println("3: Mostrar pila");
                System.out.println("-1: Sortir");
                opcio = s.nextInt();
                switch (opcio) {
                    case 1 -> { //apilar
                        System.out.println("Quin numero vol afegir?"); //demanam quin nombre posam
                        int numero = s.nextInt();
                        p.apilar(numero);
                    }
                    case 2 -> { //desapilar
                        p.desapilar();
                    }
                    case 3 -> { //mostrar
                        p.mostrarElements();
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Introdueixi un numero valid!");
            }
        }
    }
}
