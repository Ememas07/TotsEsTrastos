/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Boromir
 * 
 * Nota: 1
 */
public class Ud1a4ProvaPractica2MODMarcMas {

    // public static float descompteEdat(int anyNaixement, int any, int descompte) { // ORIGINAL
    public static float descompteEdat(int anyNaixement, int any) { // MODIFICAT
        /* 
        1: Falta el return
        2: descompte es un float, no un int (descompte = 1.00, etc) 
        3: a cada declaracio de descompte, falta la "f" de float
        4: passam el parametre de descompte i no es necessari
         */
        float descompte = 0.0f;
        if (any - anyNaixement <= 3) {
            System.out.println("100% descompte");
            descompte = 1.00f;
        } else if (any - anyNaixement >= 4 && any - anyNaixement <= 7) {
            System.out.println("75% descompte");
            descompte = 0.75f;
        } else if (any - anyNaixement >= 8 && any - anyNaixement <= 15) {
            System.out.println("50% descompte");
            descompte = 0.5f;
        } else if (any - anyNaixement >= 16 && any - anyNaixement <= 29) {
            System.out.println("25% descompte");
            descompte = 0.25f;
        } else if (any - anyNaixement >= 30 && any - anyNaixement <= 64) {
            System.out.println("sense descompte");
            descompte = 0.0f;
        } else if (any - anyNaixement > 0) {
            System.out.println("Valor erroni");
        } else {
            System.out.println("65% descompte");
            descompte = 0.65f;
        }
        return descompte;
    }

    // MODIFICACIONS:
    /*
    1: void -> boolean, verificarem les dades de any i diaSetmana, si una de les dues es incorrecte: false
    2: afegir un return false al if de l'any, el default del switch, i return true al final
     */
    public static boolean validacioDades(int any, int diaSetmana) {
        if (any < 1980 || any > 3000) { //Validació any <- aquest comentari estava a l'examen
            System.out.println("Introdueix un any coherent (entre 1980 i 3000)");
            return false;
        }
        switch (diaSetmana) {
            case 1 -> {
                System.out.println("Avui es dilluns");
            }
            case 2 -> {
                System.out.println("Avui es dimarts");
            }
            case 3 -> {
                System.out.println("Dimecres");
            }
            case 4 -> {
                System.out.println("Dijous");
            }
            case 5 -> {
                System.out.println("Divendres");
            }
            case 6 -> {
                System.out.println("Dissabte");
            }
            case 7 -> {
                System.out.println("Diumenge");
            }
            default -> {
                System.out.println("Introdueix un dia de la setmana correcte (1-7)");
                return false;
            }
        }
        return true;
    }

    // public static void tipusButaca(int butaca, int butacaTotal) { // ORIGINAL
    public static void tipusButaca(int butaca, int butacaTotal, int butacaNormal, int butacaVIP) { // MODIFICAT: faltaven els parametres de butacaNormal i butacaVIP
        switch (butaca) {
            case 1 -> {
                System.out.println("Has triat una butaca normal");
                butacaNormal--;
                butacaTotal--;
            }
            case 2 -> {
                System.out.println("Has triat una butaca normal");
                butacaVIP--;
                butacaTotal--;
            }
            default -> {
                System.out.println("Introdueix 1 per normal o 2 per VIP");
            }
        }
    }

