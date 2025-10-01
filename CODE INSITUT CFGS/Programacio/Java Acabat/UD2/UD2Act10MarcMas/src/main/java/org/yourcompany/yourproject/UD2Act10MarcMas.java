/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class UD2Act10MarcMas {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Quants d'alumnes seran"); //demanam nombre d'alumnes
        Integer alumnes = s.nextInt();
        Integer costTotal = 0; //inicialitzam variables de cost total i per alumne
        Integer costAlumne = 0;
        if (alumnes >= 30) { //si hi ha més de 30 alumnes, posam cost per alumne a 95
            costAlumne = 95;
            if (alumnes >= 50) { //si n'hi ha mes de 50, a 70
                costAlumne = 70;
                if (alumnes >= 100) { //si n'hi ha mes de 100, a 65
                    costAlumne = 65;
                }
            }
            costTotal = costAlumne * alumnes; //calculam el cost total multiplicant cost per alumne per el nombre d'alumnes
        } else { //si no hi ha mes de 30 alumnes, posam cost total a 4000 i calculam preu per alumne
            costTotal = 4000;
            costAlumne = (4000 / alumnes);
        }
        System.out.println("El cost total es de " + costTotal + " i aixo equival a " + costAlumne + " per alumne"); //imprimim resultat final
    }
}
