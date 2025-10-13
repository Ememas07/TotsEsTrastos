/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 *
 * Partint de l’Activitat 3.10:
 *
 *
 * Orientació:
 *
 * Pinta el triangle amb la punta cap amunt.
 *
 * Pinta el triangle amb la part plana cap a la dreta.
 *
 * Pinta el triangle amb la punta cap amunt i la part plana a la dreta.
 *
 * Triangle simètric o isòsceles:
 *
 * En lloc de triangles amb un costat recte (rectangle) fes que la punta sigui
 * simètrica al mig (isòsceles).
 *
 * Pinta el triangle simètric cap amunt.
 *
 * Variants gràfiques:
 *
 * Fes que cada línia del triangle tingui un caràcter diferent (ex: *, +, -, .)
 * per simular un degradat visual.
 *
 * Permet que l’usuari triï quin caràcter vol utilitzar per dibuixar el triangle
 * (ex: *, #, @, etc.).
 *
 * Dibuixa només el contorn del triangle (sense omplir-lo), com si fos una
 * silueta.
 *
 * Menú:
 *
 * Deixa que l’usuari triï el tipus (rectangle o isòsceles), orientació del
 * triangle (esquerra, dreta, adalt, abaix) i gràfics del triangle (degradat,
 * caràcter, contorn, etc.).
 *
 *
 */
public class Ud3ActExtra1MarcMas {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Programa per imprimir un triangle rectangle amb altura per pantalla");
        System.out.println("Preparacio del triangle");
        System.out.println("Quina orientacio vols?");
        System.out.println("1 per punt cap abaix, 2 per punta cap amunt, 3 per part plana a la dreta, 4 per punta cap amunt i part plana a la dreta");
        Byte orientacio = s.nextByte();
        System.out.println("Tipus de triangle:");
        System.out.println("1 per triangle rectangle, 2 per triangle simetric, 3 per triangle isosceles");
        Byte tipusTriangle = s.nextByte();
        System.out.println("Variants Grafiques");
        System.out.println("1 per emprar asteriscs, 2 per emprar un degradat, 3 per emprar un caracter personalitzat, 4 per nomes el contorn");
        Byte grafics = s.nextByte();
        System.out.println("Quina altura vol?");
        Byte altura = s.nextByte(); //agafam altura per consola
        char rellenador = ' ';
        switch (grafics) {
            case 1:
                rellenador = '*';
                break;
            case 2:
                rellenador = '*';
                break;
            case 3:
                System.out.println("Quin caracter vols emprar?");
                rellenador = s.next().charAt(0);
            case 4:
                rellenador = '*';
            default:
                throw new AssertionError();
        }
        switch (orientacio) {
            case 1:
                for (int i = altura; i > 0; i--) { //bucle 1 per definir la quantiat de pixels verticals
                    for (int a = i; a > 0; a--) { // bucle 2 per la horizontal, imprimeix en linea i agafa el valor del bucle anterior.
                        // per exemple, si tenim i = 4, en pinta 4, despres printa el bot de linea, se li resta 1 a "i", i torna a començar fins a 0
                        // tendrem i = 3, en pinta 3, després bot de linea, i aixi succesivament
                        System.out.print(rellenador);
                    }
                    System.out.println("");
                }
                break;
            case 2:
                for (int i = 0; i < altura; i++) { //bucle 1 per definir la quantiat de pixels verticals
                    for (int a = i; a > 0; a--) { // bucle 2 per la horizontal, imprimeix en linea i agafa el valor del bucle anterior.
                        // per exemple, si tenim i = 4, en pinta 4, despres printa el bot de linea, se li resta 1 a "i", i torna a començar fins a 0
                        // tendrem i = 3, en pinta 3, després bot de linea, i aixi succesivament
                        System.out.print(rellenador);
                    }
                    System.out.println("");
                }
                break;
            case 3:

                break;
            case 4:

                break;
            default:
                throw new AssertionError();
        }

    }
}
