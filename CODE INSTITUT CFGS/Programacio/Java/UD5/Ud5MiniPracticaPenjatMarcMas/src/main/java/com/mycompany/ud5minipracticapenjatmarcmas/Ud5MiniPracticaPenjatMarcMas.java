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

    public static void imprimirMenu(int mode, int numJugadors, int longitut, int sensitiu, int dibuix, int llistaErrors, String[] llistaJugadors) {
        imprimirTitol();
        System.out.println("1. Jugar");
        System.out.println("");
        System.out.println("Configuració actual:");
        System.out.print("2. Mode de joc:");
        if (mode == 0) { //PvE
            System.out.println("[Jugador contra la màquina]");
        } else {
            System.out.println("Jugador contra jugador");
            System.out.print("3. Numero de jugadors");
            System.out.println("[" + numJugadors + "]");
        }
        System.out.print("4. Longitut de paraules");
        if (mode == 1) {
            System.out.println("[Mode PvP, no hi ha nombre de lletres!]");
        } else {
            System.out.println("[ " + longitut + " lletres ]");
        }
        System.out.print("5. Majuscules / Minscules");
        if (sensitiu == 1) {
            System.out.println("[Si]");
        } else {
            System.out.println("[No]");
        }
        System.out.print("6. Dibuix");
        if (dibuix == 0) {
            System.out.println("[Forca + Penjat]");
        } else {
            System.out.println("[Penjat]");
        }
        System.out.print("7. Llista d'errades: ");
        if (llistaErrors == 1) {
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
        int mode = 0;
        int numJugadors = 2;
        int longitut = 4;
        int sensitiu = 0;
        int dibuix = 0;
        int llistaErrors = 0;
        String[] llistaJugadors = new String[numJugadors];
        for (int i = 0; i < numJugadors; i++) {
            llistaJugadors[i] = ("Jugador " + (i + 1));
        }
        menu(mode, numJugadors, longitut, sensitiu, dibuix, llistaErrors, llistaJugadors);
    }

    public static void menu(int mode, int numJugadors, int longitut, int sensitiu, int dibuix, int llistaErrors, String[] llistaJugadors) {
        Scanner s = new Scanner(System.in);
        boolean sortir = false;
        while (!sortir) {
            cls();
            imprimirMenu(mode, numJugadors, longitut, sensitiu, dibuix, llistaErrors, llistaJugadors);
            int opcio = s.nextInt();
            while (opcio > 8 && opcio < 0) {
                System.out.println("Opcio invalida!");
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
                    System.out.println("Configurant Mode de joc");
                    System.out.println("0: PvE");
                    System.out.println("1: PvP");
                    mode = s.nextInt();
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
                    System.out.println("Configurant Majuscules");
                    System.out.println("0: No es sensible");
                    System.out.println("1: Es sensible");
                    sensitiu = s.nextInt();
                    break;
                case 6:
                    System.out.println("Configurant Dibuix");
                    System.out.println("0: Forca + Penjat");
                    System.out.println("1: Nomes Penjat");
                    dibuix = s.nextInt();
                    break;
                case 7:
                    System.out.println("Configurant Llista d'errades");
                    System.out.println("0: No");
                    System.out.println("1: Si");
                    llistaErrors = s.nextInt();
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

    public static void jugar(int numJugadors, int longitut, int sensitiu, int dibuix, int llistaErrors, String[] nomJugadors) {
        Scanner s = new Scanner(System.in);
        char[] lletresProvades = {};
        char[] lletresEncertades = {};
        int encerts = 0;
        String paraulaSecreta = "";
        if (numJugadors == 0) { //jugam contra maquina
            String[] paraulesValides = llistaParaules(longitut);
            paraulaSecreta = paraulesValides[(int) (Math.random() * paraulesValides.length)];
        } else { //jugam contra un altre jugador
            System.out.println("Quina vol que sigui la paraula a endivinar?");
            paraulaSecreta = s.next();
            longitut = paraulaSecreta.length();
            cls();
        }
        do {
            System.out.println("Introdueixi la seva lletra");
            char input = s.next().charAt(0);
            int encertsAbans = encerts;
            encerts = comprovarParaula(input, paraulaSecreta, dibuix, llistaErrors, lletresProvades, lletresEncertades, encerts);
            if (encertsAbans == encerts && !estaDinsArray(lletresProvades, input)) {
                lletresProvades = insertarValor(lletresProvades, input);
                if (dibuix == 1) {
                    dibuixar(lletresProvades.length + 5);
                } else {
                    dibuixar(lletresProvades.length);
                }
            } else if (!estaDinsArray(lletresEncertades, input)) {
                lletresEncertades = insertarValor(lletresEncertades, input);
            }
            if (llistaErrors == 1) {
                imprimirArray(lletresProvades);
            }
        } while (encerts != longitut);
        System.out.println("Has guanyat!");
        System.out.println("Introdueix un caracter per seguir jugant");
        s.next();
    }

    public static void dibuixar(int passa) {
        String[] partsDibuix = new String[7];
        partsDibuix[0] = "└----┴-";
        partsDibuix[1] = "|\\";
        partsDibuix[6] = "┌-┬-┐";
        partsDibuix[5] = "|/";
        partsDibuix[2] = "| ";
        partsDibuix[3] = "| ";
        partsDibuix[4] = "| ";
        if (passa > 5) {
            partsDibuix[5] = "|/  |";
            if (passa > 6) {
                partsDibuix[4] = "|   O";
                if (passa > 7) {
                    partsDibuix[3] = "|  /|\\";
                    if (passa > 8) {
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

    public static int comprovarParaula(char input, String secreta, int tipusDibuix, int llistaErrors, char[] lletresErrades, char[] lletresEncertades, int encerts
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

    public static void jugar(int mode, int numJugadors, int longitut, int sensitiu, int dibuix, int llistaErrors, String[] nomJugadors) {
        Scanner s = new Scanner(System.in);
        if (mode == 0) {
            numJugadors = 0;
        }
        jugar(numJugadors, longitut, sensitiu, dibuix, llistaErrors, nomJugadors);
    }
}
