/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class UD2Act6MarcMas {

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
            String llargaria = numero.toString(); //convertesc de int a string per desprer cridar a length()
            System.out.println("El teu numero te " + llargaria.length() + " xifres"); //imprimesc resultat per pantalla
        }
    }
}
