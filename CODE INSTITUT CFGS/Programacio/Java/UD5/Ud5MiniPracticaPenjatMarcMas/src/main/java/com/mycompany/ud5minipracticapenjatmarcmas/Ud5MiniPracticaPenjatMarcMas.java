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
        int[] opcions = {0, 1, 4, 0, 0, 0};
        String[] llistaJugadors = new String[opcions[1]];
        for (int i = 0; i < opcions[1]; i++) {
            llistaJugadors[i] = ("Jugador " + (i + 1));
        }
        menu(opcions, llistaJugadors);
    }

    // public static void menu(boolean mode, int numJugadors, int longitut, boolean sensitiu, boolean dibuix, boolean llistaErrors, String[] llistaJugadors) {
    //     Scanner s = new Scanner(System.in);
    //     boolean sortir = false;
    //     while (!sortir) {
    //         cls();
    //         imprimirMenu(mode, numJugadors, longitut, sensitiu, dibuix, llistaErrors, llistaJugadors);
    //         int opcio = s.nextInt();
    //         while (opcio > 8 && opcio < 0) {
    //             System.out.println("Opcio invalida!");
    //         }
    //         if (mode) {
    //             numJugadors = 1;
    //         }
    //         switch (opcio) {
    //             case 0:
    //                 System.out.println("Esta segur que vol sortir?");
    //                 System.out.println("introdueixi -1 si vol sortir");
    //                 int confirmarSortida = s.nextInt();
    //                 if (confirmarSortida == -1) {
    //                     sortir = true;
    //                 }
    //                 break;
    //             case 1:
    //                 if (longitut > 10 && longitut < 3) {
    //                     System.out.println("La longitut no es valida per PvE! ");
    //                 } else {
    //                     jugar(mode, numJugadors, longitut, sensitiu, dibuix, llistaErrors, llistaJugadors);
    //                 }
    //                 break;
    //             case 2:
    //                 mode = !mode;
    //                 break;
    //             case 3:
    //                 System.out.println("Configurant Nombre de jugadors");
    //                 numJugadors = s.nextInt();
    //                 llistaJugadors = new String[numJugadors];
    //                 for (int i = 0; i < numJugadors; i++) {
    //                     llistaJugadors[i] = ("Jugador " + i);
    //                 }
    //                 break;
    //             case 4:
    //                 System.out.println("Configurant longitut:");
    //                 System.out.println("Introdueixi la nova longitut");
    //                 longitut = s.nextInt();
    //                 break;
    //             case 5:
    //                 sensitiu = !sensitiu;
    //                 break;
    //             case 6:
    //                 dibuix = !dibuix;
    //                 break;
    //             case 7:
    //                 llistaErrors = !llistaErrors;
    //                 break;
    //             case 8:
    //                 System.out.println("Configurant Noms de jugadors");
    //                 if (numJugadors < 1) {
    //                     System.out.println("Configura el numero de jugadors bé!");
    //                 } else {
    //                     for (int i = 0; i < numJugadors; i++) {
    //                         System.out.println("Configurant: " + llistaJugadors[i]);
    //                         System.out.println("Vol canviar el nom?");
    //                         System.out.println("1 Per si, 0 per No");
    //                         int canviarNom = s.nextInt();
    //                         if (canviarNom == 1) {
    //                             System.out.println("Introdueix nou nom per: " + llistaJugadors[i]);
    //                             llistaJugadors[i] = s.next();
    //                         }
    //                     }
    //                 }
    //                 break;
    //         }
    //     }
    // }
    public static void jugar(int[] opcions, String[] nomJugadors) {
        Scanner s = new Scanner(System.in);
        System.out.println(opcions[1]);
        char[] lletresProvades = {};
        char[] lletresEncertades = {};
        int jugadorPrincipal = 0;
        int encerts = 0;
        String paraulaSecreta = "";
        int[] punts = new int[0];
        int combo[] = new int[0];
        if (opcions[0] == 0) { //jugam contra maquina
            String[] paraulesValides = llistaParaules(opcions[2]);
            paraulaSecreta = paraulesValides[(int) (Math.random() * paraulesValides.length)];
            punts = new int[1];
            combo = new int[1];
        } else { //jugam contra un altre jugador
            jugadorPrincipal = (int) (Math.random() * nomJugadors.length);
            System.out.println(nomJugadors[jugadorPrincipal] + ", tria una paraula");
            System.out.println("Quina vol que sigui la paraula a endivinar?");
            paraulaSecreta = s.next();
            opcions[2] = paraulaSecreta.length();
            cls();
            punts = new int[opcions[1]];
            combo = new int[opcions[1]];
        }
        boolean perdut = false;
        int lletresRepetides = 0;
        int jugadorActual = 0;
        do {
            /*
            if (numJugadors > 1) {
                if (jugadorActual == jugadorPrincipal) {
                    jugadorActual++;
                }
                if (jugadorActual == nomJugadors.length) {
                    jugadorActual = -1;
                }
                jugadorActual++;
                //logica per girar jugadors aniria aqui, inacabat
            } */
            System.out.println("Jugador Actual: " + nomJugadors[jugadorActual]);
            System.out.println("Introdueixi la seva lletra");
            char input = s.next().charAt(0);
            int ocurrences = comprovarParaula(input, paraulaSecreta, lletresProvades, lletresEncertades);
            encerts += ocurrences;
            int casPuntuacio = 0;
            if (ocurrences == 0) { //la paraula no surt cap vegada, no hem encertat
                combo[jugadorActual] = 0; //hem fallat la lletra
                if (estaDinsArray(lletresProvades, input)) {
                    casPuntuacio = 2; //cas 2: lletra repetida
                    lletresRepetides++;
                } else {
                    casPuntuacio = 1; //cas 1: lletra no repeteida
                    lletresProvades = insertarValor(lletresProvades, input);
                }
                int errades = lletresProvades.length + lletresRepetides;
                if (opcions[4] == 1) {
                    errades += 6;
                }
                if (errades >= 11) {
                    perdut = true;
                }
                dibuixar(errades);
            } else if (!estaDinsArray(lletresEncertades, input)) {
                combo[jugadorActual]++;
                lletresEncertades = insertarValor(lletresEncertades, input);
            }
            // cas 0: lletra nova
            punts[jugadorActual] = actualitzarPunts(punts[jugadorActual], casPuntuacio, combo[jugadorActual], 1, ocurrences);
            if (opcions[5] == 1) {
                imprimirArray(lletresProvades);
            }
            System.out.println("Puntuacio: (" + nomJugadors[jugadorActual] + "): " + punts[jugadorActual]);
            /*if (jugadorActual == nomJugadors.length) {
                jugadorActual = -1;
            }
             jugadorActual++; */

        } while (encerts != opcions[2] && !perdut);
        if (opcions[1] == 1) {
            if (perdut) {
                System.out.println("Has Perdut!");
            } else {
                System.out.println("Has guanyat!");
            }
        } else {
            if (perdut) {
                System.out.println("Ha guanyat el jugador que ha posat la paraula");
            } else {
                System.out.println("Ha guanyat el jugador que endivinava");
            }
        }
        System.out.println("Que vol fer?");
        System.out.println("0: Tornar al menu");
        System.out.println("1: Jugar un altre vegada");
        System.out.println("2: Sortir");
        int opcio = s.nextInt();
        switch (opcio) {
            case 1:
                jugar(opcions, nomJugadors);
                break;
        }
    }

    public static int actualitzarPunts(int punts, int cas, int combo, int multiplicador, int ocurrences) {
        switch (cas) {
            case 0:
                punts += (ocurrences + combo) * multiplicador;
                break;
            case 1:
                punts -= 1;
                break;
            case 2:
                punts -= 3;
                break;
        }
        return punts;
    }

    public static void dibuixar(int passa) {
        String[] partsDibuix = new String[7];
        partsDibuix[6] = "┌-┬-┐";
        partsDibuix[5] = "|/";
        partsDibuix[4] = "| ";
        partsDibuix[3] = "| ";
        partsDibuix[2] = "| ";
        partsDibuix[1] = "|\\";
        partsDibuix[0] = "└-┴----";
        if (passa > 7) {
            partsDibuix[5] = "|/  |";
            if (passa > 8) {
                partsDibuix[4] = "|   O";
                if (passa > 9) {
                    partsDibuix[3] = "|  /|\\";
                    if (passa > 10) {
                        partsDibuix[2] = "|  / \\";
                    }
                }
            }
        }
        System.out.println("");
        if (passa > 7) {
            passa = 7;
        }
        for (int i = passa; i > 0; i--) {
            System.out.println(partsDibuix[i - 1]);
        }

    }

    public static char[] insertarValor(char[] taula, char valor) {
        char[] taulaNova = new char[taula.length + 1];
        for (int i = 0; i < taula.length; i++) {
            taulaNova[i] = taula[i];
        }
        taulaNova[taulaNova.length - 1] = valor;
        return taulaNova;
    }

    public static char[] copiarArray(char[] taula) {
        char[] taulaNova = new char[taula.length];
        for (int i = 0; i < taula.length; i++) {
            taulaNova[i] = taula[i];
        }
        return taulaNova;
    }

    public static boolean estaDinsArray(char[] taula, char input) {
        for (int i = 0; i < taula.length; i++) {
            if (taula[i] == input) {
                return true;
            }
        }
        return false;
    }

    public static void imprimirArray(char[] taula) {
        for (int i = 0; i < taula.length; i++) {
            System.out.print(taula[i] + ", ");
        }
    }

    public static void imprimirArray(String[] taula) {
        for (int i = 0; i < taula.length; i++) {
            System.out.println(taula[i]);
        }
    }

    public static int comprovarParaula(char input, String secreta, char[] lletresErrades, char[] lletresEncertades) {
        int vegades = 0;
        for (int i = 0; i < secreta.length(); i++) { //recorrem el input i la taula d'encerts i el comprovam contra cada posicio de la paraula secrta
            if (!estaDinsArray(lletresEncertades, input)) {
                if (estaDinsArray(lletresEncertades, secreta.charAt(i)) || input == secreta.charAt(i)) {
                    if (input == secreta.charAt(i)) {
                        vegades++;
                    }
                    System.out.print(secreta.charAt(i));
                } else {
                    System.out.print("_");
                }
            }
        }
        System.out.println("");

        return vegades;
    }
}
