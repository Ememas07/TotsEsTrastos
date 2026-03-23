/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.Llista.Llista;

/**
 * Afegir a la classe Llista la implementació de la interfície Pila, junt a la
 * interfície Coa, ja implementada
 *
 * @author Marc Mas
 */
public class Ud9Act4MarcMas {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Llista l = new Llista();
        System.out.println("Quina operacio vol fer?");
        int opcio = 0;
        while (opcio > -1) { //-1 sortirà 
            try {
                System.out.println("1: Apilar un numero ");
                System.out.println("-1: Sortir");
                System.out.println("2: Desapilar Un element");
                System.out.println("3: Mostrar pila");
                System.out.println("4: Desapilar tots");
                opcio = s.nextInt();
                switch (opcio) {
                    case 1 -> { //apilar
                        System.out.println("Quin numero vol afegir?"); //demanam quin nombre posam
                        int numero = s.nextInt();
                        l.apilar(numero);
                    }
                    case 2 -> { //desapilar
                        l.desapilar();
                    }
                    case 3 -> { //mostrar
                        l.mostrarElements();
                    }
                    case 4 -> { //desapilar tots
                        l.desapilarTots();
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Introdueixi un numero valid!");
            }
        }
    }
}
