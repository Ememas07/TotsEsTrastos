/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Llegir el fitxer de text Main.java de qualque projecte terminat i mostra-lo
 * per pantalla.
 *
 * @author Marc Mas
 */
public class Ud10Act2MarcMas {

    public static void main(String[] args) {
        try {
            FileReader fitxer = new FileReader(
                    "..\\Ud10Act1MarcMas\\src\\main\\java\\org\\yourcompany\\yourproject\\Ud10Act1MarcMas.java" //arxiu main.java de la ac10
            );
            int c; //declaram
            while ((c = fitxer.read()) != -1) { //llegim i assignam, si no es -1, imprimim
                System.out.print((char) c);
            }
            fitxer.close(); //tancam fitxer
        } catch (FileNotFoundException e) { 
            System.out.println("No s'ha trobat el fitxer!");
        } catch (IOException ex) {
            System.out.println("Error de IO!");
        }
    }
}
