/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class Ud5MiniPracticaPenjatMarcMasAntic {

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

    public static void imprimirMenu(boolean mode, int numJugadors, int longitut, boolean sensitiu, boolean dibuix, boolean llistaErrors, String[] llistaJugadors) {
        imprimirTitol();
        System.out.println("1. Jugar");
        System.out.println("");
        System.out.println("Configuració actual:");
        System.out.print("2. Mode de joc:");
        if (!mode) { //PvE
            System.out.println("[Jugador contra la màquina]");
        } else {
            System.out.println("Jugador contra jugador");
            System.out.print("3. Numero de jugadors");
            System.out.println("[" + numJugadors + "]");
        }
        System.out.print("4. Longitut de paraules");
        if (mode) {
            System.out.println("[Mode PvP, no hi ha nombre de lletres!]");
        } else {
            System.out.println("[ " + longitut + " lletres ]");
        }
        System.out.print("5. Majuscules / Minscules");
        if (sensitiu) {
            System.out.println("[Si]");
        } else {
            System.out.println("[No]");
        }
        System.out.print("6. Dibuix");
        if (!dibuix) {
            System.out.println("[Forca + Penjat]");
        } else {
            System.out.println("[Penjat]");
        }
        System.out.print("7. Llista d'errades: ");
        if (llistaErrors) {
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
        boolean mode = false;
        int numJugadors = 2;
        int longitut = 4;
        boolean sensitiu = false;
        boolean dibuix = false;
        boolean llistaErrors = false;
        String[] llistaJugadors = new String[numJugadors];
        for (int i = 0; i < numJugadors; i++) {
            llistaJugadors[i] = ("Jugador " + (i + 1));
        }
        menu(mode, numJugadors, longitut, sensitiu, dibuix, llistaErrors, llistaJugadors);
    }

    public static void menu(boolean mode, int numJugadors, int longitut, boolean sensitiu, boolean dibuix, boolean llistaErrors, String[] llistaJugadors) {
        Scanner s = new Scanner(System.in);
        boolean sortir = false;
        while (!sortir) {
            cls();
            imprimirMenu(mode, numJugadors, longitut, sensitiu, dibuix, llistaErrors, llistaJugadors);
            int opcio = s.nextInt();
            while (opcio > 8 && opcio < 0) {
                System.out.println("Opcio invalida!");
            }
            if (mode) {
                numJugadors = 1;
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
                    if (longitut > 10 && longitut < 3) {
                        System.out.println("La longitut no es valida per PvE! ");
                    } else {
                        jugar(mode, numJugadors, longitut, sensitiu, dibuix, llistaErrors, llistaJugadors);
                    }
                    break;
                case 2:
                    mode = !mode;
                    break;
                case 3:
                    System.out.println("Configurant Nombre de jugadors");
                    numJugadors = s.nextInt();
                    llistaJugadors = new String[numJugadors];
                    for (int i = 0; i < numJugadors; i++) {
                        llistaJugadors[i] = ("Jugador " + i);
                    }
                    break;
                case 4:
                    System.out.println("Configurant longitut:");
                    System.out.println("Introdueixi la nova longitut");
                    longitut = s.nextInt();
                    break;
                case 5:
                    sensitiu = !sensitiu;
                    break;
                case 6:
                    dibuix = !dibuix;
                    break;
                case 7:
                    llistaErrors = !llistaErrors;
                    break;
                case 8:
                    System.out.println("Configurant Noms de jugadors");
                    if (numJugadors < 1) {
                        System.out.println("Configura el numero de jugadors bé!");
                    } else {
                        for (int i = 0; i < numJugadors; i++) {
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

    public static void jugar(boolean mode, int numJugadors, int longitut, boolean sensitiu, boolean dibuix, boolean llistaErrors, String[] nomJugadors) {
        Scanner s = new Scanner(System.in);
        System.out.println(numJugadors);
        char[] lletresProvades = {};
        char[] lletresEncertades = {};
        int jugadorPrincipal = 0;
        int encerts = 0;
        String paraulaSecreta = "";
        int[] punts = new int[0];
        int combo[] = new int[0];
        if (!mode) { //jugam contra maquina
            String[] paraulesValides = llistaParaules(longitut);
            paraulaSecreta = paraulesValides[(int) (Math.random() * paraulesValides.length)];
            punts = new int[1];
            combo = new int[1];
        } else { //jugam contra un altre jugador
            jugadorPrincipal = (int) (Math.random() * nomJugadors.length);
            System.out.println(nomJugadors[jugadorPrincipal] + ", tria una paraula");
            System.out.println("Quina vol que sigui la paraula a endivinar?");
            paraulaSecreta = s.next();
            longitut = paraulaSecreta.length();
            cls();
            punts = new int[numJugadors];
            combo = new int[numJugadors];
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
            int encertsAbans = encerts;
            encerts = comprovarParaula(input, paraulaSecreta, dibuix, llistaErrors, lletresProvades, lletresEncertades, encerts);
            int ocurrences = encerts - encertsAbans;
            if (encertsAbans == encerts) {
                combo[jugadorActual] = 0; //hem fallat la lletra
                if (estaDinsArray(lletresProvades, input)) {
                    punts[jugadorActual] = actualitzarPunts(punts[jugadorActual], 2, combo[jugadorActual], 1, 0); //cas 2: lletra repetida
                    lletresRepetides++;
                } else {
                    lletresProvades = insertarValor(lletresProvades, input);
                    punts[jugadorActual] = actualitzarPunts(punts[jugadorActual], 1, combo[jugadorActual], 1, 0); //cas 1: lletra nova
                }
                if (dibuix) {
                    if ((lletresProvades.length + lletresRepetides) >= 4) {
                        perdut = true;
                    } else {
                        dibuixar((lletresProvades.length + lletresRepetides) + 7);
                    }
                } else {
                    if ((lletresProvades.length + lletresRepetides) >= 11) {
                        perdut = true;
                    } else {
                        dibuixar(lletresProvades.length + lletresRepetides);
                    }
                }
            } else if (!estaDinsArray(lletresEncertades, input)) {
                combo[jugadorActual]++;
                punts[jugadorActual] = actualitzarPunts(punts[jugadorActual], 0, combo[jugadorActual], 1, ocurrences); //cas 0: lletra encertada
                lletresEncertades = insertarValor(lletresEncertades, input);
            }
            if (llistaErrors) {
                imprimirArray(lletresProvades);
            }
            System.out.println("Puntuacio: (" + nomJugadors[jugadorActual] + "): " + punts[jugadorActual]);
            /*if (jugadorActual == nomJugadors.length) {
                jugadorActual = -1;
            }
             jugadorActual++; */

        } while (encerts != longitut && !perdut);
        if (numJugadors == 1) {
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
                jugar(mode, numJugadors, longitut, sensitiu, dibuix, llistaErrors, nomJugadors);
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

    public static int comprovarParaula(char input, String secreta, boolean tipusDibuix, boolean llistaErrors, char[] lletresErrades, char[] lletresEncertades, int encerts
    ) {
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
        while (vegades > 0) {
            encerts++;
            vegades--;
        }
        System.out.println("");

        return encerts;
    }
}
