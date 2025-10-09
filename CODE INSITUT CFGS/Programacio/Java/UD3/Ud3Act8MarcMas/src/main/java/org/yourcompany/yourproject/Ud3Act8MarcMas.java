/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class Ud3Act8MarcMas {

    public static void main(String[] args) {
        System.out.println("Maquina per calcular un factorial introduit per l'usuari");
        Scanner s = new Scanner(System.in);
        System.out.println("Quina versio vols emprar? introdueix 0 per versio amb int, 1 per versio amb double (amb mes capacitat)");
        Byte versio = s.nextByte();
        //switch per saber quin case volem emprar (versió amb int o versió amb doubles)
        switch (versio) {
            case 0:
                Integer input = 0; //input de l'usuari
                System.out.println("Introdueixi un numero positiu per calcular el seu factorial (entre 1 i 12)");
                while (input < 1 | input > 12) { //si l'input està defora del rang de 1 a 12
                    input = s.nextInt(); //agaf input
                    if (input < 1 | input > 12) {
                        System.out.println("El nombre ha d'estar entre l'1 i 12"); //si està defora, pos un missatge d'error i torn a demanar input
                    }
                }
                System.out.print("El factorial de " + input + " es "); //informació a l'usuari
                Integer resultat = input; //inicialitz variable de resultat
                for (int i = 1; i < input; i++) { //desde i fins al nombre i sumant 1 cada pic
                    resultat = resultat * i; //multiplicam resultat * i cada vegada, o sigui, 5x1,5x2,5x3... fins a 5x4 (5x5 ja no)
                }
                System.out.println(resultat); //imprimim per pantalla
                break;
            case 1:
                Double input2 = 0.0; //input de l'usuari
                System.out.println("Introdueixi un numero positiu per calcular el seu factorial (entre 1 i 170)");
                while (input2 < 1 | input2 > 170) { //si l'input està defora del rang de 1 a 170
                    input2 = s.nextDouble(); //agaf input
                    if (input2 < 1 | input2 > 170) {
                        System.out.println("El nombre ha d'estar entre l'1 i 170"); //si està defora, pos un missatge d'error i torn a demanar input
                    }
                }
                System.out.print("El factorial de " + input2 + " es "); //informació a l'usuari
                Double resultat2 = input2; //inicialitz variable de resultat
                for (int i = 1; i < input2; i++) { //desde i fins al nombre i sumant 1 cada pic
                    resultat2 = resultat2 * i; //multiplicam resultat * i cada vegada, o sigui, 5x1,5x2,5x3... fins a 5x4 (5x5 ja no)
                }
                System.out.println(resultat2); //imprimim per pantalla
                break;
            default:
                System.out.println("No has especificat versio correcta, programa acabat");
        }

    }
}
