/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * Implementar una aplicació que simula el registre de les temperatures al llarg
 * d'un dia en una estació meteorològica. L'aplicació mostrarà un menú amb les
 * opcions:
 *
 * 1. Nou registre (que introduirem manualment, encara que se suposa que, al
 * sistema original, estaria controlat per un rellotge).
 *
 * 2. Llistar registres.
 *
 * 3. Mostrar estadística (amb els valors màxim, mínim i mitjana de les
 * temperatures registrades fins ara des de la primera lectura del dia).
 *
 * 4. Sortir.
 *
 * Cada registre constarà de la temperatura en graus centígrads i l'hora, que es
 * llegirà del sistema en el moment de la creació del registre.
 *
 * @author Marc Mas
 */
public class Ud11Act13MarcMas {

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.setOut(new PrintStream(System.out, true, "UTF8"));
        EstacioMeteorologica em = new EstacioMeteorologica();
        System.out.println("Benvingut a la meva aplicacio meteorologica");
        Scanner s = new Scanner(System.in); //cream un scanner per poder demanar a l'usuari coses per consola
        int opcio = 0;
        while (opcio > -1) { //si introduim un nombre negatiu, sortirem del bucle
            System.out.println("Opcions:");
            System.out.println("1: Nou registre");
            System.out.println("2: Veure registres");
            System.out.println("3: Estadistiques");
            System.out.println("-1: Sortir");
            opcio = s.nextInt(); //agafam opcio per consola
            switch (opcio) {
                case 1 -> {
                    em.nouRegistre(s);
                }
                case 2 -> {
                    em.llistarRegistres();
                }
                case 3 -> {
                    em.estadistiques();
                }
            }
        }
    }

}
