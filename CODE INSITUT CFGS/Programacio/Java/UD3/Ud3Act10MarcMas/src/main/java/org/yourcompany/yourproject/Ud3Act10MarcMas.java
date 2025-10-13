/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class Ud3Act10MarcMas {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Programa per imprimir un triangle rectangle amb altura per pantalla");
        System.out.println("Quina altura vol?");
        Byte altura = s.nextByte(); //agafam altura per consola
        for (int i = altura; i > 0; i--) { //bucle 1 per definir la quantiat de pixels verticals
            for (int a = i; a > 0; a--) { // bucle 2 per la horizontal, imprimeix en linea i agafa el valor del bucle anterior.
            // per exemple, si tenim i = 4, en pinta 4, despres printa el bot de linea, se li resta 1 a "i", i torna a començar fins a 0
            // tendrem i = 3, en pinta 3, després bot de linea, i aixi succesivament
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
