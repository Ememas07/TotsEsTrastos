/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class Ud2Act6MarcMas {

    public static void main(String[] args) {
        System.out.println("Calculador de llargaria del nombre");
        Scanner s = new Scanner(System.in);
        System.out.println("Introdueix un numero entre -99.999 i 99.999"); //deman un nombre per comanda
        Integer numero = s.nextInt();
        if (numero > 99999 || numero < -99999) { //si el nombre està defora del rang, imprimesc l'error
            System.out.println("Nombre massa gran");
        } else {
            if (numero < 0) { //si el nombre es negatiu, el torn a positiu per no tenir el signe
                numero = -numero;
            }
            if (numero > 9999) {
                System.out.println("El teu numero te 5 xifres"); //imprimesc resultat per pantalla
            } else if (numero > 999) {
                System.out.println("El teu numero te 4 xifres"); //imprimesc resultat per pantalla
            } else if (numero > 99) {
                System.out.println("El teu numero te 3 xifres"); //imprimesc resultat per pantalla
            } else if (numero > 9) {
                System.out.println("El teu numero te 2 xifres"); //imprimesc resultat per pantalla
            } else {
                System.out.println("El teu numero te 1 xifra"); //imprimesc resultat per pantalla
            }
        }
    }
}
