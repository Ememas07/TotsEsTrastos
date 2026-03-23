/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.Pila.Pila;

/**
 * Emprant la llista anterior, escriu un programa en el que s'encoin nombres
 * enters introduïts per teclat, fins que s'hi introdueix un de negatiu.
 *
 * A continuació, desencoar-los tots a mesura que es mostren per pantalla
 *
 * @author Marc Mas
 */
public class Ud9Act2MarcMas {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Pila p = new Pila();
        System.out.println("Aquest programa encoarà nombres enters fins que posis un nombre negatiu");
        try {
            int numero = 0;
            while (numero > -1) {
                System.out.println("Quin numero vol afegir?"); //demanam quin nombre posam
                numero = s.nextInt();
                if (numero > -1) {
                    p.apilar(numero);
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Introdueixi un numero valid!");
        }
        p.desapilarTots();
    }
}
