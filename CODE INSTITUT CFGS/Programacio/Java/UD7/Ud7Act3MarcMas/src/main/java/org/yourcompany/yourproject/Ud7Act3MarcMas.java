/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.yourcompany.yourproject.package2.CompteBancari;

/**
 * Modificar la visibilitat de la classe CompteBancari per a que sigui visible
 * des de classes externes i la visibilitat dels seus atributs per a que:
 *
 * saldo no sigui visible per a altres classes.
 *
 * nom sigui públic per a qualsevol classe
 *
 * dni només sigui visible per a classes veinades
 *
 * Escriu un programa que comprovi la visibilitat dels atributs
 *
 * @author Marc Mas
 */
public class Ud7Act3MarcMas {

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
                    //     System.out.println(c.saldo); // Saldo es privat, per lo qual aquesta linea donarà un error 
                }
            } catch (InputMismatchException e) {
                System.out.println("Introdueixi un numero valid!");
            }
        }
    }
}
