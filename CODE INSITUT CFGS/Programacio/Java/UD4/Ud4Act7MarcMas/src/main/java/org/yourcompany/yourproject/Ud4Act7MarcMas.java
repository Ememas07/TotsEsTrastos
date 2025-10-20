/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * Aprofitant la funció creada a una activitat anterior, crea una funció que
 * calculi el nombre més gran de tres valors enters.
 *
 * @author Marc Mas
 */
public class Ud4Act7MarcMas {

    private static int max(int n1, int n2) { //funcio que ens dona el nombre major entre dos
        if (n1 > n2) { //si N1 es major que n2, retornam n1
            return n1;
        } else { //si no, retornam n2
            return n2;
        }
        // Math.max((int) n1, (int) n2); // Manera Alternativa 
    }

    private static int max(int n1, int n2, int n3) { 
        return max(max(n1, n2), n3); //comprovam els dos primers, i despres el major dels dos primers amb el 3r
    }

    public static void main(String[] args) {
        System.out.println("Programa per imprimir tots els nombres compresos entre ells"); //informacio a l'usuari
        Scanner s = new Scanner(System.in); //iniciam scanner
        System.out.println("Nombre 1"); // demanam primer nombre
        Integer n1 = s.nextInt(); //assignam
        System.out.println("Nombre 2"); //demanam segon nombre
        Integer n2 = s.nextInt(); //assignam
        System.out.println("Nombre 3"); //demanam segon nombre
        Integer n3 = s.nextInt(); //assignam
        System.out.println(max(n1, n2, n3)); //executam la funció
    }
}
