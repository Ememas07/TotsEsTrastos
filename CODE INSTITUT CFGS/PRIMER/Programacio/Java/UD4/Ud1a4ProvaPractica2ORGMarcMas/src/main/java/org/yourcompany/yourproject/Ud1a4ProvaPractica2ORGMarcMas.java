/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner; // MODIFICAT: scanner esta importat a un altre lloc

/**
 *
 * @author Boromir
 * 
 * Nota: 1
 */
public class Ud1a4ProvaPractica2ORGMarcMas {

    // public static float descompteEdat(int anyNaixement, int any, int descompte) { // ORIGINAL
    public static float descompteEdat(int anyNaixement, int any, float descompte) { // MODIFICAT
        /* 
        1: Li falta un return
        2: descompte es un float, no un int (descompte = 1.00, etc) 
        3: a cada declaracio de descompte, falta la "f" de float
         */
        if (any - anyNaixement <= 3) {
            System.out.print("100% descompte");
            descompte = 1.00f;
        } else if (any - anyNaixement >= 4 && any - anyNaixement <= 7) {
            System.out.print("75% descompte");
            descompte = 0.75f;
        } else if (any - anyNaixement >= 8 && any - anyNaixement <= 15) {
            System.out.print("50% descompte");
            descompte = 0.5f;
        } else if (any - anyNaixement >= 16 && any - anyNaixement <= 29) {
            System.out.print("25% descompte");
            descompte = 0.25f;
        } else if (any - anyNaixement >= 30 && any - anyNaixement <= 64) {
            System.out.print("sense descompte");
            descompte = 0.0f;
        } else if (any - anyNaixement > 0) {
            System.out.print("Valor erroni");
        } else {
            System.out.print("65% descompte");
            descompte = 0.65f;
        }
        return descompte;
    }

    public static void validacioDades(int any, int diaSetmana) {
        if (any < 1980 || any > 3000) { //Validació any <- aquest comentari estava a l'examen
            System.out.print("Introdueix un any coherent (entre 1980 i 3000)");
        }
        switch (diaSetmana) {
            case 1 -> {
                System.out.print("Avui es dilluns");
            }
            case 2 -> {
                System.out.print("Avui es dimarts");
            }
            case 3 -> {
                System.out.print("Dimecres");
            }
            case 4 -> {
                System.out.print("Dijous");
            }
            case 5 -> {
                System.out.print("Divendres");
            }
            case 6 -> {
                System.out.print("Dissabte");
            }
            case 7 -> {
                System.out.print("Diumenge");
            }
            default -> {
                System.out.print("Introdueix un dia de la setmana correcte (1-7)");
            }
        }
    }

    // public static void tipusButaca(int butaca, int butacaTotal) { // ORIGINAL
    public static void tipusButaca(int butaca, int butacaTotal, int butacaNormal, int butacaVIP) { // MODIFICAT: faltaven els parametres de butacaNormal i butacaVIP
        while (butacaTotal > 0) {
            switch (butaca) {
                case 1 -> {
                    System.out.print("Has triat una butaca normal");
                    butacaNormal--;
                }
                case 2 -> {
                    System.out.print("Has triat una butaca VIP");
                    butacaVIP--;
                }
                default -> {
                    System.out.println("Introdueix 1 per normal o 2 per VIP");
                }
            }
        }
    }

