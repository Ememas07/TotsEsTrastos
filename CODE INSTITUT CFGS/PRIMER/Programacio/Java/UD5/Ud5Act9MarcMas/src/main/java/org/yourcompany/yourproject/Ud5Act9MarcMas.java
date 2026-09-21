/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Dissenyar una aplicació per a gestionar un campionat de programació
 *
 *
 * S'ha d'introduir la puntuació (enters) obtinguda per 5 programadors, segons
 * van acabant la prova.
 *
 * L'aplicació ha de mostrar les puntuacions ordenades dels cinc participants.
 *
 * De vegades, quan finalitzen els 5 programadors, s'hi afegeixen participants
 * de prova, les puntuacions dels quals també s'hi afegeixen.
 *
 * La manera d'especificar que s'ha acabat tot el torneig és amb una puntuació
 * de -1.
 *
 * L'aplicació ha de mostrar els punts ordenats de tots els participants,
 * oficials i de prova.
 *
 * @author Marc Mas
 */
public class Ud5Act9MarcMas {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Programa per gestionar un campionat de programacio");
        int puntuacions[] = new int[5]; //cream un array amb 5 posicions 
        for (int i = 0; i < puntuacions.length; i++) {
            System.out.println("Introdueix la puntuacio del programador " + (i + 1)); //introduim les 5 primeres puntuacions manualment
            puntuacions[i] = s.nextInt();
        }
        int darreraPuntuacio = 0; // anirem canviant aquesta variable amb les puntuacions afegides després de les 5 primeres
        while (darreraPuntuacio != -1) { //si no hem posat -1 volem seguir
            System.out.println("Vol afegir un altre programador? introdueix la seva puntuacio o -1 per aturar");
            darreraPuntuacio = s.nextInt();
            if (darreraPuntuacio != -1) { //si no hem posat -1, afegim la puntuacio a l'array
                puntuacions = introduirOrdenat(puntuacions, darreraPuntuacio);
            }
        }
        System.out.println("Puntuacions: "); //imprimim l'array
        for (int i = 0; i < puntuacions.length; i++) {
            System.out.print(puntuacions[i] + ", ");
        }
    }

    public static int[] introduirOrdenat(int[] t, int n) {
        int indexIntroduit = 0; //cream un index que anirem incrementant
        int taulaNova[] = Arrays.copyOf(t, t.length + 1); //copiam l'array existent
        for (; indexIntroduit < t.length && t[indexIntroduit] < n; indexIntroduit++) { //copiam desde 0 fins al darrer nombre més petit que el que introduim
            taulaNova[indexIntroduit] = t[indexIntroduit];
        }
        taulaNova[indexIntroduit] = n; //copiam el nombre a la casella especifica
        for (; indexIntroduit < t.length; indexIntroduit++) {
            taulaNova[indexIntroduit + 1] = t[indexIntroduit]; //copiam desde el nombre que hem afegit fins al final de l'array
        }
        return taulaNova;

    }
}
