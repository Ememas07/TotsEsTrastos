/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

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
public class Ud9Act5MarcMas {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Cua c = new Cua() {
            int[] numeros = new int[0];

            @Override
            public void insertarPrincipi(int[] insercions) {
                for (int i = 0; i < insercions.length; i++) {
                    this.insertarPrincipi(insercions[i]); //recorrem l'array i aficam al principi un per un
                }
            }

            @Override
            @SuppressWarnings("ManualArrayToCollectionCopy")
            public void insertarPrincipi(int numero) {
                int[] llistaNova = Arrays.copyOf(numeros, numeros.length + 1);
                for (int i = 0; i < numeros.length; i++) { //feim una copia amb totes les posicions avançades per un
                    llistaNova[i + 1] = numeros[i];
                }
                llistaNova[0] = numero; //canviam primer element
                this.numeros = llistaNova;
            }

            @Override
            public void insertarFinal(int numero) {
                int[] llistaNova = Arrays.copyOf(numeros, numeros.length + 1); //feim una copia 
                llistaNova[llistaNova.length - 1] = numero; //canviam el darrer element
                this.numeros = llistaNova;
            }

            @Override
            public void insertarFinal(int[] insercions) {
                for (int i = 0; i < insercions.length; i++) {
                    this.insertarFinal(insercions[i]);
                }
            }

            @Override
            @SuppressWarnings("ManualArrayToCollectionCopy")
            public void insertarEnmig(int numero, int index) {
                try {
                    int[] llistaNova = Arrays.copyOf(numeros, numeros.length + 1);
                    for (int i = 0; i < index; i++) {
                        llistaNova[i] = numeros[i]; //copiam fins a index
                    }
                    llistaNova[index] = numero; //assignam index
                    for (int i = index; i < numeros.length; i++) {
                        llistaNova[i + 1] = numeros[i]; //copiam desde index fins al final de la llista
                    }
                    this.numeros = llistaNova;
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("L'index insertat no és valid!");
                }
            }

            @Override
            public void insertarEnmig(int[] numeros, int index) {
                for (int i = 0; i < numeros.length; i++) {
                    insertarEnmig(numeros[i], index + i);
                }
            }

            @Override
            public void eliminarElement(int index) {
                try {
                    int[] llistaNova = Arrays.copyOf(numeros, numeros.length - 1);
                    if (index == 0) {
                        for (int i = 0; i < numeros.length - 1; i++) {
                            llistaNova[i] = numeros[i + 1];
                            //si l'index es 0, copiam tot l'array llevant el primer valor, 
                            // però ho hem de posar en un ordre diferent ja que volem fer i+1, 
                            // de l'altra manera estariem assignant a un index negatiu
                        }
                    } else {
                        for (int i = 0; i < numeros.length - 1; i++) {
                            if (i <= index) {
                                llistaNova[i] = numeros[i]; //copiam fins a index
                            } else {
                                llistaNova[i] = numeros[i - 1]; //copiam desde index fins al final de la llista
                            }
                        }
                    }
                    this.numeros = llistaNova;
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("L'index insertat no és valid!");
                }
            }

            @Override
            public void mostrarElement(int index) {
                System.out.println(numeros[index]);
            }

            @Override
            public void desapilarTots() {
                while (this.numeros.length != 0) {
                    this.mostrarElement(0);
                    this.eliminarElement(0);
                }
            }
        };

        try {
            int numero = 0;
            while (numero > -1) {
                System.out.println("Quin numero vol afegir?"); //demanam quin nombre posam
                numero = s.nextInt();
                if (numero > -1) {
                    c.insertarPrincipi(numero);
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Introdueixi un numero valid!");
        }
        c.desapilarTots();
    }
}
