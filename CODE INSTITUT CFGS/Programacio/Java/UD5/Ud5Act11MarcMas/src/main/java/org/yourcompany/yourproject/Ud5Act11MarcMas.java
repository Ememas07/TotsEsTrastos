/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 * Desenvolupar el joc “La Cambra Secreta”, que consisteix en abrir un candau
 * amb una combinació secreta
 *
 * La combinació és una combinació de dígits de 1 a 5.
 *
 * El jugador especifica quina és la longitud de la combinació (més longitud =
 * més dificultat).
 *
 * L'aplicació genera, de forma aleatòria, una combinació secreta que l'usuari
 * ha d'encertar.
 *
 * A cada intent, es mostra com a pista, si el resultat indicat per el jugador
 * és major o menor que la combinació actual.
 *
 * @author Marc Mas
 */
public class Ud5Act11MarcMas {

    public static boolean comprovacio(int[] correcta, int[] usuari) {
        int encerts = 0;
        for (int i = 0; i < correcta.length; i++) {
            if (correcta[i] > usuari[i]) {
                System.out.print(">");
            } else if (correcta[i] < usuari[i]) {
                System.out.print("<");
            } else {
                encerts++;
                System.out.print("=");
                System.out.print("(" + usuari[i] + ")"); // mostram a l'usuari quin nombre ha posat si es correcte perque el pugui repetir
            }
            System.out.print("   ||   ");
        }
        System.out.println("");
        return encerts == correcta.length; //equivalent a fer un "if encerts == correcta.length return true i return false si no"
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Joc de La Cambra Secreta");
        System.out.println("Hauras d'introduir una serie de nombres i intentar endivinar la combinacio correcta");
        System.out.println("Quin vol que sigui el nombre maxim del nombre?"); //demanam quin rang de nombres vol l'usuari
        int maxim = s.nextInt();
        System.out.println("Quina sera la longitut de la combinacio?");
        int longitut = s.nextInt();
        int combinacioCorrecta[] = new int[longitut];
        int combinacioUsuari[] = new int[longitut];
        for (int i = 0; i < combinacioCorrecta.length; i++) {
            combinacioCorrecta[i] = (int) (1 + Math.random() * maxim);
        }
        do {
            demanarUsuari(combinacioUsuari);
        } while (!comprovacio(combinacioCorrecta, combinacioUsuari));
        System.out.println("Has guanyat!");
    }

    public static void demanarUsuari(int t[]) {
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < t.length; i++) {
            System.out.println("Introdueixi el nombre " + (i + 1) + " de la seva combinacio");
            t[i] = s.nextInt();
        }
    }
}
