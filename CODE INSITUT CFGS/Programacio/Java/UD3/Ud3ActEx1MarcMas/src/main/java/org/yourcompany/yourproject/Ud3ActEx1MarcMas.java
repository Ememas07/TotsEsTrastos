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
public class Ud3ActEx1MarcMas {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Programa per imprimir un triangle rectangle amb altura per pantalla");
        System.out.println("Preparacio del triangle");
        System.out.println("Quina orientacio vols?");
        System.out.println("1 per punt cap abaix, 2 per punta cap amunt, 3 per part plana a la dreta, 4 per punta cap amunt i part plana a la dreta");
        Byte orientacio = s.nextByte();
        System.out.println("Tipus de triangle:");
        System.out.println("1 per triangle rectangle, 2 per triangle simetric cap avall, 3 per triangle simetric cap abaix");
        Byte tipusTriangle = s.nextByte();
        System.out.println("Variants Grafiques");
        System.out.println("1 per emprar asteriscs, 2 per emprar un degradat, 3 per emprar un caracter personalitzat, 4 per nomes el contorn");
        Byte grafics = s.nextByte();
        System.out.println("Quina altura vol?");
        Byte altura = s.nextByte(); //agafam altura per consola
        char rellenador = ' ';
        Integer buits = 0; //emprarem aquestes dues variables per saber quants de caracters hem d'imprimir de cada tipus (per els casos de alineació a la dreta)
        Integer caracters = 0;
        Integer amplada = 0;
        switch (grafics) {
            case 1: // asteriscs
                rellenador = '*';
                break;
            case 2: //degradat (TODO)
                rellenador = '*';
                break;
            case 3: //personalitzat
                System.out.println("Quin caracter vols emprar?");
                rellenador = s.next().charAt(0);
                break;
            case 4: //contorn (TODO)
                rellenador = '*';
                break;
            default:
                System.out.println("Input no valid");
        }
        switch (tipusTriangle) {
            case 1:
                switch (orientacio) {
                    case 1:
                        for (int i = altura; i > 0; i--) { //bucle 1 per definir la quantiat de pixels verticals
                            if (grafics == 2) {
                                switch (i) {
                                    case 1:
                                        rellenador = '.';
                                        break;
                                    case 2:
                                        rellenador = ':';
                                        break;
                                    case 3:
                                        rellenador = '-';
                                        break;
                                    case 4:
                                        rellenador = '=';
                                        break;
                                    case 5:
                                        rellenador = '+';
                                        break;
                                    case 6:
                                        rellenador = '*';
                                        break;
                                    case 7:
                                        rellenador = '#';
                                        break;
                                    case 8:
                                        rellenador = '%';
                                        break;
                                    case 9:
                                        rellenador = '@';
                                        break;
                                    default:
                                        rellenador = '*';
                                }
                            }
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
                            if (grafics == 2) {
                                switch (i) {
                                    case 1:
                                        rellenador = '.';
                                        break;
                                    case 2:
                                        rellenador = ':';
                                        break;
                                    case 3:
                                        rellenador = '-';
                                        break;
                                    case 4:
                                        rellenador = '=';
                                        break;
                                    case 5:
                                        rellenador = '+';
                                        break;
                                    case 6:
                                        rellenador = '*';
                                        break;
                                    case 7:
                                        rellenador = '#';
                                        break;
                                    case 8:
                                        rellenador = '%';
                                        break;
                                    case 9:
                                        rellenador = '@';
                                        break;
                                    default:
                                        rellenador = '*';
                                }
                            }
                            for (int a = i; a > 0; a--) { // bucle 2 per la horizontal, imprimeix en linea i agafa el valor del bucle anterior.
                                // per exemple, si tenim i = 4, en pinta 4, despres printa el bot de linea, se li resta 1 a "i", i torna a començar fins a 0
                                // tendrem i = 3, en pinta 3, després bot de linea, i aixi succesivament
                                System.out.print(rellenador);
                            }
                            System.out.println("");
                        }
                        break;
                    case 3:
                        for (int i = 0; i < altura; i++) { // bucle per iterar quantes vegades verticals necessitem
                            if (grafics == 2) {
                                switch (i) {
                                    case 1:
                                        rellenador = '.';
                                        break;
                                    case 2:
                                        rellenador = ':';
                                        break;
                                    case 3:
                                        rellenador = '-';
                                        break;
                                    case 4:
                                        rellenador = '=';
                                        break;
                                    case 5:
                                        rellenador = '+';
                                        break;
                                    case 6:
                                        rellenador = '*';
                                        break;
                                    case 7:
                                        rellenador = '#';
                                        break;
                                    case 8:
                                        rellenador = '%';
                                        break;
                                    case 9:
                                        rellenador = '@';
                                        break;
                                    default:
                                        rellenador = '*';
                                }
                            }
                            buits = i; //la variable de buits sera la variable "i" cada vegada
                            caracters = altura - i; //la variable de caracters sera l'altura - 1 (ja que i va pujant i altura no canvia)
                            //com funciona: si tenim la primera linea, tenim "10" l'altura ara mateix es 10, i volem fer 9 caracters i un buit
                            //per lo tant, volem que les variables per la  linea siguin "9 (caracters)" i "1 (buit)"
                            //9 caracters = l'altura menys i, ja que altura no canvia i "i" ja pujant
                            //1 buit = la variable i, ja que comença a 0 i va pujant
                            //un pic tenim les variables, feim un bucle que imprimirà, o un espai (per cada buit) o el caracter que volguem

                            for (; buits > 0; buits--) {
                                System.out.print(" ");
                            }
                            for (; caracters > 0; caracters--) {
                                System.out.print(rellenador);
                            }
                            System.out.println("");

                        }
                        break;
                    case 4:
                        for (int i = altura; i > 0; i--) { // bucle per iterar quantes vegades verticals necessitem
                            if (grafics == 2) {
                                switch (i) {
                                    case 1:
                                        rellenador = '.';
                                        break;
                                    case 2:
                                        rellenador = ':';
                                        break;
                                    case 3:
                                        rellenador = '-';
                                        break;
                                    case 4:
                                        rellenador = '=';
                                        break;
                                    case 5:
                                        rellenador = '+';
                                        break;
                                    case 6:
                                        rellenador = '*';
                                        break;
                                    case 7:
                                        rellenador = '#';
                                        break;
                                    case 8:
                                        rellenador = '%';
                                        break;
                                    case 9:
                                        rellenador = '@';
                                        break;
                                    default:
                                        rellenador = '*';
                                }
                            }
                            buits = i - 1; //la variable de buits sera la variable "i" cada vegada
                            caracters = altura - i + 1; //la variable de caracters sera l'altura - i +1
                            //com funciona: si tenim la primera linea, tenim "10" l'altura ara mateix es 10, i volem fer 9 buits i una estrella
                            //per lo tant, volem que les variables siguin "9" i "1"
                            //9 = l'altura menys 1, pero més envant volem que vagi baixant, aixi que agafarem "i" (ja que i anira decrementant)
                            //1 = si tenim, per exemple, 10 d'altura, i restam i (començaria a 0), però volem que sigui 1, aixi que sumarem 1
                            //un pic tenim les variables, feim un bucle que imprimirà, o un espai (per cada buit) o el caracter que volguem

                            for (; buits > 0; buits--) {
                                System.out.print(" ");
                            }
                            for (; caracters > 0; caracters--) {
                                System.out.print(rellenador);
                            }
                            System.out.println("");

                        }
                        break;
                    default:
                        System.out.println("Input no valid!");
                }
                break;
            case 2:
                for (int i = 0; i < altura; i++) { // bucle per iterar quantes vegades verticals necessitem
                    amplada = i;
                    buits = i; //la variable de buits sera la variable "i" cada vegada
                    caracters = altura - i; //la variable de caracters sera l'altura - 1 (ja que i va pujant i altura no canvia)
                    //com funciona: si tenim la primera linea, tenim "10" l'altura ara mateix es 10, i volem fer 9 caracters i un buit
                    //per lo tant, volem que les variables per la  linea siguin "9 (caracters)" i "1 (buit)"
                    //9 caracters = l'altura menys i, ja que altura no canvia i "i" ja pujant
                    //1 buit = la variable i, ja que comença a 0 i va pujant
                    //un pic tenim les variables, feim un bucle que imprimirà, o un espai (per cada buit) o el caracter que volguem

                    for (; buits > 0; buits--) {
                        System.out.print(" ");
                    }
                    for (; caracters > 0; caracters--) {
                        System.out.print(rellenador);
                    }
                    System.out.println("");

                }
                break;
            case 3:
                break;
            default:
                System.out.println("Input no valid!");
        }

    }
}
