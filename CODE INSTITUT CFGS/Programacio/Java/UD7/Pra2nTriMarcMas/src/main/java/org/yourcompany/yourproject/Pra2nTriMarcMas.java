/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.Paraula.Paraula;
import org.Text.Text;

/**
 *
 * @author Marc Mas
 */
public class Pra2nTriMarcMas {

    public static void main(String[] args) throws UnsupportedEncodingException {
        Scanner s = new Scanner(System.in);
        System.setOut(new PrintStream(System.out, true, "UTF-8")); //Per mostra accents
        System.out.println("Benvingut a la meva pràctica del segon trimestre!");
        Text text = new Text("text.txt");
        byte option = 0;
        while (option > -1) { //-1 surt
            try {
                System.out.println("1: Mostrar Totes les paraules");
                System.out.println("2: Mostrar Totes les paraules Uniques");
                System.out.println("3: Mostrar Palindroms");
                System.out.println("4: Mostrar Paraula mes llarga");
                System.out.println("5: Mostrar Paraules mes llargues que X");
                System.out.println("6: Mostrar Anagrames");
                System.out.println("7: Mostrar estadistíques d'una paraula especifica");
                option = s.nextByte();
                switch (option) {
                    case 1 -> { // Mostrar paraules
                        text.mostrarParaules();
                    }
                    case 2 -> {
                        text.mostrarParaulesUniques();
                    }
                    case 3 -> {
                        text.mostrarPalindroms();
                    }
                    case 4 -> {
                        text.mostrarParaulaMesLlarga();
                    }
                    case 5 -> {
                        int longitut = 0;
                        System.out.println("Insereix quina es la longitut minima");
                        longitut = s.nextInt();
                        text.mostrarParaulesLlargues(longitut);
                    }
                    case 6 -> {
                        text.pintarParellesAnagrames();
                    }
                    case 7 -> {
                        int sortir = 0;
                        System.out.println("Insereix el numero de la paraula");
                        sortir = s.nextInt();
                        if (sortir > -1) { //si no hem posat -1, agafam el numero i agafam la paraula del text amb el numero inserit
                            Paraula p = text.getParaula(sortir);
                            if (!p.getText().equals("")) { //si no esta buida, mostram estadisitques i si te anagrames
                                p.estadistiques();
                                text.teAnagrames(p);
                            }
                        }

                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Please input a valid option");
            }
        }
    }
}
