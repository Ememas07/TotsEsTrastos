/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.yourcompany.yourproject.package2.CompteBancari;

/**
 * Tots els comptes corrents amb les que es va a treballar pertanyen al mateix
 * banc.
 *
 * Afegir un atribut que emmagatzemi el nom del banc a la classe CompteBancari.
 *
 * Dissenyar un mètode que permeti recuperar i modifica el nom del banc.
 *
 * @author Marc Mas
 */
public class Ud7Act4MarcMas {

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
                System.out.println("3: Mostrar informacio");
                System.out.println("4: Canviar Banc");
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
                        //     System.out.println(c.saldo); // Saldo es privat, per lo qual aquesta linea donarà un error 
                    }
                    case 4 -> {
                        System.out.println("Quin es el nou banc?");
                        s.next();
                        String nomBanc = s.nextLine();
                        c.setNomBanc(nomBanc);
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Introdueixi un numero valid!");
            }
        }
    }
}
