/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.Pila.Pila;

/**
 * Defineix la interfície Pila per a nombres enters
 *
 * @author Marc Mas
 */
public class Ud9Act3MarcMas {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Pila p = new Pila();
        System.out.println("Quina operacio vol fer?");
        int opcio = 0;
        while (opcio > -1) { //-1 sortirà 
            try {
                System.out.println("1: Apilar un numero ");
                System.out.println("-1: Sortir");
                opcio = s.nextInt();
                switch (opcio) {
                    case 1 -> { //apilar
                        System.out.println("Quin numero vol afegir?"); //demanam quin nombre posam
                        int numero = s.nextInt();
                        p.apilar(numero);
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Introdueixi un numero valid!");
            }
        }
        p.desapilarTots();
    }
}
