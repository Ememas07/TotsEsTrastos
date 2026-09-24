/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Guardam a un fitxer el següent text:
 *
 * Setze jutges d'un jutjat
 *
 * mengen fetge d'un penjat
 *
 * Escriu la primera línia caràcter a caràcter i la segona d'una sola vegada.
 *
 * @author Marc Mas
 */
public class Ud10Act7MarcMas {

    public static void main(String[] args) {
        try {
            String frase1 = "Setze jutges d'un jutjat";
            String frase2 = "mengen fetge d'un penjat";
            BufferedWriter sortida = new BufferedWriter(new FileWriter(
                    "src\\main\\java\\org\\yourcompany\\yourproject\\FitxerText.txt" //especificam el fitxer que volem llegir i emprarem un BufferedReader
            ));
            for (int i = 0; i < frase1.length(); i++) {
                sortida.write(frase1.charAt(i));
                sortida.newLine();
            }
            sortida.write(frase2);
            sortida.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Arxiu no trobat!");
        } catch (IOException e) {
            System.out.println("Error d'E/S!");
        }
    }
}
