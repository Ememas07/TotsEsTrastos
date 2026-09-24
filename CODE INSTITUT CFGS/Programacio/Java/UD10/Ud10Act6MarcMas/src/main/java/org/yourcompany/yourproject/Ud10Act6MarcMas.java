/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Crear amb un editor el fitxer de text Enters.txt a la carpeta del projecte de
 * NetBeans actual i escriu dins ell una sèrie de nombres enters, separats per
 * espais, tabuladors i inclús per bots de línia.
 *
 * Implementar un programa que accedeixi al fitxer amb un objecte Scanner a
 * través d'un flux d'entrada, llegeixi els nombres i calculi la suma i la
 * mitjana, mostrant els resultats per pantalla.
 *
 * @author Marc Mas
 */
public class Ud10Act6MarcMas {

    public static int[] insertarValor(int[] taula, int numero) {
        int[] taulaNova = Arrays.copyOf(taula, taula.length + 1);
        taulaNova[taula.length] = numero;
        return taulaNova;
    }

    public static void main(String[] args) {
        try {
            BufferedReader fitxer = new BufferedReader(new FileReader(
                    "src\\main\\java\\org\\yourcompany\\yourproject\\Enters.txt" //especificam el fitxer que volem llegir i emprarem un BufferedReader
            ));
            Scanner s = new Scanner(fitxer); //obrim un scanner
            int[] taula = new int[0]; //cream una taula nova
            int suma = 0; //incialitzam variable de suma
            while (s.hasNextInt()) { //mentres hi hagui nous numeros dins l'escanner
                int numero = s.nextInt(); //les agafam i anam posant a la variable numero
                taula = insertarValor(taula, numero);//insertam el valor
                suma += numero; //afegim a la suma
            }
            fitxer.close(); //tancam el fitxer 
            float mitjana = suma / taula.length; //calculam la mitjana
            System.out.println("La suma es " + suma);
            System.out.println("La mitjana es " + mitjana);
        } catch (FileNotFoundException e) { //si no trobam el fitxer
            System.out.println("No s'ha trobat el fitxer!");
        } catch (IOException ex) { //o tenim un error de IO
            System.out.println("Error de IO!");
        }
    }
}
