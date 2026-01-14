/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.yourcompany.yourproject.package2.CompteBancari;
import org.yourcompany.yourproject.package2.Gestor;

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
public class Ud7Act5MarcMas {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Creant compte Bancari");
        CompteBancari c = CompteBancari.crearCompte(); //crear un compte, que demanarà les dades a l'usuari i el guardam a la variable C
        System.out.println("Quina operacio vol fer?");
        int opcio = 0; 
        while (opcio > -1) { //-1 sortirà 
            try {
                System.out.println("1: Treure doblers");
                System.out.println("2: Ingressar doblers");
                System.out.println("3: Mostrar informació");
                System.out.println("4: Canviar Banc");
                System.out.println("5: Canviar Gestor");
                System.out.println("-1: Sortir ");
                opcio = s.nextInt();
                switch (opcio) {
                    case 1 -> { //treure doblers
                        System.out.println("Quants de doblers vol treure?");
                        int quantitat = s.nextInt();
                        c.treureDoblers(quantitat);
                    }
                    case 2 -> { //aficar doblers
                        System.out.println("Quants de doblers vol ingressar?");
                        int quantitat = s.nextInt();
                        c.ingressarDoblers(quantitat);
                    }
                    case 3 -> { //mostrar informacio
                        c.mostrarInformacio();
                        //     System.out.println(c.saldo); // Saldo es privat, per lo qual aquesta linea donarà un error 
                    }
                    case 4 -> { //canviar nom del banc
                        System.out.println("Quin es el nou banc?");
                        s.next();
                        String nomBanc = s.nextLine();
                        c.setNomBanc(nomBanc);
                    }
                    case 5 -> { //cream i canviam el gestor
                        Gestor g = Gestor.crearGestor();
                        c.canviarGestor(g);
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Introdueixi un numero valid!");
            }
        }
    }
}
