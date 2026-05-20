/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.arbres;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author Devil Hongo
 */
// ------------------------------------------------------------
// CLASSE PRINCIPAL
//
// Punt d'entrada del programa. Llegeix una expressió prefixa,
// construeix l'arbre corresponent, el mostra en diferents
// formats i n'avalua el resultat.
// ------------------------------------------------------------
public class Arbres {

    // ------------------------------------------------------------
    // CONSTANT PER DEFINIR L'EXPRESSIÓ PREFIXA PER DEFECTE
    //
    // Si l'usuari no passa cap argument, s'utilitzarà aquesta.
    // ------------------------------------------------------------
    private static final String DEFAULT = "- + 2 3 5";

    public static void main(String[] args) throws UnsupportedEncodingException {

        // Sortida UTF-8 (accents, ç, ñ, etc.)
        System.setOut(new PrintStream(System.out, true, "UTF8"));

        // ------------------------------------------------------------
        // 1. Determinar els tokens prefixos d'entrada
        // ------------------------------------------------------------
        if (args.length == 0) {
            System.out.println("No s'ha rebut cap expressió. S'usarà la prefixa per defecte:");
            System.out.println(DEFAULT);

            args = DEFAULT.split("\\s+");
        } else {
            System.out.println("Expressió prefixa rebuda:");
            System.out.println(String.join(" ", args));
        }

        // ------------------------------------------------------------
        // 2. Construir l'arbre a partir de la prefixa
        // ------------------------------------------------------------
        Arbre arbre = construirDesDePrefixa(args);

        // ------------------------------------------------------------
        // 3. Mostrar l'arbre i els recorreguts
        // ------------------------------------------------------------
        System.out.println("\nArbre indentat:");
        arbre.imprimirArbre();

        System.out.println("\nPrefixa:");
        arbre.imprimirPreFixa();

        System.out.println("\nInfixa:");
        arbre.imprimirInFixa();

        System.out.println("\nPostfixa:");
        arbre.imprimirPostFixa();

        // ------------------------------------------------------------
        // 4. Avaluar l'expressió
        // ------------------------------------------------------------
        int resultat = avaluar(arbre.getArrel());
        System.out.println("\nResultat = " + resultat);
    }

    // ------------------------------------------------------------
    // DETERMINAR SI UN TOKEN ÉS UNA OPERACIÓ
    //
    // Una operació és EXACTAMENT un dels símbols: + - * /
    // ------------------------------------------------------------
    private static boolean esOperacio(String token) {
        //TO DO
        return false;
    }

    // ------------------------------------------------------------
    // CONSTRUCCIÓ DE L'ARBRE DES D'UNA EXPRESSIÓ PREFIXA
    //
    // Es fa servir un índex encapsulat en un array ( int[] )
    // per poder-lo modificar recursivament.
    // ------------------------------------------------------------
    private static Arbre construirDesDePrefixa(String[] tokens) {
        //TO DO
        return new Arbre();
    }

    // ------------------------------------------------------------
    // CONSTRUCCIÓ RECURSIVA DE NODES
    //
    // Si el token és una operació, crea dos fills recursivament.
    // Si és un número, crea un node fulla.
    // ------------------------------------------------------------
    private static Node construirNodePrefix(String[] tokens, int[] index) {
        //TO DO
        return new Node("");
    }

    // ------------------------------------------------------------
    // AVALUACIÓ DE L'ARBRE D'EXPRESSIÓ
    //
    // Avalua recursivament l'expressió representada per l'arbre.
    // Si no és una operació, Integer.parseInt() detectarà errors.
    // ------------------------------------------------------------
    private static int avaluar(Node node) {
        //TO DO
        return 0;
    }
}
