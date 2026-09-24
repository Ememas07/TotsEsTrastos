/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.text.Text;

/**
 * Dissenya la classe Text que gestiona una cadena de caracters amb algunes
 * característiques.
 *
 * La cadena de caracters tindrà una longitud màxima, especificada al
 * constructor.
 *
 * Permet afegir un caràcter al principi o al final, sempre que hi hagi espai.
 *
 * Permet afegir una cadena de text al principi o al final, sempre que hi hagi
 * espai.
 *
 * Es necessari saber quantes vocals, majúscules, minúscules o amb accents hi ha
 * al text.
 *
 * De cada objecte de tipus Text se n'ha de saber la data i hora de la creació,
 * així com data i hora de la darrera modificació
 *
 * Haurà d'existir un mètode que mostri la informació de l'objecte.
 *
 * @author Marc Mas
 */
public class Ud7Act7MarcMas {

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.setOut(new PrintStream(System.out, true, "UTF-8"));
        try {
            Scanner s = new Scanner(System.in);
            System.out.println("Longitut del text?");
            int longitut = s.nextInt();
            Text t = new Text(longitut);
            System.out.println("Quina operacio vol fer?");
            int opcio = 0;
            while (opcio > -1) { //-1 sortirà 
                t.mostrarText();
                System.out.println("1: Afegir al principi");
                System.out.println("2: Afegir al final");
                System.out.println("3: Mostrar informacio");
                System.out.println("-1: Sortir ");
                opcio = s.nextInt();
                switch (opcio) {
                    case 1 -> { //afegir principi
                        System.out.println("Insertar al principi");
                        System.out.println("1: Caracter");
                        System.out.println("2: Cadena");
                        int opcio2 = s.nextInt();
                        if (opcio2 == 1) {
                            System.out.println("Quin caracter vol afegir?");
                            char c = s.next().charAt(0);
                            t.afegirPrincipi(c);
                        } else {
                            System.out.println("Quina cadena vol afegir?");
                            String cadena = s.next() + s.nextLine();
                            t.afegirPrincipi(cadena);
                        }
                    }
                    case 2 -> { //afegir al final
                        System.out.println("Insertar al final");
                        System.out.println("1: Caracter");
                        System.out.println("2: Cadena");
                        int opcio2 = s.nextInt(); //triam l'opció que volem fer
                        if (opcio2 == 1) {
                            System.out.println("Quin caracter vol afegir?");
                            char c = s.next().charAt(0);
                            t.afegirFinal(c);
                        } else {
                            System.out.println("Quina cadena vol afegir?");
                            String cadena = s.next() + s.nextLine();
                            t.afegirFinal(cadena);
                        }
                    }
                    case 3 -> { //mostrar informacio
                        t.mostrarInformacio();
                    }
                }

            }
        } catch (InputMismatchException e) {
            System.out.println("Introdueix un valor valid!");
        }
    }
}
