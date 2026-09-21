/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Escriu un programa que dupliqui el contingut d'un fitxer el nom del qual es
 * demani a l'usuari. El fitxer copia tindrà el mateix nom amb el prefix
 * “copia_de_”
 *
 * @author Marc Mas
 */
public class Ud10Act8MarcMas {

    public static void main(String[] args) {
        try {
            System.out.println("Programa per copiar un arxiu");
            System.out.println("L'arxiu es cercara a la mateixa carpeta on hi ha aquest .java");
            System.out.println("Introdueixi el nom de l'arxiu SENSE extensio");
            Scanner s = new Scanner(System.in);
            String nomArxiu = s.next();
            BufferedWriter sortida = new BufferedWriter(new FileWriter(
                    "src\\main\\java\\org\\yourcompany\\yourproject\\copia_de_" + nomArxiu + ".txt" //especificam el fitxer que volem llegir i emprarem un BufferedReader
            ));
            BufferedReader entrada = new BufferedReader(new FileReader(
                    "src\\main\\java\\org\\yourcompany\\yourproject\\" + nomArxiu + ".txt" //especificam el fitxer que volem llegir i emprarem un BufferedReader
            ));
            s = new Scanner(entrada);
            while (s.hasNextLine()) {
                sortida.write(s.nextLine());
            }
            sortida.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Arxiu no trobat!");
        } catch (IOException e) {
            System.out.println("Error d'E/S!");
        }
    }
}
