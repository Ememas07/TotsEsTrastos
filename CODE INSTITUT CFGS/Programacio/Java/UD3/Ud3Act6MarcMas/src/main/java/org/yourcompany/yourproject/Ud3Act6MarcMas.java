/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class Ud3Act6MarcMas {

    public static void main(String[] args) {
        System.out.println("Maquina d'escriure la taula de multiplicar de l'usuari");
        Scanner s = new Scanner(System.in); 
        Byte input = 0; //input de l'usuari
        System.out.println("Introdueixi un numero de l'1 al 10");
        while (input < 1 | input > 10) { //si l'input està defora del rang de 1 a 10
            input = s.nextByte(); //agaf input
            if (input < 1 | input > 10) {
                System.out.println("El nombre ha d'estar entre l'1 i el 10!"); //si està defora, pos un missatge d'error i torn a demanar input
            }
        }
        System.out.println("La taula de multiplicar del " + input + " es: "); //informació a l'usuari
        for (int i = 0; i < 11; i++) { // comença a la taula del 0 i fa fins a la del 10
            System.out.println(input + " x " + i + " = " + i * input); //imprimesc en format "nombre x nombre2 = resultat" 
        }
    }
}
