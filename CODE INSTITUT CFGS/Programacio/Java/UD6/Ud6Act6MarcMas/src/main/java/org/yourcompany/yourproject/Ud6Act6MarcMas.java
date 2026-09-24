/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 * Escriure un programa que demani una frase i una paraula a l'usuari. S'hade
 * cercar quantes vegades apareix la paraula dins la frase.
 *
 * @author Marc Mas
 */
public class Ud6Act6MarcMas {

    public static int contadorParaula(String frase, String paraula) {
        int vegades = 0;
        for (int i = 0; i < frase.length(); i++) { //recorrem tot el string
            int index = 0;
            while (index < paraula.length() && frase.charAt(i + index) == paraula.charAt(index)) {
                /* el primer bucle incrementa la i per cada lletra
                   el bucle while mira desde la lletra inicial i (mes index)
                   index se va incrementant cada vegada que la funcio es compleix
                   per exemple, posam "hola bon dia" i "bon"
                   for mira la h, h != b
                   no feim res
                   o != b, l != b, a !=...
                   fins a la b
                   b == b, incrementam index
                   o == o, incrementam index
                   n == n, incrementam index (i aturam perque ja hem recorregut tota la paraula)
                 */
                index++;
            }
            if (index == paraula.length()) { // si index == paraula.length, vol dir que hem trobat la paraula sencera dins l'array, aixi que sumarem 1 a les vegades que apareix
                vegades++;
            }
        }
        return vegades;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Aquest programa retornara la quantitat de vegades que apareix una paraula a una frase");
        System.out.println("Introdueixi una frase");
        String frase = s.nextLine(); //agafam la frase per consola
        System.out.println("Introdueixi una paraula");
        String paraula = s.next(); //agafam la paraula per consola
        System.out.println("La paraula " + paraula + " apareix " + contadorParaula(frase, paraula) + " vegades"); // imprimim per l'usuari
    }
}