    public static float preuEntrada(int diaSetmana, int butaca, int butacaTotal, float descompte) {
        float preuEntrada = 0; // Faltava incialitzar la variable 
        if (butacaTotal > 0) { //while canviat per if, explicat més abaix, i signe girat
            switch (diaSetmana) {
                case 1 -> {
                    switch (butaca) {
                        // ORIGINAL
                        /*
                    zda<    case 1 -> { 
                            System.out.println("5€");
                            preuEntrada = 5} <- falta ;, bracket no esta on toca
                            butacaTotal--;
                        case 2 -> {
                            System.out.println("7€");
                            preuEntrada = 7} <- falta ;, bracket no esta on toca
                            butacaTotal--;
                         */
                        // Només esta malament aquí, als altres dies el switch intern está bé cada vegada

                        // MODIFICAT
                        case 1 -> {
                            System.out.println("5€");
                            preuEntrada = 5;
                            butacaTotal--;
                        }
                        case 2 -> {
                            System.out.println("7€");
                            preuEntrada = 7;
                            butacaTotal--;
                        }
                    }
                }
                case 2, 4 -> {
                    switch (butaca) {
                        case 1 -> {
                            System.out.println("7€");
                            preuEntrada = 7;
                            butacaTotal--;
                        }
                        case 2 -> {
                            System.out.println("9€");
                            preuEntrada = 9;
                            butacaTotal--;
                        }
                    }
                }
                case 3 -> {
                    switch (butaca) {
                        case 1 -> {
                            System.out.println("3€");
                            preuEntrada = 3;
                            butacaTotal--;
                        }
                        case 2 -> {
                            System.out.println("5€");
                            preuEntrada = 5;
                            butacaTotal--;
                        }
                    }
                }
                case 5, 6, 7 -> {
                    switch (butaca) {
                        case 1 -> {
                            System.out.println("10€");
                            preuEntrada = 10;
                            butacaTotal--;
                        }
                        case 2 -> {
                            System.out.println("12€");
                            preuEntrada = 12;
                            butacaTotal--;
                        }
                    }
                }
            }
            preuEntrada = (float) preuEntrada * descompte; //MODIFICAT: falta el ;
            return preuEntrada;
        } else { // Canviat un if per un while
            System.out.println("No queden entrades!");
            return 0;
        }
        // preuEntrada = (float) preuEntrada * descompte // ORIGINAL
    }

    public static float compraBar(int compraBar, float totalBar) {
        switch (compraBar) {
            case 1 -> {
                System.out.println("Crispetes: 6 €");
                totalBar = 6;
            }
            case 2 -> {
                System.out.println("Beguda = 6 €");
                totalBar = 6;
            }
            case 3 -> {
                System.out.println("Combo: 10 €");
                totalBar = 10;
            }
            default -> {
                System.out.println("Introdueix un valor correcte");
            }
        }
        // return totalBar; // ORIGINAL
        return (int) totalBar; // MODIFICAT: Canvi de tipus 
        // Passa la variable com un parametre pero no l'empra? i es de tipus float? i la funcio es tipus int??????? me no entender
    }

    public static float preuTotal(float totalBar, float preuEntrada) {
        float preuSenseIVA = totalBar + preuEntrada;
        return preuSenseIVA;
    }

    public static float preuIva(float preuSenseIVA) {
        float preuIVA = preuSenseIVA * 0.1f; //IVA hardcoded a l'examen, falta la "f" de float
        return preuIVA;
    }

    public static float preuFinal(float preuSenseIVA, float preuIVA) {
        float preuIVAinclos = preuSenseIVA + preuIVA;
        return preuIVAinclos;
    }

