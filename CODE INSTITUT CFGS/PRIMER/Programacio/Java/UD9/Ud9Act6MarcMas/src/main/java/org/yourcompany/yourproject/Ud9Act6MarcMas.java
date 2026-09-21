/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.Llista.Llista;

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
public class Ud9Act6MarcMas {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Llista l = new Llista();
        System.out.println("Quina operacio vol fer?");
        int opcio = 0;
        while (opcio > -1) { //-1 sortirà 
            try {
                System.out.println("1: Apilar un numero ");
                System.out.println("2: Encoar un numero varies vegades");
                System.out.println("3: Desapilar Un element");
                System.out.println("4: Mostrar pila");
                System.out.println("5: Desapilar tots");
                System.out.println("-1: Sortir");
                opcio = s.nextInt();
                switch (opcio) {
                    case 1 -> { //apilar
                        System.out.println("Quin numero vol afegir?"); //demanam quin nombre posam
                        int numero = s.nextInt();
                        l.apilar(numero);
                    }
                    case 2 -> { //apilar varis
                        System.out.println("Quin numero vol afegir?"); //demanam quin nombre posam
                        int numero = s.nextInt();
                        System.out.println("Quantes vegades?"); //demanam quin nombre posam
                        int repeticions = s.nextInt();
                        l.encoarMultiple(numero, repeticions);
                    }
                    case 3 -> { //desapilar
                        l.desapilar();
                    }
                    case 4 -> { //mostrar
                        l.mostrarElements();
                    }
                    case 5 -> { //desapilar tots
                        l.desapilarTots();
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Introdueixi un numero valid!");
            }
        }
    }
}
