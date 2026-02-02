/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.Llista.Llista;

/**
 * Les llistes són estructures dinàmiques de dades on es poden inserir o
 * eliminar elements d'un tipus determinat sense limitació d'espai. Implementar
 * la classe Llista corresponent a una llista de números de la classe Integer.
 * Els números es guardaran en una taula que es redimensionarà amb les
 * insercions i eliminacions, augmentant o disminuint la capacitat de la llista
 * segons el cas. Entre els mètodes de la classe, s'inclouran les tasques
 * següents:
 *
 *
 * Un constructor que inicialitzi la taula amb una mida 0. ●
 *
 * Obtenir el nombre d'elements inserits a la llista. ●
 *
 * Inserir un número al final de la llista.
 *
 * Inserir un número al principi de la llista.
 *
 * Inserir un número en un lloc de la llista l'índex del qual es passa com a
 * paràmetre.
 *
 * Afegir al final de la llista els elements d'una altra llista que es passa com
 * a paràmetre.
 *
 * Eliminar un element l'índex del qual a la llista es passa com a paràmetre.
 *
 * Obtenir l'element l'índex del qual es passa com a paràmetre.
 *
 * Buscar un número a la llista, retornant l'índex del primer lloc on es trobi.
 * Si no hi és, tornarà -1.
 *
 * Mostra els elements de la llista per consola.
 *
 * @author Marc Mas
 */
public class Ud7Act10MarcMas {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Llista l = new Llista();
        System.out.println("Quina operacio vol fer?");
        int opcio = 0;
        while (opcio > -1) { //-1 sortirà 
            try {
                System.out.println("1: Insertar nombre al principi");
                System.out.println("2: Insertar nombre al final");
                System.out.println("3: Insertar nombre a un index");
                System.out.println("4: Insertar nombres al principi");
                System.out.println("5: Insertar nombres al final");
                System.out.println("6: Eliminar un index especific");
                System.out.println("7: Obtenir un index especific");
                System.out.println("8: Cercar un numero");
                System.out.println("9: Mostrar Llista");
                System.out.println("10: Omplir amb nombres aleatoris");
                System.out.println("-1: Sortir");
                opcio = s.nextInt();
                switch (opcio) {
                    case 1 -> { //Insertar principi
                        System.out.println("Quin nombre vol inserir?");
                        int numero = s.nextInt();
                        l.insertarPrincipi(numero);
                    }
                    case 2 -> { //Insertar Final
                        System.out.println("Quin nombre vol inserir?");
                        int numero = s.nextInt();
                        l.insertarFinal(numero);
                    }
                    case 3 -> { //Insertar amb index
                        System.out.println("Quin nombre vol inserir?");
                        int numero = s.nextInt();
                        System.out.println("A quin index?");
                        int index = s.nextInt();
                        l.insertarEnmig(numero, index);
                    }
                    case 4 -> { //insertar principi (multiple)
                        System.out.println("Quants de nombres vol inserir?");
                        int quantitat = s.nextInt();
                        int numero;
                        int[] llista = new int[quantitat];
                        for (int i = 0; i < llista.length; i++) {
                            System.out.println("Insertant numero " + (i + 1));
                            numero = s.nextInt();
                            llista[i] = numero;
                        }
                        l.insertarPrincipi(llista);
                    }
                    case 5 -> { //insertar final (multiple)
                        System.out.println("Quants de nombres vol inserir?");
                        int quantitat = s.nextInt();
                        int numero;
                        int[] llista = new int[quantitat];
                        for (int i = 0; i < llista.length; i++) {
                            System.out.println("Insertant numero " + (i + 1));
                            numero = s.nextInt();
                            llista[i] = numero;
                        }
                        l.insertarFinal(llista);
                    }
                    case 6 -> { //insertar enmig (multiple)
                        System.out.println("Quants de nombres vol inserir?");
                        int quantitat = s.nextInt();
                        int numero;
                        System.out.println("A quin index?");
                        int index = s.nextInt();
                        int[] llista = new int[quantitat];
                        for (int i = 0; i < llista.length; i++) {
                            System.out.println("Insertant numero " + (i + 1));
                            numero = s.nextInt();
                            llista[i] = numero;
                        }
                        l.insertarEnmig(llista, index);
                    }
                    case 7 -> { //eliminar index
                        System.out.println("Quin index vol eliminar?");
                        int index = s.nextInt();
                        l.eliminarElement(index);
                    }
                    case 8 -> { //obtenir index
                        System.out.println("Quin index vol obtenir?");
                        int index = s.nextInt();
                        int resultat = l.obtenirElement(index);
                        if (resultat != -1) {
                            System.out.println("L'element " + index + " es " + resultat);
                        }
                    }
                    case 9 -> { //cercar nombre
                        System.out.println("Quin nombre vol cercar?");
                        int numero = s.nextInt();
                        int resultat = l.cercarElement(numero);
                        if (resultat == -1) {
                            System.out.println("No s'ha trobat el numero");
                        } else {
                            System.out.println("S'ha trobat a la posicio " + resultat);
                        }
                    }
                    case 10 -> { //mostrar
                        l.mostrarElements();
                    }
                    case 11 -> { //omplir aleatori
                        System.out.println("Quants de nombres vol?");
                        int numeros = s.nextInt();
                        l.omplirAleatori(numeros);
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Introdueixi un numero valid!");
            }
        }
    }
}