    // import java.util.Scanner; // ORIGINAL: l'import està aqui a l'examen original
    // static void menu() { // ORIGINAL: falta el public a l'examen
    public static void menu() { //MODIFICAT: afegit public
        Scanner sc = new Scanner(System.in);
        int any = 0;
        int diaSetmana = 0;
        do {
            System.out.println("Any actual:");
            any = sc.nextInt();
            System.out.println("Dia setmana actual: ");
            diaSetmana = sc.nextInt();
        } while (!validacioDades(any, diaSetmana));
        System.out.println("Tipus butaca:");
        int butaca = 0;
        while (butaca < 1 || butaca > 2) {
            butaca = sc.nextInt();
        }
        int butacaVIP = 5;
        int butacaNormal = 15;
        int butacaTotal = butacaVIP + butacaNormal;
        float descompte = 1f; // No inicialitzada previament
        System.out.println("Descompte: any naixement: ");
        int anyNaixement = sc.nextInt();
        descompte = descompteEdat(anyNaixement, any);
        float preuEntrada = preuEntrada(diaSetmana, butaca, butacaTotal, descompte);
        System.out.println("Compra Bar");
        int compraBar = 0;
        float totalBar = 0f; // No inicialitzada previament
        while (compraBar < 1 || compraBar > 4) {
            compraBar = sc.nextInt();
            totalBar = compraBar(compraBar, totalBar);
        }
        // float IVA = 0.9; // ORIGINAL
        float IVA = 0.9f; // MODIFICAT: falta el "f" de float
        int contadorTaquilla = 0;
        // int contadorBar; // ORIGINAL
        int contadorBar = 0; // MODIFICAT, no assignava cap valor
        // int contadorGlobal = contadorTaquilla + contadorBar // ORIGINAL
        int contadorGlobal = contadorTaquilla + contadorBar; // MODIFICAT: faltava el ";"
        // System.out.println(validacioDades(any, diaSetmana)); // no necessitam el print
        // System.out.println(tipusButaca(butaca)); // ORIGINAL
        // System.out.println(tipusButaca(butaca,butacaTotal)); // MODIFICAT: Falten parametres de la versió original
        // System.out.println(tipusButaca(butaca, butacaTotal, butacaNormal, butacaVIP)); // MODIFICAT: 
        // Falten parametres de la versió modificada però això es perque jo he canviat el nombre de parametres
        tipusButaca(butaca, butacaTotal, butacaNormal, butacaVIP); // MODIFICAT: no importa el println 
        // System.out.println(descompteEdat(anyNaixement, any, descompte)); 
        System.out.print("Preu entrada: ");
        preuEntrada(diaSetmana, butaca, butacaTotal, descompte); // MODIFICAT: no importa el println //

        // System.out.println(compraBar(compraBar, totalBar));
        float preuSenseIVA = preuTotal(totalBar, preuEntrada); // No inicialitzada previament
        // System.out.println(preuIVA(preuSenseIVA)); // ORIGINAL
        float preuIVA = preuIva(preuSenseIVA); // No inicialitzada previament

        DecimalFormat df = new DecimalFormat("#.##");
        System.out.print("Preu no IVA: ");
        System.out.println(df.format(preuSenseIVA));
        System.out.print("IVA:");
        System.out.println(df.format(preuIVA)); // MODIFICAT: la funcio preuIVA no existeix, es preuIVA
        System.out.print("Suma: ");
        System.out.println(df.format(preuFinal(preuSenseIVA, preuIVA)));
    } // tambe falta el bracket de tancament

    public static void main(String[] args) {
        // ORIGINAL:
        /*
        System.out.println(validacioDades(any, diaSetmana));
        // System.out.println(tipusButaca(butaca)); // ORIGINAL
        // System.out.println(tipusButaca(butaca,butacaTotal)); // MODIFICAT: Falten parametres de la versió original
        System.out.println(tipusButaca(butaca, butacaTotal, butacaNormal, butacaVip)); // MODIFICAT: 
        // Falten parametres de la versió modificada però això es perque jo he canviat el nombre de parametres
        System.out.println(descompteEdat(any, anyNaixement, descompte));
        System.out.println(preuEntrada(diaSetmana, butaca, butacaTotal, descompte));
        System.out.println(compraBar(compraBar, totalBar));
        System.out.println(preuTotal(totalBar, preuEntrada));
        // System.out.println(preuIVA(preuSenseIVA)); // ORIGINAL
        System.out.println(preuIva(preuSenseIVA)); // MODIFICAT: la funcio preuIVA no existeix, es preuIVA
        System.out.println(preuFinal(preuSenseIVA, preuIVA));
         */
        // MODIFICAT:
        menu();
    }
}
