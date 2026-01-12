/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

/*
Dissenyar la classe CompteBancari, que emmagatzema les dades: DNI, nomTitular i saldo. Les operacions típiques d'aquesta compta són:
○ Crear un compte. Es necessita el DNI i nom del titular, el saldo és 0
○ Treure doblers: s'ha d'indicar si és possible o no, en funció del saldo
○ Ingressar doblers
○ Mostrar informació
 */
/**
 *
 * @author Marc Mas
 */
public class Ud7Act1MarcMas {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Quina operacio vol fer?");
        int opcio = 0;
        while (opcio > 0) {
            try {
                System.out.println("Crear un compte");
                System.out.println("Treure doblers");
                System.out.println("Ingressar doblers");
                System.out.println("Mostrar informació");
                opcio = s.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Introdueixi un numero valid!");
            }
            switch (opcio) {
                case 1 ->
                    int dni =
                    
                case 2 ->
                    System.out.println("Treure doblers");
                case 3 ->
                    System.out.println("Ingressar doblers");
                case 4 ->
                    System.out.println("Mostrar informació");
                default -> {
                }
            }
        }
    }
}
