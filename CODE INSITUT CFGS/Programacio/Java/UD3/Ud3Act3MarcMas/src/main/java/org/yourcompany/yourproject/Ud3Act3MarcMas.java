/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class Ud3Act3MarcMas {

    public static void main(String[] args) {
        System.out.println("Joc d'aproximacio");
        System.out.println("L'ordinador generara un nombre enter entre 0 i 100, i l'has d'endivinar.");
        System.out.println("Introdueix el nombre -1 per rendir-te");
        Scanner s = new Scanner(System.in);
        System.out.println("Introdueixi un nombre"); //deman el primer nombre per consola i l'agaf com a byte
        Byte n = s.nextByte();
        Byte rondes = 0; //inicialitzam variables
        Integer punts = 0;
        Integer solucio = (int) (Math.random() * 100); //Math.random genera un nombre entre 0.0 i 1.0, el multiplicare per 100 per tenir un valor entre 1 i 100
        if (solucio == 0) {
            solucio = 1; //per evitar que el random doni 0
        }
        while ((int) n != solucio && (int) n != -1) { //si n no es igual que la solucio, entram
            if (n > solucio) {
                System.out.println("El teu nombre es mes alt que la solucio");
                punts += (n - solucio);
            } else {
                System.out.println("El teu nombre es mes baix que la solucio");
                punts += (solucio - n); //sumam la diferencia entre punts i el nombre introduit (o viceversa)
            }
            rondes++; //sumam una ronda
            System.out.println("Introdueixi un altre"); //deman el primer nombre per consola i l'agaf com a byte
            n = s.nextByte();
        }
        //un pic encertam el nombre o ens rendim, surtim
        if ((int) n != -1) {
            System.out.println("Enhorabona! La teva puntuacio es de " + rondes + " Rondes - " + punts + " Punts");
        } else {
            System.out.println("T'has rendit :(");
            System.out.println("La teva puntuacio es de " + rondes + " Rondes - " + punts + " Punts");
        }
    }
}
