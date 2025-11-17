/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

/**
 * Escriu la funció: int primitiva(int[] aposta, int[] combGuanyadora).
 *
 * La funció ha de tornar el nombre d’encerts (posicions iguals) entre les dues
 * taules
 *
 * @author Marc Mas
 */
public class Ud5Act6MarcMas {

    public static int primitiva(int[] aposta, int[] combGuanyadora) {
        int puntuacio = 0;
        for (int i = 0; i < aposta.length; i++) {
            if (aposta[i] == combGuanyadora[i]) {
                puntuacio++;
            }
        }

        return puntuacio;
    }

    public static int[] generarPrimitiva() {
        int taula[] = new int[6];
        for (int i = 0; i < taula.length; i++) {
            
        }

        return taula;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