    public static float preuEntrada(int diaSetmana, int butaca, int butacaTotal, float descompte) {
        float preuEntrada = 0; // Faltava incialitzar la variable 
        while (butacaTotal < 0) {
            switch (diaSetmana) {
                case 1 -> {
                    switch (butaca) {
                        // ORIGINAL
                        /*
                        case 1 -> { 
                            System.out.print("5€");
                            preuEntrada = 5} <- falta ;, bracket no esta on toca
                            butacaTotal--;
                        case 2 -> {
                            System.out.print("7€");
                            preuEntrada = 7} <- falta ;, bracket no esta on toca
                            butacaTotal--;
                         */
                        // Només esta malament aquí, als altres dies el switch intern está bé cada vegada

                        // MODIFICAT
                        case 1 -> {
                            System.out.print("5€");
                            preuEntrada = 5;
                            butacaTotal--;
                        }
                        case 2 -> {
                            System.out.print("7€");
                            preuEntrada = 7;
                            butacaTotal--;
                        }
                    }
                }
                case 2, 4 -> {
                    switch (butaca) {
                        case 1 -> {
                            System.out.print("7€");
                            preuEntrada = 7;
                            butacaTotal--;
                        }
                        case 2 -> {
                            System.out.print("9€");
                            preuEntrada = 9;
                            butacaTotal--;
                        }
                    }
                }
                case 3 -> {
                    switch (butaca) {
                        case 1 -> {
                            System.out.print("3€");
                            preuEntrada = 3;
                            butacaTotal--;
                        }
                        case 2 -> {
                            System.out.print("5€");
                            preuEntrada = 5;
                            butacaTotal--;
                        }
                    }
                }
                case 5, 6, 7 -> {
                    switch (butaca) {
                        case 1 -> {
                            System.out.print("10€");
                            preuEntrada = 10;
                            butacaTotal--;
                        }
                        case 2 -> {
                            System.out.print("12€");
                            preuEntrada = 12;
                            butacaTotal--;
                        }
                    }
                }
            }
        }
        // preuEntrada = (float) preuEntrada * descompte // ORIGINAL

        preuEntrada = (float) preuEntrada * descompte; //MODIFICAT: falta el ;

        return preuEntrada;
    }

    public static int compraBar(int compraBar, float totalBar) {
        switch (compraBar) {
            case 1 -> {
                System.out.print("Crispetes: 6€");
                totalBar = 6;
            }
            case 2 -> {
                System.out.print("Beguda = 6€");
                totalBar = 6;
            }
            case 3 -> {
                System.out.print("Combo: 10€");
                totalBar = 10;
            }
            default -> {
                System.out.print("Introdueix un valor correcte");
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
        System.out.print("Any actual:");
        int any = sc.nextInt();
        System.out.print("Dia setmana actual: ");
        int diaSetmana = sc.nextInt();
        validacioDades(any, diaSetmana);
        System.out.print("Tipus butaca:");
        int butaca = sc.nextInt();
        int butacaVIP = 5;
        int butacaNormal = 15;
        int butacaTotal = butacaVIP + butacaNormal;
        System.out.print("Descompte: any naixement: ");
        int anyNaixement = sc.nextInt();
        float descompte;
        int preuEntrada;
        System.out.print("Compra Bar");
        int compraBar = sc.nextInt();
        float totalBar;
        // float IVA = 0.9; // ORIGINAL
        float IVA = 0.9f; // MODIFICAT: falta el "f" de float
        int contadorTaquilla = 0;
        // int contadorBar; // ORIGINAL
        int contadorBar = 0; // MODIFICAT, no assignava cap valor
        // int contadorGlobal = contadorTaquilla + contadorBar // ORIGINAL
        int contadorGlobal = contadorTaquilla + contadorBar; // MODIFICAT: faltava el ";"
    } // tambe falta el bracket de tancament

    public static void main(String[] args) {
        // ORIGINAL:
        /*
        System.out.print(validacioDades(any, diaSetmana));
        // System.out.print(tipusButaca(butaca)); // ORIGINAL
        // System.out.print(tipusButaca(butaca,butacaTotal)); // MODIFICAT: Falten parametres de la versió original
        System.out.print(tipusButaca(butaca, butacaTotal, butacaNormal, butacaVip)); // MODIFICAT: 
        // Falten parametres de la versió modificada però això es perque jo he canviat el nombre de parametres
        System.out.print(descompteEdat(any, anyNaixement, descompte));
        System.out.print(preuEntrada(diaSetmana, butaca, butacaTotal, descompte));
        System.out.print(compraBar(compraBar, totalBar));
        System.out.print(preuTotal(totalBar, preuEntrada));
        // System.out.print(preuIVA(preuSenseIVA)); // ORIGINAL
        System.out.print(preuIva(preuSenseIVA)); // MODIFICAT: la funcio preuIVA no existeix, es preuIVA
        System.out.print(preuFinal(preuSenseIVA, preuIVA));
         */
        // MODIFICAT:
        // si, esta buit, però es que es main original no feia res
    }
}
