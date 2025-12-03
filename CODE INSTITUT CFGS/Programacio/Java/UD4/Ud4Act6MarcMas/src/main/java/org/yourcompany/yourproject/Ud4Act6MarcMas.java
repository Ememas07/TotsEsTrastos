/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * Escriure una funció que retorna un valor double, de nom calculadora, a la
 * qual se li passen tres paràmetres:
 *
 * El primer i el segon, són dos variables double, per els operands.
 *
 * El tercer valor és un int. Valdrà 1 per la suma, 2 per la resta, 3 per la
 * multiplicació i 4 per la divisió.
 *
 * La funció retorna el resultat de l'operació
 *
 * @author Marc Mas
 */
public class Ud4Act6MarcMas {

    private static double calculadora(double n1, double n2, int op) {
        switch (op) {
            case 1 -> {
                //suma
                return n1 + n2;
            }
            case 2 -> {
                //resta
                return n1 - n2;
            }
            case 3 -> {
                //multiplicacio
                return n1 * n2;
            }
            case 4 -> {
                //divisio
                return n1 / n2;
            }
            default -> {
                System.out.println("Operacio no suportada!"); //per evitar que s'introdueixi una operacio invalida
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); //iniciam scanner
        System.out.println("Calculadora amb funcions, introdueixi la operacio que vol fer"); //informacio a l'usuari
        System.out.println("1: Suma");
        System.out.println("2: Resta");
        System.out.println("3: Multiplicacio");
        System.out.println("4: Divisio");
        Integer op = s.nextInt(); //variable de operacio
        System.out.println("Introdueix el primer operand"); //primer nombre 
        double n1 = s.nextDouble();
        System.out.println("Introdueix el segon operand"); //segon nombre
        double n2 = s.nextDouble();
        System.out.println(calculadora(n1, n2, op)); //feim la funcio i imprimim

    }
}
