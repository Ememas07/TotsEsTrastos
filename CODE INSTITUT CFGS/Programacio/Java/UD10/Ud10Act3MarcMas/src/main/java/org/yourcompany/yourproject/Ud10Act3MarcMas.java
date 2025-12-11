/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Copia l'activitat 10.2, però empra un flux de text amb buffer.
 *
 * @author Marc Mas
 */
public class Ud10Act3MarcMas {

    public static void main(String[] args) {
        try {
            BufferedReader fitxer = new BufferedReader(new FileReader(
                    "..\\Ud10Act2MarcMas\\src\\main\\java\\org\\yourcompany\\yourproject\\Ud10Act2MarcMas.java" //main.java de la act2
            ));
            String c; //inicialitzam la variable
            while ((c = fitxer.readLine()) != null) { //llegim linea, si no es null, imprimim
                System.out.println(c);
            }
            fitxer.close(); //tancam 
        } catch (FileNotFoundException e) {
            System.out.println("No s'ha trobat el fitxer!");
        } catch (IOException ex) {
            System.out.println("Error de IO!");
        }
    }
}
