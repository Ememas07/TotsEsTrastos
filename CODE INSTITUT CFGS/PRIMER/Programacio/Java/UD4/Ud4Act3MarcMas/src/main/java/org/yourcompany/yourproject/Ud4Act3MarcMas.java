/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 * Escriure una funció, de nom max, a la qual se li passen dos nombres enters
 * retorna el major dels dos
 *
 * @author Marc Mas
 */
public class Ud4Act3MarcMas {

    private static int max(int n1, int n2) { //funcio que ens dona el nombre major entre dos
        if (n1 > n2) { //si N1 es major que n2, retornam n1
            return n1;
        } else { //si no, retornam n2
            return n2;
        }
        // Math.max((int) n1, (int) n2); // Manera Alternativa 
    }

    public static void main(String[] args) {
        System.out.println("Programa per imprimir tots els nombres compresos entre ells"); //informacio a l'usuari
        Scanner s = new Scanner(System.in); //iniciam scanner
        System.out.println("Nombre 1"); // demanam primer nombre
        Integer n1 = s.nextInt(); //assignam
        System.out.println("Nombre 2"); //demanam segon nombre
        Integer n2 = s.nextInt(); //assignam
        System.out.println(max(n1, n2)); //executam la funció
    }
}
