/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 * Escriu la funció: byte primitiva(byte[] aposta, byte[] combGuanyadora).
 *
 * La funció ha de tornar el nombre d’encerts (posicions iguals) entre les dues
 * taules
 *
 * @author Marc Mas
 */
public class Ud5Act6MarcMas {

    public static byte primitiva(byte[] aposta, byte[] combGuanyadora) { 
        byte puntuacio = 0;
        for (byte i = 0; i < aposta.length; i++) {
            if (aposta[i] == combGuanyadora[i]) {
                puntuacio++;
            }
        }

        return puntuacio;
    }

    public static byte[] generarPrimitiva() {
        byte taula[] = new byte[6]; //cream un array de 6 posicions
        for (byte i = 0; i < taula.length; i++) { //recorrem tot l'array
            taula[i] = (byte) (1 + Math.random() * 49); //anam omplbyte amb nombres desde 1 fins a 49
        }
        return taula;
    }

    public static byte[] rellenarPrimitiva() {
        Scanner s = new Scanner(System.in); 
        byte taula[] = new byte[6]; //cream un array de 6 posicions
        for (byte i = 0; i < taula.length; i++) { //recorrem tot l'array
            System.out.println("Introdueixi el numero " + (i + 1)); //anam demanant valors a l'usuari
            byte numero = s.nextByte(); //assignam
            while (numero > 49 || numero < 0) { //si l'usuari introdueix un valor invalid, el tornarem demanar
                System.out.println("Introdueix un numero valid!"); 
                numero = s.nextByte();
            }
            taula[i] = numero; //ficam el valor a l'array
        }
        return taula;
    }

    public static void main(String[] args) {
        System.out.println("Benvingut al meu programa de la primitiva!");
        byte aposta[] = rellenarPrimitiva(); //omplim la nostra aposta 
        byte combGuanyadora[] = generarPrimitiva(); //generam una combinació guanyadora aleatoria 
        byte puntuacio = primitiva(aposta, combGuanyadora); //assignam la puntuacio amb la variable que ho compreva
        System.out.println("La teva puntuacio es " + puntuacio); //imprim a l'usuari
    }
}
