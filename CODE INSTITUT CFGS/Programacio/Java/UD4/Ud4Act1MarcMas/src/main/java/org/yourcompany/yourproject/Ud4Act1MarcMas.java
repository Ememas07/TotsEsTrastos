/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 * Dissenyar la funció eco(), a la que li passam com a paràmetre un nombre n i
 * mostra per pantalla n vegades el missatge “Eco...”
 *
 * @author Marc Mas
 */
public class Ud4Act1MarcMas {

    private static void eco(int n) { //funcio que imprimira "eco..." n vegades
        for (int i = 0; i < n; i++) { // desde 0 fins a N
            System.out.println("Eco..."); //imprimim
        }
    }

    public static void main(String[] args) {
        System.out.println("Programa per imprimir eco quantes vegades ens digui l'usuari");
        Scanner s = new Scanner(System.in); //com a feina extra, demanaré a l'usuari que posi quantes vegades vol el nombre
        Integer n = s.nextInt(); //assignam el valor introduit a la variable n
        eco(n); //cridam la funcio amb el nombre que volem
    }
}
