/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

/**
 * Crear una taula de longitud 10 que s’inicialitzarà amb nombres aleatoris de
 * l’1 al 100.
 *
 * Mostrar la suma de tots els elements de la taula
 *
 * @author Marc Mas
 */
public class Ud5Act1MarcMas {

    public static void main(String[] args) {
        int taulaAleatoris[] = new int[10]; //cream array
        int suma = 0;
        for (int i = 0; i < taulaAleatoris.length; i++) { //recorrem tot l'array
            taulaAleatoris[i] = (int) (1 + Math.random() * 100); //omplim amb nombres de 1 a 100
            suma += taulaAleatoris[i]; //afegim a la suma
        }
        System.out.println("La suma total dels valors es" + suma); //imprimim
    }
}
