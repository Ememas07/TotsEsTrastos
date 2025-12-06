/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ud5minipracticapenjatmarcmas;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class Ud5MiniPracticaPenjatMarcMas {

    public static final String[] llistaParaules(int longitut) {
        // Length 3 
        String[] l3 = {"ram", "usb", "cpu", "app", "gui", "net", "api", "cli",
            "ide", "sql"};
// Length 4 
        String[] l4 = {"port", "disc", "byte", "node", "ping", "data", "font",
            "codi", "html", "java"};
// Length 5 
        String[] l5 = {"xarxa", "claus", "stack", "array", "token", "linux",
            "cache", "proxy", "input", "debug"};
// Length 6 
        String[] l6 = {"cursor", "driver", "script", "output", "kernel",
            "switch", "socket", "buffer", "plugin", "vector"};
// Length 7 
        String[] l7 = {"programa", "fitxer", "compres", "memoria", "servidor",
            "usuari", "control", "enllaç", "process", "dominis"};
// Length 8 
        String[] l8 = {"computar", "compilar", "variable", "protocol",
            "registre", "terminal", "software", "hardware", "emulador", "constant"};
// Length 9 
        String[] l9 = {"aplicatiu", "aplicacio", "ordenador", "interfici",
            "algorisme", "algoritme", "programar", "maquinari", "directori",
            "processar"};
// Length 10 
        String[] l10 = {"informatic", "compilador", "tecnologia", "computador",
            "programari", "configurar", "compilacio", "informacio", "programant",
            "interficie"};
        switch (longitut) {
            case 3:
                return l3;
            case 4:
                return l4;
            case 5:
                return l5;
            case 6:
                return l6;
            case 7:
                return l7;
            case 8:
                return l8;
            case 9:
                return l9;
            case 10:
                return l10;
            default:
                System.out.println("Longitut no valida retornant llista de longitut 3!");
                return l3;
        }
    }

    public static void cls() {
        for (int i = 0; i < 100; i++) { // imprimim 100 bots de linea per fer la pantalla neta
            System.out.println("");
        }
    }

    public static void imprimirTitol() {
        System.out.println("┌------------------------┐");
        System.out.println("|     JOC DEL PENJAT     |");
        System.out.println("└------------------------┘");
    }

    // public static void menu(boolean mode, int numJugadors, int longitut, boolean sensitiu, boolean dibuix, boolean llistaErrors, String[] llistaJugadors) {
    public static void menu(int[] opcions, String[] llistaJugadors) {
        Scanner s = new Scanner(System.in);
        boolean sortir = false;
        while (!sortir) {
            cls();
            imprimirMenu(opcions, llistaJugadors);
            int opcio = s.nextInt();
            while (opcio > 8 && opcio < 0) {
                System.out.println("Opcio invalida!");
            }
            if (opcions[0] == 1) {
                opcions[1] = 1;
            }
            switch (opcio) {
                case 0:
                    System.out.println("Esta segur que vol sortir?");
                    System.out.println("introdueixi -1 si vol sortir");
                    int confirmarSortida = s.nextInt();
                    if (confirmarSortida == -1) {
                        sortir = true;
                    }
                    break;
                case 1:
                    if (opcions[2] > 10 && opcions[2] < 3) {
                        System.out.println("La longitut no es valida per PvE! ");
                    } else {
                        jugar(opcions, llistaJugadors);
                    }
                    break;
                case 2:
                    System.out.println("Configurant Mode de joc");
                    System.out.println("0: PvE");
                    System.out.println("1: PvP");
                    opcions[0] = s.nextInt();
                    break;
                case 3:
                    System.out.println("Configurant Nombre de jugadors");
                    opcions[1] = s.nextInt();
                    llistaJugadors = new String[opcions[1]];
                    for (int i = 0; i < opcions[1]; i++) {
                        llistaJugadors[i] = ("Jugador " + i);
                    }
                    break;
                case 4:
                    System.out.println("Configurant longitut:");
                    System.out.println("Introdueixi la nova longitut");
                    opcions[2] = s.nextInt();
                    break;
                case 5:
                    System.out.println("Configurant Majuscules");
                    System.out.println("0: No es sensible");
                    System.out.println("1: Es sensible");
                    opcions[3] = s.nextInt();
                    break;
                case 6:
                    System.out.println("Configurant Dibuix");
                    System.out.println("0: Forca + Penjat");
                    System.out.println("1: Nomes Penjat");
                    opcions[4] = s.nextInt();
                    break;
                case 7:
                    System.out.println("Configurant Llista d'errades");
                    System.out.println("0: No");
                    System.out.println("1: Si");
                    opcions[5] = s.nextInt();
                    break;
                case 8:
                    System.out.println("Configurant Noms de jugadors");
                    if (opcions[1] < 1) {
                        System.out.println("Configura el numero de jugadors bé!");
                    } else {
                        for (int i = 0; i < opcions[1]; i++) {
                            System.out.println("Configurant: " + llistaJugadors[i]);
                            System.out.println("Vol canviar el nom?");
                            System.out.println("1 Per si, 0 per No");
                            int canviarNom = s.nextInt();
                            if (canviarNom == 1) {
                                System.out.println("Introdueix nou nom per: " + llistaJugadors[i]);
                                llistaJugadors[i] = s.next();
                            }
                        }
                    }
                    break;
            }
        }
    }

    public static void imprimirMenu(int[] opcions, String[] llistaJugadors) {
        imprimirTitol();
        System.out.println("1. Jugar");
        System.out.println("");
        System.out.println("Configuració actual:");
        System.out.print("2. Mode de joc:");
        if (opcions[0] == 0) { //PvE
            System.out.println("[Jugador contra la màquina]");
        } else {
            System.out.println("Jugador contra jugador");
            System.out.print("3. Numero de jugadors");
            System.out.println("[" + opcions[1] + "]");
        }
        System.out.print("4. Longitut de paraules");
        if (opcions[0] == 1) {
            System.out.println("[Mode PvP, no hi ha nombre de lletres!]");
        } else {
            System.out.println("[ " + opcions[2] + " lletres ]");
        }
        System.out.print("5. Majuscules / Minscules");
        if (opcions[3] == 1) {
            System.out.println("[Si]");
        } else {
            System.out.println("[No]");
        }
        System.out.print("6. Dibuix");
        if (opcions[4] == 1) {
            System.out.println("[Forca + Penjat]");
        } else {
            System.out.println("[Penjat]");
        }
        System.out.print("7. Llista d'errades: ");
        if (opcions[5] == 1) {
            System.out.println("[Si]");
        } else {
            System.out.println("[No]");
        }
        System.out.print("8. Noms dels jugadors: ");
        for (int i = 0; i < llistaJugadors.length - 1; i++) {
            System.out.print(llistaJugadors[i] + ", ");
        }
        System.out.println(llistaJugadors[llistaJugadors.length - 1]);
        System.out.println("");

        System.out.println("0. Sortir");

        System.out.println("");

        System.out.println("Seleccioni una opció:");

    }

    public static void main(String[] args) {

    }

}
