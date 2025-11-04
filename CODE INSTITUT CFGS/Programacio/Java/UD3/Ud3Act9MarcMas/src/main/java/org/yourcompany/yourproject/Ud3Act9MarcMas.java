/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class Ud3Act9MarcMas {

    public static void main(String[] args) {
        System.out.println("Maquina d'escriure les taules de l'1 al 10");
        Scanner s = new Scanner(System.in); //iniciam scanner
        for (int i = 1; i < 11; i++) { //primer bucle per el primer nombre
            System.out.println("La taula de multiplicar del " + i + " es: "); //informació a l'usuari
            for (int a = 0; a < 11; a++) { // segon bucle per el segon nombre
                System.out.println(i + " x " + a + " = " + a * i); // imprimim per pantalla, format primerNombre x segonNombre = resultat
            }
        }
    }
}
