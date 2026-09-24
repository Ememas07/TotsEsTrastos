/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 * Fer un programa que demani a l'usuari 5 nombres decimals.
 *
 * A continuació, mostrar els nombres en el mateix ordre que s'han introduit
 *
 * @author Marc Mas
 */
public class Ud5Act2MarcMas {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        float taulaNombres[] = new float[5]; //cream el array amb mida 5
        for (int i = 0; i < taulaNombres.length; i++) { //recorrem tot l'array
            System.out.println("Introdueixi un numero decimal"); //demanam nombre i el posam a l'array 
            taulaNombres[i] = s.nextFloat();
        }
        for (int i = 0; i < taulaNombres.length; i++) {
            System.out.println(taulaNombres[i]); //recorrem tot l'array i imprimim tots els nombres
        }
    }
}
