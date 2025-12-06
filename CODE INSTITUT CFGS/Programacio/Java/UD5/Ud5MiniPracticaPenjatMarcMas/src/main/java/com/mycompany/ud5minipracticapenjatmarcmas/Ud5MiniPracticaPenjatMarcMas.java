/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ud5minipracticapenjatmarcmas;

import java.util.Arrays;
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
            case 3 -> {
                return l3;
            }
            case 4 -> {
                return l4;
            }
            case 5 -> {
                return l5;
            }
            case 6 -> {
                return l6;
            }
            case 7 -> {
                return l7;
            }
            case 8 -> {
                return l8;
            }
            case 9 -> {
                return l9;
            }
            case 10 -> {
                return l10;
            }
            default -> {
                System.out.println("Longitut no valida retornant llista de longitut 3!");
                return l3;
            }
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

    public static void menu(int[] opcions, String[] llistaJugadors, int[][] puntsJugadors, boolean sortir) {
        Scanner s = new Scanner(System.in);
        while (!sortir) {
            cls();
            puntsJugadors = canviarTaulaPunts(puntsJugadors, opcions[1]);
            imprimirMenu(opcions, llistaJugadors);
            int opcio = s.nextInt();
            while (opcio > 8 && opcio < 0) {
                System.out.println("Opcio invalida!");
            }
            if (opcions[0] == 0) {
                opcions[1] = 1;
            }
            switch (opcio) {
                case 0 -> {
                    System.out.println("Esta segur que vol sortir?");
                    System.out.println("introdueixi -1 si vol sortir");
                    int confirmarSortida = s.nextInt();
                    if (confirmarSortida == -1) {
                        sortir = true;
                    }
                }
                case 1 -> {
                    if (opcions[2] > 10 && opcions[2] < 3) {
                        System.out.println("La longitut no es valida per PvE! ");
                    } else {
                        sortir = true;
                        jugar(opcions, llistaJugadors, puntsJugadors);
                    }
                }
                case 2 -> {
                    System.out.println("Configurant Mode de joc");
                    System.out.println("0: PvE");
                    System.out.println("1: PvP");
                    opcions[0] = s.nextInt();
                }
                case 3 -> {
                    System.out.println("Configurant Nombre de jugadors");
                    opcions[1] = s.nextInt();
                    llistaJugadors = new String[opcions[1]];
                    for (int i = 0; i < opcions[1]; i++) {
                        llistaJugadors[i] = ("Jugador " + (i + 1));
                    }
                }
                case 4 -> {
                    System.out.println("Configurant longitut:");
                    System.out.println("Introdueixi la nova longitut");
                    opcions[2] = s.nextInt();
                }
                case 5 -> {
                    System.out.println("Configurant Majuscules");
                    System.out.println("0: No es sensible");
                    System.out.println("1: Es sensible");
                    opcions[3] = s.nextInt();
                }
                case 6 -> {
                    System.out.println("Configurant Dibuix");
                    System.out.println("0: Forca + Penjat");
                    System.out.println("1: Nomes Penjat");
                    opcions[4] = s.nextInt();
                }
                case 7 -> {
                    System.out.println("Configurant Llista d'errades");
                    System.out.println("0: No");
                    System.out.println("1: Si");
                    opcions[5] = s.nextInt();
                }
                case 8 -> {
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
                }
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
        int[] opcions = {1, 6, 4, 0, 0, 0}; //opcions per defecte
        String[] llistaJugadors = new String[opcions[1]];
        for (int i = 0; i < opcions[1]; i++) {
            llistaJugadors[i] = ("Jugador " + (i + 1));
        }
        int puntsJugadors[][] = new int[llistaJugadors.length][3];

        menu(opcions, llistaJugadors, puntsJugadors, false);
    }

    public static void jugar(int[] opcions, String[] nomJugadors, int[][] puntsJugadors) {
        Scanner s = new Scanner(System.in);
        System.out.println(opcions[1]);
        char[] lletresProvades = {};
        char[] lletresEncertades = {};
        int introdueixParaula = 0;
        int encerts = 0;
        int jugadorActual = -1;
        int index = 0;
        while (index < puntsJugadors.length && jugadorActual == -1) {
            if (puntsJugadors[index][2] > 1) { //miram si algun jugador té multiplicador, si hi ha algu que el tengui, el posam com a actual
                jugadorActual = index;
            }
            index++;
        }
        if (jugadorActual == -1) {
            jugadorActual = (int) (Math.random() * opcions[1]); //calculam jugador aleatori
        }
        String paraulaSecreta = "";
        if (opcions[0] == 0) { //jugam contra maquina
            String[] paraulesValides = llistaParaules(opcions[2]);
            paraulaSecreta = paraulesValides[(int) (Math.random() * paraulesValides.length)];
        } else { //jugam contra un altre jugador
            do {
                introdueixParaula = (int) (Math.random() * opcions[1]);
            } while (introdueixParaula == jugadorActual); //no volem que el jugador que posa la paraula sigui el primer a endivinar
            System.out.println(nomJugadors[introdueixParaula] + ", tria una paraula");
            System.out.println("Quina vol que sigui la paraula a endivinar?");
            paraulaSecreta = s.next();
            opcions[2] = paraulaSecreta.length();
            cls();
        }
        boolean perdut = false;
        int lletresRepetides = 0;
        do {
            System.out.println("Jugador Actual: " + nomJugadors[jugadorActual]);
            System.out.println("Introdueixi la seva lletra");
            char input = s.next().charAt(0);
            int ocurrences = comprovarParaula(input, paraulaSecreta, lletresProvades, lletresEncertades, puntsJugadors[jugadorActual]);
            encerts += ocurrences;
            if (ocurrences == 0) { //la paraula no surt cap vegada, no hem encertat
                puntsJugadors[jugadorActual][1] = 0; //hem fallat la lletra
                if (estaDinsArray(lletresProvades, input)) {
                    lletresRepetides++;
                } else {
                    lletresProvades = insertarValor(lletresProvades, input); //si no esta a l'array de lletres errades, l'afegim
                }
                int errades = lletresProvades.length + lletresRepetides;
                if (opcions[4] == 1) {
                    errades += 6;
                }
                if (errades >= 11) {
                    perdut = true;
                }
                dibuixar(errades);
                jugadorActual = girarJugadors(opcions[1], jugadorActual, introdueixParaula); //si ha fallat, giram el jugador
            } else {
                lletresEncertades = insertarValor(lletresEncertades, input); //si la lletra NO està a l'array de lletres encertades, l'afegim
            }
            // cas 0: lletra nova

            if (opcions[5] == 1) {
                imprimirArray(lletresProvades);
            }

            for (int i = 0; i < nomJugadors.length; i++) {
                if (i == jugadorActual) {
                    System.out.print(">");
                }
                System.out.println("Puntuacio: (" + nomJugadors[i] + "): " + puntsJugadors[i][0]);
            }
        } while (encerts != opcions[2] && !perdut);
        if (opcions[1] == 1) {
            if (perdut) {
                System.out.println("Has Perdut!");
            } else {
                System.out.println("Has guanyat!");
            }
        } else {
            if (perdut) {
                puntsJugadors[introdueixParaula][0] += paraulaSecreta.length();
                System.out.println("Ha guanyat el jugador que ha posat la paraula");
            } else {
                puntsJugadors[jugadorActual][2]++; //sumam multiplicador al jugador que ha endivinat la paraula
                System.out.println("Ha guanyat el jugador que endivinava");
            }
        }
        System.out.println("Que vol fer?");
        System.out.println("0: Tornar al menu");
        System.out.println("1: Jugar un altre vegada");
        System.out.println("2: Sortir");
        int opcio = s.nextInt();
        switch (opcio) {
            case 0 -> {
                menu(opcions, nomJugadors, puntsJugadors, false);
            }
            case 1 ->
                jugar(opcions, nomJugadors, puntsJugadors);
            case 2 -> {
                System.out.println("Segur que vol sortir? Introdueixi -1");
                int sortidaJugar = s.nextInt();
                if (sortidaJugar != -1) {
                    menu(opcions, nomJugadors, puntsJugadors, false);
                }
            }
        }
    }

    public static int girarJugadors(int numJugadors, int jugadorActual, int introdueixParaula) {
        if (numJugadors == 1) {
            return 0;
        }
        jugadorActual++;
        if (jugadorActual == introdueixParaula) {
            jugadorActual++;
        }
        if (jugadorActual >= numJugadors) {
            if (introdueixParaula == 0) {
                jugadorActual = 1;
            } else {
                jugadorActual = 0;
            }
        }
        return jugadorActual;
    }

    public static int[] actualitzarPunts(int[] punts, int ocurrences) {
        if (ocurrences > 0) {
            punts[0] += (ocurrences + punts[1]) * punts[2];
        } else if (ocurrences == 0) {
            punts[0] -= 1;
        } else {
            punts[0] -= 3;
        }
        System.out.println("Puntuació:");
        System.out.println("Encerts (lletra actual): " + ocurrences);
        System.out.println("Combo: " + punts[1]);
        System.out.println("Multiplicador: " + punts[2]);

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
        char[] taulaNova = Arrays.copyOf(taula, taula.length + 1);
        taulaNova[taulaNova.length - 1] = valor;
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
        for (String valor : taula) {
            System.out.println(valor);
        }
    }

    public static int[][] canviarTaulaPunts(int[][] arrayOriginal, int nombreJugadors) {
        int[][] taulaNova = new int[nombreJugadors][3];
        for (int i = 0; i < arrayOriginal.length && i < taulaNova.length; i++) {
            for (int j = 0; j < arrayOriginal[0].length && i < taulaNova[0].length; j++) {
                taulaNova[i][j] = arrayOriginal[i][j]; //copia de l'array original primer
            }
        }
        for (int i = 0; i < taulaNova.length; i++) {
            if (taulaNova[i][2] == 0) { //revisam que no hi hagui cap multiplicador a 0 a la nova taula, i si n'hi ha cap, el posam a 1
                taulaNova[i][2] = 1;
            }
        }
        return taulaNova;
    }

    public static int comprovarParaula(char input, String secreta, char[] lletresErrades, char[] lletresEncertades, int[] puntsJugadors) {
        int vegades = 0;
        boolean repetida = false;
        for (int i = 0; i < secreta.length(); i++) {
            if (secreta.charAt(i) == input) {
                if (!estaDinsArray(lletresEncertades, input)) {
                    lletresEncertades = insertarValor(lletresEncertades, input); //si la lletra NO està a l'array de lletres encertades, l'afegim
                }
                vegades++; //per cada lletra endivinada, sumam una vegada
            }
            if (estaDinsArray(lletresEncertades, secreta.charAt(i))) { //recorrem tot l'array de lletres encertades i les mostram
                System.out.print(secreta.charAt(i));
            } else {
                System.out.print("_");
                if (estaDinsArray(lletresErrades, input)) {
                    repetida = true;
                }
            }
        }
        System.out.println("");
        if (repetida) {
            puntsJugadors = actualitzarPunts(puntsJugadors, -1);
        } else {
            puntsJugadors = actualitzarPunts(puntsJugadors, vegades);
        }
        return vegades;
    }
}
