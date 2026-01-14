/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.InputMismatchException;
import java.util.Scanner;

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
public class Ud7Act2MarcMas {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Creant compte Bancari");
        CompteBancari c = CompteBancari.crearCompte();
        System.out.println("Quina operacio vol fer?");
        int opcio = 0;
        while (opcio > -1) {
            try {
                System.out.println("1: Treure doblers");
                System.out.println("2: Ingressar doblers");
                System.out.println("3: Mostrar informació");
                System.out.println("-1: Sortir ");
                opcio = s.nextInt();
                switch (opcio) {
                    case 1 -> {
                        System.out.println("Quants de doblers vol treure?");
                        int quantitat = s.nextInt();
                        c.treureDoblers(quantitat);
                    }
                    case 2 -> {
                        System.out.println("Quants de doblers vol ingressar?");
                        int quantitat = s.nextInt();
                        c.ingressarDoblers(quantitat);
                    }
                    case 3 -> {
                        c.mostrarInformacio();
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Introdueixi un numero valid!");
            }
        }
    }
}
